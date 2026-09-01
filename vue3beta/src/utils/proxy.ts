// 代理 URL 拼接工具
import type { Settings } from '@/types'

// 拼接代理 URL
export function getProxiedUrl(
  originalUrl: string,
  settings: Settings,
  isDownload = false,
): string {
  if (!originalUrl || !/^https?:/.test(originalUrl)) return originalUrl
  if (!settings.proxyGlobalEnable) return originalUrl
  const prefix = isDownload
    ? settings.downloadProxyPrefix
    : settings.contentProxyPrefix
  if (!prefix) return originalUrl
  const normalized = prefix.endsWith('/') ? prefix : prefix + '/'
  return normalized + originalUrl
}

// 获取 raw 直链（github raw 或 blob 转 raw）
export function rawUrl(item: { download_url?: string | null; html_url?: string }): string {
  if (item.download_url) return item.download_url
  // html_url 例如 https://github.com/o/r/blob/branch/path -> raw
  const m = item.html_url?.match(/github\.com\/([^/]+\/[^/]+)\/(blob|raw)\/(.*)/)
  if (m) {
    return `https://raw.githubusercontent.com/${m[1]}/${m[3]}`
  }
  return item.html_url ?? ''
}

// 解压下载仓库为 zip 的地址
export function repoZipUrl(
  fullName: string,
  defaultBranch: string,
  settings: Settings,
): string {
  const raw = `https://github.com/${fullName}/archive/refs/heads/${defaultBranch}.zip`
  return getProxiedUrl(raw, settings, true)
}

// 触发浏览器下载一个 URL
export function triggerDownload(url: string, filename?: string) {
  const a = document.createElement('a')
  a.href = url
  if (filename) a.download = filename
  a.target = '_blank'
  document.body.appendChild(a)
  a.click()
  document.body.removeChild(a)
}
