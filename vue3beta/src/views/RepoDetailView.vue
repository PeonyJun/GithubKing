<script setup lang="ts">
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { GH } from '@/api/github'
import FileBrowser from '@/components/FileBrowser.vue'
import type { GithubBranch, GithubRepo } from '@/types'

const route = useRoute()
const router = useRouter()
const owner = String(route.params.owner)
const name = String(route.params.name)
const fullName = `${owner}/${name}`

const repo = ref<GithubRepo | null>(null)
const branches = ref<GithubBranch[]>([])
const currentBranch = ref(String(route.query.branch || ''))

async function loadInfo() {
  try {
    repo.value = await GH.getRepo(owner, name)
    branches.value = await GH.getBranches(owner, name)
    if (!currentBranch.value && branches.value.length) {
      currentBranch.value = repo.value.default_branch || branches.value[0].name
    }
  } catch {
    /* 仓库信息加载失败，文件浏览器会显示错误 */
  }
}

loadInfo()
</script>

<template>
  <div class="detail">
    <van-nav-bar :title="repo?.full_name || fullName" left-arrow @click-left="router.back()" />

    <div class="toolbar">
      <van-dropdown-menu class="branch-menu">
        <van-dropdown-item
          v-model="currentBranch"
          title="分支"
          :options="branches.map((b) => ({ text: b.name, value: b.name }))"
        />
      </van-dropdown-menu>
      <span class="branch-name ellipsis">{{ currentBranch }}</span>
    </div>

    <FileBrowser v-if="currentBranch" :owner="owner" :name="name" :branch="currentBranch" path="" :repo="repo" />
  </div>
</template>

<style scoped>
.detail {
  min-height: 100vh;
  background: var(--app-bg);
}
.toolbar {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 12px;
  padding-bottom: 0;
}
.branch-menu {
  flex: 1;
}
.branch-name {
  max-width: 45%;
  font-size: 12px;
  color: var(--app-text-sub);
}
</style>
