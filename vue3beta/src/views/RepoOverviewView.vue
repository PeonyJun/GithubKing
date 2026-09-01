<script setup lang="ts">
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { getProxiedUrl } from '@/utils/proxy'
import { formatTime, formatSize } from '@/utils/format'
import type { GithubRepo } from '@/types'

const route = useRoute()
const router = useRouter()
const store = useStore()
const owner = String(route.params.owner)
const name = String(route.params.name)
const fullName = `${owner}/${name}`

const repo = ref<GithubRepo | null>(null)
const readme = ref('')
const loadingReadme = ref(true)
const settings = store.state.settings

GH.getRepo(owner, name)
  .then((r) => {
    repo.value = r
  })
  .catch(() => {})

async function loadReadme() {
  try {
    readme.value = await GH.getReadme(owner, name)
  } catch {
    readme.value = '（无 README）'
  } finally {
    loadingReadme.value = false
  }
}
loadReadme()
</script>

<template>
  <div class="overview">
    <van-nav-bar title="仓库详情" left-arrow @click-left="router.back()" />

    <div v-if="repo" class="ov-card">
      <van-image round width="56" height="56" :src="getProxiedUrl(repo.owner.avatar_url, settings)" />
      <div class="ov-name">{{ repo.full_name }}</div>
      <div class="ov-owner">@{{ repo.owner.login }}</div>
      <div class="ov-stats">
        <div class="ov-stat"><span>★</span>{{ repo.stargazers_count }}</div>
        <div class="ov-stat"><span>⑂</span>{{ repo.forks_count }}</div>
        <div class="ov-stat"><span>👁</span>{{ repo.watchers_count }}</div>
      </div>
    </div>

    <van-cell-group v-if="repo" inset>
      <van-cell title="描述" :label="repo.description || '暂无描述'" />
      <van-cell title="语言" value-position="right" value="..." :label="repo.language || '无'" />
      <van-cell title="大小" :value="formatSize(repo.size * 1024)" />
      <van-cell title="创建时间" :value="formatTime(repo.created_at)" />
      <van-cell title="更新时间" :value="formatTime(repo.updated_at)" />
      <van-cell title="默认分支" :value="repo.default_branch" />
      <van-cell title="是否公开" :value="repo.private ? '私有' : '公开'" />
    </van-cell-group>

    <div class="ov-readme">
      <div class="ov-readme-title">README</div>
      <div v-if="loadingReadme" class="ov-readme-load">
        <van-loading>加载中...</van-loading>
      </div>
      <pre v-else class="ov-readme-body">{{ readme }}</pre>
    </div>
  </div>
</template>

<style scoped>
.overview {
  min-height: 100vh;
  background: var(--app-bg);
}
.ov-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px 16px;
  background: var(--app-card-bg);
  border-radius: 12px;
  margin: 12px;
}
.ov-name {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
  margin-top: 10px;
}
.ov-owner {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 2px;
}
.ov-stats {
  display: flex;
  gap: 24px;
  margin-top: 14px;
}
.ov-stat {
  font-size: 15px;
  font-weight: 600;
  color: var(--app-text);
}
.ov-stat span {
  margin-right: 2px;
}
.ov-readme {
  margin: 4px 12px;
}
.ov-readme-title {
  font-size: 15px;
  font-weight: 600;
  color: var(--app-text);
  padding: 8px 4px;
}
.ov-readme-load {
  padding: 20px;
  display: flex;
  justify-content: center;
}
.ov-readme-body {
  white-space: pre-wrap;
  word-break: break-all;
  font-size: 13px;
  line-height: 1.6;
  color: var(--app-text);
  background: var(--app-card-bg);
  padding: 12px;
  border-radius: 8px;
  margin: 0;
}
</style>
