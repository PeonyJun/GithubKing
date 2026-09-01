// 长按菜单定义与过滤逻辑（复刻原项目 CONTEXT_MENU_DEFINITIONS）
import { useStore } from '@/stores'
import type { GithubContentItem, GithubRepo, MenuCategory, MenuDef } from '@/types'
import { ZIP_EXTS } from '@/utils/files'

export const MENU_DEFS: Record<MenuCategory, MenuDef[]> = {
  repo: [
    { action: 'togglePin', text: '置顶 / 取消' },
    { action: 'forkRepo', text: '复刻仓库' },
    { action: 'viewUserRepos', text: '所有仓库' },
    { action: 'renameRepo', text: '仓库设置' },
    { action: 'createBranch', text: '分支管理' },
    { action: 'manageReleases', text: 'Releases' },
    { action: 'downloadRepoDirect', text: '代理下载' },
    { action: 'copyMainSiteLink', text: '主站链接' },
    { action: 'copyProjectSiteLink', text: '网站链接' },
    { action: 'copyCustomDomainLink', text: '域名链接' },
    { action: 'copyRepoGitHubLink', text: '仓库链接' },
    { action: 'viewDetails', text: '仓库详情' },
    { action: 'deleteRepo', text: '删除', danger: true },
  ],
  folder: [
    { action: 'multiSelect', text: '多选' },
    { action: 'copyPagesLink', text: '网站链接' },
    { action: 'copyGitHubLink', text: '仓库链接' },
    { action: 'rename', text: '重命名' },
    { action: 'downloadFolder', text: '下载 ZIP' },
    { action: 'delete', text: '删除', danger: true },
  ],
  file: [
    { action: 'goToDirectory', text: '进入目录' },
    { action: 'multiSelect', text: '多选' },
    { action: 'rename', text: '重命名' },
    { action: 'download', text: '代理下载' },
    { action: 'copyPagesLink', text: '网站链接' },
    { action: 'copyCustomDomainLink', text: '域名链接' },
    { action: 'copyGitHubLink', text: '仓库链接' },
    { action: 'copyLink', text: '复制raw链接' },
    { action: 'copyProxy', text: '复制代理链接' },
    { action: 'unzip', text: '解压缩(仅ZIP)' },
    { action: 'delete', text: '删除', danger: true },
  ],
}

export interface FileMenuCtx {
  isOwner: boolean
  isSearchResults: boolean
  hasPages: boolean
  isMainSiteRepo: boolean
  hasCustomDomain: boolean
  isZip: boolean
}

export function fileMenuItems(
  item: GithubContentItem,
  ctx: FileMenuCtx,
  menuVisibility: Record<string, boolean>,
): MenuDef[] {
  const category: MenuCategory = item.type === 'dir' ? 'folder' : 'file'
  const cfg = menuVisibility ?? {}
  return MENU_DEFS[category].filter((def) => {
    if (cfg[def.action] === false) return false
    const isDir = item.type === 'dir'
    switch (def.action) {
      case 'goToDirectory':
        return ctx.isSearchResults && !isDir
      case 'rename':
      case 'delete':
        return ctx.isOwner
      case 'unzip':
        return ctx.isOwner && ctx.isZip
      case 'downloadFolder':
        return isDir
      case 'copyPagesLink':
        return ctx.hasPages || ctx.isMainSiteRepo
      case 'copyCustomDomainLink':
        return ctx.hasCustomDomain
      case 'copyLink':
      case 'copyProxy':
      case 'download':
      case 'multiSelect':
        return true
      default:
        return true
    }
  })
}

export function isMainSite(repo: GithubRepo, login: string): boolean {
  if (!login) return false
  return repo.name.toLowerCase() === `${login.toLowerCase()}.github.io`
}

export function repoMenuItems(
  repo: GithubRepo,
  login: string,
  isStarredView: boolean,
  menuVisibility: Record<string, boolean>,
): MenuDef[] {
  const cfg = menuVisibility ?? {}
  const isOwnerVal =
    !!login && repo.owner.login.toLowerCase() === login.toLowerCase()
  const main = isMainSite(repo, login)
  return MENU_DEFS.repo.filter((def) => {
    if (cfg[def.action] === false) return false
    switch (def.action) {
      case 'forkRepo':
      case 'viewUserRepos':
        return !isOwnerVal
      case 'togglePin':
      case 'renameRepo':
      case 'createBranch':
      case 'deleteRepo':
        return isOwnerVal
      case 'copyMainSiteLink':
        return main
      case 'copyProjectSiteLink':
        return !!repo.has_pages && !main
      case 'copyCustomDomainLink':
        return !!(repo as any).customDomain
      default:
        return true
    }
  })
}

export function isZipFile(name: string): boolean {
  const ext = name.split('.').pop()?.toLowerCase() ?? ''
  return ZIP_EXTS.includes(ext)
}
