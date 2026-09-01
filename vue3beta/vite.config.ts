import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { fileURLToPath, URL } from 'node:url'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    host: '0.0.0.0',
    allowedHosts: ['.monkeycode-ai.online'],
    proxy: {
      // 前端开发时把 /api/gh 代理到 GitHub API，规避 CORS
      '/api/gh': {
        target: 'https://api.github.com',
        changeOrigin: true,
        rewrite: (p) => p.replace(/^\/api\/gh/, ''),
      },
    },
  },
})
