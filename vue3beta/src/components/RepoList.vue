<script setup lang="ts">
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'
import { showToast } from 'vant'
import { GH } from '@/api/github'
import type { GithubRepo } from '@/types'
import { openRepo } from '@/router/nav'

const props = defineProps<{
  fetchFn: (per: number, page: number) => Promise<GithubRepo[]>
}>()

const router = useRouter()

const list = ref<GithubRepo[]>([])
const loading = ref(false)
const finished = ref(false)
const refreshing = ref(false)
const error = ref(false)
const page = ref(1)
const PER = 30

const showSheet = ref(false)
const actions = ref<{ name: string; color?: string }[]>([])
const currentRepo = ref<GithubRepo | null>(null)

async function load(refresh = false) {
  try {
    error.value = false
    if (refresh) {
      page.value = 1
      list.value = []
    }
    const data = await props.fetchFn(PER, page.value)
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
function onRepoClick(repo: GithubRepo) {
  openRepo(router, repo)
}

let pressTimer: ReturnType<typeof setTimeout> | null = null
function onPressStart(repo: GithubRepo) {
  currentRepo.value = repo
  actions.value = [
    { name: '查看详情', color: '#1989fa' },
    { name: '复制地址', color: '#1989fa' },
  ]
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

async function onAction(item: { name: string }) {
  const repo = currentRepo.value
  if (!repo) return
  if (item.name === '查看详情') {
    onRepoClick(repo)
  } else if (item.name === '复制地址') {
    try {
      await navigator.clipboard.writeText(repo.html_url)
      showToast('已复制')
    } catch {
      showToast('复制失败')
    }
  }
}
</script>

<template>
  <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
    <van-list
      v-model:loading="loading"
      v-model:error="error"
      :finished="finished"
      finished-text="没有更多了"
      error-text="请求失败，点击重试"
      @load="onLoad"
      :style="{ background: 'transparent' }"
    >
      <van-cell-group v-if="list.length" inset>
        <van-cell
          v-for="repo in list"
          :key="repo.id"
          center
          clickable
          @click="onRepoClick(repo)"
          @touchstart.stop="onPressStart(repo)"
          @touchend="onPressEnd"
          @touchcancel="onPressEnd"
        >
          <template #title>
            <div class="cell-title">
              <span class="repo-name ellipsis">{{ repo.name }}</span>
              <van-tag v-if="repo.private" type="warning" plain>私有</van-tag>
            </div>
            <div v-if="repo.description" class="cell-desc ellipsis">
              {{ repo.description }}
            </div>
            <div class="cell-meta">
              <span>⭐ {{ repo.stargazers_count }}</span>
              <span v-if="repo.language" class="lang">{{ repo.language }}</span>
              <span>{{ repo.updated_at?.slice(0, 10) }}</span>
            </div>
          </template>
        </van-cell>
      </van-cell-group>

      <van-empty v-else-if="!loading && !error" description="暂无数据" />
    </van-list>
  </van-pull-refresh>

  <van-action-sheet
    v-model:show="showSheet"
    :actions="actions"
    cancel-text="取消"
    close-on-click-action
    @select="onAction"
  />
</template>

<style scoped>
.cell-title {
  display: flex;
  align-items: center;
  gap: 6px;
  font-size: 16px;
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
  display: flex;
  gap: 12px;
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 6px;
}
</style>
