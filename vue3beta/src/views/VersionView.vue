<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import { showToast } from 'vant'

const router = useRouter()
const version = '1.0.0'
const checking = ref(false)

async function checkUpdate() {
  checking.value = true
  // 简化：在此版本内展示信息；可替换为请求远端版本接口
  setTimeout(() => {
    checking.value = false
    showToast('已是最新版本')
  }, 800)
}
</script>

<template>
  <div class="version">
    <van-nav-bar title="版本更新" left-arrow @click-left="router.back()" />

    <div class="ver-card">
      <van-image
        round
        width="64"
        height="64"
        src="https://github.githubassets.com/apple-touch-icon-180x180.png"
      />
      <div class="ver-name">GitHub Mobile</div>
      <div class="ver-code">当前版本 v{{ version }}</div>
      <div class="ver-btn">
        <van-button round type="primary" :loading="checking" @click="checkUpdate">
          检查更新
        </van-button>
      </div>
    </div>

    <van-cell-group inset title="更新日志">
      <van-cell title="v1.0.0" label="首个版本：支持 Token/OAuth 登录、仓库浏览、文件查看、设置主题。" />
    </van-cell-group>

    <div class="ver-tip">本页面为演示版本，正式更新检测可对接远端接口。</div>
  </div>
</template>

<style scoped>
.version {
  min-height: 100vh;
  background: var(--app-bg);
}
.ver-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 28px 16px 24px;
}
.ver-name {
  font-size: 20px;
  font-weight: 700;
  color: var(--app-text);
  margin-top: 12px;
}
.ver-code {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 4px;
}
.ver-btn {
  margin-top: 16px;
}
.ver-tip {
  padding: 16px 24px;
  font-size: 12px;
  color: var(--app-text-sub);
  text-align: center;
}
</style>
