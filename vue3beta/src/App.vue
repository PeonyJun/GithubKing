<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import { showConfirmDialog } from 'vant'
import { useStore } from '@/stores'
import { drawerShow, openDrawer, closeDrawer } from '@/composables/useDrawer'
import AppDrawer from '@/components/AppDrawer.vue'

const store = useStore()
const router = useRouter()

const show = drawerShow
const open = openDrawer
const close = closeDrawer

// 手指从屏幕左边缘右滑唤出抽屉（辅助手势）
const EDGE = 24
const TRIGGER = 40
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
    openDrawer()
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
  closeDrawer()
  router.push('/settings')
}
function goHelp() {
  closeDrawer()
  router.push('/help')
}
function goVersion() {
  closeDrawer()
  router.push('/version')
}
function goActivity() {
  closeDrawer()
  router.push('/activity')
}
function goStarred() {
  closeDrawer()
  router.push('/starred')
}
function goLogin() {
  closeDrawer()
  router.push('/login')
}
function onLogout() {
  showConfirmDialog({
    title: '退出登录',
    message: '确定退出当前账号吗？',
    confirmButtonText: '退出',
  }).then(() => {
    store.setActiveAccount(null)
    closeDrawer()
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
    v-model:show="show"
    @settings="goSettings"
    @help="goHelp"
    @version="goVersion"
    @login="goLogin"
    @logout="onLogout"
    @activity="goActivity"
    @starred="goStarred"
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
