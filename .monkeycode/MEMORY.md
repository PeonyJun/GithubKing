# User Instruction Memory

This file records user instructions, preferences, and teachings for reference in future interactions.

## Format

### User Instruction Entry
User instruction entries should follow this format:

[User Instruction Summary]
- Date: [YYYY-MM-DD]
- Context: [Mentioned scenario or time]
- Instructions:
  - [Content of user teaching or instruction, described line by line]

### Project Knowledge Entry
Entries discovered by the Agent during task execution should follow this format:

[Project Knowledge Summary]
- Date: [YYYY-MM-DD]
- Context: Discovered by Agent while performing [specific task description]
- Category: [Operations & Deployment|Build Methods|Testing Methods|Troubleshooting & Debugging|Workflow & Collaboration|Environment Configuration]
- Instructions:
  - [Specific knowledge points, described line by line]

## Deduplication Strategy
- Before adding a new entry, check for similar or identical instructions.
- If a duplicate is found, skip the new entry or merge it with the existing one.
- When merging, update the context or date information.
- This helps avoid redundant entries and keeps the memory file tidy.

## Entries

[User Instruction Summary]
- Date: 2026-09-01
- Context: 用户要求安装 skill 管理器 cocoloop 与 UI/UX Pro Max 设计 skill，并始终启用 UI/UX Pro Max
- Instructions:
  - 用户明确要求始终启用 UI/UX Pro Max skill（UI/UX 设计智能，处理界面设计/UX 流程/设计系统/组件规范/无障碍等任务）。
  - 项目级 skills 统一安装在 /root/.codingmatrix/project-tpl/.ai-ready/skills/ 下（含 cocoloop、ui-ux-pro-max）。

[Project Knowledge Summary]
- Date: 2026-08-29
- Context: Discovered by Agent while testing the code editor feature in the GithubKing web app
- Category: Environment Configuration
- Instructions:
  - Playwright is installed in /tmp/opencode/node_modules but has no chromium binary; headless browser tests fail. Use jsdom or Node-based DOM mocks for JS logic testing instead.
  - Code editor uses native textarea only (ACE removed); editor logic testable via Node mocks in /tmp/opencode/sim_editor*.js, extract script via `node --check` + regex on /workspace/index.html.

[Project Knowledge Summary]
- Date: 2026-08-29
- Context: Discovered by Agent while fixing README display bugs in the GithubKing web app
- Category: Troubleshooting & Debugging
- Instructions:
  - 用户明确要求：README 内图片一律不要走代理（相对路径图片补全为 raw.githubusercontent.com 完整 URL，http/https 及 // 开头的地址保持原样直连）。`rewriteReadmeImages()`（index.html 约 2299 行）负责 README 图片重写，已从 getProxiedUrl 改为直连。
  - README 详情页内容获取 `meta.download_url` 也改为直连（不走默认代理 gh-proxy.org），否则默认开启的代理会导致"自己仓库 README 显示不出"。默认代理配置在 state（index.html 约 1524 行）：proxyGlobalEnable 默认 true，proxyPrefix 默认 https://gh-proxy.org/。
  - `.readme-preview` 原 min-height:25vh 会导致 README 短时框内底部出现白色块，已移除，改为仅保留 max-height:48vh + overflow-y:auto。
  - 仅改 /workspace 下文件，不同步 assets、不 push、不构建 APK；预览用 8000 端口 http.server。

[Project Knowledge Summary]
- Date: 2026-08-29
- Context: Discovered by Agent while adding GitHub OAuth 授权登录（只接 APK，不接网页）
- Category: Operations & Deployment
- Instructions:
  - 登录界面在 index.html 的 `#authScreen` 内：新增官方授权/令牌访问双 tab（`toggleLoginMode`）、`startOAuthLogin()`、`window.onReceiveAuthToken(token)`（APK 原生注入 token 后触发 `el.authBtn.click()`）以及已存账号快捷登录 `renderLoginSavedAccounts`/`quickLoginAccount`。
  - OAuth 只接 APK：网页端 `startOAuthLogin` 无 AndroidBridge 时仅 `window.open` 授权页（不换 token）；token 交换由 APK 端完成。
  - **构建 APK 的正确方式是往 `/opt/android-project` 同步后再用 gradle 编译**：`cp index.html style.css /opt/android-project/app/src/main/assets/`，并把 MainActivity.java、AndroidManifest.xml 同步过去；然后 `cd /opt/android-project && /opt/gradle/gradle-8.9/bin/gradle assembleRelease --no-daemon --max-workers=2`，产物 `app/build/outputs/apk/release/app-release.apk`，再复制回 `/workspace/GithubKing.apk`。签名配置在 `/opt/android-project/signing.properties`。
  - APK 端 OAuth 实现：MainActivity 注册 `@JavascriptInterface startGithubAuth()`（拉系统浏览器到 GitHub authorize）、拦截 `gk://` scheme（AndroidManifest 加 `singleTask` + `gk` scheme intent-filter）、`exchangeCodeForToken` 在 APK 内用 client_secret POST `/login/oauth/access_token` 换 token 后经 `window.onReceiveAuthToken` 注入。OAuth client_id / secret / redirect(gk://login) 常量集中在 MainActivity 顶部。
  - 内联 JS 语法校验命令：`node -e "new Function(<script>text)"`。

[Project Knowledge Summary]
- Date: 2026-08-30
- Context: Discovered by Agent while migrating sidebar to 设置页 and fixing bottom-sheet popups
- Category: Build Methods
- Instructions:
  - 设置页工作已完成：底部导航第4格「我的」改为「设置」(fa-gear)，侧边栏 `#sideNav`/`#sideNavToggleBtn`/`#mainOverlay` 已彻底删除，头像/用户名/退出/账号切换收进设置页分类卡片；设置页卡片点开用底部上滑（`.settings-sheet` 通用弹层 + 4 个原 modal 加 `bottom-sheet` 类）。
  - 用户要求的弹层交互规范：底部弹层/上滑面板**不显示右上角 x 关闭图标**，改为**点击遮罩外部即可关闭**（通过 document 级 click + `el.<sheet>.contains(e.target)` 判断，或 modal overlay `onclick` 中 `e.target === modal` 判断）。后续新增弹层一律遵循此交互。
  - 弹层定位规范：上滑面板不能贴死屏幕最底边，需 `bottom` 偏移 + 左右 margin（`.settings-sheet` 为 `bottom:12px; margin:0 8px; border-radius:14px; max-height:88vh`）；转成 bottom-sheet 的 modal 用 `.modal-overlay.bottom-sheet`（`padding:0 8px 12px`）并给内容容器 `transform:none; overflow-y:auto` 以保证内容可见且可滚动。`#usageGuideModal` 用 `.publish-help-dialog`（非 `.modal-form-container`），需单独加 `#usageGuideModal.bottom-sheet .publish-help-dialog` 的 id 级 override 才能盖过原 id 选择器。
  - 顶层 `const themeManager`/`uiStateStack` 等变量在浏览器可作为裸标识符访问但**不是 window 属性**；vm 沙箱里 `this[n]` 检测会误报 undefined。故 `renderHub`/`openLogoutConfirm` 等嵌套作用域函数需显式 `window.*` 暴露，而顶层 const 函数直接用裸标识符即可，别用 `this[n]` 判定是否存在。

[Project Knowledge Summary]
- Date: 2026-08-30
- Context: Discovered by Agent while debugging "设置功能点不出界面(只弹遮盖层或啥也不弹)"
- Category: Troubleshooting & Debugging
- Instructions:
  - **弹层"啥也不弹"最终解决**：曾用 `document` 级 click + `settingsSheetOpenAt` 时间戳(250ms)守卫实现"点击外部关闭"，但 document 监听会在同一次点击里与卡片/按钮事件相互干扰，且点击外部按钮会穿透触发按钮功能。**最终改回"遮罩层"方案**：`#settingsSheetBackdrop`（`position:fixed;inset:0;z-index:89`，`.settings-sheet` 为 90）覆盖全屏，点击 backdrop 即 `closeSettingsSheet()`，因遮罩盖住下层按钮，点击不会穿透。`openSettingsSheet`/`closeSettingsSheet` 同步显示/隐藏 backdrop。**弹层"点击外部关闭"一律用全屏遮罩层拦截，别用 document 级监听**（后者造成点击穿透/误关）。
  - **弹层"只弹遮盖层不显示内容"的根因**：CSS 进入动画 `@keyframes settingsSheetUp` 若从 `translateY(100%)`（完全屏幕外）开始，某些 WebView(`prefers-reduced-motion`/动画优化)可能卡在初始帧，导致内容停在屏幕外只剩遮罩。修复：动画起点改为 `translateY(24px)+opacity:0`（仍在屏内），并给所有 `<sheet/modal> animation: settingsSheetUp .25s ease-out both;` 加 `both` fill-mode，保证即使动画被跳过也落在可见的 `to` 态。基本原则：**弹层可见性不要依赖动画**——基础样式本身(无 transform)就应可见。`.modal-overlay.bottom-sheet` 本身即全屏遮罩(覆盖按钮故不穿透)。
  - 排查手段结论：jsdom 对该内联大 script 常因 API 缺失在 `const el`(1702) 前中断，导致 `w.el` undefined，**不可作为弹层逻辑的可靠验证**；可靠的是 vm 沙箱 mock(补齐 localStorage/fetch/HTMLAudioElement 等)逐个调用函数 + `node --check`。真实浏览器唯一可靠验证需真机。
   - 用户要求"暗色主题要标准，不要深蓝/蓝"，采用 GitHub Dark 中性色系。改动在 style.css：`:root`(暗色) `--gk-*` 改为 #0d1117/#161b22/#21262d/…(#e6edf3/#8b949e)；body 背景与 `#authScreen` 同用 `--gk-bg:#0d1117`；footer 底栏 rgba(10,15,30,.6)→rgba(13,17,23,.6)；slate 蓝面(linear-gradient(#1e293b,#0f172a)等 4 处)→中性 #0d1117/#1c2128；rgba(15,23,42)/rgba(30,41,59) 玻璃面→rgba(22,27,34)/rgba(33,38,45)。**关键边界**：`#111827`(gray-900)`#0f172a`/`#1e293b`/`#334155` 也作为 `body.light-theme` 下的亮色深文字色，**绝对不能全局替换**，只改 `body.light-theme` 之外(暗色)的背景用法。代码编辑器保留标准蓝色 accent 按钮(#1e3a5f/#2b528a/#93c5fd)作为操作高亮。
  - **浅色主题已设为硬默认 + 主题切换开关化**：①`<body>` 直接写 `class="light-theme"`（line 11）让浅色成为 HTML/CSS 硬默认，无存储时首帧就是浅色，不再闪暗色；②设置「主题切换」卡片由"点开底部 sheet 选浅/深"改为**卡片文字+右侧 `.switch` 开关**：卡片左为标题"启用深色主题"+副文案(`#settingsThemeSub` 浅色模式/深色模式)，右为 `label.switch.settings-theme-switch > input#settingsThemeToggle + span.slider.round`，点开关直接 `themeManager.apply('dark'|'light')` 并写 `localStorage app_theme`，**不再走 `showSettingsSheetTheme` 底部 sheet**（该函数现为死代码保留不影响）；③图标 `#settingsThemeIcon` 浅色= fa-sun / 深色= fa-cloud，随 class 切换同步（`syncSettingsThemeUI()` 统一刷新开关状态、副文案、图标）；④**修复了 `themeManager.apply` 曾依赖已删除的 `#menuThemeToggle`**——旧实现 `if(!themeToggle)return` 会短路导致 class/meta 永远不切换（侧边栏迁移后主题实际失效），现改为不依赖该按钮并统一 `syncSettingsThemeUI`；⑤主题变量(color)本就由 `--gk-*`+`body.light-theme` 驱动，切换 `light-theme` 类即可整体变色，文字/图标动态变换无需额外 selector。工装：vm 沙箱 `themeManager.apply("dark"/"light")+syncSettingsThemeUI()` 冒烟通过，`node --check` 通过，文件已同步 `/opt/android-project/app/src/main/assets/`。
   - **软件层状态栏/底部小白条适配暗色 + 前端主题一致性**：①`MainActivity.COLOR_DARK` 由老深蓝 `0xFF04091A` 改为中性 `0xFF0D1117`，使 Android 原生状态栏/导航栏(`applyThemeUi` 里 `setStatusBarColor`/`setNavigationBarColor` + `LIGHT_*_BAR` 开关)颜色与 web 暗色 `#0d1117` 一致；`@JavascriptInterface setTheme` 桥接接收 `themeManager.apply` 调用，每次切换都会刷新原生栏色；②浅色主题下底部 footer 背景由 `rgba(255,255,255,0.6)`(半透明白)改为**不透明 `#f0f2f5`**，与顶部 `<header>`(sticky 透明+blur 透出 body `--gk-bg:#f0f2f5`)完全同色，实现"底部导航块 = 顶部标题栏色"；暗色 footer 仍 `rgba(13,17,23,.6)` 保持不变；③**长按右键菜单 `#contextMenu`** 加 `max-height:11.5rem; overflow-y:auto`(约显 5 项)并保留 `-webkit-overflow-scrolling:touch`，超出项可手动上滑；`menuHeight=menu.offsetHeight` 自动反映 max-height 封顶值，底部定位 clamp 仍准确，短菜单自然收缩不出现空框。

[Project Knowledge Summary]
- Date: 2026-09-01
- Context: Discovered by Agent while 优化 UI/UX（设置/部署标题、app 壳配色、重做部署界面）+ 打包 APK
- Category: Build Methods
- Instructions:
  - **当前环境可直接在仓库内 `/workspace/android` 模块构建 APK**（比 /opt/android-project 更直接）：工具链已装 `/opt/gradle/gradle-8.9`、`/opt/android-sdk`（platform 34 + build-tools 34.0.0），JDK 为系统 openjdk-17。`cp index.html style.css android/app/src/main/assets/` 后执行 `cd /workspace/android && JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 && ANDROID_HOME=/opt/android-sdk && /opt/gradle/gradle-8.9/bin/gradle assembleRelease --no-daemon --max-workers=2`，产物 `app/build/outputs/apk/release/app-release.apk`，复制回 `/workspace/GithubKing_1.0.1.apk`。`android/local.properties` 需含 `sdk.dir=/opt/android-sdk`。release 签名配置在 `android/signing.properties` + `android/githubking-release.jks`（.gitignore 已忽略，不入库）。
  - **系统状态栏/导航栏(小白条)颜色要与顶部 header、底部 footer 同色**（本次定为：暗色 `#161B22`=header/footer 的 `--gk-surface`，浅色 `#FFFFFF`=header/footer 白色），而 WebView 背景用 body 色（暗 `#0D1117`、浅 `#F0F2F5`）避免下拉刷新露色块。即 MainActivity `applyThemeUi` 分离 `barColor`(系统栏)与 `webColor`(WebView 背景)。`res/values/themes.xml` 的 AppTheme/ApperTheme.Light 也需同步 statusBarColor/navigationBarColor（同 barColor）、windowBackground（同 body 色）。
   - **UI 页约定**：顶部左侧 `<h1 id=currentRepo>` 是各页面顶栏标题。设置页 `showSettingsPage()` 需自行 `el.currentRepo.textContent='设置'`（其内容区不再放"设置"标题）；部署页 `showPublishPage()` 已设标题并移除内容区 `.gk-page-head`。部署管理列表 `#publishManageList` 已改为 `.gk-card-list` 卡片化，点击卡片项进 `showPublishDetailPage(fullname)` 部署详情页（视图标识 `state.currentView='publish_detail'`、`#publishDetailPage` 容器、`updatePaginationUI` 用 backBtn 返回切换），详情页用 `renderPublishDetailBody` 复用现有发布/域名函数。

[Project Knowledge Summary]
- Date: 2026-09-01
- Context: Discovered by Agent while 修复部署详情页"串台到其他主 tab"+"返回直接跳仓库列表"两个 bug
- Category: Troubleshooting & Debugging
- Instructions:
  - **新增子页面(如部署详情 `#publishDetailPage`)必须被所有主视图切换函数隐藏**，否则会"串台"到其他主 tab（内容叠显在背后）。既有 `showRepoListView()`/`showPublishPage()`/`showSettingsPage()` 只隐藏 `publishPage`/`settingsPage`/`repoList`/`fileList`，**不隐藏后来新增的详情容器**，务必逐个补 `if (el.publishDetailPage) el.publishDetailPage.classList.add('hidden')`。
  - **浏览器/系统"返回"依赖 history+popstate**，子页面若不 push 自己的 state，返回会跳过其"父级"直接把栈底(常是 own_repos)弹出的上层清掉→跳回仓库列表而非上一级。修复：进入子视图时 `history.pushState({view:'detail', fullname},...)`，footer backBtn 与系统返回统一走 `history.back()` → 在 popstate 的 `case` 里渲染上一级(父视图)并做返回高亮(记录 flash 目标如 `state.publishReturnFlashFullname`)。切勿在 back 里既直接 `showXxx()` 又 `history.back()` 混用，会与 popstate 双重重渲染；backBtn 只 `history.back()`，恢复逻辑全放 popstate。
  - **`updatePaginationUI` 里 `isHomeListView` 决定底部 tab 显隐**：新增的子视图(如 `publish_detail`)不在该集合时，报错/详情等非首页视图会把 bnStar/bnDeploy/bnMine 隐藏。底部 tab `bnDeploy.onclick` 需在详情视图下也能返回列表（`if(isPublishDetail){hidePublishDetailPage();return}`）。
  - **在现有`switch … case`分组中新增 `case` 时，切勿插到多 case 分组的中间**：`case 'starred_repos': case 'own_repos': …` 这类连续 case 是**fall-through**到 `default` 的；若把新子视图的 `case`（含 `return`/隐藏 footer 逻辑）插进这个连续 case 列表里，前面所有主 tab 会一起 fall-through 进新 case 的代码（如 `footer.style.display='none'`），导致所有页面底栏/导航消失（回归）。新增独立子视图 case 应放在"连续 case 分组 + `default`"之前或之后单独成块。
  - **部署列表 `renderPublishManagerLists` 与仓库列表动画**：`.gk-card-item` 部署卡片原本无入场动效；要加"载入动效"就复用 `.file-item-enter`+`itemFadeInUp` 动画，用 `state.shouldAnimateList` 门控（`showPublishPage()` 置 true，render 末尾置 false），并给每个卡片 `animationDelay = enterIndex*30ms` 做交错。仓库列表 `renderRepoList` 本就应用 `.file-item-enter`，机制完好在代码层经 jsdom 验证生效；若用户反映"没动效"，多为 `shouldAnimateList` 为 false 的导航路径，非 CSS/机制损坏。
  - **下拉刷新 `initPullToRefresh` 的 `targetListEl` 只认 `repoList`/`fileList`**，部署页(`publishManageList`)无目标 → 部署页本来就拉不动。要让所有列表页都能下拉刷新：`touchstart` 里把 `!el.publishPage.classList.contains('hidden')? el.publishManageList : null` 加进目标链；`handleRefresh` 需在 `publish_manager` 视图下 `fetchRepos(true,false)` + `renderPublishManagerLists()` 后 return。
