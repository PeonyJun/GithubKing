import { createApp } from 'vue'
import {
  Tabbar,
  TabbarItem,
  Cell,
  CellGroup,
  Field,
  Form,
  Button,
  Popup,
  ActionSheet,
  NavBar,
  PullRefresh,
  List,
  Empty,
  Tag,
  Icon,
  Image as VanImage,
  Skeleton,
  Loading,
  Switch,
  Radio,
  RadioGroup,
  Checkbox,
  Tabs,
  Tab,
  Search,
  Stepper,
  DropdownMenu,
  DropdownItem,
  Divider,
  SwipeCell,
} from 'vant'
import 'vant/lib/index.css'
import './assets/main.css'

import App from './App.vue'
import router from './router'
import { useStore } from './stores'

const app = createApp(App)

// 全量引入用到的 Vant 组件
const components = [
  Tabbar,
  TabbarItem,
  Cell,
  CellGroup,
  Field,
  Form,
  Button,
  Popup,
  ActionSheet,
  NavBar,
  PullRefresh,
  List,
  Empty,
  Tag,
  Icon,
    VanImage,
    Skeleton,
  Loading,
  Switch,
  Radio,
  RadioGroup,
  Checkbox,
  Tabs,
  Tab,
  Search,
  Stepper,
  DropdownMenu,
  DropdownItem,
  Divider,
  SwipeCell,
]
components.forEach((c) => app.use(c))

// 初始化主题 + 恢复已登录账号的 token（刷新后 API 请求仍带鉴权）
const store = useStore()
document.documentElement.setAttribute('data-theme', store.state.theme)
store.initAuth()

app.use(router)
app.mount('#app')
