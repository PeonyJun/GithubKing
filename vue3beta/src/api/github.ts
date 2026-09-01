// GitHub REST API 服务
import { httpGet, httpPost, httpDelete, httpPatch, httpPut, http } from './client'
import type {
  GithubBranch,
  GithubBranchRef,
  GithubContentItem,
  GithubRelease,
  GithubReleaseAsset,
  GithubRepo,
  GithubTree,
  GithubUser,
  GitTreeEntry,
  MenuCategory,
  PagesInfo,
  SearchRepoResult,
} from '@/types'

export const GH = {
  async getUser(): Promise<GithubUser> {
    return httpGet<GithubUser>('/user')
  },

  async getRepos(perPage = 50, page = 1, sort = 'updated'): Promise<GithubRepo[]> {
    return httpGet<GithubRepo[]>(`/user/repos?per_page=${perPage}&page=${page}&sort=${sort}`)
  },

  async getUserRepos(owner: string, perPage = 50, page = 1): Promise<GithubRepo[]> {
    return httpGet<GithubRepo[]>(`/users/${owner}/repos?per_page=${perPage}&page=${page}`)
  },

  async getStarred(perPage = 50, page = 1): Promise<GithubRepo[]> {
    return httpGet<GithubRepo[]>(`/user/starred?per_page=${perPage}&page=${page}&sort=updated`)
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

  async getContentItem(
    owner: string,
    repo: string,
    path: string,
    ref?: string,
  ): Promise<GithubContentItem> {
    return httpGet<GithubContentItem>(`/repos/${owner}/${repo}/contents/${path}?ref=${ref}`)
  },

  async getBranches(owner: string, repo: string): Promise<GithubBranch[]> {
    return httpGet<GithubBranch[]>(`/repos/${owner}/${repo}/branches`)
  },

  async getReleases(owner: string, repo: string, perPage = 30): Promise<GithubRelease[]> {
    return httpGet<GithubRelease[]>(`/repos/${owner}/${repo}/releases?per_page=${perPage}`)
  },

  async getReleaseAssets(id: number): Promise<GithubReleaseAsset[]> {
    return httpGet<GithubReleaseAsset[]>(`/releases/${id}/assets`)
  },

  async createRelease(
    fullName: string,
    body: {
      tag_name: string
      name: string
      body?: string
      draft?: boolean
      prerelease?: boolean
    },
  ): Promise<GithubRelease> {
    return httpPost<GithubRelease>(`/repos/${fullName}/releases`, body)
  },

  async deleteRelease(fullName: string, id: number): Promise<void> {
    await httpDelete<void>(`/repos/${fullName}/releases/${id}`)
  },

  async uploadReleaseAsset(
    releaseId: number,
    name: string,
    contentType: string,
    body: Blob | string,
  ): Promise<GithubReleaseAsset> {
    const res = await http.post(
      `/repos/this-is-unused/releases/${releaseId}/assets?name=${encodeURIComponent(name)}`,
      body,
      { headers: { 'Content-Type': contentType } },
    )
    return res.data as GithubReleaseAsset
  },

  async getReadme(owner: string, repo: string): Promise<string> {
    const res: { content: string } = await httpGet(`/repos/${owner}/${repo}/readme`)
    return decodeURIComponent(escape(atob(res.content)))
  },

  async starRepo(owner: string, repo: string): Promise<void> {
    await httpPut(`/user/starred/${owner}/${repo}`)
  },

  async unstarRepo(owner: string, repo: string): Promise<void> {
    await httpDelete<void>(`/user/starred/${owner}/${repo}`)
  },

  async isStarred(owner: string, repo: string): Promise<boolean> {
    try {
      await httpGet(`/user/starred/${owner}/${repo}`)
      return true
    } catch {
      return false
    }
  },

  // -------- 文件内容操作 --------
  async createOrUpdateFile(
    owner: string,
    repo: string,
    path: string,
    body: { message: string; content: string; branch?: string; sha?: string },
  ): Promise<GithubContentItem> {
    return httpPost<GithubContentItem>(`/repos/${owner}/${repo}/contents/${path}`, body)
  },

  async deleteFile(
    owner: string,
    repo: string,
    path: string,
    body: { message: string; sha: string; branch?: string },
  ): Promise<void> {
    await http.delete<void>(`/repos/${owner}/${repo}/contents/${path}`, { data: body })
  },

  async updateRepo(
    fullName: string,
    body: { name?: string; description?: string; private?: boolean },
  ): Promise<GithubRepo> {
    return httpPatch<GithubRepo>(`/repos/${fullName}`, body)
  },

  async deleteRepo(fullName: string): Promise<void> {
    await httpDelete<void>(`/repos/${fullName}`)
  },

  async createFork(fullName: string, body: { name?: string } = {}): Promise<GithubRepo> {
    return httpPost<GithubRepo>(`/repos/${fullName}/forks`, body)
  },

  async createBranch(
    owner: string,
    repo: string,
    body: { ref: string; sha: string },
  ): Promise<GithubBranchRef> {
    return httpPost<GithubBranchRef>(`/repos/${owner}/${repo}/git/refs`, body)
  },

  async renameBranch(owner: string, repo: string, branch: string, newName: string): Promise<void> {
    await httpPost<void>(`/repos/${owner}/${repo}/branches/${branch}/rename`, { new_name: newName })
  },

  async deleteBranch(owner: string, repo: string, branch: string): Promise<void> {
    await httpDelete<void>(`/repos/${owner}/${repo}/git/refs/heads/${branch}`)
  },

  async getRefHead(owner: string, repo: string, branch: string): Promise<{ object: { sha: string } }> {
    return httpGet<{ object: { sha: string } }>(`/repos/${owner}/${repo}/git/ref/heads/${branch}`)
  },

  async getCommit(owner: string, repo: string, sha: string): Promise<{ tree: { sha: string } }> {
    return httpGet<{ tree: { sha: string } }>(`/repos/${owner}/${repo}/git/commits/${sha}`)
  },

  async createTree(
    owner: string,
    repo: string,
    body: { base_tree: string; tree: GitTreeEntry[] },
  ): Promise<GithubTree> {
    return httpPost<GithubTree>(`/repos/${owner}/${repo}/git/trees`, body)
  },

  async createCommit(
    owner: string,
    repo: string,
    body: { message: string; tree: string; parents: string[] },
  ): Promise<{ sha: string }> {
    return httpPost<{ sha: string }>(`/repos/${owner}/${repo}/git/commits`, body)
  },

  async updateRef(
    owner: string,
    repo: string,
    branch: string,
    body: { sha: string; force?: boolean },
  ): Promise<{ ref: string }> {
    return httpPatch<{ ref: string }>(`/repos/${owner}/${repo}/git/refs/heads/${branch}`, body)
  },

  async getTreeRecursive(
    owner: string,
    repo: string,
    treeSha: string,
  ): Promise<GithubTree> {
    return httpGet<GithubTree>(
      `/repos/${owner}/${repo}/git/trees/${treeSha}?recursive=1`,
    )
  },

  // -------- Pages / 自定义域名 --------
  async enablePages(fullName: string, branch: string): Promise<void> {
    await httpPost<void>(`/repos/${fullName}/pages`, { source: { branch, path: '/' } })
  },

  async disablePages(fullName: string): Promise<void> {
    try {
      await httpDelete<void>(`/repos/${fullName}/pages`)
    } catch {
      /* 404 视为成功 */
    }
  },

  async getCNAME(owner: string, repo: string): Promise<string> {
    const res: { content: string } = await httpGet(`/repos/${owner}/${repo}/contents/CNAME`)
    return decodeURIComponent(escape(atob(res.content)))
  },

  async setCNAME(
    owner: string,
    repo: string,
    domain: string,
    sha?: string,
  ): Promise<void> {
    await httpPost<void>(`/repos/${owner}/${repo}/contents/CNAME`, {
      message: 'feat: Set custom domain',
      content: btoa(domain),
      sha,
    })
  },

  async removeCNAME(owner: string, repo: string, sha: string): Promise<void> {
    await httpDelete<void>(`/repos/${owner}/${repo}/contents/CNAME`)
  },

  // -------- 搜索 --------
  async searchPublicRepos(q: string, page = 1, perPage = 20): Promise<SearchRepoResult> {
    return httpGet<SearchRepoResult>(
      `/search/repositories?q=${encodeURIComponent(q)}&page=${page}&per_page=${perPage}`,
    )
  },
}
