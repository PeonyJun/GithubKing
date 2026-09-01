import type { Router } from 'vue-router'
import type { GithubRepo } from '@/types'

// 打开仓库详情（文件根目录）
export function openRepo(router: Router, repo: GithubRepo) {
  router.push({
    name: 'RepoDetail',
    params: { owner: repo.owner.login, name: repo.name },
  })
}

// 打开文件浏览分支路径
export function openFiles(
  router: Router,
  owner: string,
  name: string,
  branch: string,
  path: string,
) {
  router.push({
    name: 'Files',
    params: { owner, name, branch, path: path || '' },
  })
}
