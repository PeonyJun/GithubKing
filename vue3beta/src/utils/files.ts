// 文件图标 / 类型 / 排序工具
import type { GithubContentItem } from '@/types'

export const IMAGE_EXTS = ['png', 'jpg', 'jpeg', 'ico', 'gif', 'webp', 'bmp', 'svg']
export const VIDEO_EXTS = ['mp4', 'webm', 'mov', 'avi', 'mkv', 'm4v']
export const AUDIO_EXTS = ['mp3', 'wav', 'ogg', 'flac', 'aac', 'm4a']
export const ZIP_EXTS = ['zip', 'tar', 'gz', '7z', 'rar']
export const TEXT_EXTS = [
  'txt', 'md', 'markdown', 'js', 'ts', 'tsx', 'jsx', 'json', 'html', 'htm',
  'css', 'scss', 'less', 'py', 'go', 'java', 'c', 'cpp', 'h', 'hpp', 'cs',
  'rb', 'php', 'sql', 'xml', 'yml', 'yaml', 'sh', 'bash', 'ini', 'conf',
  'log', 'cfg', 'env', 'vue', 'svelte', 'toml', 'rs', 'swift', 'kt', 'dart',
]

// 图标映射（Vant icon 名，无则用通用名）
const ICON_MAP: Record<string, string> = {
  txt: 'notes-o',
  md: 'description',
  js: 'code-o',
  ts: 'code-o',
  tsx: 'code-o',
  jsx: 'code-o',
  json: 'code-o',
  html: 'code-o',
  css: 'color-o',
  scss: 'color-o',
  less: 'color-o',
  py: 'code-o',
  go: 'code-o',
  java: 'code-o',
  c: 'code-o',
  cpp: 'code-o',
  h: 'code-o',
  cs: 'code-o',
  rb: 'code-o',
  php: 'code-o',
  vue: 'code-o',
  sh: 'terminal',
  png: 'photo-o',
  jpg: 'photo-o',
  jpeg: 'photo-o',
  gif: 'photo-o',
  webp: 'photo-o',
  svg: 'photo-o',
  bmp: 'photo-o',
  ico: 'photo-o',
  mp4: 'video-o',
  webm: 'video-o',
  mov: 'video-o',
  mp3: 'music-o',
  wav: 'music-o',
  ogg: 'music-o',
  zip: 'down',
  tar: 'down',
  gz: 'down',
  pdf: 'description',
  doc: 'description',
  docx: 'description',
}

export function getFileIcon(name: string): string {
  const ext = name.split('.').pop()?.toLowerCase() ?? ''
  const icon = ICON_MAP[ext]
  if (icon) return icon
  if (IMAGE_EXTS.includes(ext)) return 'photo-o'
  if (VIDEO_EXTS.includes(ext)) return 'video-o'
  if (AUDIO_EXTS.includes(ext)) return 'music-o'
  return 'notes-o'
}

// 类型权重（用于“智能排序”）
function typeWeight(item: GithubContentItem): number {
  const ext = item.name.split('.').pop()?.toLowerCase() ?? ''
  if (item.type === 'dir') return 0
  if (IMAGE_EXTS.includes(ext)) return 1
  if (VIDEO_EXTS.includes(ext)) return 2
  if (AUDIO_EXTS.includes(ext)) return 3
  return 6
}

export type FileSort =
  | 'type_name_asc'
  | 'name_asc'
  | 'name_desc'
  | 'size_desc'
  | 'size_asc'
  | 'time_desc'

// 文件夹置顶 + 排序
export function sortFiles(
  list: GithubContentItem[],
  sortKey: FileSort,
  dirsFirst: boolean,
): GithubContentItem[] {
  const arr = [...list]
  const dirWeight = (i: GithubContentItem) => (i.type === 'dir' ? 0 : 1)
  arr.sort((a, b) => {
    if (dirsFirst) {
      const dw = dirWeight(a) - dirWeight(b)
      if (dw !== 0) return dw
    }
    switch (sortKey) {
      case 'type_name_asc': {
        const tw = typeWeight(a) - typeWeight(b)
        if (tw !== 0) return tw
        return a.name.localeCompare(b.name, 'zh', { numeric: true })
      }
      case 'name_asc':
        return a.name.localeCompare(b.name, 'zh', { numeric: true })
      case 'name_desc':
        return b.name.localeCompare(a.name, 'zh', { numeric: true })
      case 'size_desc':
        return b.size - a.size
      case 'size_asc':
        return a.size - b.size
      case 'time_desc':
      default:
        return 0
    }
  })
  return arr
}
