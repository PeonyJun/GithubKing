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
  downloadProxyPrefix: string
  layout: ListLayout
}
