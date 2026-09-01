<script setup lang="ts">
import RepoList from '@/components/RepoList.vue'
import { GH } from '@/api/github'

const starredFetcher = (per: number, page: number) => GH.getStarred(per, page)
</script>

<template>
  <div class="page">
    <div class="list-head">
      <span class="list-title">收藏的仓库</span>
    </div>
    <RepoList :fetch-fn="starredFetcher" />
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
</style>
