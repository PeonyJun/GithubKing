import { createRouter, createWebHashHistory } from 'vue-router'
import type { RouteRecordRaw } from 'vue-router'
import { useStore } from '@/stores'

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('@/views/TabLayout.vue'),
    children: [
      { path: '', redirect: '/repos' },
      {
        path: 'repos',
        name: 'Repos',
        component: () => import('@/views/ReposView.vue'),
        meta: { tab: true, title: '仓库' },
      },
      {
        path: 'search',
        name: 'Search',
        component: () => import('@/views/SearchView.vue'),
        meta: { tab: true, title: '搜索' },
      },
      {
        path: 'deploy',
        name: 'Deploy',
        component: () => import('@/views/DeployView.vue'),
        meta: { tab: true, title: '部署' },
      },
      {
        path: 'profile',
        name: 'Profile',
        component: () => import('@/views/ProfileView.vue'),
        meta: { tab: true, title: '我的' },
      },
    ],
  },
  {
    path: '/activity',
    name: 'Activity',
    component: () => import('@/views/ActivityView.vue'),
    meta: { title: '动态' },
  },
  {
    path: '/starred',
    name: 'Starred',
    component: () => import('@/views/StarredView.vue'),
    meta: { title: '收藏' },
  },
  {
    path: '/repo/:owner/:name',
    name: 'RepoDetail',
    component: () => import('@/views/RepoDetailView.vue'),
    meta: { title: '仓库' },
  },
  {
    path: '/repo/:owner/:name/overview',
    name: 'RepoOverview',
    component: () => import('@/views/RepoOverviewView.vue'),
    meta: { title: '仓库详情' },
  },
  {
    path: '/repo/:owner/:name/releases',
    name: 'Releases',
    component: () => import('@/views/ReleasesView.vue'),
    meta: { title: 'Releases' },
  },
  {
    path: '/files/:owner/:name/:branch/:path(.*)*',
    name: 'Files',
    component: () => import('@/views/FilesView.vue'),
    meta: { title: '文件' },
  },
  {
    path: '/settings',
    name: 'Settings',
    component: () => import('@/views/SettingsView.vue'),
    meta: { title: '设置' },
  },
  {
    path: '/help',
    name: 'Help',
    component: () => import('@/views/HelpView.vue'),
    meta: { title: '使用帮助' },
  },
  {
    path: '/version',
    name: 'Version',
    component: () => import('@/views/VersionView.vue'),
    meta: { title: '版本更新' },
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/LoginView.vue'),
    meta: { title: '登录' },
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

router.beforeEach((to) => {
  const { state } = useStore()
  const authed = !!state.activeAccountId
  const publicRoutes = ['Login', 'Help']
  if (!authed && !publicRoutes.includes(String(to.name))) {
    return { name: 'Login' }
  }
  return true
})

export default router
