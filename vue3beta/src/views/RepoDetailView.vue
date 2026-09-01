<script setup lang="ts">
import { ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { showToast } from 'vant'
import { GH } from '@/api/github'
import type { GithubBranch, GithubContentItem, GithubRepo } from '@/types'
import { openFiles } from '@/router/nav'
import { formatSize } from '@/utils/format'

const route = useRoute()
const router = useRouter()
const owner = String(route.params.owner)
const name = String(route.params.name)

const repo = ref<GithubRepo | null>(null)
const branches = ref<GithubBranch[]>([])
const currentBranch = ref('')
const items = ref<GithubContentItem[]>([])
const loading = ref(false)
const refreshing = ref(false)
const error = ref(false)
const dirs = ref<GithubContentItem[]>([])
const files = ref<GithubContentItem[]>([])

// 长按菜单
const showSheet = ref(false)
const currentItem = ref<GithubContentItem | null>(null)

async function loadInfo() {
  try {
    repo.value = await GH.getRepo(owner, name)
    branches.value = await GH.getBranches(owner, name)
    if (!currentBranch.value && branches.value.length) {
      currentBranch.value = repo.value.default_branch || branches.value[0].name
    }
  } catch {
    error.value = true
  }
}

async function loadContents() {
  if (!currentBranch.value) return
  loading.value = true
  try {
    const res = await GH.getContents(owner, name, '', currentBranch.value)
    files.value = res.filter((i) => i.type === 'file')
    dirs.value = res.filter((i) => i.type === 'dir')
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

function onItemClick(item: GithubContentItem) {
  if (item.type === 'dir') {
    openFiles(router, owner, name, currentBranch.value, item.path)
  } else if (item.type === 'file') {
    // 文件点击：预览文本 / 下载
    openFiles(router, owner, name, currentBranch.value, item.path)
  }
}

function onBranchChange() {
  items.value = []
  files.value = []
  dirs.value = []
  loadContents()
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

loadInfo()
watch(currentBranch, () => {
  if (currentBranch.value) loadContents()
})
</script>

<template>
  <div class="detail">
    <van-nav-bar :title="repo?.full_name || name" left-arrow @click-left="router.back()" />

    <div class="branch-bar">
      <span class="branch-label">分支</span>
      <van-dropdown-menu class="branch-menu">
        <van-dropdown-item
          v-model="currentBranch"
          title="选择分支"
          :options="branches.map((b) => ({ text: b.name, value: b.name }))"
          @change="onBranchChange"
        />
      </van-dropdown-menu>
    </div>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model:loading="loading"
        :finished="true"
        finished-text=""
        :error="error"
      >
        <!-- 目录 -->
        <van-cell-group v-if="dirs.length" title="目录" inset>
          <van-cell
            v-for="d in dirs"
            :key="d.sha"
            :title="d.name"
            is-link
            icon="folder-o"
            @click="onItemClick(d)"
            @touchstart.stop="onPressStart(d)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          />
        </van-cell-group>

        <!-- 文件 -->
        <van-cell-group v-if="files.length" title="文件" inset class="mt-12">
          <van-cell
            v-for="f in files"
            :key="f.sha"
            :title="f.name"
            :label="formatSize(f.size)"
            is-link
            icon="description"
            @click="onItemClick(f)"
            @touchstart.stop="onPressStart(f)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          />
        </van-cell-group>

        <van-empty v-else-if="!loading && !error" description="空目录" />
      </van-list>
    </van-pull-refresh>

    <van-action-sheet
      v-model:show="showSheet"
      cancel-text="取消"
      close-on-click-action
      :actions="[
        {
          name:
            currentItem?.type === 'file' ? '复制下载链接' : '复制路径',
          color: '#1989fa',
        },
      ]"
      @select="onAction"
    />
  </div>
</template>

<style scoped>
.detail {
  min-height: 100vh;
  background: var(--app-bg);
}
.branch-bar {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 12px;
}
.branch-label {
  font-size: 14px;
  color: var(--app-text-sub);
}
.branch-menu {
  flex: 1;
}
</style>
