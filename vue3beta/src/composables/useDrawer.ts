// 抽屉开关的共享状态，供各列表页顶部菜单按钮调用
import { ref } from 'vue'

export const drawerShow = ref(false)

export function openDrawer() {
  drawerShow.value = true
}

export function closeDrawer() {
  drawerShow.value = false
}

export function useDrawer() {
  return { drawerShow, openDrawer, closeDrawer }
}
