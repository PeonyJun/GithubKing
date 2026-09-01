<script setup lang="ts">
import { ref, watch } from 'vue'

const props = withDefaults(
  defineProps<{
    show: boolean
    title: string
    message?: string
    placeholder?: string
    value?: string
  }>(),
  { message: '', placeholder: '', value: '' },
)
const emit = defineEmits<{
  (e: 'update:show', v: boolean): void
  (e: 'confirm', value: string | null): void
}>()

const inputVal = ref(props.value)
watch(
  () => props.show,
  (v) => {
    if (v) inputVal.value = props.value
  },
)

function confirm() {
  emit('confirm', inputVal.value)
  emit('update:show', false)
}
function cancel() {
  emit('confirm', null)
  emit('update:show', false)
}
</script>

<template>
  <van-popup :show="show" round position="bottom" :style="{ padding: '20px 16px' }">
    <div class="prompt">
      <div class="prompt-title">{{ title }}</div>
      <div v-if="message" class="prompt-msg">{{ message }}</div>
      <van-field
        v-model="inputVal"
        :placeholder="placeholder"
        clearable
        :style="{ marginTop: '12px' }"
      />
      <div class="prompt-btns">
        <van-button round plain type="default" style="flex: 1" @click="cancel">取消</van-button>
        <van-button round type="primary" style="flex: 1" @click="confirm">确定</van-button>
      </div>
    </div>
  </van-popup>
</template>

<style scoped>
.prompt-title {
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
}
.prompt-msg {
  font-size: 12px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.prompt-btns {
  display: flex;
  gap: 12px;
  margin-top: 16px;
}
</style>
