<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const steps = [
  { title: 'Token 登录', icon: 'lock', body: '前往 GitHub「Settings → Developer settings → Personal access tokens」生成令牌，粘贴登录。' },
  { title: 'OAuth 授权', icon: 'shield-o', body: '使用 GitHub 设备码授权流程，在手机浏览器完成授权即可，无需明文保存令牌。' },
  { title: '浏览仓库', icon: 'apps-o', body: '底部「仓库」Tab 可查看你的全部仓库，下拉刷新，长按条目可收藏/复制链接。' },
  { title: '文件浏览', icon: 'folder-o', body: '点击仓库进入文件列表，可切换分支，长按文件可复制下载链接。' },
  { title: '侧滑抽屉', icon: 'wap-nav', body: '在任意页面从屏幕左边缘向右滑动，即可唤出账户与设置抽屉。' },
  { title: '排序与布局', icon: 'setting-o', body: '在「设置」中可调整仓库排序规则、下载代理前缀和视图布局。' },
]
</script>

<template>
  <div class="help">
    <van-nav-bar title="使用帮助" left-arrow @click-left="router.back()" />

    <div class="help-card">
      <div class="help-title">快速上手</div>
      <div class="help-desc">
        这是一个极简的移动端 GitHub 客户端，支持 Token 与 OAuth 两种登录方式。
      </div>
    </div>

    <van-cell-group inset title="操作指南">
      <van-cell
        v-for="(s, i) in steps"
        :key="s.title"
        :title="`${i + 1}. ${s.title}`"
        :label="s.body"
        :icon="s.icon"
      />
    </van-cell-group>

    <div class="help-tip">遇到问题可前往「版本更新」页获取更多信息。</div>
  </div>
</template>

<style scoped>
.help {
  min-height: 100vh;
  background: var(--app-bg);
}
.help-card {
  margin: 12px;
  padding: 20px 16px;
  background: var(--app-card-bg);
  border-radius: 12px;
}
.help-title {
  font-size: 18px;
  font-weight: 700;
  color: var(--app-text);
}
.help-desc {
  font-size: 13px;
  color: var(--app-text-sub);
  margin-top: 6px;
  line-height: 1.6;
}
.help-tip {
  padding: 16px 24px;
  font-size: 12px;
  color: var(--app-text-sub);
  text-align: center;
}
</style>
