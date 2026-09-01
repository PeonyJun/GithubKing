<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { GH } from '@/api/github'
import FileBrowser from '@/components/FileBrowser.vue'
import type { GithubRepo } from '@/types'

const route = useRoute()
const router = useRouter()
const owner = String(route.params.owner)
const name = String(route.params.name)
const branch = String(route.params.branch)
const currentPath = computed(() => String(route.params.path ?? ''))

const repo = ref<GithubRepo | null>(null)

GH.getRepo(owner, name).then((r) => (repo.value = r)).catch(() => {})

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

function goCrumb(path: string) {
  router.push({ name: 'Files', params: { owner, name, branch, path } })
}
</script>

<template>
  <div class="files">
    <van-nav-bar :title="'/' + currentPath || name" left-arrow @click-left="router.back()" />

    <div class="crumb-bar">
      <span class="crumb" @click="goCrumb('')">root</span>
      <template v-for="c in crumbs" :key="c.path">
        <van-icon name="arrow" class="crumb-sep" />
        <span class="crumb" @click="goCrumb(c.path)">{{ c.text }}</span>
      </template>
    </div>

    <FileBrowser :owner="owner" :name="name" :branch="branch" :path="currentPath" :repo="repo" />
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
  padding: 8px 12px 0;
  font-size: 14px;
  color: var(--app-text-sub);
}
.crumb {
  color: var(--app-accent);
}
.crumb-sep {
  font-size: 12px;
}
</style>
