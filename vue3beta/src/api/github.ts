// GitHub REST API 服务
import { httpGet, httpPost, httpDelete } from './client'
import type {
  GithubBranch,
  GithubContentItem,
  GithubRelease,
  GithubRepo,
  GithubUser,
} from '@/types'

export const GH = {
  async getUser(): Promise<GithubUser> {
    return httpGet<GithubUser>('/user')
  },

  async getRepos(perPage = 50, page = 1, sort = 'updated'): Promise<GithubRepo[]> {
    return httpGet<GithubRepo[]>(`/user/repos?per_page=${perPage}&page=${page}&sort=${sort}`)
  },

  async getStarred(perPage = 50, page = 1): Promise<GithubRepo[]> {
    return httpGet<GithubRepo[]>(
      `/user/starred?per_page=${perPage}&page=${page}&sort=updated`,
    )
  },

  async getRepo(owner: string, repo: string): Promise<GithubRepo> {
    return httpGet<GithubRepo>(`/repos/${owner}/${repo}`)
  },

  async getContents(
    owner: string,
    repo: string,
    path: string,
    ref?: string,
  ): Promise<GithubContentItem[]> {
    return httpGet<GithubContentItem[]>(
      `/repos/${owner}/${repo}/contents/${path}?ref=${ref ?? 'HEAD'}`,
    )
  },

  async getBranches(owner: string, repo: string): Promise<GithubBranch[]> {
    return httpGet<GithubBranch[]>(`/repos/${owner}/${repo}/branches`)
  },

  async getReleases(owner: string, repo: string, perPage = 30): Promise<GithubRelease[]> {
    return httpGet<GithubRelease[]>(
      `/repos/${owner}/${repo}/releases?per_page=${perPage}`,
    )
  },

  async getReadme(owner: string, repo: string): Promise<string> {
    const res: { content: string } = await httpGet(`/repos/${owner}/${repo}/readme`)
    return decodeURIComponent(escape(atob(res.content)))
  },

  async starRepo(owner: string, repo: string): Promise<void> {
    await httpPost(`/user/starred/${owner}/${repo}`)
  },

  async unstarRepo(owner: string, repo: string): Promise<void> {
    await httpDelete<void>(`/user/starred/${owner}/${repo}`)
  },

  async getFileBase64(url: string): Promise<string> {
    return httpGet<string>(url, { responseType: 'text' })
  },
}
