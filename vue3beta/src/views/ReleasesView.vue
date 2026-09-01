<script setup lang="ts">
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { showConfirmDialog, showToast } from 'vant'
import { GH } from '@/api/github'
import { useStore } from '@/stores'
import { getProxiedUrl } from '@/utils/proxy'
import { formatSize, formatTime } from '@/utils/format'
import type { GithubRelease } from '@/types'

const route = useRoute()
const router = useRouter()
const store = useStore()
const owner = String(route.params.owner)
const name = String(route.params.name)
const fullName = `${owner}/${name}`

const releases = ref<GithubRelease[]>([])
const loading = ref(false)
const error = ref(false)
const settings = store.state.settings

async function load() {
  loading.value = true
  try {
    releases.value = await GH.getReleases(owner, name, 30)
    error.value = false
  } catch {
    error.value = true
  } finally {
    loading.value = false
  }
}
load()

async function onDelete(release: GithubRelease) {
  await showConfirmDialog({
    title: '删除 Release',
    message: `确定删除 ${release.tag_name} ？`,
    confirmButtonText: '删除',
  })
  try {
    await GH.deleteRelease(fullName, release.id)
    showToast('已删除')
    load()
  } catch {
    showToast('删除失败')
  }
}
</script>

<template>
  <div class="releases">
    <van-nav-bar title="Releases" left-arrow @click-left="router.back()" />

    <van-list v-model:loading="loading" :finished="true" :error="error" error-text="请求失败" finished-text="">
      <van-cell-group v-if="releases.length" inset>
        <van-cell v-for="r in releases" :key="r.id">
          <template #title>
            <div class="rel-name">{{ r.name || r.tag_name }}</div>
            <div class="rel-tag ellipsis">tag: {{ r.tag_name }} · {{ formatTime(r.published_at) }}</div>
            <pre v-if="r.body" class="rel-body">{{ r.body }}</pre>
            <div v-if="r.assets?.length" class="rel-assets">
              <span v-for="a in r.assets" :key="a.id" class="rel-asset" @click.stop>
                <van-icon name="down" /> {{ a.name }} ({{ formatSize(a.size) }})
              </span>
            </div>
          </template>
          <template #right-icon>
            <van-icon name="delete-o" class="rel-del" @click.stop="onDelete(r)" />
          </template>
        </van-cell>
      </van-cell-group>
      <van-empty v-else-if="!loading && !error" description="暂无 Releases" />
    </van-list>
  </div>
</template>

<style scoped>
.releases {
  min-height: 100vh;
  background: var(--app-bg);
}
.rel-name {
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
}
.rel-tag {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.rel-body {
  white-space: pre-wrap;
  word-break: break-all;
  font-size: 12px;
  color: var(--app-text-sub);
  margin: 6px 0 0;
}
.rel-assets {
  margin-top: 8px;
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}
.rel-asset {
  font-size: 11px;
  color: var(--app-accent);
  background: var(--app-bg);
  padding: 2px 8px;
  border-radius: 10px;
}
.rel-del {
  color: #ee0a24;
  font-size: 20px;
}
</style>
