<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { showToast, showConfirmDialog, showSuccessToast } from 'vant'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { getProxiedUrl } from '@/utils/proxy'
import { formatTime } from '@/utils/format'
import type { GithubBranch, GithubRepo, PagesInfo } from '@/types'

const store = useStore()
const router = useRouter()

const list = ref<GithubRepo[]>([])
const loading = ref(false)
const finished = ref(false)
const refreshing = ref(false)
const error = ref(false)
const page = ref(1)
const PER = 30

async function load(refresh = false) {
  try {
    error.value = false
    if (refresh) {
      page.value = 1
      list.value = []
    }
    const data = await GH.getRepos(PER, page.value, 'updated')
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
  load(true)
}
function onLoad() {
  if (!refreshing.value) load()
}

// ---- 部署面板 ----
const panelShow = ref(false)
const currentRepo = ref<GithubRepo | null>(null)
const branches = ref<GithubBranch[]>([])
const pagesInfo = ref<PagesInfo | null>(null)
const pagesError = ref(false)
const branchSheetShow = ref(false)
const actionLabel = ref<'enable' | 'switch'>('enable')

function openPanel(repo: GithubRepo) {
  currentRepo.value = repo
  pagesInfo.value = null
  pagesError.value = false
  panelShow.value = true
  loadPages(repo)
  loadBranches(repo)
}

async function loadPages(repo: GithubRepo) {
  try {
    pagesInfo.value = await GH.getPages(repo.full_name)
    pagesError.value = false
  } catch {
    pagesInfo.value = null
    pagesError.value = true
  }
}

async function loadBranches(repo: GithubRepo) {
  try {
    branches.value = await GH.getBranches(repo.owner.login, repo.name)
  } catch {
    branches.value = []
  }
}

function pickBranch(action: 'enable' | 'switch') {
  actionLabel.value = action
  branchSheetShow.value = true
}

async function onBranchSelected(b: GithubBranch) {
  const repo = currentRepo.value
  if (!repo) return
  branchSheetShow.value = false
  try {
    showToast('正在配置...')
    if (actionLabel.value === 'enable') {
      await GH.enablePages(repo.full_name, b.name)
      showSuccessToast('已启用 Pages')
    } else {
      await GH.updatePages(repo.full_name, b.name)
      showSuccessToast('已切换分支')
    }
    repo.has_pages = true
    await loadPages(repo)
  } catch {
    showToast('操作失败')
  }
}

// ---- 域名(CNAME) ----
const cname = ref('')
const cnameEdit = ref(false)

function openCname() {
  const info = pagesInfo.value
  cname.value = info?.cname ?? ''
  cnameEdit.value = true
}

function removeCnameNow() {
  cname.value = ''
  confirmCname()
}

async function confirmCname() {
  const repo = currentRepo.value
  if (!repo) return
  const domain = cname.value.trim()
  try {
    showToast('设置域名中...')
    let sha: string | undefined
    let exists = false
    try {
      const file = await GH.getContentItem(repo.owner.login, repo.name, 'CNAME')
      sha = file.sha
      exists = true
    } catch {
      exists = false
    }
    if (!domain) {
      if (exists && sha) await GH.removeCNAME(repo.owner.login, repo.name, sha)
      showSuccessToast(exists ? '已移除域名' : '当前无自定义域名')
      cnameEdit.value = false
      await loadPages(repo)
      return
    }
    await GH.setCNAME(repo.owner.login, repo.name, domain, exists ? sha : undefined)
    showSuccessToast('已设置域名')
    cnameEdit.value = false
    await loadPages(repo)
  } catch {
    showToast('设置域名失败')
  }
}

async function removePages() {
  const repo = currentRepo.value
  if (!repo) return
  await showConfirmDialog({
    title: '禁用 Pages',
    message: `确定禁用 ${repo.full_name} 的 GitHub Pages？`,
    confirmButtonText: '禁用',
  })
  try {
    showToast('禁用中...')
    await GH.disablePages(repo.full_name)
    showSuccessToast('已禁用')
    pagesInfo.value = null
    await loadPages(repo)
  } catch {
    showToast('禁用失败')
  }
}

function openSite() {
  const url = pagesInfo.value?.html_url
  if (url) window.open(url, '_blank')
  else if (currentRepo.value)
    window.open(`https://${currentRepo.value.owner.login}.github.io/${currentRepo.value.name}/`, '_blank')
}
</script>

<template>
  <div class="page">
    <div class="list-head">
      <span class="list-title">部署</span>
      <span class="list-sub">我的仓库 Pages</span>
    </div>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model:loading="loading"
        v-model:error="error"
        :finished="finished"
        finished-text="没有更多了"
        error-text="请求失败，点击重试"
        @load="onLoad"
      >
        <van-cell-group v-if="list.length" inset>
          <van-cell
            v-for="repo in list"
            :key="repo.id"
            center
            clickable
            :title="repo.name"
            :label="formatTime(repo.updated_at) + (repo.description ? ' · ' + repo.description : '')"
            @click="openPanel(repo)"
          >
            <template #icon>
              <van-image round width="40" height="40" :src="getProxiedUrl(repo.owner.avatar_url, store.state.settings)" class="repo-avatar" />
            </template>
            <template #right-icon>
              <van-tag v-if="repo.has_pages" type="success" plain>已启用</van-tag>
              <van-tag v-else plain type="default">未启用</van-tag>
            </template>
          </van-cell>
        </van-cell-group>
        <van-empty v-else-if="!loading && !error" description="暂无仓库" />
      </van-list>
    </van-pull-refresh>

    <!-- 部署面板 -->
    <van-popup v-model:show="panelShow" round position="bottom" :style="{ padding: '20px 16px' }">
      <div v-if="currentRepo" class="panel">
        <div class="panel-title">
          <span class="ellipsis">{{ currentRepo.full_name }}</span>
          <van-icon name="cross" class="panel-close" @click="panelShow = false" />
        </div>

        <div class="panel-status">
          <div class="status-row">
            <span>Pages 状态</span>
            <van-tag :type="pagesInfo ? 'success' : (pagesError ? 'default' : 'warning')" plain>
              {{ pagesInfo ? (pagesInfo.status || '已启用') : (pagesError ? '未启用' : '查询中...') }}
            </van-tag>
          </div>
          <div v-if="pagesInfo" class="status-row">
            <span>部署分支</span>
            <span class="status-val">{{ pagesInfo.source?.branch || '-' }}</span>
          </div>
          <div v-if="pagesInfo?.cname" class="status-row">
            <span>自定义域名</span>
            <span class="status-val">{{ pagesInfo.cname }}</span>
          </div>
          <div v-if="pagesInfo?.html_url" class="status-row">
            <span>站点地址</span>
            <span class="status-val link" @click="openSite">{{ pagesInfo.html_url }}</span>
          </div>
        </div>

        <van-cell-group inset title="部署操作">
          <van-cell v-if="!pagesInfo" title="启用 Pages" is-link @click="pickBranch('enable')" />
          <van-cell v-else title="切换部署分支" is-link @click="pickBranch('switch')" />
          <van-cell title="设置自定义域名" is-link @click="openCname" />
          <van-cell v-if="pagesInfo?.cname" title="移除自定义域名" is-link class="danger-cell" @click="removeCnameNow" />
          <van-cell v-if="pagesInfo" title="禁用 Pages" is-link class="danger-cell" @click="removePages" />
        </van-cell-group>

        <van-button round block type="primary" style="margin-top: 16px" @click="openSite">访问站点</van-button>
      </div>
    </van-popup>

    <van-action-sheet
      v-model:show="branchSheetShow"
      :actions="branches.map((b) => ({ name: b.name, branchName: b.name }))"
      cancel-text="取消"
      close-on-click-action
      @select="(a) => onBranchSelected({ name: (a as any).branchName } as GithubBranch)"
    />

    <!-- 域名编辑 -->
    <van-popup v-model:show="cnameEdit" round position="bottom" :style="{ padding: '20px 16px' }">
      <div class="panel">
        <div class="panel-title">自定义域名</div>
        <van-field v-model="cname" label="域名" placeholder="例如 www.example.com" clearable />
        <div class="panel-btns">
          <van-button round plain type="default" style="flex: 1" @click="cnameEdit = false">取消</van-button>
          <van-button round type="primary" style="flex: 1" @click="confirmCname">保存</van-button>
        </div>
      </div>
    </van-popup>
  </div>
</template>

<style scoped>
.list-head {
  padding: 4px 4px 12px;
}
.list-title {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
}
.list-sub {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-left: 8px;
}
.repo-avatar {
  margin-right: 12px;
}
.panel-title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 17px;
  font-weight: 600;
  color: var(--app-text);
  margin-bottom: 8px;
}
.panel-close {
  font-size: 18px;
  color: var(--app-text-sub);
  padding: 4px;
}
.panel-status {
  margin: 8px 0 16px;
  padding: 12px 16px;
  border-radius: 8px;
  background: var(--app-bg);
}
.status-row {
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  color: var(--app-text);
  padding: 6px 0;
}
.status-val {
  color: var(--app-text-sub);
}
.link {
  color: #1989fa;
}
.danger-cell :deep(.van-cell__title) {
  color: #ee0a24;
}
.panel-btns {
  display: flex;
  gap: 12px;
  margin-top: 16px;
}
</style>
