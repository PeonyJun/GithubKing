<script setup lang="ts">
import { ref, computed, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import {
  showToast,
  showConfirmDialog,
  showDialog,
  showSuccessToast,
} from 'vant'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { repoMenuItems, isMainSite } from '@/composables/useContextMenu'
import { getProxiedUrl, repoZipUrl, triggerDownload } from '@/utils/proxy'
import { formatTime } from '@/utils/format'
import PromptDialog from '@/components/dialog/PromptDialog.vue'
import RepoSettingsDialog from '@/components/dialog/RepoSettingsDialog.vue'
import BranchesDialog from '@/components/dialog/BranchesDialog.vue'
import type { GithubBranch, GithubRepo } from '@/types'

const props = defineProps<{
  mode?: 'own' | 'starred' | 'other'
  userLogin?: string
}>()

const store = useStore()
const router = useRouter()
const route = useRoute()

const resolvedMode = computed<'own' | 'starred' | 'other'>(
  () => props.mode || ((route.query.mode as 'other') || 'own'),
)
const resolvedUser = computed(
  () => props.userLogin || (route.query.user as string) || '',
)

watch(
  () => [route.query.mode, route.query.user],
  () => {
    if (!props.mode) {
      list.value = []
      page.value = 1
      finished.value = false
      load()
    }
  },
)
const list = ref<GithubRepo[]>([])
const loading = ref(false)
const finished = ref(false)
const refreshing = ref(false)
const error = ref(false)
const page = ref(1)
const PER = 30
const showSheet = ref(false)
const actions = ref<{ name: string; danger?: boolean }[]>([])
const currentRepo = ref<GithubRepo | null>(null)

// 各类弹窗状态
const showPrompt = ref(false)
const showRepoSettings = ref(false)
const showBranches = ref(false)
const branchesList = ref<GithubBranch[]>([])
const pendingBranchesRepo = ref<GithubRepo | null>(null)

// 搜索
const searchQuery = ref('')
const searching = ref(false)
const searchMode = ref(false) // 全局搜索态（公共仓库）
const searchTotal = ref(0)
const searchPage = ref(1)

const login = computed(() => store.activeAccount.value?.login ?? '')
const pinnedIds = ref<number[]>(loadPinned())

function loadPinned(): number[] {
  try {
    return JSON.parse(localStorage.getItem('pinned_repos') || '[]')
  } catch {
    return []
  }
}
function savePinned() {
  localStorage.setItem('pinned_repos', JSON.stringify(pinnedIds.value))
}

const sortLabel: Record<string, string> = {
  updated: '最近更新',
  created: '创建时间',
  pushed: '最近推送',
  name: '名称',
}

const displayList = computed(() => {
  if (resolvedMode.value === 'own') {
    const sorted = [...list.value].sort(
      (a, b) => new Date(b.updated_at).getTime() - new Date(a.updated_at).getTime(),
    )
    const pinned = sorted.filter((r) => pinnedIds.value.includes(r.id))
    const rest = sorted.filter((r) => !pinnedIds.value.includes(r.id))
    return [...pinned, ...rest]
  }
  return list.value
})

async function fetchPage(per: number, p: number): Promise<GithubRepo[]> {
  if (resolvedMode.value === 'starred') return GH.getStarred(per, p)
  if (resolvedMode.value === 'other' && resolvedUser.value)
    return GH.getUserRepos(resolvedUser.value, per, p)
  return GH.getRepos(per, p, store.state.settings.sortRule)
}

async function load(refresh = false) {
  try {
    error.value = false
    if (refresh) {
      page.value = 1
      list.value = []
    }
    const data = await fetchPage(PER, page.value)
    list.value = list.value.concat(data)
    finished.value = data.length < PER
    page.value += 1
  } catch {
    error.value = true
    showToast('加载失败')
  } finally {
    loading.value = false
    refreshing.value = false
  }
}

function onRefresh() {
  if (searchMode.value) {
    const q = (searchQuery.value.trim().startsWith('#') ? searchQuery.value.trim().slice(1) : searchQuery.value.trim())
    fetchPublicSearch(q, 1)
  } else {
    load(true)
  }
}
function onLoad() {
  if (!refreshing.value) onLoadMore()
}

function openRepo(repo: GithubRepo) {
  if (resolvedMode.value === 'own' || resolvedMode.value === 'other') {
    router.push({ name: 'RepoDetail', params: { owner: repo.owner.login, name: repo.name } })
  } else {
    showRepoOverview(repo)
  }
}

// ---- 全局搜索 ----
function onSearch() {
  const q = searchQuery.value.trim()
  if (!q) return
  if (/^@[a-zA-Z0-9_-]+$/.test(q)) {
    router.push({ name: 'Repos', query: { mode: 'other', user: q.slice(1) } })
    return
  }
  const ghMatch = q.match(/github\.com\/([^/\s]+)(?:\/([^/\s?#]+))?/)
  if (/^https?:\/\//.test(q) && ghMatch) {
    const [, o, r] = ghMatch
    if (r && r !== 'undefined') {
      router.push({ name: 'RepoDetail', params: { owner: o, name: r } })
    } else {
      router.push({ name: 'Repos', query: { mode: 'other', user: o } })
    }
    return
  }
  const fileQ = q.startsWith('#') ? q.slice(1) : q
  searchMode.value = true
  searchPage.value = 1
  list.value = []
  fetchPublicSearch(fileQ, 1)
}

async function fetchPublicSearch(q: string, page: number) {
  searching.value = true
  try {
    const res = await GH.searchPublicRepos(q, page, 20)
    searchTotal.value = res.total_count
    list.value = page === 1 ? res.items : list.value.concat(res.items)
    finished.value = list.value.length >= res.total_count || res.items.length < 20
    searchPage.value = page
  } catch {
    error.value = true
    showToast('搜索失败（可能触达限流）')
  } finally {
    searching.value = false
    loading.value = false
    refreshing.value = false
  }
}

function onLoadMore() {
  if (searchMode.value && !finished.value) {
    fetchPublicSearch(
      (searchQuery.value.trim().startsWith('#') ? searchQuery.value.trim().slice(1) : searchQuery.value.trim()),
      searchPage.value + 1,
    )
  } else {
    load()
  }
}

function exitSearch() {
  searchMode.value = false
  list.value = []
  page.value = 1
  finished.value = false
  load()
}

// ---- 长按菜单 ----
let pressTimer: ReturnType<typeof setTimeout> | null = null
function onPressStart(repo: GithubRepo) {
  currentRepo.value = repo
  actions.value = repoMenuItems(
    repo,
    login.value,
    resolvedMode.value === 'starred',
    store.state.settings.menuVisibility.repo,
  ).map((m) => ({ name: m.text, danger: m.danger ?? false }))
  // 插入置顶态文案
  actions.value = actions.value.map((a) => {
    if (a.name === '置顶 / 取消') {
      return { ...a, name: pinnedIds.value.includes(repo.id) ? '取消置顶' : '置顶' }
    }
    return a
  })
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

async function copyText(t: string) {
  try {
    await navigator.clipboard.writeText(t)
    showToast('已复制')
  } catch {
    showToast('复制失败')
  }
}

async function onAction(item: { name: string; danger?: boolean }) {
  const repo = currentRepo.value
  if (!repo) return
  const name = item.name
  if (name === '置顶') {
    if (!pinnedIds.value.includes(repo.id)) pinnedIds.value.push(repo.id)
    savePinned()
    showToast('已置顶')
  } else if (name === '取消置顶') {
    pinnedIds.value = pinnedIds.value.filter((id) => id !== repo.id)
    savePinned()
    showToast('已取消置顶')
  } else if (name === '复刻仓库') {
    await doFork(repo)
  } else if (name === '所有仓库') {
    router.push({ name: 'Repos', query: { mode: 'other', user: repo.owner.login } })
  } else if (name === '仓库设置') {
    await doRepoSettings(repo)
  } else if (name === '分支管理') {
    await doBranches(repo)
  } else if (name === 'Releases') {
    await doReleases(repo)
  } else if (name === '代理下载') {
    triggerDownload(repoZipUrl(repo.full_name, repo.default_branch, store.state.settings))
    showToast('开始下载仓库压缩包')
  } else if (name === '主站链接') {
    await copyText(`https://${login.value}.github.io/`)
  } else if (name === '网站链接') {
    await copyText(`https://${repo.owner.login}.github.io/${repo.name}/`)
  } else if (name === '域名链接') {
    await copyText(`https://${(repo as any).customDomain}`)
  } else if (name === '仓库链接') {
    await copyText(repo.html_url)
  } else if (name === '仓库详情') {
    showRepoOverview(repo)
  } else if (name === '删除') {
    await doDeleteRepo(repo)
  }
}

// 复刻仓库
function doFork(repo: GithubRepo) {
  currentRepo.value = repo
  showPrompt.value = true
}
async function onForkConfirm(val: string | null) {
  const repo = currentRepo.value
  if (!repo || val == null) return
  const newName = val.trim()
  try {
    showToast('复刻中...')
    await GH.createFork(repo.full_name, newName ? { name: newName } : {})
    showSuccessToast('已发起复刻')
  } catch {
    showToast('复刻失败')
  }
}

// 仓库设置（改名/描述/公开私有）
function doRepoSettings(repo: GithubRepo) {
  currentRepo.value = repo
  showRepoSettings.value = true
}
async function onRepoSettingsConfirm(data: { name?: string; description?: string; private?: boolean } | null) {
  const repo = currentRepo.value
  if (!repo || !data) return
  try {
    showToast('保存中...')
    await GH.updateRepo(repo.full_name, data)
    showSuccessToast('已保存')
  } catch {
    showToast('保存失败')
  }
}

// 分支管理
async function doBranches(repo: GithubRepo) {
  currentRepo.value = repo
  pendingBranchesRepo.value = repo
  try {
    branchesList.value = await GH.getBranches(repo.owner.login, repo.name)
    showBranches.value = true
  } catch {
    showToast('获取分支失败')
  }
}
function onBranchNavigate(branch: string) {
  const repo = currentRepo.value
  if (!repo) return
  router.push({
    name: 'RepoDetail',
    params: { owner: repo.owner.login, name: repo.name },
    query: { branch },
  })
}

// Releases 列表
async function doReleases(repo: GithubRepo) {
  router.push({ name: 'Releases', params: { owner: repo.owner.login, name: repo.name } })
}

// 仓库详情
async function showRepoOverview(repo: GithubRepo) {
  router.push({ name: 'RepoOverview', params: { owner: repo.owner.login, name: repo.name } })
}

// 删除仓库
async function doDeleteRepo(repo: GithubRepo) {
  await showConfirmDialog({
    title: '删除仓库',
    message: `确定删除 ${repo.full_name} ？此操作不可恢复。`,
    confirmButtonText: '删除',
  })
  try {
    showToast('删除中...')
    await GH.deleteRepo(repo.full_name)
    showSuccessToast('已删除')
    onRefresh()
  } catch {
    showToast('删除失败，可能需要 delete_repo 权限')
  }
}
</script>

<template>
  <div class="page">
    <div class="list-head">
      <span class="list-title">
        {{ searchMode ? '搜索结果' : resolvedMode === 'starred' ? '星标仓库' : resolvedMode === 'other' ? `${resolvedUser} 的仓库` : '我的仓库' }}
      </span>
      <van-tag v-if="resolvedMode === 'own' && !searchMode" plain type="primary">
        {{ sortLabel[store.state.settings.sortRule] }}
      </van-tag>
      <van-tag v-if="searchMode" plain type="primary">@用户 / 仓库搜索</van-tag>
      <van-button v-if="searchMode" size="mini" plain type="default" @click="exitSearch">退出</van-button>
    </div>

    <van-search
      v-model="searchQuery"
      placeholder="搜索 @用户 / #文件 / 仓库名或链接"
      show-action
      @search="onSearch"
    >
      <template #action>
        <div @click="onSearch">搜索</div>
      </template>
    </van-search>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model:loading="loading"
        v-model:error="error"
        :finished="finished"
        finished-text="没有更多了"
        error-text="请求失败，点击重试"
        @load="onLoad"
      >
        <van-cell-group v-if="displayList.length" inset>
          <van-cell
            v-for="repo in displayList"
            :key="repo.id"
            center
            clickable
            @click="openRepo(repo)"
            @touchstart.stop="onPressStart(repo)"
            @touchend="onPressEnd"
            @touchcancel="onPressEnd"
          >
            <template #icon>
              <van-image
                round
                width="40"
                height="40"
                :src="getProxiedUrl(repo.owner.avatar_url, store.state.settings)"
                class="repo-avatar"
              />
            </template>
            <template #title>
              <div class="cell-title">
                <span class="repo-name ellipsis">{{ repo.name }}</span>
                <van-icon v-if="pinnedIds.includes(repo.id)" name="flag-o" class="pin-icon" />
                <van-tag v-if="repo.private" type="warning" plain>私有</van-tag>
                <van-tag v-else type="primary" plain>公开</van-tag>
              </div>
              <div class="cell-meta">
                <span>{{ formatTime(repo.updated_at) }}</span>
                <span v-if="repo.language">· {{ repo.language }}</span>
                <span v-if="repo.size">· {{ repo.size.toFixed(1) }} KB</span>
              </div>
              <div v-if="repo.description" class="cell-desc ellipsis">
                {{ repo.description }}
              </div>
              <div class="cell-bottom">
                <span class="star-badge">★ {{ repo.stargazers_count }} · fork {{ repo.forks_count }}</span>
              </div>
            </template>
          </van-cell>
        </van-cell-group>
        <van-empty v-else-if="!loading && !error" description="暂无仓库" />
      </van-list>
    </van-pull-refresh>

    <van-action-sheet
      v-model:show="showSheet"
      :actions="actions"
      cancel-text="取消"
      close-on-click-action
      @select="onAction"
    />

    <PromptDialog
      v-model:show="showPrompt"
      title="复刻仓库"
      message="可自定义新仓库名（留空用原名）"
      placeholder="新仓库名"
      @confirm="onForkConfirm"
    />

    <RepoSettingsDialog
      v-model:show="showRepoSettings"
      :repo="currentRepo"
      @confirm="onRepoSettingsConfirm"
    />

    <BranchesDialog
      v-model:show="showBranches"
      :repo="pendingBranchesRepo"
      :branches="branchesList"
      @navigate="onBranchNavigate"
    />
  </div>
</template>

<style scoped>
.list-head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 4px 4px 12px;
}
.list-title {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
}
.repo-avatar {
  margin-right: 12px;
}
.cell-title {
  display: flex;
  align-items: center;
  gap: 6px;
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
}
.repo-name {
  max-width: 60%;
}
.pin-icon {
  color: #ff8a00;
}
.cell-meta {
  display: flex;
  gap: 6px;
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.cell-desc {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.cell-bottom {
  margin-top: 6px;
}
.star-badge {
  font-size: 12px;
  color: var(--app-text-sub);
}
</style>
