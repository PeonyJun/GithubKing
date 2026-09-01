<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import type { GithubUser } from '@/types'

const router = useRouter()
const store = useStore()
const loading = ref(true)
const user = ref<GithubUser | null>(null)
const activeAccount = computed(() => store.activeAccount.value)

const stats = [
  { label: '仓库', key: 'public_repos' },
  { label: '关注', key: 'following' },
  { label: '粉丝', key: 'followers' },
] as const

async function load() {
  loading.value = true
  try {
    user.value = await GH.getUser()
  } finally {
    loading.value = false
  }
}
load()
</script>

<template>
  <div class="page">
    <div class="profile-card">
      <van-image class="big-avatar" round width="72" height="72" :src="user?.avatar_url || activeAccount?.avatar" />
      <div class="p-name">{{ user?.name || activeAccount?.name }}</div>
      <div class="p-login">@{{ user?.login || activeAccount?.login }}</div>
      <div v-if="user?.bio" class="p-bio">{{ user.bio }}</div>

      <div class="p-stats">
        <div v-for="s in stats" :key="s.key" class="p-stat">
          <div class="p-stat-num">{{ user?.[s.key] ?? '—' }}</div>
          <div class="p-stat-label">{{ s.label }}</div>
        </div>
      </div>
    </div>

    <van-cell-group inset>
      <van-cell title="设置" icon="setting-o" is-link @click="router.push('/settings')" />
      <van-cell title="使用帮助" icon="question-o" is-link @click="router.push('/help')" />
      <van-cell
        title="版本更新"
        icon="update"
        is-link
        @click="router.push('/version')"
      />
    </van-cell-group>
  </div>
</template>

<style scoped>
.profile-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 24px 16px 20px;
  background: var(--app-card-bg);
  border-radius: 12px;
  margin-bottom: 12px;
}
.big-avatar {
  margin-bottom: 12px;
}
.p-name {
  font-size: 20px;
  font-weight: 700;
  color: var(--app-text);
}
.p-login {
  font-size: 14px;
  color: var(--app-text-sub);
  margin-top: 2px;
}
.p-bio {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 8px;
  text-align: center;
  padding: 0 16px;
}
.p-stats {
  display: flex;
  gap: 24px;
  margin-top: 16px;
}
.p-stat {
  text-align: center;
}
.p-stat-num {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
}
.p-stat-label {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 2px;
}
</style>
