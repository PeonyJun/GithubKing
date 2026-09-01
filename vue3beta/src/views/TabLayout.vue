<script setup lang="ts">
import { ref, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const tabs = [
  { name: 'Repos', path: '/repos', icon: 'apps-o', title: '仓库' },
  { name: 'Starred', path: '/starred', icon: 'star-o', title: '收藏' },
  { name: 'Activity', path: '/activity', icon: 'newspaper-o', title: '动态' },
  { name: 'Profile', path: '/profile', icon: 'user-o', title: '我的' },
]

const active = ref(0)

function syncActive() {
  const idx = tabs.findIndex((t) => t.path === route.path)
  if (idx >= 0) active.value = idx
}
watch(() => route.path, syncActive, { immediate: true })

function onChange(index: number) {
  router.push(tabs[index].path)
}
</script>

<template>
  <div class="tab-layout">
    <div class="tab-content">
      <router-view />
    </div>

    <van-tabbar
      v-model="active"
      active-color="#1989fa"
      inactive-color="#969799"
      fixed
      safe-area-inset-bottom
      @change="onChange"
    >
      <van-tabbar-item v-for="t in tabs" :key="t.path" :icon="t.icon">
        {{ t.title }}
      </van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<style scoped>
.tab-content {
  min-height: 100vh;
}
</style>
