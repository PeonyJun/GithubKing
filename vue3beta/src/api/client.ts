// GitHub API 客户端封装
// 说明：开发环境下走 vite proxy /api/gh -> api.github.com 规避 CORS；
// 正式部署时可用后端代理 / 或用户配置下载代理前缀。

import axios, { AxiosInstance } from 'axios'
import type { AxiosRequestConfig } from 'axios'

let currentToken = ''

export function setToken(token: string) {
  currentToken = token
}

export function getToken() {
  return currentToken
}

const baseURL = '/api/gh'

export const http: AxiosInstance = axios.create({
  baseURL,
  timeout: 15000,
  headers: { Accept: 'application/vnd.github+json', 'X-GitHub-Api-Version': '2022-11-28' },
})

http.interceptors.request.use((config) => {
  if (currentToken) {
    config.headers.Authorization = `Bearer ${currentToken}`
  }
  return config
})

http.interceptors.response.use(
  (res) => res,
  (err) => {
    const status = err?.response?.status
    if (status === 401) {
      // token 失效
      window.dispatchEvent(new CustomEvent('gh:unauthorized'))
    }
    return Promise.reject(err)
  },
)

export async function httpGet<T>(url: string, config?: AxiosRequestConfig): Promise<T> {
  const res = await http.get<T>(url, config)
  return res.data
}

export async function httpPost<T>(url: string, data?: unknown): Promise<T> {
  const res = await http.post<T>(url, data)
  return res.data
}

export async function httpDelete<T>(url: string): Promise<T> {
  const res = await http.delete<T>(url)
  return res.data
}
