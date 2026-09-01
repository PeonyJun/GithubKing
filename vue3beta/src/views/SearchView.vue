<script setup lang="ts">
import { ref, computed, watch } from 'vue'
import { useRouter } from 'vue-router'
import { showToast } from 'vant'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { getProxiedUrl } from '@/utils/proxy'
import { formatTime } from '@/utils/format'
import {
  createSearchQuery,
  REPO_FILTER_DEFAULTS,
  LANGUAGES,
  type RepoFilter,
  type SearchCategory,
} from '@/utils/searchQuery'
import type {
  GithubRepo,
  CodeSearchItem,
  UserSearchItem,
  IssueSearchItem,
} from '@/types'
import TopBarMenu from '@/components/TopBarMenu.vue'

const store = useStore()
const router = useRouter()

const category = ref<SearchCategory>('repositories')

const tabOpts: { name: SearchCategory; label: string }[] = [
  { name: 'repositories', label: '仓库' },
  { name: 'code', label: '代码' },
  { name: 'users', label: '用户' },
  { name: 'issues', label: 'Issues' },
]

const keyword = ref('')
const filter = ref<RepoFilter>({ ...REPO_FILTER_DEFAULTS })

// 排序
const repoSorts = [
  { text: '最佳匹配', value: '' },
  { text: '星标最多', value: 'stars' },
  { text: '复刻最多', value: 'forks' },
  { text: '最近更新', value: 'updated' },
]
const codeSorts = [
  { text: '最佳匹配', value: '' },
  { text: '最近索引', value: 'indexed' },
]
const userSorts = [
  { text: '最佳匹配', value: '' },
  { text: '关注者最多', value: 'followers' },
  { text: '仓库最多', value: 'repositories' },
]
const issueSorts = [
  { text: '最佳匹配', value: '' },
  { text: '评论最多', value: 'comments' },
  { text: '最新创建', value: 'created' },
  { text: '最近更新', value: 'updated' },
]
const sortInput = ref('')
const sortOrder = ref<'asc' | 'desc'>('desc')

const sortOptions = computed(() => {
  switch (category.value) {
    case 'repositories':
      return repoSorts
    case 'code':
      return codeSorts
    case 'users':
      return userSorts
    case 'issues':
      return issueSorts
  }
})
const orderOptions = [
  { text: '降序', value: 'desc' },
  { text: '升序', value: 'asc' },
]

// ---- 筛选面板 ----
const filterShow = ref(false)
const starsOptions = [
  { text: '不限', value: 'any' },
  { text: '>= 100', value: '100' },
  { text: '>= 1k', value: '1000' },
  { text: '>= 10k', value: '10000' },
]
const pushedOptions = [
  { text: '不限', value: 'any' },
  { text: '近一周', value: 'week' },
  { text: '近一月', value: 'month' },
  { text: '近一年', value: 'year' },
]

// ---- 结果 ----
const repos = ref<GithubRepo[]>([])
const codeItems = ref<CodeSearchItem[]>([])
const users = ref<UserSearchItem[]>([])
const issues = ref<IssueSearchItem[]>([])
const totalCount = ref(0)
const loading = ref(false)
const finished = ref(false)
const refreshing = ref(false)
const error = ref(false)
const searched = ref(false)
const page = ref(1)
const PER = 20

watch(category, () => resetAndLoad())

function resetAndLoad() {
  repos.value = []
  codeItems.value = []
  users.value = []
  issues.value = []
  page.value = 1
  totalCount.value = 0
  finished.value = false
  searched.value = false
  if (keyword.value.trim()) doSearch(1)
}

async function doSearch(p = 1) {
  const kw = keyword.value.trim()
  if (!kw) {
    showToast('请输入搜索关键词')
    searched.value = false
    loading.value = false
    refreshing.value = false
    return
  }
  const q = createSearchQuery(category.value, keyword.value, filter.value)
  searched.value = true
  loading.value = true
  error.value = false
  const sort = sortInput.value || undefined
  try {
    switch (category.value) {
      case 'repositories': {
        const res = await GH.searchPublicRepos(q, p, PER, sort as any, sortOrder.value)
        repos.value = p === 1 ? res.items : repos.value.concat(res.items)
        totalCount.value = res.total_count
        finished.value = repos.value.length >= res.total_count || res.items.length < PER
        break
      }
      case 'code': {
        const res = await GH.searchCode(q, p, PER, sort as any, sortOrder.value)
        codeItems.value = p === 1 ? res.items : codeItems.value.concat(res.items)
        totalCount.value = res.total_count
        finished.value = codeItems.value.length >= res.total_count || res.items.length < PER
        break
      }
      case 'users': {
        const res = await GH.searchUsers(q, p, PER, sort as any, sortOrder.value)
        users.value = p === 1 ? res.items : users.value.concat(res.items)
        totalCount.value = res.total_count
        finished.value = users.value.length >= res.total_count || res.items.length < PER
        break
      }
      case 'issues': {
        const res = await GH.searchIssues(q, p, PER, sort as any, sortOrder.value)
        issues.value = p === 1 ? res.items : issues.value.concat(res.items)
        totalCount.value = res.total_count
        finished.value = issues.value.length >= res.total_count || res.items.length < PER
        break
      }
    }
  } catch (e) {
    error.value = true
    showToast('搜索失败，请稍后重试')
  } finally {
    loading.value = false
    refreshing.value = false
  }
}

function onSearch() {
  if (!keyword.value.trim()) {
    showToast('请输入搜索关键词')
    searched.value = false
    return
  }
  resetAndLoad()
}

function onRefresh() {
  doSearch(1)
}
function onLoad() {
  if (!refreshing.value && !finished.value) doSearch(page.value + 1)
  else loading.value = false
}

function applyFilter() {
  filterShow.value = false
  if (!keyword.value.trim()) {
    showToast('请输入搜索关键词')
    searched.value = false
    return
  }
  resetAndLoad()
}

function openRepo(repo: GithubRepo) {
  router.push({ name: 'RepoDetail', params: { owner: repo.owner.login, name: repo.name } })
}
function openUser(u: UserSearchItem) {
  router.push({ name: 'Repos', query: { mode: 'other', user: u.login } })
}
function openCode(c: CodeSearchItem) {
  window.open(`${c.repository.html_url}/blob/master/${c.path}`, '_blank')
}
function openIssue(i: IssueSearchItem) {
  window.open(i.html_url, '_blank')
}
function repoOfIssue(i: IssueSearchItem): string {
  const m = i.repository_url.match(/\/repos\/([^/]+)\/([^/]+)/)
  return m ? `${m[1]}/${m[2]}` : ''
}

const currentItems = computed(() => {
  switch (category.value) {
    case 'repositories':
      return repos.value
    case 'code':
      return codeItems.value
    case 'users':
      return users.value
    case 'issues':
      return issues.value
  }
})
</script>

<template>
  <div class="page">
    <TopBarMenu title="搜索" />
    <div class="search-head">
      <van-search
        v-model="keyword"
        placeholder="输入关键词"
        shape="round"
        show-action
        @search="onSearch"
      >
        <template #action>
          <van-button
            type="primary"
            size="small"
            round
            icon="search"
            :loading="loading"
            @click="onSearch"
          >
            搜索
          </van-button>
        </template>
      </van-search>
    </div>

    <!-- 类别切换 -->
    <van-tabs v-model:active="category" shrink class="cat-tabs" @change="resetAndLoad">
      <van-tab v-for="t in tabOpts" :key="t.name" :name="t.name" :title="t.label" />
    </van-tabs>

    <!-- 筛选 + 排序 -->
    <div class="filter-bar">
      <div class="filter-btn" @click="filterShow = true">
        <van-icon name="filter-o" />
        <span>筛选</span>
        <span v-if="category === 'repositories'" class="filter-count">
          {{ filter.language || filter.stars !== 'any' || filter.pushedRange !== 'any' || filter.archived !== 'any' ? '·' : '' }}
        </span>
      </div>

      <div class="sort-area">
        <van-dropdown-menu>
          <van-dropdown-item
            v-model="sortInput"
            title="排序"
            :options="sortOptions"
          />
          <van-dropdown-item
            v-model="sortOrder"
            title="方向"
            :options="orderOptions"
          />
        </van-dropdown-menu>
      </div>
    </div>

    <!-- 结果 -->
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model:loading="loading"
        v-model:error="error"
        :finished="finished"
        finished-text="没有更多了"
        error-text="请求失败，点击重试"
        @load="onLoad"
      >
        <div v-if="searched" class="result-meta">
          共 {{ totalCount }} 条结果
        </div>

        <!-- 仓库 -->
        <van-cell-group v-if="category === 'repositories' && repos.length" inset>
          <van-cell
            v-for="repo in repos"
            :key="repo.id"
            center
            clickable
            @click="openRepo(repo)"
          >
            <template #icon>
              <van-image round width="40" height="40" :src="getProxiedUrl(repo.owner.avatar_url, store.state.settings)" class="cell-avatar" />
            </template>
            <template #title>
              <div class="cell-title">
                <span class="repo-name ellipsis">{{ repo.full_name }}</span>
                <van-tag v-if="repo.private" type="warning" plain>私有</van-tag>
              </div>
              <div v-if="repo.description" class="cell-desc ellipsis">{{ repo.description }}</div>
              <div class="cell-meta">
                <span class="star">★ {{ repo.stargazers_count }}</span>
                <span>fork {{ repo.forks_count }}</span>
                <span v-if="repo.language">· {{ repo.language }}</span>
                <span>· {{ formatTime(repo.updated_at) }}</span>
              </div>
            </template>
          </van-cell>
        </van-cell-group>

        <!-- 代码 -->
        <van-cell-group v-else-if="category === 'code' && codeItems.length" inset>
          <van-cell
            v-for="(c, i) in codeItems"
            :key="c.sha + i"
            clickable
            @click="openCode(c)"
          >
            <template #title>
              <div class="code-title">
                <van-tag type="primary" plain>{{ c.repository.language || '代码' }}</van-tag>
                <span class="code-path ellipsis">{{ c.path }}</span>
              </div>
              <div class="code-repo ellipsis">{{ c.repository.full_name }}</div>
              <div
                v-if="c.text_matches && c.text_matches.length"
                class="code-frag"
              >
                <template v-for="(m, mi) in c.text_matches" :key="mi">
                  <div class="code-line">{{ m.fragment }}</div>
                </template>
              </div>
            </template>
          </van-cell>
        </van-cell-group>

        <!-- 用户 -->
        <van-cell-group v-else-if="category === 'users' && users.length" inset>
          <van-cell
            v-for="u in users"
            :key="u.id"
            center
            clickable
            :title="u.login"
            @click="openUser(u)"
          >
            <template #icon>
              <van-image round width="40" height="40" :src="u.avatar_url" class="cell-avatar" />
            </template>
            <template #label>
              <span v-if="u.followers">关注者 {{ u.followers }}</span>
              <span v-if="u.public_repos"> · 仓库 {{ u.public_repos }}</span>
            </template>
          </van-cell>
        </van-cell-group>

        <!-- Issues -->
        <van-cell-group v-else-if="category === 'issues' && issues.length" inset>
          <van-cell
            v-for="i in issues"
            :key="i.id"
            clickable
            :title="i.title"
            @click="openIssue(i)"
          >
            <template #label>
              <div class="issue-meta">
                <van-tag :type="i.state === 'open' ? 'success' : 'default'" plain>{{ i.state }}</van-tag>
                <span>#{{ repoOfIssue(i) }}</span>
                <span>· {{ i.comments }} 评论</span>
                <span>· {{ formatTime(i.updated_at) }}</span>
              </div>
            </template>
          </van-cell>
        </van-cell-group>

        <van-empty v-if="searched && currentItems.length === 0 && !loading && !error" description="无结果" />
        <van-empty v-if="!searched && !loading" description="输入关键词开始搜索" />
      </van-list>
    </van-pull-refresh>

    <!-- 筛选面板 -->
    <van-popup v-model:show="filterShow" round position="bottom" :style="{ maxHeight: '70%', padding: '20px 16px' }">
      <div class="filter-panel">
        <div class="filter-title">筛选</div>

        <template v-if="category === 'repositories'">
          <div class="f-group">
            <div class="f-label">语言</div>
            <div class="f-options">
              <van-tag
                v-for="lang in LANGUAGES"
                :key="lang"
                :type="filter.language === lang ? 'primary' : 'default'"
                plain
                class="f-tag"
                @click="filter.language = lang"
              >{{ lang || '全部' }}</van-tag>
            </div>
          </div>

          <div class="f-group">
            <div class="f-label">Stars 数量</div>
            <div class="f-row">
              <van-tag
                v-for="s in starsOptions"
                :key="s.value"
                :type="filter.stars === s.value ? 'primary' : 'default'"
                plain
                class="f-tag"
                @click="filter.stars = s.value as any"
              >{{ s.text }}</van-tag>
            </div>
          </div>

          <div class="f-group">
            <div class="f-label">最近更新</div>
            <div class="f-row">
              <van-tag
                v-for="p in pushedOptions"
                :key="p.value"
                :type="filter.pushedRange === p.value ? 'primary' : 'default'"
                plain
                class="f-tag"
                @click="filter.pushedRange = p.value as any"
              >{{ p.text }}</van-tag>
            </div>
          </div>

          <div class="f-group">
            <div class="f-label">归档 / 复刻</div>
            <div class="f-switches">
              <div class="f-switch-line">
                <span>归档仓库</span>
                <van-radio-group v-model="filter.archived" direction="horizontal">
                  <van-radio name="include">包含</van-radio>
                  <van-radio name="exclude">排除</van-radio>
                  <van-radio name="any">不限</van-radio>
                </van-radio-group>
              </div>
              <div class="f-switch-line">
                <span>复刻仓库</span>
                <van-radio-group v-model="filter.fork" direction="horizontal">
                  <van-radio name="include">包含</van-radio>
                  <van-radio name="exclude">排除</van-radio>
                  <van-radio name="any">不限</van-radio>
                </van-radio-group>
              </div>
            </div>
          </div>
        </template>

        <template v-else-if="category === 'code'">
          <div class="f-group">
            <div class="f-label">语言</div>
            <div class="f-options">
              <van-tag
                v-for="lang in LANGUAGES"
                :key="lang"
                :type="filter.language === lang ? 'primary' : 'default'"
                plain
                class="f-tag"
                @click="filter.language = lang"
              >{{ lang || '全部' }}</van-tag>
            </div>
          </div>
        </template>

        <template v-else>
          <van-empty description="该类暂无可筛选维度，可直接搜索" :image-size="80" />
        </template>

        <div class="filter-btns">
          <van-button round plain type="default" style="flex: 1" @click="filter = { ...REPO_FILTER_DEFAULTS }">重置</van-button>
          <van-button round type="primary" style="flex: 1" @click="applyFilter">应用筛选</van-button>
        </div>
      </div>
    </van-popup>
  </div>
</template>

<style scoped>
.page {
  min-height: 100vh;
}
.search-head .van-search {
  padding-bottom: 0;
}
.cat-tabs {
  margin: 0 12px;
}
.cat-tabs :deep(.van-tabs__wrap) {
  justify-content: center;
}
.filter-bar {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 12px 16px;
}
.filter-btn {
  display: flex;
  align-items: center;
  gap: 4px;
  font-size: 14px;
  color: var(--app-text);
  white-space: nowrap;
}
.filter-count {
  color: #1989fa;
}
.sort-area {
  flex: 1;
  margin-right: -8px;
}
.result-meta {
  font-size: 12px;
  color: var(--app-text-sub);
  padding: 4px 16px;
}
.cell-avatar {
  margin-right: 12px;
}
.cell-title {
  display: flex;
  align-items: center;
  gap: 6px;
  font-size: 15px;
  font-weight: 600;
  color: var(--app-text);
}
.repo-name {
  max-width: 70%;
}
.cell-desc {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.cell-meta {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 6px;
}
.star {
  color: #f7ba2a;
}
.code-title {
  display: flex;
  align-items: center;
  gap: 8px;
}
.code-path {
  font-size: 15px;
  font-weight: 600;
  color: var(--app-text);
}
.code-repo {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.code-frag {
  margin-top: 8px;
}
.code-line {
  font-family: monospace;
  font-size: 12px;
  color: #57606a;
  background: var(--app-bg);
  border-radius: 4px;
  padding: 6px 8px;
  margin-top: 4px;
  white-space: pre-wrap;
  word-break: break-all;
}
.issue-meta {
  display: flex;
  gap: 8px;
  margin-top: 4px;
}
.filter-title {
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
  margin-bottom: 12px;
}
.f-group {
  margin-bottom: 16px;
}
.f-label {
  font-size: 14px;
  font-weight: 600;
  color: var(--app-text);
  margin-bottom: 8px;
}
.f-options,
.f-row {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}
.f-tag {
  padding: 6px 12px;
  font-size: 13px;
  border-radius: 999px;
}
.f-switches {
  display: flex;
  flex-direction: column;
  gap: 8px;
}
.f-switch-line {
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-size: 14px;
  color: var(--app-text);
}
.filter-btns {
  display: flex;
  gap: 12px;
  margin-top: 8px;
}
</style>
