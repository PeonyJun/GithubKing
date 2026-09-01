<script setup lang="ts">
import { openDrawer } from '@/composables/useDrawer'

defineProps<{
  title: string
  icon?: string
  leftText?: string
}>()
</script>

<template>
  <div class="topbar">
    <div class="topbar-left">
      <div class="menu-btn" @click="openDrawer">
        <van-icon name="wap-nav" size="20" />
      </div>
      <span class="topbar-title">{{ title }}</span>
    </div>
    <div v-if="$slots.right" class="topbar-right">
      <slot name="right" />
    </div>
  </div>
</template>

<style scoped>
.topbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 8px 12px 4px;
}
.topbar-left {
  display: flex;
  align-items: center;
  gap: 10px;
}
.menu-btn {
  padding: 6px;
  color: var(--app-text);
  border-radius: 6px;
}
.menu-btn:active {
  background: var(--app-bg);
}
.topbar-title {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
}
.topbar-right {
  display: flex;
  align-items: center;
}
</style>
