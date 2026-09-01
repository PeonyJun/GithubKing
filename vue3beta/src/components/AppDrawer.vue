<script setup lang="ts">
import { computed } from 'vue'
import { showConfirmDialog } from 'vant'
import { useStore } from '@/stores'

defineProps<{
  show: boolean
}>()

const emit = defineEmits<{
  (e: 'update:show', val: boolean): void
  (e: 'settings'): void
  (e: 'help'): void
  (e: 'version'): void
  (e: 'login'): void
  (e: 'logout'): void
}>()

const store = useStore()
const activeAccount = computed(() => store.activeAccount.value)

function switchTo(accountId: string) {
  store.setActiveAccount(accountId)
  emit('update:show', false)
}

async function removeAccount(account: { id: string; name: string }) {
  await showConfirmDialog({
    title: '删除账号',
    message: `确定删除账号「${account.name}」？`,
    confirmButtonText: '删除',
  })
  store.removeAccount(account.id)
}

function toggleTheme() {
  store.toggleTheme()
}
</script>

<template>
  <van-popup
    :show="show"
    position="left"
    :style="{ width: '78%', height: '100%' }"
    @update:show="(v: boolean) => emit('update:show', v)"
  >
    <div class="drawer">
      <!-- 用户信息区 -->
      <div class="drawer-head">
        <van-image
          width="56"
          height="56"
          round
          fit="cover"
          :src="activeAccount?.avatar || ''"
          class="drawer-avatar"
        />
        <div class="drawer-user">
          <div class="drawer-name">{{ activeAccount?.name || activeAccount?.login || '未登录' }}</div>
          <div class="drawer-login">@{{ activeAccount?.login || '—' }}</div>
        </div>
      </div>

      <!-- 账户管理 -->
      <van-cell-group inset title="账户管理">
        <template v-if="store.state.accounts.length">
          <van-cell
            v-for="acc in store.state.accounts"
            :key="acc.id"
            center
            :title="acc.name || acc.login"
            :label="'@' + acc.login"
            clickable
            @click="switchTo(acc.id)"
          >
            <template #icon>
              <van-image round width="32" height="32" :src="acc.avatar" class="cell-avatar" />
            </template>
            <template #right-icon>
              <van-tag
                v-if="acc.id === store.state.activeAccountId"
                type="success"
                plain
              >
                当前
              </van-tag>
              <van-icon
                v-else
                name="cross"
                class="del-icon"
                @click.stop="removeAccount(acc)"
              />
            </template>
          </van-cell>
        </template>

        <van-cell
          title="添加账号 / 登录"
          icon="plus"
          clickable
          @click="$emit('login')"
        />
      </van-cell-group>

      <!-- 通用设置 -->
      <van-cell-group inset title="通用">
        <van-cell title="主题切换" @click="toggleTheme" is-link>
          <template #value>
            {{ store.state.theme === 'dark' ? '深色' : '浅色' }}
          </template>
        </van-cell>
        <van-cell title="设置" icon="setting-o" is-link @click="$emit('settings')" />
        <van-cell title="使用帮助" icon="question-o" is-link @click="$emit('help')" />
        <van-cell title="版本更新" icon="update" is-link @click="$emit('version')" />
      </van-cell-group>

      <div v-if="store.state.activeAccountId" class="drawer-footer">
        <van-button round block type="danger" plain @click="$emit('logout')">
          退出登录
        </van-button>
      </div>
    </div>
  </van-popup>
</template>

<style scoped>
.drawer {
  height: 100%;
  display: flex;
  flex-direction: column;
  padding: 16px 0;
  background: var(--app-bg-el);
}
.drawer-head {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 12px 16px 20px;
}
.drawer-user {
  min-width: 0;
}
.drawer-name {
  font-size: 17px;
  font-weight: 600;
  color: var(--app-text);
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.drawer-login {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 2px;
}
.cell-avatar {
  margin-right: 12px;
}
.del-icon {
  color: #ee0a24;
  font-size: 18px;
}
.drawer-footer {
  margin-top: auto;
  padding: 16px;
}
</style>
