<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { showToast, showLoadingToast, closeToast } from 'vant'
import { useStore } from '@/stores'
import { setToken, httpPost, httpGet } from '@/api/client'
import { GH } from '@/api/github'
import type { GithubUser, Account } from '@/types'

const router = useRouter()
const store = useStore()

const mode = ref<'token' | 'oauth'>('token')

// ---- Token 登录 ----
const tokenForm = ref({ token: '' })

async function loginByToken() {
  const token = tokenForm.value.token.trim()
  if (!token) {
    showToast('请输入访问令牌')
    return
  }
  showLoadingToast({ message: '验证中...', forbidClick: true })
  try {
    setToken(token)
    const user = await GH.getUser()
    const acc: Account = {
      id: String(user.id),
      login: user.login,
      name: user.name ?? user.login,
      avatar: user.avatar_url,
      token,
      kind: 'token',
    }
    store.upsertAccount(acc)
    closeToast()
    showToast('登录成功')
    router.replace('/repos')
  } catch (e) {
    setToken('')
    closeToast()
    showToast('令牌无效，请检查')
  }
}

// ---- OAuth 授权（设备码流程，适配移动端） ----
const CLIENT_ID = 'Ov23liGITHUB_CLIENT_ID_PLACEHOLDER'
const oauthState = ref<'idle' | 'waiting' | 'done'>('idle')
const userCode = ref('')
const deviceResp = ref<{ verification_uri: string; user_code: string } | null>(null)
let pollTimer: ReturnType<typeof setInterval> | null = null

async function startDeviceFlow() {
  if (CLIENT_ID.includes('PLACEHOLDER')) {
    showToast('请在源码中配置 GitHub OAuth Client ID')
    return
  }
  showLoadingToast({ message: '获取授权码...', forbidClick: true })
  try {
    const resp = await httpPost<{
      device_code: string
      user_code: string
      verification_uri: string
      interval: number
    }>('/login/device/code', { client_id: CLIENT_ID, scope: 'repo user' })
    deviceResp.value = resp
    oauthState.value = 'waiting'
    closeToast()
    poll(resp.device_code, resp.interval)
  } catch {
    closeToast()
    showToast('获取授权码失败')
  }
}

function poll(deviceCode: string, interval: number) {
  pollTimer = setInterval(async () => {
    try {
      const resp = await httpPost<{
        access_token: string
        error?: string
        error_description?: string
      }>('/login/oauth/access_token', {
        client_id: CLIENT_ID,
        device_code: deviceCode,
        grant_type: 'urn:ietf:params:oauth:grant-type:device_code',
      })
      if (resp.access_token) {
        stopPoll()
        await finishOAuth(resp.access_token)
      } else if (resp.error === 'authorization_pending') {
        // 继续等待
      } else if (resp.error === 'slow_down') {
        // 需要放慢频率
      } else if (resp.error === 'expired_token') {
        stopPoll()
        showToast('授权码已过期')
        oauthState.value = 'idle'
      }
    } catch {
      /* 网络抖动忽略 */
    }
  }, (interval > 0 ? interval : 1) * 1000)
}

function stopPoll() {
  if (pollTimer) {
    clearInterval(pollTimer)
    pollTimer = null
  }
}

async function finishOAuth(accessToken: string) {
  setToken(accessToken)
  try {
    const user = await GH.getUser()
    const acc: Account = {
      id: String(user.id),
      login: user.login,
      name: user.name ?? user.login,
      avatar: user.avatar_url,
      token: accessToken,
      kind: 'oauth',
    }
    store.upsertAccount(acc)
    oauthState.value = 'done'
    showToast('授权成功')
    router.replace('/repos')
  } catch {
    setToken('')
    showToast('授权失败')
    oauthState.value = 'idle'
  }
}

function cancelOAuth() {
  stopPoll()
  oauthState.value = 'idle'
  deviceResp.value = null
}
</script>

<template>
  <div class="login-page">
    <div class="login-brand">
      <van-image
        round
        width="64"
        height="64"
        src="https://github.githubassets.com/apple-touch-icon-180x180.png"
      />
      <div class="login-title">GitHub Mobile</div>
      <div class="login-sub">移动端 GitHub 客户端</div>
    </div>

    <van-tabs v-model:active="mode" shrink class="login-tabs">
      <van-tab title="Token 登录" name="token" />
      <van-tab title="OAuth 授权" name="oauth" />
    </van-tabs>

    <div class="login-body">
      <!-- Token 登录 -->
      <van-form v-show="mode === 'token'" @submit="loginByToken">
        <van-cell-group inset>
          <van-field
            v-model="tokenForm.token"
            label="令牌"
            placeholder="GitHub Personal Access Token"
            autocomplete="off"
          />
        </van-cell-group>
        <div class="login-btn">
          <van-button round block type="primary" native-type="submit">登录</van-button>
        </div>
        <div class="login-hint">
          在 GitHub「Settings → Developer settings → Personal access tokens」创建
        </div>
      </van-form>

      <!-- OAuth 授权（设备码流程） -->
      <div v-if="mode === 'oauth'">
        <div v-if="oauthState === 'idle'">
          <div class="login-btn">
            <van-button round block type="primary" @click="startDeviceFlow">
              开始授权
            </van-button>
          </div>
          <div class="login-hint">将跳转到 GitHub 设备授权流程，适用于移动端</div>
        </div>

        <van-cell-group v-if="oauthState === 'waiting'" inset>
          <van-cell title="授权地址" :label="deviceResp?.verification_uri" />
          <van-cell title="输入验证码" :label="deviceResp?.user_code" />
        </van-cell-group>
        <div v-if="oauthState === 'waiting'" class="login-hint">
          在浏览器打开上方地址并输入验证码完成授权，应用会自动登录
        </div>
        <div v-if="oauthState === 'waiting'" class="login-btn">
          <van-button round block plain type="danger" @click="cancelOAuth">取消</van-button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.login-page {
  min-height: 100vh;
  background: var(--app-bg);
  padding: 40px 0 24px;
  display: flex;
  flex-direction: column;
}
.login-brand {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 12px;
  margin-bottom: 28px;
}
.login-title {
  font-size: 22px;
  font-weight: 700;
  color: var(--app-text);
}
.login-sub {
  font-size: 14px;
  color: var(--app-text-sub);
}
.login-tabs {
  margin: 0 16px;
}
.login-tabs :deep(.van-tabs__wrap) {
  justify-content: center;
}
.login-body {
  margin-top: 24px;
}
.login-btn {
  padding: 20px 24px 0;
}
.login-hint {
  padding: 14px 28px 0;
  font-size: 12px;
  color: var(--app-text-sub);
  text-align: center;
  line-height: 1.6;
}
</style>
