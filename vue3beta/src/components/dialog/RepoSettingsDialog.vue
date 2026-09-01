<script setup lang="ts">
import { ref, watch } from 'vue'
import type { GithubRepo } from '@/types'

const props = defineProps<{
  show: boolean
  repo: GithubRepo | null
}>()
const emit = defineEmits<{
  (e: 'update:show', v: boolean): void
  (e: 'confirm', data: { name?: string; description?: string; private?: boolean } | null): void
}>()

const name = ref('')
const description = ref('')
const isPrivate = ref(false)
watch(
  [() => props.show, () => props.repo],
  () => {
    if (props.repo) {
      name.value = props.repo.name
      description.value = props.repo.description ?? ''
      isPrivate.value = props.repo.private
    }
  },
  { immediate: true },
)

function confirm() {
  const data:
    | { name?: string; description?: string; private?: boolean }
    | null = { name: name.value, description: description.value, private: isPrivate.value }
  emit('confirm', data)
  emit('update:show', false)
}
function cancel() {
  emit('confirm', null)
  emit('update:show', false)
}
</script>

<template>
  <van-popup :show="show" round position="bottom" :style="{ padding: '20px 16px' }">
    <div class="rs-dialog">
      <div class="rs-title">仓库设置</div>
      <van-field v-model="name" label="名称" placeholder="仓库名" clearable />
      <van-field v-model="description" label="描述" placeholder="简介描述" type="textarea" rows="2" clearable />
      <div class="rs-cell">
        <span>公开 / 私有</span>
        <van-switch v-model="isPrivate" size="20" :active-color="isPrivate ? '#ff976a' : '#1989fa'" />
      </div>
      <div class="rs-btns">
        <van-button round plain type="default" style="flex: 1" @click="cancel">取消</van-button>
        <van-button round type="primary" style="flex: 1" @click="confirm">保存</van-button>
      </div>
    </div>
  </van-popup>
</template>

<style scoped>
.rs-title {
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
  margin-bottom: 8px;
}
.rs-cell {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 14px 16px;
  font-size: 14px;
  color: var(--app-text);
}
.rs-btns {
  display: flex;
  gap: 12px;
  margin-top: 12px;
}
</style>
