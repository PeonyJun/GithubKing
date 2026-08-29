# GithubKing

一个 Android 端的 GitHub 管理工具，用 WebView 承载的单页应用，无需安装额外依赖，登录即用。

## 功能

- **仓库管理**：浏览/搜索我的仓库、星标仓库与其他用户的公开仓库，支持多账户切换
- **文件操作**：浏览文件树、在线编辑、创建、重命名、删除、上传，支持多选批量操作
- **Releases 管理**：查看、创建、删除版本，上传/下载发布资产
- **代理加速**：访问与下载代理分离，文本/图片/README 内容自动走代理加速加载，图片代理预览
- **网站部署**：将仓库分支发布为 GitHub Pages 静态网站，批量部署/下线
- **阅读体验**：深浅主题、文件预览（图片/视频/文本/PDF）、README 渲染

## 使用

1. 在 GitHub 设置中生成 Personal Access Token（需要 `repo` 权限）
2. 打开应用，登录令牌
3. 开始浏览和管理你的仓库

## 构建

```bash
# 同步 Web 资源到 Android assets
cp index.html style.css android/app/src/main/assets/
cp index.html style.css /opt/android-project/app/src/main/assets/

# 构建 APK
cd /opt/android-project
/opt/gradle/gradle-8.9/bin/gradle assembleRelease --no-daemon --max-workers=4
# 输出: app/build/outputs/apk/release/app-release.apk
```

## 许可

供个人使用，请遵守 GitHub 服务条款与 API 使用规范。
