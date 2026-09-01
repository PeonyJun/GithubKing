// 将 UI 筛选条件编译为 GitHub Search 的 qualifier 查询串
export type SearchCategory = 'repositories' | 'code' | 'users' | 'issues'

export interface RepoFilter {
  language: string
  stars: 'any' | '0' | '100' | '1000' | '10000'
  pushedRange: 'any' | 'week' | 'month' | 'year'
  archived: 'any' | 'include' | 'exclude'
  fork: 'any' | 'include' | 'exclude'
}

export const REPO_FILTER_DEFAULTS: RepoFilter = {
  language: '',
  stars: 'any',
  pushedRange: 'any',
  archived: 'any',
  fork: 'exclude',
}

export const LANGUAGES = [
  '', 'JavaScript', 'TypeScript', 'Python', 'Java', 'Go', 'C', 'C++', 'C#',
  'Rust', 'PHP', 'Ruby', 'Swift', 'Kotlin', 'Shell', 'HTML', 'CSS', 'Vue', 'React',
]

function isoDays(days: number): string {
  const d = new Date(Date.now() - days * 86400000)
  return d.toISOString().slice(0, 10)
}

export function buildRepoQuery(keyword: string, f: RepoFilter): string {
  const parts: string[] = []
  if (keyword.trim()) parts.push(keyword.trim())
  if (f.language) parts.push(`language:${f.language.toLowerCase()}`)
  if (f.stars !== 'any') parts.push(f.stars === '10000' ? 'stars:>=10000' : `stars:>=${f.stars}`)
  if (f.pushedRange !== 'any') {
    const daysMap = { week: 7, month: 30, year: 365 }
    parts.push(`pushed:>${isoDays(daysMap[f.pushedRange])}`)
  }
  if (f.archived === 'include') parts.push('archived:true')
  if (f.archived === 'exclude') parts.push('archived:false')
  if (f.fork === 'exclude') parts.push('fork:true')
  if (f.fork === 'include') parts.push('fork:only')
  return parts.join(' ')
}

export function buildUserQuery(keyword: string): string {
  const parts: string[] = []
  if (keyword.trim()) parts.push(keyword.trim())
  parts.push('type:user')
  return parts.join(' ')
}

export function buildCodeQuery(keyword: string, language?: string): string {
  const parts: string[] = []
  if (keyword.trim()) parts.push(keyword.trim())
  if (language) parts.push(`language:${language.toLowerCase()}`)
  return parts.join(' ')
}

export function buildIssueQuery(keyword: string): string {
  const parts: string[] = []
  if (keyword.trim()) parts.push(keyword.trim())
  return parts.join(' ')
}

export function createSearchQuery(category: SearchCategory, keyword: string, filter: RepoFilter): string {
  switch (category) {
    case 'repositories':
      return buildRepoQuery(keyword, filter)
    case 'users':
      return buildUserQuery(keyword)
    case 'code':
      return buildCodeQuery(keyword, filter.language || undefined)
    case 'issues':
      return buildIssueQuery(keyword)
  }
}
