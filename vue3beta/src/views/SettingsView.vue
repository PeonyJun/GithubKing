<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { showToast } from 'vant'
import { useStore } from '@/stores'
import { MENU_DEFS } from '@/composables/useContextMenu'
import type { ListLayout, MenuCategory } from '@/types'

const router = useRouter()
const store = useStore()

const sortRule = ref<string>(store.state.settings.sortRule)
const contentProxy = ref(store.state.settings.contentProxyPrefix)
const downloadProxy = ref(store.state.settings.downloadProxyPrefix)
const proxyEnable = ref(store.state.settings.proxyGlobalEnable)
const layout = ref<ListLayout>(store.state.settings.layout)
const viewMode = ref(store.state.settings.viewMode)
const folderFirst = ref(store.state.settings.folderFirst)

const sortOptions = [
  { value: 'updated', label: '最近更新', desc: '按 Push 时间排序' },
  { value: 'created', label: '创建时间', desc: '按创建时间排序' },
  { value: 'pushed', label: '最近推送', desc: '按 Pushed At 排序' },
  { value: 'name', label: '名称', desc: '按名称字母排序' },
]

const layoutOptions: { value: ListLayout; label: string; icon: string }[] = [
  { value: 'single', label: '单列', icon: 'apps-o' },
  { value: 'double', label: '双列', icon: 'bag-o' },
  { value: 'triple', label: '三列', icon: 'grid-o' },
]

// 菜单配置
const menuTab = ref<MenuCategory>('repo')
const menuCategories: { key: MenuCategory; label: string }[] = [
  { key: 'repo', label: '仓库' },
  { key: 'folder', label: '文件夹' },
  { key: 'file', label: '文件' },
]
const menuVisibility = computed(
  () => store.state.settings.menuVisibility[menuTab.value] ?? {},
)

function onSortChange(v: string) {
  store.updateSettings({ sortRule: v as any })
  showToast('已应用排序')
}

function onProxyToggle(v: boolean) {
  store.updateSettings({ proxyGlobalEnable: v })
}
function onProxyBlur() {
  store.updateSettings({
    contentProxyPrefix: contentProxy.value.trim(),
    downloadProxyPrefix: downloadProxy.value.trim(),
  })
  showToast('代理已保存')
}
function setProxyPreset(kind: 'content' | 'download', url: string) {
  if (kind === 'content') contentProxy.value = url
  else downloadProxy.value = url
  store.updateSettings({
    contentProxyPrefix: contentProxy.value.trim(),
    downloadProxyPrefix: downloadProxy.value.trim(),
  })
  showToast('已应用代理')
}

function onLayoutChange(v: string | number) {
  store.setLayout(String(v) as ListLayout)
  showToast('布局已切换')
}
function onViewModeChange(v: boolean) {
  store.updateSettings({ viewMode: v ? 'grid' : 'list' })
}
</script>

<template>
  <div class="settings">
    <van-nav-bar title="设置" left-arrow @click-left="router.back()" />

    <!-- 列表排序 -->
    <van-cell-group inset title="仓库排序规则">
      <van-radio-group
        class="sort-group"
        :model-value="sortRule"
        @update:model-value="onSortChange"
      >
        <van-cell
          v-for="s in sortOptions"
          :key="s.value"
          :title="s.label"
          :label="s.desc"
          clickable
          @click="onSortChange(s.value)"
        >
          <template #right-icon>
            <van-radio :name="s.value" />
          </template>
        </van-cell>
      </van-radio-group>
    </van-cell-group>

    <!-- 仓库视图布局 -->
    <van-cell-group inset title="仓库视图布局" class="mt-12">
      <div class="layout-picker">
        <van-radio-group :model-value="layout" direction="horizontal" @update:model-value="onLayoutChange">
          <van-radio v-for="l in layoutOptions" :key="l.value" :name="l.value" class="layout-radio">
            <div class="layout-item">
              <van-icon :name="l.icon" />
              <span>{{ l.label }}</span>
            </div>
          </van-radio>
        </van-radio-group>
      </div>
    </van-cell-group>

    <!-- 文件展示 -->
    <van-cell-group inset title="文件列表" class="mt-12">
      <van-cell title="网格视图" center>
        <template #right-icon>
          <van-switch :model-value="viewMode === 'grid'" @update:model-value="onViewModeChange" />
        </template>
      </van-cell>
      <van-cell title="文件夹置顶" center>
        <template #right-icon>
          <van-switch v-model="folderFirst" @change="(v: any) => store.updateSettings({ folderFirst: !!v })" />
        </template>
      </van-cell>
    </van-cell-group>

    <!-- 网络代理 -->
    <van-cell-group inset title="网络代理" class="mt-12">
      <van-cell title="全局代理开关" center>
        <template #right-icon>
          <van-switch :model-value="proxyEnable" @update:model-value="onProxyToggle" />
        </template>
      </van-cell>
      <van-field v-model="contentProxy" label="访问代理" placeholder="https://gh-proxy.org/" clearable />
      <van-field v-model="downloadProxy" label="下载代理" placeholder="https://down.ksx.qzz.io/" clearable @blur="onProxyBlur" />
      <div class="proxy-presets">
        <van-tag plain type="primary" @click="setProxyPreset('content', 'https://gh-proxy.org/')">gh-proxy.org</van-tag>
        <van-tag plain type="primary" @click="setProxyPreset('download', 'https://down.ksx.qzz.io/')">down.ksx.qzz.io</van-tag>
      </div>
    </van-cell-group>

    <!-- 菜单项配置 -->
    <van-cell-group inset title="长按菜单项配置" class="mt-12">
      <van-tabs v-model:active="menuTab">
        <van-tab v-for="c in menuCategories" :key="c.key" :title="c.label" :name="c.key">
          <van-cell
            v-for="def in MENU_DEFS[menuTab]"
            :key="def.action"
            :title="def.text"
            center
          >
            <template #right-icon>
              <van-switch
                :model-value="menuVisibility[def.action] ?? true"
                @update:model-value="(v: any) => store.updateMenuVisibility(menuTab, def.action, !!v)"
              />
            </template>
          </van-cell>
        </van-tab>
      </van-tabs>
    </van-cell-group>

    <div class="settings-tip">代理默认：访问 gh-proxy.org / 下载 down.ksx.qzz.io</div>
  </div>
</template>

<style scoped>
.settings {
  min-height: 100vh;
  background: var(--app-bg);
  padding-bottom: 40px;
}
.sort-group {
  padding: 4px 0;
}
.proxy-presets {
  display: flex;
  gap: 8px;
  padding: 8px 16px 12px;
}
.layout-picker {
  padding: 12px 16px;
}
.layout-radio {
  --van-radio-size: 18px;
  margin-right: 8px;
}
.layout-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 4px;
  font-size: 13px;
  color: var(--app-text);
}
.settings-tip {
  padding: 14px 24px;
  font-size: 12px;
  color: var(--app-text-sub);
  text-align: center;
}
</style>
