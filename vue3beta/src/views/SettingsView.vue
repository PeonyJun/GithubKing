<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { showToast } from 'vant'
import { useStore } from '@/stores'
import type { ListLayout } from '@/types'

const router = useRouter()
const store = useStore()

const sortRule = ref<string>(store.state.settings.sortRule)
const proxy = ref(store.state.settings.downloadProxyPrefix)
const layout = ref<ListLayout>(store.state.settings.layout)

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

function onSortChange(v: string | number) {
  if (typeof v === 'number') v = String(v)
  store.updateSettings({ sortRule: v as any })
  showToast('已应用排序')
}

function onProxyBlur() {
  store.updateSettings({ downloadProxyPrefix: proxy.value.trim() })
  showToast('下载代理已保存')
}

function onLayoutChange(v: ListLayout | string | number) {
  const val = String(v) as ListLayout
  store.setLayout(val)
  showToast('视图布局已切换')
}
</script>

<template>
  <div class="settings">
    <van-nav-bar title="设置" left-arrow @click-left="router.back()" />

    <!-- 列表排序 -->
    <van-cell-group inset title="列表排序规则">
      <van-radio-group class="sort-group" :model-value="sortRule" @update:model-value="onSortChange">
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

    <!-- 下载代理 -->
    <van-cell-group inset title="文件下载代理前缀" class="mt-12">
      <van-field
        v-model="proxy"
        placeholder="例如 https://ghproxy.cn/"
        label="代理前缀"
        clearable
        @blur="onProxyBlur"
      />
      <div class="proxy-hint">
        留空则直连 GitHub。若无法访问 raw 文件，可填中转代理前缀。
      </div>
    </van-cell-group>

    <!-- 布局视图 -->
    <van-cell-group inset title="仓库视图布局" class="mt-12">
      <div class="layout-picker">
        <van-radio-group
          :model-value="layout"
          direction="horizontal"
          @update:model-value="onLayoutChange"
        >
          <van-radio v-for="l in layoutOptions" :key="l.value" :name="l.value" class="layout-radio">
            <div class="layout-item">
              <van-icon :name="l.icon" />
              <span>{{ l.label }}</span>
            </div>
          </van-radio>
        </van-radio-group>
      </div>
    </van-cell-group>

    <div class="settings-tip">
      布局切换将在「仓库」列表生效（单列卡片 / 双列 / 三列）
    </div>
  </div>
</template>

<style scoped>
.settings {
  min-height: 100vh;
  background: var(--app-bg);
}
.sort-group {
  padding: 4px 0;
}
.proxy-hint {
  padding: 6px 16px 12px;
  font-size: 12px;
  color: var(--app-text-sub);
  line-height: 1.6;
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
