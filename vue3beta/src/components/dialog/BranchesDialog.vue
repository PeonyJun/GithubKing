<script setup lang="ts">
import { ref, watch } from 'vue'
import { showToast } from 'vant'
import { GH } from '@/api/github'
import type { GithubBranch, GithubRepo } from '@/types'
import PromptDialog from '@/components/dialog/PromptDialog.vue'

const props = defineProps<{
  show: boolean
  repo: GithubRepo | null
  branches: GithubBranch[]
}>()
const emit = defineEmits<{
  (e: 'update:show', v: boolean): void
  (e: 'navigate', branch: string): void
}>()

const showPrompt = ref(false)

const promptTitle = ref('新建分支')
const promptVal = ref('')
const promptMsg = ref('')

async function createBranch() {
  if (!props.repo) return
  const name = promptVal.value.trim()
  if (!name) {
    showToast('请输入分支名')
    return
  }
  showPrompt.value = false
  try {
    const head = await GH.getRefHead(props.repo.owner.login, props.repo.name, props.repo.default_branch)
    await GH.createBranch(props.repo.owner.login, props.repo.name, {
      ref: `refs/heads/${name}`,
      sha: head.object.sha,
    })
    showToast('分支已创建')
    props.branches.push({ name, protected: false, commit: { sha: head.object.sha, url: '' } })
  } catch {
    showToast('创建失败')
  }
}

function onPromptConfirm(val: string | null) {
  if (val == null) return
  promptVal.value = val
  createBranch()
}
</script>

<template>
  <van-popup :show="show" round position="bottom" :style="{ height: '70%', padding: '16px' }">
    <div class="br-dialog">
      <div class="br-head">
        <span class="br-title">分支管理</span>
        <van-button size="small" round type="primary" @click="showPrompt = true">
          + 新建
        </van-button>
      </div>

      <van-cell-group>
        <van-cell
          v-for="b in branches"
          :key="b.name"
          :title="b.name"
          icon="code-o"
          is-link
          @click="$emit('navigate', b.name); $emit('update:show', false)"
        >
          <template #right-icon>
            <van-icon name="arrow" />
          </template>
        </van-cell>
      </van-cell-group>

      <div class="br-hint">点击分支进入该分支的文件浏览</div>
    </div>

    <PromptDialog
      v-model:show="showPrompt"
      title="新建分支"
      message="分支将基于默认分支创建"
      placeholder="输入分支名"
      @confirm="onPromptConfirm"
    />
  </van-popup>
</template>

<style scoped>
.br-dialog {
  display: flex;
  flex-direction: column;
  height: 100%;
}
.br-head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 0 12px;
}
.br-title {
  font-size: 16px;
  font-weight: 600;
  color: var(--app-text);
}
.br-hint {
  padding: 16px 8px;
  font-size: 12px;
  color: var(--app-text-sub);
  text-align: center;
}
</style>
