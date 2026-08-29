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
