<script setup lang="ts">
import { ref, onMounted, onUnmounted, computed } from 'vue'
import { useRouter } from 'vue-router'
import { showConfirmDialog } from 'vant'
import { useStore } from '@/stores'
import AppDrawer from '@/components/AppDrawer.vue'

const store = useStore()
const router = useRouter()

const drawerShow = ref(false)

// 手指从屏幕左边缘右滑唤出抽屉
const EDGE = 24
const TRIGGER = 60
let touchStartX = 0
let touchStartY = 0

function onTouchStart(e: TouchEvent) {
  if (drawerShow.value) return
  const t = e.touches[0]
  touchStartX = t.clientX
  touchStartY = t.clientY
}

function onTouchEnd(e: TouchEvent) {
  if (drawerShow.value) return
  const t = e.changedTouches[0]
  const dx = t.clientX - touchStartX
  const dy = t.clientY - touchStartY
  // 左边缘 24px 内、水平右滑、横向位移大于纵向
  if (touchStartX <= EDGE && dx > TRIGGER && Math.abs(dx) > Math.abs(dy) * 1.5) {
    drawerShow.value = true
  }
}

onMounted(() => {
  window.addEventListener('touchstart', onTouchStart, { passive: true })
  window.addEventListener('touchend', onTouchEnd, { passive: true })
})
onUnmounted(() => {
  window.removeEventListener('touchstart', onTouchStart)
  window.removeEventListener('touchend', onTouchEnd)
})

function goSettings() {
  drawerShow.value = false
  router.push('/settings')
}
function goHelp() {
  drawerShow.value = false
  router.push('/help')
}
function goVersion() {
  drawerShow.value = false
  router.push('/version')
}
function goLogin() {
  drawerShow.value = false
  router.push('/login')
}
function onLogout() {
  showConfirmDialog({
    title: '退出登录',
    message: '确定退出当前账号吗？',
    confirmButtonText: '退出',
  }).then(() => {
    store.setActiveAccount(null)
    drawerShow.value = false
    router.push('/login')
  })
}
</script>

<template>
  <router-view v-slot="{ Component }">
    <transition name="fade" mode="out-in">
      <component :is="Component" />
    </transition>
  </router-view>

  <!-- 左侧滑出抽屉 -->
  <AppDrawer
    v-model:show="drawerShow"
    @settings="goSettings"
    @help="goHelp"
    @version="goVersion"
    @login="goLogin"
    @logout="onLogout"
  />
</template>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.15s ease;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>
