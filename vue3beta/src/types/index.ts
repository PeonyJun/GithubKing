// GitHub API 相关类型定义

export interface GithubUser {
  id: number
  login: string
  name: string | null
  avatar_url: string
  html_url: string
  bio: string | null
  email: string | null
  followers: number
  following: number
  public_repos: number
  location: string | null
  blog: string | null
}

export interface GithubRepo {
  id: number
  name: string
  full_name: string
  private: boolean
  html_url: string
  description: string | null
  fork: boolean
  url: string
  created_at: string
  updated_at: string
  pushed_at: string
  language: string | null
  default_branch: string
  owner: GithubUser
  stargazers_count: number
  forks_count: number
  watchers_count: number
  size: number
  has_pages: boolean
  homepage: string | null
}

export interface GithubContentItem {
  type: 'file' | 'dir' | 'symlink' | 'submodule'
  size: number
  name: string
  path: string
  content?: string
  sha: string
  url: string
  html_url: string
  download_url: string | null
}

export interface GithubBranch {
  name: string
  commit: { sha: string; url: string }
  protected: boolean
}

export interface GithubRelease {
  id: number
  tag_name: string
  name: string
  body: string
  published_at: string
  html_url: string
  draft?: boolean
  prerelease?: boolean
  assets?: GithubReleaseAsset[]
}

// 本地应用类型
export interface Account {
  id: string
  login: string
  name: string
  avatar: string
  token: string
  kind: 'token' | 'oauth'
}

export type ListLayout = 'single' | 'double' | 'triple'

export interface Settings {
  sortRule: 'updated' | 'created' | 'pushed' | 'name'
  contentProxyPrefix: string
  downloadProxyPrefix: string
  proxyGlobalEnable: boolean
  layout: ListLayout
  viewMode: 'list' | 'grid'
  folderFirst: boolean
  menuVisibility: Record<'repo' | 'folder' | 'file', Record<string, boolean>>
}

export interface GithubBranchRef {
  ref: string
  node_id: string
  object: { sha: string; type: string; url: string }
}

export interface GithubReleaseAsset {
  id: number
  name: string
  size: number
  browser_download_url: string
  content_type: string
}

export interface SearchRepoResult {
  total_count: number
  incomplete_results: boolean
  items: GithubRepo[]
}

export interface GitTreeEntry {
  path: string
  mode: string
  type: 'blob' | 'tree'
  size?: number
  sha: string | null
  url?: string
}

export interface GithubTree {
  sha: string
  url: string
  tree: GitTreeEntry[]
  truncated: boolean
}

export interface PagesInfo {
  status: string
  cname: string | null
  html_url: string
  source: { branch: string; path: string }
}

export interface MenuDef {
  action: string
  text: string
  danger?: boolean
}

export type MenuCategory = 'repo' | 'folder' | 'file'
