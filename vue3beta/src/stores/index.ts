// 全局状态 Store（基于 Vue reactive + localStorage，无额外依赖）
import { reactive, watch, computed } from 'vue'
import { storage } from '@/utils/storage'
import type { Account, ListLayout, Settings } from '@/types'

export interface AppState {
  accounts: Account[]
  activeAccountId: string | null
  settings: Settings
  theme: 'light' | 'dark'
}

const settingsDefaults: Settings = {
  sortRule: 'updated',
  downloadProxyPrefix: '',
  layout: 'single',
}

const state = reactive<AppState>({
  accounts: storage.get<Account[]>('accounts', []),
  activeAccountId: storage.get<string | null>('activeAccountId', null),
  settings: { ...settingsDefaults, ...storage.get<Partial<Settings>>('settings', {}) },
  theme: storage.get<'light' | 'dark'>('theme', 'light'),
})

watch(
  () => state.accounts,
  (v) => storage.set('accounts', v),
  { deep: true },
)
watch(() => state.activeAccountId, (v) => storage.set('activeAccountId', v))
watch(
  () => state.settings,
  (v) => storage.set('settings', v),
  { deep: true },
)
watch(
  () => state.theme,
  (v) => {
    storage.set('theme', v)
    document.documentElement.setAttribute('data-theme', v)
    const meta = document.querySelector('meta[name="theme-color"]')
    if (meta) meta.setAttribute('content', v === 'dark' ? '#15181f' : '#ffffff')
  },
  { immediate: true },
)

export function useStore() {
  const activeAccount = computed(() =>
    state.accounts.find((a) => a.id === state.activeAccountId) ?? null,
  )

  function setActiveAccount(id: string | null) {
    state.activeAccountId = id
  }

  function upsertAccount(acc: Account) {
    const i = state.accounts.findIndex((a) => a.id === acc.id)
    if (i >= 0) state.accounts[i] = acc
    else state.accounts.push(acc)
    state.activeAccountId = acc.id
  }

  function removeAccount(id: string) {
    state.accounts = state.accounts.filter((a) => a.id !== id)
    if (state.activeAccountId === id) {
      state.activeAccountId = state.accounts[0]?.id ?? null
    }
  }

  function clearAccounts() {
    state.accounts = []
    state.activeAccountId = null
  }

  function updateSettings(partial: Partial<Settings>) {
    state.settings = { ...state.settings, ...partial }
  }

  function setLayout(layout: ListLayout) {
    state.settings.layout = layout
  }

  function toggleTheme() {
    state.theme = state.theme === 'light' ? 'dark' : 'light'
  }

  return {
    state,
    activeAccount,
    setActiveAccount,
    upsertAccount,
    removeAccount,
    clearAccounts,
    updateSettings,
    setLayout,
    toggleTheme,
  }
}
