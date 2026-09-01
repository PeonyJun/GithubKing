<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { showToast } from 'vant'
import { GH } from '@/api/github'
import type { GithubContentItem } from '@/types'
import { formatSize } from '@/utils/format'

const route = useRoute()
const router = useRouter()
const owner = String(route.params.owner)
const name = String(route.params.name)
const branch = String(route.params.branch)
const currentPath = computed(() => String(route.params.path ?? ''))

const items = ref<GithubContentItem[]>([])
const loading = ref(false)
const refreshing = ref(false)
const error = ref(false)
const dirs = computed(() => items.value.filter((i) => i.type === 'dir'))
const files = computed(() => items.value.filter((i) => i.type === 'file'))

// 文件预览
const preview = ref<{ name: string; content: string } | null>(null)
const previewLoading = ref(false)
const showPreviewer = ref(false)

const crumbs = computed(() => {
  const parts = currentPath.value ? currentPath.value.split('/') : []
  const arr: { text: string; path: string }[] = []
  let acc = ''
  for (const p of parts) {
    acc = acc ? acc + '/' + p : p
    arr.push({ text: p, path: acc })
  }
  return arr
})

// 长按菜单
const showSheet = ref(false)
const currentItem = ref<GithubContentItem | null>(null)

async function loadContents() {
  loading.value = true
  try {
    const res = await GH.getContents(owner, name, currentPath.value, branch)
    items.value = res
    error.value = false
  } catch {
    error.value = true
  } finally {
    loading.value = false
    refreshing.value = false
  }
}

function onRefresh() {
  loadContents()
}

function goDir(path: string) {
  router.push({ name: 'Files', params: { owner, name, branch, path } })
}
function goCrumb(path: string) {
  router.push({ name: 'Files', params: { owner, name, branch, path } })
}

async function onFileClick(item: GithubContentItem) {
  previewLoading.value = true
  showPreviewer.value = true
  preview.value = { name: item.name, content: '加载中...' }
  try {
    const text = await GH.getReadme(owner, name)
    void text
  } catch {
    /* ignore */
  }
  try {
    // 尝试按文本读取
    const res = await fetchProxy(item.download_url)
    preview.value = { name: item.name, content: res }
  } catch {
    preview.value = { name: item.name, content: '无法预览该文件，可长按复制下载链接' }
  } finally {
    previewLoading.value = false
  }
}

async function fetchProxy(url: string | null): Promise<string> {
  if (!url) throw new Error('no url')
  const { useStore } = await import('@/stores')
  const prefix = useStore().state.settings.downloadProxyPrefix
  let full = url
  if (prefix) {
    // 用户配置了下载代理前缀，拼接
    full = prefix + encodeURIComponent(url)
  }
  const resp = await fetch(full)
  return resp.text()
}

let pressTimer: ReturnType<typeof setTimeout> | null = null
function onPressStart(item: GithubContentItem) {
  currentItem.value = item
  pressTimer = setTimeout(() => {
    showSheet.value = true
  }, 500)
}
function onPressEnd() {
  if (pressTimer) {
    clearTimeout(pressTimer)
    pressTimer = null
  }
}

async function onAction(action: { name: string }) {
  const item = currentItem.value
  if (!item) return
  if (action.name === '复制下载链接' && item.download_url) {
    try {
      await navigator.clipboard.writeText(item.download_url)
      showToast('已复制')
    } catch {
      showToast('复制失败')
    }
  } else if (action.name === '复制路径') {
    try {
      await navigator.clipboard.writeText(item.path)
      showToast('已复制')
    } catch {
      showToast('复制失败')
    }
  }
}

loadContents()
</script>

<template>
  <div class="files">
    <van-nav-bar :title="'/' + currentPath || name" left-arrow @click-left="router.back()" />

    <!-- 面包屑 -->
    <div class="crumb-bar">
      <span class="crumb" @click="goCrumb('')">root</span>
      <template v-for="c in crumbs" :key="c.path">
        <van-icon name="arrow" class="crumb-sep" />
        <span class="crumb" @click="goCrumb(c.path)">{{ c.text }}</span>
      </template>
    </div>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list v-model:loading="loading" :finished="true" :error="error">
        <van-cell-group v-if="dirs.length" inset>
          <van-cell
            v-for="d in dirs"
            :key="d.sha"
            :title="d.name"
            is-link
            icon="folder-o"
            @click="goDir(d.path)"
            @touchstart.stop="onPressStart(d)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          />
        </van-cell-group>

        <van-cell-group v-if="files.length" inset class="mt-12">
          <van-cell
            v-for="f in files"
            :key="f.sha"
            :title="f.name"
            :label="formatSize(f.size)"
            is-link
            icon="description"
            @click="onFileClick(f)"
            @touchstart.stop="onPressStart(f)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          />
        </van-cell-group>

        <van-empty v-else-if="!loading && !error" description="空目录" />
      </van-list>
    </van-pull-refresh>

    <!-- 文件内容预览 -->
    <van-popup v-model:show="showPreviewer" position="bottom" :style="{ height: '70%' }">
      <div class="preview">
        <div class="preview-head">
          <span class="ellipsis flex-1">{{ preview?.name }}</span>
          <van-icon name="cross" @click="showPreviewer = false" />
        </div>
        <div v-if="previewLoading" class="preview-load">
          <van-loading>加载中...</van-loading>
        </div>
        <pre v-else class="preview-body">{{ preview?.content }}</pre>
      </div>
    </van-popup>

    <van-action-sheet
      v-model:show="showSheet"
      cancel-text="取消"
      close-on-click-action
      :actions="[
        {
          name: currentItem?.type === 'file' ? '复制下载链接' : '复制路径',
          color: '#1989fa',
        },
      ]"
      @select="onAction"
    />
  </div>
</template>

<style scoped>
.files {
  min-height: 100vh;
  background: var(--app-bg);
}
.crumb-bar {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  gap: 4px;
  padding: 8px 12px;
  font-size: 14px;
  color: var(--app-text-sub);
}
.crumb {
  color: var(--app-accent);
}
.crumb-sep {
  font-size: 12px;
}
.preview {
  height: 100%;
  display: flex;
  flex-direction: column;
}
.preview-head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 12px 16px;
  font-size: 16px;
  font-weight: 600;
  border-bottom: 1px solid var(--app-divider);
}
.preview-load {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
}
.preview-body {
  flex: 1;
  overflow: auto;
  padding: 12px 16px;
  margin: 0;
  font-size: 13px;
  line-height: 1.6;
  white-space: pre-wrap;
  word-break: break-all;
  color: var(--app-text);
  background: var(--app-card-bg);
}
</style>
