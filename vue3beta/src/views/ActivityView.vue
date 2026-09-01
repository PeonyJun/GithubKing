<script setup lang="ts">
import { ref } from 'vue'
import { showToast } from 'vant'
import { httpGet } from '@/api/client'
import { useStore } from '@/stores'
import { computed } from 'vue'

const store = useStore()
const login = computed(() => store.activeAccount.value?.login)
const events = ref<any[]>([])
const loading = ref(false)
const finished = ref(false)
const refreshing = ref(false)
const error = ref(false)

const eventText: Record<string, (e: any) => string> = {
  PushEvent: (e) =>
    `推送了 ${e.payload.commits?.length ?? 0} 次提交到 ${e.repo?.name}`,
  CreateEvent: (e) =>
    `创建了${e.payload.ref_type === 'repository' ? '仓库' : `分支 ${e.payload.ref}`}${
      e.repo ? ` (${e.repo.name})` : ''
    }`,
  PullRequestEvent: (e) =>
    `${e.payload.action} 了 PR ${e.payload.pull_request?.title ?? ''} (${e.repo?.name})`,
  IssuesEvent: (e) =>
    `${e.payload.action} 了 Issue「${e.payload.issue?.title}」(${e.repo?.name})`,
  WatchEvent: (e) => `收藏了仓库 ${e.repo?.name}`,
  ForkEvent: (e) => `Fork 了仓库 ${e.repo?.name}`,
  DeleteEvent: (e) => `删除了 ${e.payload.ref_type} ${e.payload.ref} (${e.repo?.name})`,
  StarEvent: (e) => `给仓库 ${e.repo?.name} 点了 Star`,
}

function describe(e: any): string {
  const fn = eventText[e.type]
  return fn ? fn(e) : `${e.type} (${e.repo?.name ?? ''})`
}

async function load(refresh = false) {
  const current = login.value
  if (!current) return
  try {
    error.value = false
    if (refresh) events.value = []
    const data = await httpGet<any[]>(`/users/${current}/events/public?per_page=30`)
    events.value = events.value.concat(data)
    finished.value = data.length < 30
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
  load()
}
</script>

<template>
  <div class="page">
    <div class="list-head">
      <span class="list-title">动态</span>
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
        <van-cell-group v-if="events.length" inset>
          <van-cell
            v-for="(ev, i) in events"
            :key="ev.id ?? i"
            :title="ev.actor?.login"
            :label="String(ev.created_at ?? '').slice(0, 16) + '  ' + describe(ev)"
          >
            <template #icon>
              <van-image
                round
                width="32"
                height="32"
                :src="ev.actor?.avatar_url"
                class="ev-avatar"
              />
            </template>
          </van-cell>
        </van-cell-group>

        <van-empty v-else-if="!loading && !error" description="暂无动态" />
      </van-list>
    </van-pull-refresh>
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
.ev-avatar {
  margin-right: 12px;
}
</style>
