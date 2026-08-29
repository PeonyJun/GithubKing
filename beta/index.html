<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no, viewport-fit=cover">
    
    <title>GitHub 移动工作台</title>
    <script>
        const isDark = localStorage.getItem('gh_dark_mode') === '1';
        if (isDark) document.documentElement.classList.add('dark-theme');
        document.write(`<meta name="theme-color" id="themeMeta" content="${isDark ? '#141516' : '#f8fafc'}">`);
    </script>
    <style>
        html, body { background: #ffffff; margin: 0; padding: 0; width: 100%; height: 100%; overflow: hidden; position: fixed; inset: 0; }
        @keyframes high-end-spin { 0% { transform: rotate(0deg); } 100% { transform: rotate(360deg); } }
        @keyframes pulse-text { 0%, 100% { opacity: 0.5; } 50% { opacity: 1; } }
    </style>
    <script src="https://cdn.tailwindcss.com" defer></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/marked/9.1.6/marked.min.js" defer></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js" defer></script>
        
        <script>
          function handleAvatarError(img) {
    img.onerror = null;
    img.src = 'data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgZmlsbD0iI2NiZDVlMSI+PHBhdGggZD0iTTEyIDEyYzIuMjEgMCA0LTEuNzkgNC00cy0xLjc5LTQtNC00LTQgMS43OS00IDQgMS43OSA0IDQgNHptMCAyYy0yLjY3IDAtOCAxLjM0LTggNHYyaDE2di0yYzAtMi42Ni01LjMzLTQtOC00eiIvPjwvc3ZnPg==';
}

        </script>
        
    

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap');
       
        :root { --safe-bottom: env(safe-area-inset-bottom, 0px); --safe-top: env(safe-area-inset-top, 0px); }


        .hidden { display: none !important; }

        body { 
            font-family: -apple-system, BlinkMacSystemFont, 'Inter', 'PingFang SC', 'Helvetica Neue', sans-serif;

            -webkit-tap-highlight-color: transparent; overscroll-behavior-y: none;
        }
        
        .custom-scrollbar::-webkit-scrollbar { width: 4px; height: 4px; background-color: transparent; }
        .custom-scrollbar::-webkit-scrollbar-track, 
        .custom-scrollbar::-webkit-scrollbar-track-piece, 
        .custom-scrollbar::-webkit-scrollbar-corner, 
        .custom-scrollbar::-webkit-resizer { background-color: transparent; }
        .custom-scrollbar::-webkit-scrollbar-thumb { background-color: rgba(203, 213, 225, 0.6); border-radius: 10px; background-clip: padding-box; }

        .page-slide { transition: transform 0.3s cubic-bezier(0.25, 0.8, 0.25, 1), box-shadow 0.3s ease-in-out; }
        .translate-x-full { transform: translateX(100%); box-shadow: none !important; }
        .translate-x-0 { transform: translateX(0); }

        .markdown-body { font-size: 15px; line-height: 1.6; color: #334155; word-wrap: break-word;}
        .markdown-body h1, .markdown-body h2 { font-weight: 700; border-bottom: 1px solid #e2e8f0; padding-bottom: 8px; margin: 16px 0; }
        .markdown-body pre { background: #f8fafc; padding: 12px; border-radius: 8px; overflow-x: auto; margin-bottom: 16px; border: 1px solid #e2e8f0; font-size: 13px;}
        .markdown-body code { background: #f1f5f9; padding: 2px 6px; border-radius: 4px; font-family: monospace; font-size: 13px; color: #ef4444;}
        .markdown-body img { max-width: 100%; border-radius: 8px; }

        #fileRichEditor {
            font-family: ui-monospace, SFMono-Regular, Consolas, "Liberation Mono", Menlo, monospace;
            tab-size: 4;
        }

        .tab-btn { transition: all 0.4s cubic-bezier(0.16, 1, 0.3, 1); }

        
        .head-icon-glow {
            box-shadow: 0 0 25px rgba(34, 197, 94, 0.15);
            border: 1px solid rgba(34, 197, 94, 0.08);
        }

        .btn-green-halo {
            box-shadow: 0 0 20px rgba(16, 185, 129, 0.35);
            transition: all 0.3s ease;
        }
        .btn-green-halo:active {
            box-shadow: 0 0 10px rgba(16, 185, 129, 0.2);
            transform: scale(0.97);
        }
        
html.dark-theme body,
html.dark-theme #loginView,
html.dark-theme #first-paint-loader,
html.dark-theme .bg-gray-50,
html.dark-theme .bg-slate-50,
html.dark-theme .bg-slate-50\/50 {
    background-color: #141516 !important;
    color: #c4d5df !important;
}

html.dark-theme .bg-white,
html.dark-theme .bg-white\/90 {
    background-color: #101010 !important;
}

html.dark-theme .bg-slate-100,
html.dark-theme .bg-slate-100\/80,
html.dark-theme .bg-slate-200,
html.dark-theme .active\:bg-slate-50:active,
html.dark-theme .active\:bg-slate-100:active,
html.dark-theme .active\:bg-slate-200:active {
    background-color: #1a1e24 !important;
}

html.dark-theme .text-slate-900,
html.dark-theme .text-slate-800,
html.dark-theme .text-slate-700,
html.dark-theme .text-gray-900 {
    color: #c4d5df !important;
}

html.dark-theme .text-slate-600,
html.dark-theme .text-slate-500 {
    color: #8b9bb4 !important;
}

html.dark-theme .text-slate-400,
html.dark-theme .text-slate-300 {
    color: #5c6b80 !important;
}

html.dark-theme .border-gray-200,
html.dark-theme .border-slate-100,
html.dark-theme .border-slate-200,
html.dark-theme .border-slate-50,
html.dark-theme .border-slate-100\/50,
html.dark-theme .divide-slate-50 > :not([hidden]) ~ :not([hidden]) {
    border-color: #1a1e24 !important;
}

html.dark-theme input,
html.dark-theme textarea {
    background-color: #101010 !important;
    color: #c4d5df !important;
    border-color: #1a1e24 !important;
}

html.dark-theme input::placeholder,
html.dark-theme textarea::placeholder {
    color: #5c6b80 !important;
}

html.dark-theme div.bg-blue-600 {
    background-color: #101010 !important;
    border: 1px solid #1a1e24 !important;
    box-shadow: none !important;
}

html.dark-theme .text-blue-100 {
    color: #8b9bb4 !important;
}


html.dark-theme #slider {
    background-color: #2c2c2c !important;
}


html.dark-theme #contextMenuOverlay,
html.dark-theme #formModal,
html.dark-theme #promptModal,
html.dark-theme #uploadPanelModal {
    background-color: rgba(255, 255, 255, 0.12) !important;
    backdrop-blur-sm: 4px;
}
html.dark-theme #loginAccountsList > div {
    background-color: #101010 !important;
    border-color: #1a1e24 !important;
}

html.dark-theme button[onclick="logout()"] {
    background-color: #1a1e24 !important;
    color: #c4d5df !important;
}

html.dark-theme button[onclick="logout()"]:active {
    background-color: #2c2c2c !important;
}
html.dark-theme .bg-emerald-50,
html.dark-theme .bg-blue-50,
html.dark-theme .bg-indigo-50,
html.dark-theme .bg-purple-50,
html.dark-theme .bg-amber-50,
html.dark-theme .bg-red-50 {
    background-color: #1a1e24 !important;
}

    </style>


<style>
#loginView {
    position: fixed;
    inset: 0;
    background: #ffffff;
    z-index: 1000;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 2rem;
    transition: opacity 0.3s;
}
#loginView.hidden {
    display: none !important;
}
.login-wrapper {

    width: 100%;
    max-width: 320px;
    display: flex;
    flex-direction: column;
}
.login-header {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 1.5rem;
}
.logo-box {
    width: 3.5rem;
    height: 3.5rem;
    background: #ffffff;
    border-radius: 18px;
    display: flex;
    align-items: center;
    justify-content: center;
    box-shadow: 0 0 25px rgba(34, 197, 94, 0.15);
    border: 1px solid rgba(34, 197, 94, 0.08);
    margin-bottom: 1rem;
}
.login-tabs {
    position: relative;
    background: rgba(226, 232, 240, 0.4);
    padding: 4px;
    border-radius: 9999px;
    display: flex;
    margin-bottom: 2rem;
    border: 1px solid rgba(226, 232, 240, 0.1);
}
.tab-btn-native {
    position: relative;
    z-index: 10;
    flex: 1;
    padding: 0.75rem 0;
    font-size: 11px;
    font-weight: 700;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.5rem;
    border: none;
    background: none;
    color: #94a3b8;
    cursor: pointer;
}
#slider {
    position: absolute;
    top: 4px;
    left: 4px;
    width: calc(50% - 4px);
    height: calc(100% - 8px);
    background: #ffffff;
    border-radius: 9999px;
    box-shadow: 0 1px 2px rgba(0,0,0,0.05);
    transition: transform 0.4s cubic-bezier(0.16, 1, 0.3, 1);
}
.pane-native {
    position: absolute;
    inset: 0;
    display: flex;
    flex-direction: column;
    transition: opacity 0.3s ease, transform 0.3s ease;
}
.btn-oauth-native {
    width: 100%;
    background: #10b981;
    color: #ffffff;
    height: 54px;
    border-radius: 1rem;
    font-size: 13px;
    font-weight: 700;
    border: none;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.6rem;
    box-shadow: 0 0 20px rgba(16, 185, 129, 0.35);
}
.token-area {
    background: #ffffff;
    padding: 4px;
    border-radius: 22px;
    border: 1px solid #f1f5f9;
    box-shadow: 0 1px 2px rgba(0,0,0,0.05);
    margin-bottom: 1.5rem;
}
.token-input-native {
    width: 100%;
    background: transparent;
    padding: 0.75rem 1rem;
    border: none;
    outline: none;
    font-size: 11px;
    font-family: 'JetBrains Mono', monospace;
    color: #475569;
    resize: none;
}
</style>
    

</head>
<body class="bg-gray-50 text-slate-900 h-[100dvh] w-full flex flex-col overflow-hidden select-none">
            <div id="first-paint-loader" style="position:fixed;inset:0;background:#ffffff;display:flex;flex-direction:column;justify-content:center;align-items:center;z-index:9999;transition:opacity 0.5s ease-out;">
        <div style="position:relative;width:48px;height:48px;">
            <div style="position:absolute;inset:0;border:3px solid #f1f5f9;border-radius:50%;"></div>
            <div style="position:absolute;inset:0;border:3px solid transparent;border-top:3px solid #000000;border-radius:50%;animation:high-end-spin 1s cubic-bezier(0.6, 0.2, 0.1, 1) infinite;"></div>
        </div>
        <div style="margin-top:24px;display:flex;flex-direction:column;align-items:center;gap:4px;">
            <span class="text-slate-900" style="font-size:12px;font-weight:700;letter-spacing:2px;font-family:ui-sans-serif,system-ui;text-indent:2px;">GITHUB</span>
            <span class="text-slate-400" style="font-size:10px;font-weight:500;letter-spacing:1px;animation:pulse-text 1.5s ease-in-out infinite;">MOBILE 加载中</span>
        </div>
    </div>





    <!-- ========== 1. 登录页面 ========== -->
        <div id="loginView">
    <div class="login-wrapper">
        <header class="login-header">
            <div class="logo-box">
                <svg viewBox="0 0 24 24" style="width:1.75rem;height:1.75rem;fill:none;stroke:#334155;stroke-width:1.2;stroke-linecap:round;stroke-linejoin:round;"><path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path></svg>
            </div>
            <h1 style="font-size:16px;font-weight:bold;color:#1e293b;margin:0;">GK 登陆中心</h1>
            <p style="font-size:10px;font-weight:bold;color:#94a3b8;text-transform:uppercase;letter-spacing:1px;margin-top:4px;">安全加密环境已就绪</p>
        </header>

        <div id="loginAccountsList" style="width:100%;margin-bottom:1rem;display:flex;flex-direction:column;gap:0.5rem;"></div>

        <div class="login-tabs">
            <div id="slider"></div>
            <button onclick="toggleLoginMode('oauth')" id="btn-oauth" class="tab-btn-native tab-active-native" style="color:#1e293b">
                <svg viewBox="0 0 24 24" style="width:14px;height:14px;fill:none;stroke:currentColor;stroke-width:2;"><polygon points="13 2 3 14 12 14 11 22 21 10 12 10 13 2"></polygon></svg>
                <span>官方授权</span>
            </button>
            <button onclick="toggleLoginMode('token')" id="btn-token" class="tab-btn-native">
                <svg viewBox="0 0 24 24" style="width:14px;height:14px;fill:none;stroke:currentColor;stroke-width:2;"><path d="M2 18v3c0 .6.4 1 1 1h4v-3h3v-3h2l1.4-1.4c.9.9 2.1 1.4 3.6 1.4 2.8 0 5-2.2 5-5s-2.2-5-5-5-5 2.2-5 5c0 1.5.5 2.7 1.4 3.6L2 18Z"></path><circle cx="17" cy="7" r="1"></circle></svg>
                <span>令牌访问</span>
            </button>
        </div>

        <main style="position:relative;height:290px;">
            <div id="pane-oauth" class="pane-native">
                <div style="background:#ffffff;border:1px solid #f1f5f9;border-radius:24px;padding:1.5rem;margin-bottom:1.5rem;box-shadow:0 1px 2px rgba(0,0,0,0.05);">
                    <div style="display:flex;align-items:center;gap:0.5rem;margin-bottom:0.75rem;">
                        <svg viewBox="0 0 24 24" style="width:1rem;height:1rem;stroke:#10b981;fill:none;stroke-width:2;"><circle cx="12" cy="12" r="10"></circle><path d="m9 12 2 2 4-4"></path></svg>
                        <span style="font-size:11px;font-weight:bold;color:#475569;">GitHub 授权登录</span>
                    </div>
                    <p style="font-size:12px;color:#94a3b8;line-height:1.7;margin:0;">已连接GitHub官方授权通道，你的隐私信息将由 <span style="color:#10b981;font-weight:500;">官方协议</span> 严格保护，此功能需要访Github无效果请开启代理至此APP。</p>
                </div>
                <button id="oauthBtn" onclick="oauth()" class="btn-oauth-native">
                    <svg viewBox="0 0 24 24" style="width:1rem;height:1rem;stroke:rgba(255,255,255,0.7);fill:none;stroke-width:2;"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10Z"></path><path d="m9 12 2 2 4-4"></path></svg>
                    <span>开启官方安全登录</span>
                </button>
                <div style="margin-top:auto;margin-bottom:0.5rem;display:flex;align-items:center;justify-content:center;gap:0.5rem;">
                    <svg viewBox="0 0 24 24" style="width:14px;height:14px;stroke:#10b981;fill:none;stroke-width:2;"><path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10Z"></path><path d="m9 12 2 2 4-4"></path></svg>
                    <span style="font-size:10px;font-weight:bold;color:#94a3b8;">已通过 GitHub 安全协议校验</span>
                </div>
            </div>

            <div id="pane-token" class="pane-native" style="opacity:0;transform:scale(0.96);pointer-events:none;">
                <div class="token-area">
                    <div style="display:flex;align-items:center;gap:0.5rem;padding:0.75rem 1rem 0;">
                        <svg viewBox="0 0 24 24" style="width:12px;height:12px;stroke:#cbd5e1;fill:none;stroke-width:2;"><path d="m15.5 7.5 2.3 2.3a1 1 0 0 0 1.4 0l2.1-2.1a1 1 0 0 0 0-1.4L19 4"></path><path d="m21 2-9.6 9.6"></path><circle cx="7.5" cy="15.5" r="5.5"></circle></svg>
                        <span style="font-size:9px;font-weight:bold;color:#cbd5e1;text-transform:uppercase;letter-spacing:1px;">令牌信息仅本地存储</span>
                    </div>
                    <textarea id="tokenInput" rows="3" placeholder="在此输入您的 Access Token (ghp_...)" class="token-input-native"></textarea>
                </div>
                <button onclick="handleLogin()" style="width:100%;height:54px;background:#ffffff;border:1px solid #e2e8f0;color:#475569;border-radius:1rem;font-size:13px;font-weight:bold;display:flex;align-items:center;justify-content:center;gap:0.5rem;box-shadow:0 1px 2px rgba(0,0,0,0.05);">
                    <svg viewBox="0 0 24 24" style="width:1rem;height:1rem;stroke:#6366f1;fill:none;stroke-width:2;"><path d="M12 10a2 2 0 0 0-2 2c0 1.02-.1 2.51-.26 4"></path><path d="M14 13.12c0 2.38 0 6.38-1 8.88"></path><path d="M17.29 21.02c.12-.38.24-.76.36-1.12"></path><path d="M18 12a6 6 0 0 0-12 0c0 1.53-.16 3.1-.5 4.5"></path><path d="M22 12a10 10 0 0 0-20 0"></path></svg>
                    <span>验证并初始化环境</span>
                </button>
                <div style="margin-top:auto;margin-bottom:0.5rem;display:flex;align-items:center;justify-content:center;gap:0.5rem;cursor:pointer;" onclick="openExternalBrowser('https://github.com/settings/tokens/new')">
                    <svg viewBox="0 0 24 24" style="width:14px;height:14px;stroke:#6366f1;fill:none;stroke-width:2;"><circle cx="12" cy="12" r="10"></circle><path d="M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3"></path><line x1="12" x2="12.01" y1="17" y2="17"></line></svg>
                    <span style="font-size:10px;font-weight:bold;color:#94a3b8;text-transform:uppercase;letter-spacing:1px;">如何获取 TOKEN？</span>
                </div>
            </div>
        </main>
    </div>
</div>






    <!-- ========== 2. APP 核心容器-顶部导航栏修改高度 ========== -->
    <div id="appView" class="hidden fixed inset-0 w-full h-[100dvh] flex flex-col bg-gray-50 z-10 overflow-hidden min-h-0">
                <header class="bg-white/90 backdrop-blur-md border-b border-gray-200 flex items-center justify-between px-4 shrink-0 z-50 w-full" style="padding-top: calc(var(--safe-top) + 8px); padding-bottom: 8px; min-height: calc(60px + var(--safe-top));">



            <div class="flex items-center gap-3 w-1/4">
                <button id="navBackBtn" onclick="goBack()" class="hidden p-2 -ml-2 text-slate-700 active:bg-slate-100 rounded-full transition-colors">
                    <i data-lucide="chevron-left" class="w-6 h-6"></i>
                </button>
            </div>

            <div class="flex-1 text-center">
                <h2 id="navTitle" class="text-[17px] font-bold text-slate-800 truncate px-2">我的仓库</h2>
                <p id="navSubtitle" class="text-[11px] text-slate-400 hidden truncate">main</p>
            </div>

            <div class="flex items-center justify-end gap-2 w-1/4" id="navRightArea"></div>
        </header>


        <div id="mainContent" class="flex-1 relative overflow-hidden min-h-0">


            
            <!-- 【Tab 1】仓库列表 -->
            <div id="pageRepos" class="base-tab absolute inset-0 bg-gray-50 overflow-y-auto pb-24 z-10 custom-scrollbar">
                <div class="p-4" id="repoList"></div>
            </div>

            <!-- 【Tab 2】星标仓库 -->
            <div id="pageStarred" class="base-tab hidden absolute inset-0 bg-gray-50 overflow-y-auto z-10 custom-scrollbar">
                <div class="p-4" id="starredList"></div>
            </div>

            <!-- 【Tab 3】部署管理 -->
            <div id="pageDeploy" class="base-tab hidden absolute inset-0 bg-gray-50 overflow-y-auto pb-24 z-10 custom-scrollbar">
                <div class="px-4 py-3 text-xs font-bold text-slate-400 uppercase tracking-widest bg-gray-50">选择仓库以配置 Pages 部署</div>
                <div class="px-4" id="deployList"></div>
            </div>

            <!-- 【Tab 4】我的 (多账号 & 代理设置) -->
            <div id="pageProfile" class="base-tab hidden absolute inset-0 bg-gray-50 overflow-y-scroll overflow-x-hidden pb-24 z-10 custom-scrollbar">
                <div class="p-4">
                    <div class="flex items-center justify-between mb-2 px-1">
                        <h3 class="text-xs font-bold text-slate-400 uppercase tracking-widest">当前账号</h3>
                        <button onclick="triggerAddAccount()" class="flex items-center gap-2 text-blue-600 font-bold text-[11px] active:opacity-70 transition-opacity">
                            <i data-lucide="plus" class="w-3.5 h-3.5"></i>
                            <span>添加账号</span>
                        </button>
                    </div>
                    <div class="p-5 bg-blue-600 rounded-2xl flex items-center justify-between shadow-lg shadow-blue-600/20 mb-6">
                        <div class="flex items-center gap-4">
                            <img id="profileAvatar" src="" onerror="handleAvatarError(this)" class="w-14 h-14 rounded-full border-2 border-white/50 shadow-sm bg-slate-100">
                            <div>

                                <h2 id="profileName" class="text-lg font-bold text-white">-</h2>
                                <p class="text-[11px] text-blue-100 font-medium mt-0.5">已连接至 GitHub API</p>
                            </div>
                        </div>
                        <button onclick="logout()" class="px-3 py-1.5 bg-white/20 text-white text-xs font-bold rounded-full active:bg-white/30">退出</button>
                    </div>
                    <div id="accountsList" class="space-y-2 mb-6"></div>

                    <h3 class="text-xs font-bold text-slate-400 uppercase tracking-widest mb-3 px-1 mt-6">系统设置</h3>
                    <div class="space-y-3 mb-6">
                        
                        <div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
                            <div class="p-4 flex items-center justify-between bg-white">
                                <div class="flex items-center gap-3">
                                    <div class="w-8 h-8 rounded-lg bg-slate-50 flex items-center justify-center">
                                        <i data-lucide="moon" class="w-4 h-4 text-slate-500"></i>
                                    </div>
                                    <span class="font-bold text-slate-700 text-[14px]">深色模式</span>
                                </div>
                                <label class="relative inline-flex items-center cursor-pointer">
                                    <input type="checkbox" id="themeToggle" class="sr-only peer" onchange="toggleDarkTheme()">
                                    <div class="w-11 h-6 bg-slate-200 rounded-full peer peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-slate-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all peer-checked:bg-slate-800"></div>
                                </label>
                            </div>
                        </div>

                        <div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
                            <button onclick="toggleProxyCard()" class="w-full p-4 flex items-center justify-between bg-white active:bg-slate-50 transition-colors">
                                <div class="flex items-center gap-3">
                                    <div class="w-8 h-8 rounded-lg bg-emerald-50 flex items-center justify-center">
                                        <i data-lucide="zap" class="w-4 h-4 text-emerald-500"></i>
                                    </div>
                                    <span class="font-bold text-slate-700 text-[14px]">资源代理设置</span>
                                </div>
                                <i data-lucide="chevron-down" id="proxyCardIcon" class="w-5 h-5 text-slate-400 transition-transform duration-200"></i>
                            </button>
                            
                            <div id="proxyCardBody" class="hidden border-t border-slate-100 p-4 bg-slate-50/50">
                                <div class="flex items-center justify-between mb-5">
                                    <span class="font-bold text-slate-600 text-[13px]">启用代理</span>
                                    <label class="relative inline-flex items-center cursor-pointer">
                                        <input type="checkbox" id="proxyToggle" class="sr-only peer">
                                        <div class="w-11 h-6 bg-slate-200 rounded-full peer peer-checked:after:translate-x-full peer-checked:after:border-white after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white after:border-slate-300 after:border after:rounded-full after:h-5 after:w-5 after:transition-all peer-checked:bg-blue-600"></div>
                                    </label>
                                </div>
                                
                                <div class="bg-white rounded-xl p-3 border border-slate-200 shadow-sm focus-within:border-blue-400 focus-within:ring-1 focus-within:ring-blue-100 transition-all mb-2">
                                    <input type="text" id="proxyUrl" placeholder="https://web.ksx.qzz.io/" class="w-full bg-transparent text-[13px] outline-none text-slate-600 placeholder:text-slate-300">
                                </div>
                                <p class="text-[10px] text-slate-400 mt-2 leading-relaxed px-1 mb-5">
                                    极大提高资源加速下载体验。格式为：代理网址 + GitHub链接<br>
                                    
                                    当前核心作用：代理加速下载（支持 txt 等文本文件强制触发下载，告别浏览器直接预览）。
                                    <br>
                                    <span class="text-red-500 font-medium">默认代理是专属定制节点，轻易不要更换！</span>
                                </p>
                                
                                <button onclick="saveProxySettings(); toggleProxyCard();" class="w-full py-3.5 bg-blue-600 text-white rounded-xl text-[13px] font-bold shadow-sm shadow-blue-600/20 active:bg-blue-700 transition-colors flex items-center justify-center gap-2">
                                    <i data-lucide="check" class="w-4 h-4"></i> 保存设置
                                </button>
                            </div>
                        </div>

                        <div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden">
                            <button onclick="toggleScopeCard()" class="w-full p-4 flex items-center justify-between bg-white active:bg-slate-50 transition-colors">
                                <div class="flex items-center gap-3">
                                    <div class="w-8 h-8 rounded-lg bg-blue-50 flex items-center justify-center">
                                        <i data-lucide="key" class="w-4 h-4 text-blue-500"></i>
                                    </div>
                                    <span class="font-bold text-slate-700 text-[14px]">Token 权限概览</span>
                                </div>
                                <i data-lucide="chevron-down" id="scopeCardIcon" class="w-5 h-5 text-slate-400 transition-transform duration-200"></i>
                            </button>
                            
                            <div id="scopeCardBody" class="hidden border-t border-slate-100 p-4 bg-slate-50/50">
                                <div id="scopeContainer">
                                    <div id="scopeGrid" class="grid grid-cols-1 gap-2"></div>
                                </div>
                            </div>
                        </div>
                    </div> 
                                        <div class="flex items-center justify-between mb-3 px-1 mt-6">
    <h3 class="text-xs font-bold text-slate-400 uppercase tracking-widest">交流建议</h3>
</div>
<div class="bg-white rounded-2xl shadow-sm border border-slate-100 overflow-hidden mb-6">
    <button onclick="toggleCmCard()" class="w-full p-4 flex items-center justify-between bg-white active:bg-slate-50 transition-colors">
        <div class="flex items-center gap-3">
            <div class="w-8 h-8 rounded-lg bg-indigo-50 flex items-center justify-center">
                <i data-lucide="edit-3" class="w-4 h-4 text-indigo-500"></i>
            </div>
            <span class="font-bold text-slate-700 text-[14px]">反馈与评论</span>
        </div>
        <i data-lucide="chevron-down" id="cmCardIcon" class="w-5 h-5 text-slate-400 transition-transform duration-200"></i>
    </button>
    <div id="cmCardBody" class="hidden border-t border-slate-100">
        <div class="p-4 border-b border-slate-50" id="cmFormArea">
            <div class="flex justify-between items-center mb-3 hidden" id="replyIndicator">
                <span class="text-[11px] font-bold text-blue-500 bg-blue-50 px-2 py-1 rounded-lg" id="replyText">正在回复</span>
                <button onclick="cancelReply()" class="text-slate-400 p-1"><i data-lucide="x" class="w-4 h-4"></i></button>
            </div>
            <div class="flex gap-3 mb-3">
                <img id="cmAvatar" src="https://q1.qlogo.cn/g?b=qq&nk=10000&s=100" class="w-10 h-10 rounded-full border border-slate-100 shadow-sm shrink-0 object-cover">
                <div class="flex-1 flex gap-2">
                    <input type="text" id="cmName" placeholder="昵称" onfocus="handleCmFocus()" onblur="handleCmBlur()" class="w-1/2 bg-slate-50 p-2.5 rounded-xl border border-slate-200 text-[12px] outline-none focus:border-blue-500 transition-colors">
                    <input type="number" id="cmQQ" placeholder="QQ号" onfocus="handleCmFocus()" onblur="updateCmAvatar(); handleCmBlur()" class="w-1/2 bg-slate-50 p-2.5 rounded-xl border border-slate-200 text-[12px] outline-none focus:border-blue-500 transition-colors">
                </div>
            </div>
            <textarea id="cmContent" rows="3" placeholder="留下你的建议或反馈..." onfocus="handleCmFocus()" onblur="handleCmBlur()" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-[12px] outline-none focus:border-blue-500 transition-colors mb-3 resize-none custom-scrollbar"></textarea>
            
            <div class="flex items-center justify-between">
                <div class="flex items-center gap-2 text-[15px] overflow-x-auto custom-scrollbar pb-1">
                    <span onclick="addCmEmoji('😀')" class="cursor-pointer active:scale-125 shrink-0">😀</span>
                    <span onclick="addCmEmoji('😂')" class="cursor-pointer active:scale-125 shrink-0">😂</span>
                    <span onclick="addCmEmoji('😍')" class="cursor-pointer active:scale-125 shrink-0">😍</span>
                    <span onclick="addCmEmoji('😎')" class="cursor-pointer active:scale-125 shrink-0">😎</span>
                    <span onclick="addCmEmoji('🤔')" class="cursor-pointer active:scale-125 shrink-0">🤔</span>
                  
                    <span onclick="addCmEmoji('👍')" class="cursor-pointer active:scale-125 shrink-0">👍</span>
                    <span onclick="addCmEmoji('🙏')" class="cursor-pointer active:scale-125 shrink-0">🙏</span>
                </div>
                <div class="flex items-center gap-2 shrink-0 ml-2">
                    <button id="cmRefreshBtn" onclick="triggerManualCmRefresh()" class="p-2 text-slate-400 active:bg-slate-100 rounded-xl transition-colors" title="刷新评论">
                        <i data-lucide="refresh-cw" class="w-4 h-4 transition-transform duration-500"></i>
                    </button>
                    <button onclick="postCm()" id="cmBtn" class="px-5 py-2 bg-blue-600 text-white rounded-xl text-[12px] font-bold active:scale-95 transition-all">发送</button>
                </div>
            </div>
        </div>
        <div id="cmList" class="divide-y divide-slate-50"></div>
    </div>
</div>




                </div>
                
            </div>




           

            <!-- 【子页面】文件管理器 -->
                        <div id="pageFiles" class="page-slide absolute inset-0 bg-white z-20 translate-x-full flex flex-col shadow-[-10px_0_20_rgba(0,0,0,0.05)]">
                
                <div id="fileTopBar" class="relative shrink-0 border-b border-slate-100 bg-slate-50">
                    <div id="fileDefaultBar" class="flex items-center justify-between px-6 py-1.5 h-[50px]">
                        <div id="fileBreadcrumb" class="flex-1 overflow-x-auto whitespace-nowrap custom-scrollbar flex items-center gap-2 font-mono text-[12px] text-slate-500 mr-2"></div>
                        <div id="fileActionNav" class="flex items-center gap-3 shrink-0">
                            <button onclick="triggerUploadMenu()" class="p-1 text-emerald-600 active:bg-slate-200 rounded-lg transition-colors"><i data-lucide="upload-cloud" class="w-5 h-5"></i></button>
                            <button onclick="triggerNewFolder()" class="p-1 text-amber-500 active:bg-slate-200 rounded-lg transition-colors"><i data-lucide="folder-plus" class="w-5 h-5"></i></button>
                            <button onclick="triggerNewFileWithContent()" class="p-1 text-blue-600 active:bg-slate-200 rounded-lg transition-colors"><i data-lucide="file-plus" class="w-5 h-5"></i></button>
                            <button onclick="toggleBatchMode(true)" class="p-1 text-indigo-500 active:bg-slate-200 rounded-lg transition-colors"><i data-lucide="list-checks" class="w-5 h-5"></i></button>
                        </div>
                    </div>


                    <div id="fileSearchBar" class="hidden bg-slate-50 items-center px-4 h-[50px] z-10 w-full">
                        <div class="flex items-center w-full gap-3 h-full py-1.5">
                            <div class="relative flex-1 h-full">
                                <i data-lucide="search" class="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-slate-400"></i>
                                <input type="text" id="fileSearchInput" placeholder="全局搜索当前及子目录..." oninput="debounceRecursiveSearch()" class="w-full h-full bg-white border border-slate-200 rounded-lg pl-9 pr-3 text-[13px] outline-none focus:border-blue-500 shadow-sm transition-colors">
                            </div>
                            <button onclick="toggleRecursiveSearch(false)" class="text-slate-500 text-[13px] font-bold px-2 h-full active:bg-slate-200 rounded-lg transition-colors shrink-0 flex items-center justify-center">取消</button>
                        </div>
                    </div>

                    <div id="fileBatchBar" class="hidden bg-indigo-50 items-center justify-between px-2 h-[50px] border-b border-indigo-100 z-10 w-full">
                        <div class="flex items-center gap-5">
                            <button onclick="batchDownloadFiles()" class="p-1 text-blue-500 active:bg-indigo-100 rounded-lg"><i data-lucide="download" class="w-5 h-5"></i></button>
                            <button onclick="batchDeleteFiles()" class="p-1 text-red-500 active:bg-indigo-100 rounded-lg"><i data-lucide="trash-2" class="w-5 h-5"></i></button>
                            <button onclick="selectAllBatch()" class="p-1 text-slate-600 active:bg-indigo-100 rounded-lg"><i data-lucide="box-select" class="w-5 h-5"></i></button>
                        </div>
                        <div class="flex items-center gap-3 shrink-0">
                        <span id="batchCountText" class="text-[12px] font-bold text-indigo-700">已选 0 项</span>
                     <button onclick="toggleBatchMode(false)" class="text-slate-500 p-1 active:bg-indigo-100 rounded-lg"><i data-lucide="x" class="w-5 h-5"></i></button>
                            
                        </div>
                    </div>
                </div>
                
                <div class="flex-1 overflow-y-auto custom-scrollbar">
                    <div class="divide-y divide-slate-50" id="fileList"></div>
                    <div id="fileEmpty" class="hidden flex-col items-center justify-center py-20 text-slate-300">
                        <i data-lucide="folder-open" class="w-16 h-16 mb-4 opacity-20"></i>
                        <p class="text-sm">目录为空</p>
                    </div>
                </div>

            </div>


            <!-- 【子页面】书签管理器 (重构为侧滑覆盖页) -->
            <div id="pageBookmarks" class="page-slide absolute inset-0 bg-white overflow-y-auto pb-24 z-30 translate-x-full custom-scrollbar shadow-[-10px_0_20px_rgba(0,0,0,0.05)]">
                <div class="px-4 py-3 text-xs font-bold text-slate-400 uppercase tracking-widest bg-gray-50 border-b border-slate-100">我的书签快捷方式</div>
                <div class="divide-y divide-slate-50" id="bookmarkListContainer"></div>
            </div>

            <!-- 【子页面】文件编辑器 -->
            <div id="pageEditor" class="page-slide absolute inset-0 bg-white z-30 translate-x-full flex flex-col shadow-[-10px_0_20px_rgba(0,0,0,0.05)] overflow-hidden min-h-0">
                <div class="flex items-center justify-between px-4 py-1 border-b border-slate-100 bg-white shrink-0 z-40 w-full">
                    <div class="flex-1 flex items-center gap-2 truncate pr-2">
                        <span id="editorBadge" class="hidden w-2 h-2 bg-amber-500 rounded-full shrink-0"></span>
                        <span class="text-[12px] font-bold text-slate-600 truncate" id="editorFilePath"></span>
                    </div>
                    <div class="flex items-center gap-3 shrink-0">
                        <button onclick="undoEditorAction()" class="p-1.5 text-amber-500 active:bg-slate-100 rounded-full transition-colors">
                            <i data-lucide="undo-2" class="w-5 h-5"></i>
                        </button>
                        <button onclick="toggleEditorSearch()" class="p-1.5 text-blue-600 active:bg-slate-100 rounded-full transition-colors">
                            <i data-lucide="search" class="w-5 h-5"></i>
                        </button>
                        <button onclick="toggleWordWrap()" id="btnWordWrap" class="p-1.5 text-slate-400 active:bg-slate-100 rounded-full transition-colors">
                            <svg xmlns="http://www.w3.org/2000/svg" class="w-5 h-5" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M3 6h18"/><path d="M3 12h15a3 3 0 0 1 0 6h-4"/><polyline points="16 16 14 18 16 20"/><path d="M3 18h4"/></svg>
                        </button>
                        <button onclick="editorSelectAll()" class="p-1.5 text-emerald-600 active:bg-slate-100 rounded-full transition-colors">
                            <i data-lucide="box-select" class="w-5 h-5"></i>
                        </button>
                        <button onclick="togglePreview()" id="btnPreview" class="hidden px-3 py-1 text-[12px] font-bold text-blue-600 bg-blue-50 rounded-lg ml-1">预览</button>
                    </div>

                </div>
                
                <div id="editorSearchBar" class="hidden border-b border-slate-100 bg-slate-50 p-2 flex flex-col gap-2 shrink-0 shadow-sm z-40 relative">
                    <div class="relative w-full bg-white border border-slate-200 rounded-lg focus-within:border-blue-500 shadow-sm overflow-hidden">
                        <textarea id="editorSearchInput" placeholder="查找内容 (支持换行)..." oninput="updateSearchMatches(true)" class="w-full bg-transparent py-2 pl-3 pr-10 text-[13px] outline-none resize-none h-14 custom-scrollbar whitespace-pre-wrap"></textarea>
                        <span id="searchMatchCount" class="absolute right-2 bottom-2 text-[10px] text-slate-400 font-mono bg-white/90 px-1 rounded">0/0</span>
                    </div>
                    
                    <div class="flex items-center justify-between w-full">
                        <div class="flex gap-2">
                        <button onclick="toggleEditorSearch()" class="px-4 py-1.5 bg-slate-100 text-slate-500 border border-slate-200 rounded-lg active:bg-slate-200 text-[12px] font-bold shadow-sm">收起</button>
                            <button id="replaceToggleBtn" onclick="toggleReplaceBar(true)" class="px-4 py-1.5 bg-blue-50 text-blue-600 border border-blue-200 rounded-lg active:bg-blue-100 text-[12px] font-bold shadow-sm">替换</button>
                            
                        </div>
                        <div class="flex gap-2">
                            <button onmousedown="event.preventDefault();" onclick="editorFind(false)" class="px-5 py-1.5 bg-white border border-slate-200 rounded-lg active:bg-slate-100 flex items-center justify-center shadow-sm"><i data-lucide="chevron-up" class="w-4 h-4 text-slate-700"></i></button>
                            <button onmousedown="event.preventDefault();" onclick="editorFind(true)" class="px-5 py-1.5 bg-white border border-slate-200 rounded-lg active:bg-slate-100 flex items-center justify-center shadow-sm"><i data-lucide="chevron-down" class="w-4 h-4 text-slate-700"></i></button>
                        </div>
                    </div>

                    <div id="replaceInputRow" class="hidden flex-col gap-2 pt-2 border-t border-slate-200 mt-1">
                        <div class="relative w-full bg-white border border-slate-200 rounded-lg focus-within:border-blue-500 shadow-sm overflow-hidden">
                            <textarea id="editorReplaceInput" placeholder="替换为 (支持换行)..." class="w-full bg-transparent py-2 px-3 text-[13px] outline-none resize-none h-14 custom-scrollbar whitespace-pre-wrap"></textarea>
                        </div>
                        <div class="flex items-center justify-between w-full mt-2">
                            <div class="flex gap-2">
                                <button onmousedown="event.preventDefault();" onclick="editorReplace(false)" class="px-4 py-1.5 bg-white border border-slate-200 rounded-lg active:bg-slate-100 text-[12px] text-slate-700 font-bold shadow-sm">替换</button>
                                <button onmousedown="event.preventDefault();" onclick="editorReplace(true)" class="px-4 py-1.5 bg-white border border-slate-200 rounded-lg active:bg-slate-100 text-[12px] text-slate-700 font-bold shadow-sm">全替</button>
                            </div>
                            <button onclick="toggleReplaceBar(false)" class="px-4 py-1.5 bg-slate-100 text-slate-500 border border-slate-200 rounded-lg active:bg-slate-200 text-[12px] font-bold shadow-sm">收起</button>
                        </div>
                    </div>
                </div>

                <div id="editorLocalLoader" class="hidden flex-1 flex-col items-center justify-center bg-white z-20">
                    <div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div>
                    <p class="text-xs font-bold text-slate-400">提取文件内容中...</p>
                </div>

                <div id="editorMainContainer" class="flex-1 flex flex-col w-full bg-slate-50 overflow-hidden relative min-h-0">
                    <div id="editorTransformWrapper" class="flex-1 flex flex-col w-full h-full min-h-0 relative">
                        <textarea id="fileRichEditor" wrap="off" class="flex-1 w-full h-full px-4 pt-4 pb-[300px] text-[14px] leading-relaxed font-mono resize-none bg-slate-50 text-slate-800 outline-none custom-scrollbar" spellcheck="false" oninput="syncRichToText()"></textarea>
                    </div>
                </div>

                <div id="filePreview" class="hidden flex-1 w-full p-5 overflow-y-auto custom-scrollbar bg-white min-h-0"></div>
            </div>

            <!-- 【子页面】分支管理 -->
            <div id="pageBranches" class="page-slide absolute inset-0 bg-gray-50 overflow-y-auto z-30 translate-x-full pb-10">
                <div class="p-4" id="branchList"></div>
            </div>

            <!-- 【子页面】版本管理 -->
            <div id="pageReleases" class="page-slide absolute inset-0 bg-gray-50 overflow-y-auto z-30 translate-x-full pb-10">
                <div class="p-4" id="releaseList"></div>
            </div>

            <!-- 【子页面】仓库设置 -->
            <div id="pageSettings" class="page-slide absolute inset-0 bg-gray-50 overflow-y-auto z-30 translate-x-full pb-20">
                <div class="p-4 space-y-6" id="settingsContainer"></div>
            </div>

            <!-- 【子页面】Pages部署 -->
            <div id="pagePagesDeploy" class="page-slide absolute inset-0 bg-gray-50 overflow-y-auto z-30 translate-x-full pb-20">
                <div class="p-4 space-y-6" id="pagesDeployContainer"></div>
            </div>

        </div>



        <!-- 底部四大导航栏 -->
        <nav id="bottomNav" class="bg-white border-t border-slate-200 flex items-center justify-around z-40 shrink-0" style="padding-bottom: var(--safe-bottom); height: calc(65px + var(--safe-bottom));">
            <button onclick="switchTab('pageRepos', this)" class="tab-btn flex flex-col items-center gap-2 text-blue-600 transition-colors w-1/4">
                <i data-lucide="book-marked" class="w-5 h-5"></i>
                <span class="text-[10px] font-bold">仓库</span>
            </button>
            <button onclick="switchTab('pageStarred', this)" class="tab-btn flex flex-col items-center gap-2 text-slate-400 transition-colors w-1/4">
                <i data-lucide="star" class="w-5 h-5"></i>
                <span class="text-[10px] font-bold">星标</span>
            </button>
            <button onclick="switchTab('pageDeploy', this)" class="tab-btn flex flex-col items-center gap-2 text-slate-400 transition-colors w-1/4">
                <i data-lucide="rocket" class="w-5 h-5"></i>
                <span class="text-[10px] font-bold">部署</span>
            </button>
            <button onclick="switchTab('pageProfile', this)" class="tab-btn flex flex-col items-center gap-2 text-slate-400 transition-colors w-1/4">
                <i data-lucide="user" class="w-5 h-5"></i>
                <span class="text-[10px] font-bold">我的</span>
            </button>
        </nav>
    </div>

    <!-- ========== 3. 纯净居中菜单 (Context Menu) ========== -->
    <div id="contextMenuOverlay" class="fixed inset-0 bg-black/50 backdrop-blur-sm z-[200] hidden transition-opacity duration-200 opacity-0 flex items-center justify-center p-6" onclick="closeContextMenu()">
        <div id="contextMenu" class="bg-white rounded-2xl w-full max-w-sm shadow-2xl transform scale-95 transition-transform duration-200 flex flex-col overflow-hidden relative" onclick="event.stopPropagation()">
            <button onclick="closeContextMenu()" class="absolute top-2.5 right-3 p-1.5 bg-slate-100 text-slate-600 active:bg-slate-200 rounded-full transition-colors z-[60]"><i data-lucide="x" class="w-5 h-5"></i></button>
            <div id="contextMenuContent" class="max-h-[65vh] overflow-y-auto custom-scrollbar flex flex-col"></div>
        </div>
    </div>

    <input type="file" id="batchUploadInput" multiple class="hidden" onchange="handleAddFilesToPending(event, false)">
    <input type="file" id="folderUploadInput" webkitdirectory directory mozdirectory accept="dir/*" class="hidden" onchange="handleAddFilesToPending(event, true)">

    <div id="uploadPanelModal" class="fixed inset-0 bg-black/60 backdrop-blur-md z-[500] hidden flex flex-col">
        <div class="bg-white flex items-center justify-between px-4 border-b shrink-0" style="padding-top: var(--safe-top); min-height: calc(56px + var(--safe-top));">
            <h3 class="text-[17px] font-bold text-slate-800">待上传清单</h3>
            <button onclick="closeUploadPanel()" class="p-2 text-slate-400 active:bg-slate-100 rounded-full transition-colors"><i data-lucide="x" class="w-6 h-6"></i></button>
        </div>

        <div class="flex-1 overflow-y-auto bg-slate-50 p-4 custom-scrollbar" id="pendingUploadList"></div>
        <div class="p-4 bg-white border-t space-y-3" style="padding-bottom: calc(1rem + var(--safe-bottom));">
            <div class="flex gap-2">
                <button onclick="document.getElementById('batchUploadInput').click()" class="flex-1 py-3 bg-slate-100 text-slate-600 rounded-xl font-bold text-sm flex items-center justify-center gap-2">
                    <i data-lucide="file-plus" class="w-5 h-5"></i>加文件
                </button>
                <button onclick="document.getElementById('folderUploadInput').click()" class="flex-1 py-3 bg-slate-100 text-slate-600 rounded-xl font-bold text-sm flex items-center justify-center gap-2">
                    <i data-lucide="folder-plus" class="w-5 h-5"></i>加文件夹
                </button>
            </div>
            <button onclick="executeFinalUpload()" id="startUploadBtn" class="w-full py-4 bg-blue-600 text-white rounded-2xl font-bold shadow-lg shadow-blue-600/20 active:scale-95 transition-transform flex items-center justify-center gap-2">
                <i data-lucide="upload-cloud" class="w-5 h-5"></i>
                <span>开始上传 (0)</span>
            </button>
        </div>
    </div>


    <!-- ========== 4. 全局组件 ========== -->
    
    <div id="toast" class="fixed left-1/2 -translate-x-1/2 px-4 py-2 rounded-xl shadow-md border border-slate-100/50 backdrop-blur-md z-[500] flex items-center gap-2 text-[13px] font-bold whitespace-nowrap transition-all duration-500 opacity-0 pointer-events-none transform -translate-y-2" style="top: calc(6rem + var(--safe-top));"></div>

        <div id="globalPullIndicator" class="fixed left-1/2 -translate-x-1/2 w-10 h-10 bg-white rounded-full shadow-md flex items-center justify-center z-[60] opacity-0 transition-all duration-300 pointer-events-none" style="top: calc(3.5rem + var(--safe-top)); transform: translate(-50%, -5rem);">
        <div class="w-5 h-5 border-2 border-slate-200 border-t-blue-600 rounded-full" id="globalPullSpinner"></div>
    </div>

    <div id="loader" class="fixed inset-0 bg-white/90 backdrop-blur-sm z-[400] hidden flex-col items-center justify-center">
        <div class="w-10 h-10 border-4 border-blue-100 border-t-blue-600 rounded-full animate-spin mb-4"></div>
        <p id="loaderText" class="text-sm font-bold text-slate-600 tracking-wider text-center px-4">加载中...</p>
    </div>

    <!-- 表单 Modal -->
    <div id="formModal" class="fixed inset-0 bg-black/50 backdrop-blur-sm z-[300] hidden flex items-center justify-center p-4">
        <div class="bg-white rounded-2xl w-full max-w-sm p-6 shadow-2xl transform scale-95 transition-transform relative" id="formBox">
            <button onclick="closeForm()" class="absolute top-4 right-4 p-1.5 bg-slate-100 text-slate-600 active:bg-slate-200 rounded-full transition-colors z-10"><i data-lucide="x" class="w-5 h-5"></i></button>
            <h3 id="formTitle" class="text-[18px] font-bold mb-4 text-slate-800 pr-8">表单</h3>
            <div id="formContent" class="space-y-4 mb-6"></div>
            <div class="flex gap-3">
                <button onclick="closeForm()" class="flex-1 py-3 text-slate-600 bg-slate-100 rounded-xl font-bold active:bg-slate-200">取消</button>
                <button id="formConfirmBtn" class="flex-1 py-3 text-white bg-blue-600 rounded-xl font-bold active:bg-blue-700">确认</button>
            </div>
        </div>
    </div>

    <div id="promptModal" class="fixed inset-0 bg-black/50 backdrop-blur-sm z-[300] hidden flex items-center justify-center p-6">
        <div class="bg-white rounded-2xl w-full max-w-sm p-6 shadow-2xl transform scale-95 transition-transform relative" id="promptBox">
            <button onclick="closePrompt()" class="absolute top-4 right-4 p-1.5 bg-slate-100 text-slate-600 active:bg-slate-200 rounded-full transition-colors z-10"><i data-lucide="x" class="w-5 h-5"></i></button>
            <h3 id="promptTitle" class="text-[18px] font-bold mb-4 text-slate-800 pr-8">标题</h3>
            <input type="text" id="promptInput" class="w-full bg-slate-50 border border-slate-200 rounded-xl p-3 outline-none focus:ring-2 focus:ring-blue-500 mb-6 text-[15px]">
            <div class="flex gap-3">
                <button onclick="closePrompt()" class="flex-1 py-3 text-slate-600 bg-slate-100 rounded-xl font-bold active:bg-slate-200">取消</button>
                <button id="promptConfirmBtn" class="flex-1 py-3 text-white bg-blue-600 rounded-xl font-bold active:bg-blue-700">确认</button>
            </div>
        </div>
    </div>
    <div id="imagePreviewOverlay" class="fixed inset-0 bg-black/80 backdrop-blur-sm z-[600] hidden flex items-center justify-center opacity-0 transition-opacity duration-300" onclick="closeImagePreview()">
        <div id="imagePreviewLoader" class="absolute hidden flex-col items-center justify-center">
            <div class="w-10 h-10 border-4 border-white/30 border-t-white rounded-full animate-spin mb-2"></div>
            <span class="text-white text-xs font-bold tracking-widest">加载中...</span>
        </div>
        <img id="imagePreviewTarget" class="w-[80vw] h-auto object-contain rounded-xl shadow-2xl scale-95 transition-transform duration-300" src="" alt="">
    </div>

    <script>
    
  
        // --- SVG 库 ---
        const SVG_ICONS = {
            'shield-check': '<path d="M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10Z"/><path d="m9 12 2 2 4-4"/>',
            'verified': '<circle cx="12" cy="12" r="10"/><path d="m9 12 2 2 4-4"/>',
            'fingerprint': '<path d="M12 10a2 2 0 0 0-2 2c0 1.02-.1 2.51-.26 4"/><path d="M14 13.12c0 2.38 0 6.38-1 8.88"/><path d="M17.29 21.02c.12-.38.24-.76.36-1.12"/><path d="M18 12a6 6 0 0 0-12 0c0 1.53-.16 3.1-.5 4.5"/><path d="M22 12a10 10 0 0 0-20 0"/><path d="M8.36 14.01c-.13.3-.23.6-.33.9"/><path d="M9.82 8.44A4.95 4.95 0 0 1 12 8a5 5 0 0 1 5 5v1"/>',
            'help-circle': '<circle cx="12" cy="12" r="10"/><path d="M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3"/><line x1="12" x2="12.01" y1="17" y2="17"/>',
            'key-round': '<path d="M2 18v3c0 .6.4 1 1 1h4v-3h3v-3h2l1.4-1.4c.9.9 2.1 1.4 3.6 1.4 2.8 0 5-2.2 5-5s-2.2-5-5-5-5 2.2-5 5c0 1.5.5 2.7 1.4 3.6L2 18Z"/><circle cx="17" cy="7" r="1"/>',
            'arrow-right-circle': '<circle cx="12" cy="12" r="10"/><path d="M8 12h8"/><path d="m12 16 4-4-4-4"/>',
            'list-checks': '<path d="m3 17 2 2 4-4"/><path d="m3 7 2 2 4-4"/><path d="M13 6h8"/><path d="M13 12h8"/><path d="M13 18h8"/>',
            'github': '<path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path>',
            'key': '<path d="m15.5 7.5 2.3 2.3a1 1 0 0 0 1.4 0l2.1-2.1a1 1 0 0 0 0-1.4L19 4"/><path d="m21 2-9.6 9.6"/><circle cx="7.5" cy="15.5" r="5.5"/>',
            'chevron-left': '<path d="m15 18-6-6 6-6"/>', 'chevron-right': '<path d="m9 18 6-6-6-6"/>',
            'lock': '<rect width="18" height="11" x="3" y="11" rx="2" ry="2"/><path d="M7 11V7a5 5 0 0 1 10 0v4"/>',
            'book': '<path d="M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H20v20H6.5a2.5 2.5 0 0 1 0-5H20"/>',
            'folder-open': '<path d="m6 14 1.45-2.9A2 2 0 0 1 9.24 10H20a2 2 0 0 1 1.94 2.5l-1.55 6a2 2 0 0 1-1.94 1.5H4a2 2 0 0 1-2-2V5c0-1.1.9-2 2-2h3.93a2 2 0 0 1 1.66.9l.82 1.2a2 2 0 0 0 1.66.9H18a2 2 0 0 1 2 2v2"/>',
            'folder': '<path d="M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z"/>',
            'file-text': '<path d="M14.5 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7.5L14.5 2z"/><polyline points="14 2 14 8 20 8"/><line x1="16" x2="8" y1="13" y2="13"/><line x1="16" x2="8" y1="17" y2="17"/><line x1="10" x2="8" y1="9" y2="9"/>',
            'trash-2': '<path d="M3 6h18"/><path d="M19 6v14c0 1-1 2-2 2H7c-1 0-2-1-2-2V6"/><path d="M8 6V4c0-1 1-2 2-2h4c1 0 2 1 2 2v2"/><line x1="10" x2="10" y1="11" y2="17"/><line x1="14" x2="14" y1="11" y2="17"/>',
            'plus': '<path d="M5 12h14"/><path d="M12 5v14"/>',
            'book-marked': '<path d="M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H20v20H6.5a2.5 2.5 0 0 1 0-5H20"/><polyline points="10 2 10 10 13 7 16 10 16 2"/>',
            'log-out': '<path d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4"/><polyline points="16 17 21 12 16 7"/><line x1="21" x2="9" y1="12" y2="12"/>',
            'file-plus': '<path d="M14.5 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7.5L14.5 2z"/><polyline points="14 2 14 8 20 8"/><line x1="12" x2="12" y1="18" y2="12"/><line x1="9" x2="15" y1="15" y2="15"/>',
            'upload-cloud': '<path d="M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242"/><path d="M12 12v9"/><path d="m16 16-4-4-4 4"/>',
            'alert-circle': '<circle cx="12" cy="12" r="10"/><line x1="12" x2="12" y1="8" y2="12"/><line x1="12" x2="12.01" y1="16" y2="16"/>',
            'check-circle': '<path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"/><path d="m9 11 3 3L22 4"/>',
            'external-link': '<path d="M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6"/><polyline points="15 3 21 3 21 9"/><line x1="10" x2="21" y1="14" y2="3"/>',
            'copy': '<rect width="14" height="14" x="8" y="8" rx="2" ry="2"/><path d="M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2"/>',
            'terminal': '<polyline points="4 17 10 11 4 5"/><line x1="12" x2="20" y1="19" y2="19"/>',
            'download': '<path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"/><polyline points="7 10 12 15 17 10"/><line x1="12" x2="12" y1="15" y2="3"/>',
            'user': '<path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2"/><circle cx="12" cy="7" r="4"/>',
            'edit-3': '<path d="M12 20h9"/><path d="M16.5 3.5a2.12 2.12 0 0 1 3 3L7 19l-4 1 1-4L16.5 3.5z"/>',
            'type': '<polyline points="4 7 4 4 20 4 20 7"/><line x1="9" x2="15" y1="20" y2="20"/><line x1="12" x2="12" y1="4" y2="20"/>',
            'zap': '<polygon points="13 2 3 14 12 14 11 22 21 10 12 10 13 2"/>',
            'globe': '<circle cx="12" cy="12" r="10"/><line x1="2" x2="22" y1="12" y2="12"/><path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"/>',
            'link-2': '<path d="M15 7h3a5 5 0 0 1 5 5 5 5 0 0 1-5 5h-3m-6 0H6a5 5 0 0 1-5-5 5 5 0 0 1 5-5h3"/><line x1="8" y1="12" x2="16" y2="12"/>',
            'file-archive': '<path d="M14.5 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7.5L14.5 2z"/><polyline points="14 2 14 8 20 8"/><circle cx="10" cy="12" r="2"/><path d="M10 7V6"/><path d="M10 14v1"/><path d="M10 10v1"/>',
            'star': '<polygon points="12 2 15.09 8.26 22 9.27 17 14.14 18.18 21.02 12 17.77 5.82 21.02 7 14.14 2 9.27 8.91 8.26 12 2"/>',
            'settings': '<path d="M12.22 2h-.44a2 2 0 0 0-2 2v.18a2 2 0 0 1-1 1.73l-.43.25a2 2 0 0 1-2 0l-.15-.08a2 2 0 0 0-2.73.73l-.22.38a2 2 0 0 0 .73 2.73l.15.1a2 2 0 0 1 1 1.72v.51a2 2 0 0 1-1 1.74l-.15.09a2 2 0 0 0-.73 2.73l.22.38a2 2 0 0 0 2.73.73l.15-.08a2 2 0 0 1 2 0l.43.25a2 2 0 0 1 1 1.73V20a2 2 0 0 0 2 2h.44a2 2 0 0 0 2-2v-.18a2 2 0 0 1 1-1.73l.43-.25a2 2 0 0 1 2 0l.15.08a2 2 0 0 0 2.73-.73l.22-.39a2 2 0 0 0-.73-2.73l-.15-.08a2 2 0 0 1-1-1.74v-.5a2 2 0 0 1 1-1.74l.15-.09a2 2 0 0 0 .73-2.73l-.22-.38a2 2 0 0 0-2.73-.73l-.15.08a2 2 0 0 1-2 0l-.43-.25a2 2 0 0 1-1-1.73V4a2 2 0 0 0-2-2z"/><circle cx="12" cy="12" r="3"/>',
            'git-branch': '<line x1="6" x2="6" y1="3" y2="15"/><circle cx="18" cy="6" r="3"/><circle cx="6" cy="18" r="3"/><path d="M18 9a9 9 0 0 1-9 9"/>',
            'git-fork': '<circle cx="12" cy="18" r="3"/><circle cx="6" cy="6" r="3"/><circle cx="18" cy="6" r="3"/><path d="M18 9v1a2 2 0 0 1-2 2H8a2 2 0 0 1-2-2V9"/><path d="M12 12v3"/>',
            'tag': '<path d="M12 2H2v10l9.29 9.29c.94.94 2.48.94 3.42 0l6.58-6.58c.94-.94.94-2.48 0-3.42L12 2Z"/><path d="M7 7h.01"/>',
            'folder-plus': '<path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z"/><line x1="12" x2="12" y1="11" y2="17"/><line x1="9" x2="15" y1="14" y2="14"/>',
            'rocket': '<path d="M4.5 16.5c-1.5 1.26-2 5-2 5s3.74-.5 5-2c.71-.84.7-2.13-.09-2.91a2.18 2.18 0 0 0-2.91-.09z"/><path d="m12 15-3-3a22 22 0 0 1 2-3.95A12.88 12.88 0 0 1 22 2c0 2.72-.78 7.5-6 11a22.35 22.35 0 0 1-4 2z"/><path d="M9 12H4s.55-3.03 2-4c1.62-1.08 5 0 5 0"/><path d="M12 15v5s3.03-.55 4-2c1.08-1.62 0-5 0-5"/>',
            'server': '<rect width="20" height="8" x="2" y="2" rx="2" ry="2"/><rect width="20" height="8" x="2" y="14" rx="2" ry="2"/><line x1="6" x2="6.01" y1="6" y2="6"/><line x1="6" x2="6.01" y1="18" y2="18"/>',
            'bookmark': '<path d="m19 21-7-4-7 4V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v16z"/>',
            'search': '<circle cx="11" cy="11" r="8"/><path d="m21 21-4.3-4.3"/>',
            'moon': '<path d="M12 3a6 6 0 0 0 9 9 9 9 0 1 1-9-9Z"/>',
            'undo-2': '<path d="M9 14 4 9l5-5"/><path d="M4 9h10.5a5.5 5.5 0 0 1 5.5 5.5v0a5.5 5.5 0 0 1-5.5 5.5H11"/>',
            'chevron-up': '<path d="m18 15-6-6-6 6"/>',
            'chevron-down': '<path d="m6 9 6 6 6-6"/>',
            'replace': '<path d="M14 4c0-1.1.9-2 2-2s2 .9 2 2v2"/><path d="M20 8c1.1 0 2 .9 2 2s-.9 2-2 2h-2"/><path d="M14 16c0 1.1.9 2 2 2s2-.9 2-2v-2"/><path d="M10 8c-1.1 0-2-.9-2-2s.9-2 2-2h2"/><path d="M4 16c0 1.1.9 2 2 2s2-.9 2-2v-2"/><path d="M2 12c-1.1 0-2-.9-2-2s.9-2 2-2h2"/><path d="m18 10-4 4-4-4"/><path d="m6 10 4 4 4-4"/>',
            'box-select': '<rect width="18" height="18" x="3" y="3" rx="2" stroke-dasharray="5 4"/>',
            'wand-2': '<path d="m21 2-2 2m-7.61 7.61a.999.999 0 1 1-1.42 1.42 1 1 0 0 1 1.42-1.42Zm0 0L18 4m-4.39 4.39-2.82-2.82m8.48 2.82-2.82-2.82M11 11l-9 9m2-2.5 1.5 1.5m3-3 1.5 1.5"/>',
            'music': '<path d="M9 18V5l12-2v13"/><circle cx="6" cy="18" r="3"/><circle cx="18" cy="16" r="3"/>',
            'home': '<path d="m3 9 9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"/><polyline points="9 22 9 12 15 12 15 22"/>',
            'folder-up': '<path d="M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z"/><path d="M12 10v6"/><path d="m9 13 3-3 3 3"/>',
            'x': '<path d="M18 6 6 18"/><path d="m6 6 12 12"/>',
            'box': '<path d="M21 8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16Z"/><path d="m3.3 7 8.7 5 8.7-5"/><path d="M12 22V12"/>',
            'play': '<polygon points="5 3 19 12 5 21 5 3"/>',
            'info': '<circle cx="12" cy="12" r="10"/><line x1="12" x2="12" y1="16" y2="12"/><line x1="12" x2="12.01" y1="8" y2="8"/>',
            'alert-triangle': '<path d="m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3Z"/><line x1="12" x2="12" y1="9" y2="13"/><line x1="12" x2="12.01" y1="17" y2="17"/>',
            'refresh-cw': '<path d="M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8"/><path d="M21 3v5h-5"/><path d="M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16"/><path d="M8 16H3v5"/>',
            'check': '<path d="M20 6 9 17l-5-5"/>'
        };
        
                let activeModals = 0;
        let modalHistoryTimer = null;

        function pushModalState() {
            activeModals++;
            if (activeModals === 1) {
                clearTimeout(modalHistoryTimer);
                history.pushState({ isModal: true }, "");
            }
        }

        function popModalState(fromPopState) {
            activeModals--;
            if (activeModals <= 0) {
                activeModals = 0;
                if (!fromPopState) {
                    modalHistoryTimer = setTimeout(() => {
                        if (activeModals === 0) {
                            window._ignoreNextPop = true;
                            history.back();
                            setTimeout(() => window._ignoreNextPop = false, 100);
                        }
                    }, 50);
                }
            }
        }

        


        function createLocalIcons() {
            document.querySelectorAll('i[data-lucide]').forEach(el => {
                const iconName = el.getAttribute('data-lucide');
                if(SVG_ICONS[iconName]) {
                    const svg = document.createElementNS('http://www.w3.org/2000/svg', 'svg');
                    svg.setAttribute('viewBox', '0 0 24 24'); svg.setAttribute('fill', 'none');
                    svg.setAttribute('stroke', 'currentColor'); svg.setAttribute('stroke-width', '2');
                    svg.setAttribute('stroke-linecap', 'round'); svg.setAttribute('stroke-linejoin', 'round');
                    svg.setAttribute('class', el.className); svg.innerHTML = SVG_ICONS[iconName];
                    el.parentNode.replaceChild(svg, el);
                }
            });
        }

                let pressTimer; let isLongPress = false;
        const ACCOUNTS_KEY = 'github_app_accounts_v2';
        const PINNED_KEY = 'github_app_pinned_repos';
        const BOOKMARKS_KEY = 'github_app_bookmarks';
        let GITHUB_TOKEN = ""; let USER_DATA = null;
        let REPOS = []; let STARRED_REPOS = []; let CURRENT_FILES = [];
        let PINNED_REPOS = JSON.parse(localStorage.getItem(PINNED_KEY) || '[]');
        let BOOKMARKS = JSON.parse(localStorage.getItem(BOOKMARKS_KEY) || '[]');
        let CURRENT_REPO = null; let CURRENT_PATH = ""; let CURRENT_BRANCH = "main"; let CURRENT_FILE = null;
        let NAV_STACK = ['pageRepos']; 
        let CURRENT_SCALE = 1;
        let startDist = 0;
        let startScale = 1;
        let ACTIVE_SCOPES = [];
        let ORIGINAL_CONTENT = "";
        let EDITOR_HISTORY = [];
        let CURRENT_AUDIO = null;
        let CURRENT_AUDIO_SHA = null;
        let IS_BATCH_MODE = false;
        let SELECTED_FILES = new Set();
        let searchDebounceTimer = null;
        let IS_FIRST_LOAD = true;

        function openExternalBrowser(url) {
            if (window.AndroidBridge && window.AndroidBridge.openInBrowser) {
                window.AndroidBridge.openInBrowser(url);
            } else {
                window.open(url, '_system') || window.open(url, '_blank');
            }
        }

                function toggleLoginMode(type) {
            const s = document.getElementById('slider');
            const bo = document.getElementById('btn-oauth');
            const bt = document.getElementById('btn-token');
            const po = document.getElementById('pane-oauth');
            const pt = document.getElementById('pane-token');

            if (type === 'oauth') {
                s.style.transform = 'translateX(0)';
                bo.style.color = '#1e293b';
                bt.style.color = '#94a3b8';
                
                po.style.opacity = '1'; po.style.transform = 'scale(1)'; po.style.pointerEvents = 'auto';
                pt.style.opacity = '0'; pt.style.transform = 'scale(0.96)'; pt.style.pointerEvents = 'none';
            } else {
                s.style.transform = 'translateX(100%)';
                bt.style.color = '#1e293b';
                bo.style.color = '#94a3b8';
                
                pt.style.opacity = '1'; pt.style.transform = 'scale(1)'; pt.style.pointerEvents = 'auto';
                po.style.opacity = '0'; po.style.transform = 'scale(0.96)'; po.style.pointerEvents = 'none';
            }
        }


                function oauth(customBtn = null) {
            const btn = customBtn instanceof HTMLElement ? customBtn : document.getElementById('oauthBtn');
            const allScopes = "repo,repo:status,repo_deployment,public_repo,repo:invite,security_events,admin:repo_hook,write:repo_hook,read:repo_hook,admin:org,write:org,read:org,admin:public_key,write:public_key,read:public_key,admin:org_hook,gist,notifications,user,read:user,user:email,user:follow,project,read:project,delete_repo,write:packages,read:packages,delete:packages,admin:gpg_key,write:gpg_key,read:gpg_key,workflow";
            
            if (btn) {
                btn.dataset.originHtml = btn.innerHTML;
                btn.innerHTML = '<div class="flex items-center justify-center gap-2"><div class="w-4 h-4 border-2 border-white/30 border-t-white rounded-full animate-spin"></div><span>授权中...</span></div>';
                btn.disabled = true;
                btn.style.opacity = '0.9';
            }

            const resetBtnState = () => {
                if (document.visibilityState === 'visible') {
                    setTimeout(() => {
                        if(btn && btn.innerHTML.includes('授权中')) {
                            btn.innerHTML = btn.dataset.originHtml;
                            btn.disabled = false;
                            btn.style.opacity = '1';
                            createLocalIcons();
                        }
                    }, 1500);
                    document.removeEventListener('visibilitychange', resetBtnState);
                }
            };
            document.addEventListener('visibilitychange', resetBtnState);

            if (window.AndroidBridge && window.AndroidBridge.startGithubAuth) {
                window.AndroidBridge.startGithubAuth();
            } else {
                const cid = 'Ov23liHvV3pKNTQ1G3Dt';
                window.location.href = `https://github.com/login/oauth/authorize?client_id=${cid}&redirect_uri=${encodeURIComponent('gk://login')}&scope=${encodeURIComponent(allScopes)}`;
            }
        }

        window.onReceiveAuthToken = function(token) {
            const btn = document.getElementById('oauthBtn');
            if (token) {
                if (btn) {
                    btn.innerHTML = '<div class="flex items-center justify-center gap-2"><i data-lucide="check-circle" class="w-5 h-5"></i><span>授权成功，正在登录...</span></div>';
                    btn.style.backgroundColor = '#10B981';
                    btn.style.opacity = '1';
                    createLocalIcons();
                }
                document.getElementById('tokenInput').value = token;
                handleLogin(token).then(success => {
                    if (success && document.getElementById('formModal') && !document.getElementById('formModal').classList.contains('hidden')) {
                        closeForm();
                    }
                });
            } else {
                if (btn) {
                    btn.innerHTML = '<div class="flex items-center justify-center gap-2"><i data-lucide="x-circle" class="w-5 h-5"></i><span>授权失败或取消</span></div>';
                    btn.style.backgroundColor = '#EF4444';
                    btn.style.opacity = '1';
                    createLocalIcons();
                    setTimeout(() => {
                        btn.innerHTML = btn.dataset.originHtml;
                        btn.style.backgroundColor = '';
                        btn.disabled = false;
                        createLocalIcons();
                    }, 2500);
                } else {
                    showToast("授权验证失败或异常", "error");
                }
            }
        };



        async function batchDownloadFiles() {
            if(SELECTED_FILES.size === 0) return showToast("未选择内容", "error");

            showToast("正在准备打包下载...", "loading");
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            const zip = new JSZip();
            let successCount = 0;
            let arr = Array.from(SELECTED_FILES);
            
            try {
                for(let i = 0; i < arr.length; i++) {
                    const path = arr[i];
                    const fileObj = CURRENT_FILES.find(f => f.path === path);
                    if(fileObj) {
                        if (fileObj.type === 'dir') {
                            showToast(`获取目录: ${fileObj.name}...`, "loading");
                            const treeRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/trees/${fileObj.sha}?recursive=1`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                            if (treeRes.ok) {
                                const treeData = await treeRes.json();
                                const filesToDownload = treeData.tree.filter(item => item.type === 'blob');
                                for(let j = 0; j < filesToDownload.length; j++) {
                                    const fileItem = filesToDownload[j];
                                    showToast(`打包中 (${i+1}/${arr.length}): ${fileItem.path}`, "loading");
                                    const blobRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${fileItem.sha}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                                    if(blobRes.ok) {
                                        const blobData = await blobRes.json();
                                        zip.file(`${fileObj.name}/${fileItem.path}`, blobData.content, {base64: true});
                                    }
                                }
                            }
                            successCount++;
                        } else {
                            showToast(`打包中 (${i+1}/${arr.length}): ${fileObj.name}`, "loading");
                            const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${fileObj.sha}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                            if(res.ok) {
                                const blobData = await res.json();
                                zip.file(fileObj.name, blobData.content, {base64: true});
                                successCount++;
                            }
                        }
                    }
                }
                
                if (successCount > 0) {
                    showToast("正在生成 ZIP 文件...", "loading");
                    const content = await zip.generateAsync({type: "blob"});
                    const filename = `BatchDownload_${CURRENT_REPO.name}_${Date.now()}.zip`;
                    
                    if (window.AndroidDown && window.AndroidDown.postBlob) {
                        const reader = new FileReader();
                        reader.onloadend = function() {
                            const base64data = reader.result;
                            window.AndroidDown.postBlob(base64data, "", filename);
                        }
                        reader.readAsDataURL(content);
                    } else {
                        const a = document.createElement('a');
                        a.href = URL.createObjectURL(content);
                        a.download = filename;
                        document.body.appendChild(a);
                        a.click();
                        document.body.removeChild(a);
                        setTimeout(() => URL.revokeObjectURL(a.href), 1000);
                    }
                    showToast(`已成功打包下载 ${successCount} 项`, "success");
                } else {
                    showToast("下载失败，未获取到有效文件", "error");
                }
            } catch (e) {
                showToast(e.message, "error");
            } finally {
                toggleBatchMode(false);
            }
        }




        function initEditorZoom() {
            const pageEditor = document.getElementById('pageEditor');
            if (!pageEditor) return;
            pageEditor.addEventListener('touchstart', (e) => {
                if (e.touches.length === 2) {
                    startDist = Math.hypot(
                        e.touches[0].pageX - e.touches[1].pageX,
                        e.touches[0].pageY - e.touches[1].pageY
                    );
                    startScale = CURRENT_SCALE;
                }
            }, { passive: false });
            pageEditor.addEventListener('touchmove', (e) => {
                if (e.touches.length === 2 && startDist > 0) {
                    e.preventDefault();
                    const currentDist = Math.hypot(
                        e.touches[0].pageX - e.touches[1].pageX,
                        e.touches[0].pageY - e.touches[1].pageY
                    );
                    const scale = currentDist / startDist;
                    const newScale = Math.max(0.1, Math.min(5, startScale * scale));
                    
                    if (newScale !== CURRENT_SCALE) {
                        const container = document.getElementById('editorMainContainer');
                        const wrapper = document.getElementById('editorTransformWrapper');
                        if (!wrapper) return;
                        
                        const ratio = newScale / CURRENT_SCALE;
                        
                        const centerY = (e.touches[0].pageY + e.touches[1].pageY) / 2;
                        const centerX = (e.touches[0].pageX + e.touches[1].pageX) / 2;
                        const rect = container.getBoundingClientRect();
                        
                        const docX = container.scrollLeft + (centerX - rect.left);
                        const docY = container.scrollTop + (centerY - rect.top);
                        
                        wrapper.style.zoom = newScale;
                        
                        container.scrollLeft = docX * ratio - (centerX - rect.left);
                        container.scrollTop = docY * ratio - (centerY - rect.top);

                        CURRENT_SCALE = newScale;
                    }
                }
            }, { passive: false });
        }


               let PROXY_ENABLED = localStorage.getItem('gh_proxy_enabled') !== 'false';
        let PROXY_URL = localStorage.getItem('gh_proxy_url') || 'https://web.ksx.qzz.io/';

        function initPullToRefresh() {
            const mainContent = document.getElementById('mainContent');
            const indicator = document.getElementById('globalPullIndicator');
            const spinner = document.getElementById('globalPullSpinner');
            
            let startY = 0;
            let startX = 0;
            let isPulling = false;
            let currentScrollContainer = null;
            let refreshTriggered = false;
            let currentPullDistance = 0;
            
            // 释放时的触发阈值 (松手时拉动超过 60px 即触发刷新)
            const TRIGGER_THRESHOLD = 60;

            mainContent.addEventListener('touchstart', (e) => {
                if (refreshTriggered) return;
                
                const currPage = NAV_STACK[NAV_STACK.length - 1];
                if (currPage === 'pageEditor') {
                    isPulling = false;
                    return;
                }

                const path = e.composedPath();
                currentScrollContainer = path.find(el => el.classList && (el.classList.contains('overflow-y-auto') || el.classList.contains('custom-scrollbar')));
                
                if (currentScrollContainer && currentScrollContainer.scrollTop <= 0) {
                    startY = e.touches[0].pageY;
                    startX = e.touches[0].pageX;
                    isPulling = true;
                    currentPullDistance = 0;
                    indicator.style.transition = 'none';
                    spinner.style.transform = '';
                    spinner.className = 'w-5 h-5 border-2 border-slate-200 border-t-blue-600 rounded-full';
                    spinner.innerHTML = '';
                } else {
                    isPulling = false;
                }
            }, { passive: true });

            mainContent.addEventListener('touchmove', (e) => {
                if (!isPulling || refreshTriggered) return;
                
                const y = e.touches[0].pageY;
                const x = e.touches[0].pageX;
                const deltaY = y - startY;
                const deltaX = Math.abs(x - startX);

                // 防误触逻辑：如果横向滑动幅度大于纵向，说明在左右滑，直接放行
                if (deltaX > deltaY && deltaY < 20) {
                    isPulling = false;
                    return;
                }

                // 核心控制：必须是向下拉 (deltaY > 0) 且处于容器顶部
                if (deltaY > 0 && currentScrollContainer && currentScrollContainer.scrollTop <= 0) {
                    if (e.cancelable) e.preventDefault();
                    
                    // 阻力系数 0.4，取消原来的死区，做到立刻跟手
                    currentPullDistance = deltaY * 0.4; 
                    const visualDistance = Math.min(currentPullDistance, 90); 

                    indicator.style.opacity = Math.min(visualDistance / TRIGGER_THRESHOLD, 1);
                    indicator.style.transform = `translate(-50%, calc(-5rem + ${visualDistance}px))`;
                    spinner.style.transform = `rotate(${visualDistance * 5}deg)`;
                } else {
                    currentPullDistance = 0;
                    indicator.style.opacity = 0;
                    indicator.style.transform = `translate(-50%, -5rem)`;
                }
            }, { passive: false });

            mainContent.addEventListener('touchend', () => {
                if (!isPulling || refreshTriggered) return;
                isPulling = false;
                indicator.style.transition = 'all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1)';

                if (currentPullDistance >= TRIGGER_THRESHOLD) {
                    refreshTriggered = true;
                    indicator.style.transform = `translate(-50%, 0.5rem)`;
                    spinner.style.transform = '';
                    spinner.className = 'w-5 h-5 border-2 border-slate-200 border-t-blue-600 rounded-full animate-spin';
                    
                    executeGlobalRefresh().then(() => {
                        spinner.className = 'flex items-center justify-center';
                        spinner.innerHTML = '<i data-lucide="check" class="w-6 h-6 text-emerald-500"></i>';
                        createLocalIcons();
                        setTimeout(() => {
                            indicator.style.transform = `translate(-50%, -5rem)`;
                            indicator.style.opacity = 0;
                            setTimeout(() => { refreshTriggered = false; }, 300);
                        }, 800);
                    }).catch(err => {
                        showToast(err.message || "请求服务器失败，请检查网络", "error");
                        indicator.style.transform = `translate(-50%, -5rem)`;
                        indicator.style.opacity = 0;
                        setTimeout(() => { refreshTriggered = false; }, 300);
                    });
                } else {
                    indicator.style.transform = `translate(-50%, -5rem)`;
                    indicator.style.opacity = 0;
                }
            });
        }



function getFileCategory(filename) {
    const textExts = ['txt', 'md', 'js', 'html', 'css', 'json', 'py', 'c', 'cpp', 'h', 'java', 'sh', 'php', 'xml', 'yaml', 'yml', 'go', 'rs', 'ts', 'sql', 'toml', 'env'];
    const mediaExts = ['jpg', 'jpeg', 'png', 'gif', 'webp', 'svg', 'mp3', 'wav', 'ogg', 'mp4', 'webm', 'ico'];
    const ext = filename.split('.').pop().toLowerCase();
    
    if (textExts.includes(ext)) return 'text';
    if (mediaExts.includes(ext)) return 'media';
    return 'binary';
}

function openFile(path, name) {
    const category = getFileCategory(name || path);
    
    if (category === 'binary') {
        if (typeof showToast === 'function') {
            showToast('暂不支持打开此类二进制文件', 'error');
        } else {
            alert('暂不支持打开此类二进制文件');
        }
        return;
    }

    if (category === 'media') {
        renderMediaPreview(path);
        return;
    }

    fetchFileContent(path).then(content => {
        editor.setValue(content);
    });
}







const CM_API = "https://wypl.ksx.qzz.io/api/comments";
let replyParentId = null;
let ALL_COMMENT_ROOTS = [];
let currentCmPage = 1;
const CM_PER_PAGE = 10;
let GLOBAL_DEV_QQS = [];

document.getElementById('cmName').value = localStorage.getItem('localCmName') || '';
document.getElementById('cmQQ').value = localStorage.getItem('localCmQQ') || '';

function updateCmAvatar() {
    const qq = document.getElementById('cmQQ').value.trim();
    const avatarEl = document.getElementById('cmAvatar');
    if (avatarEl) {
        avatarEl.src = qq ? `https://q1.qlogo.cn/g?b=qq&nk=${qq}&s=100` : `https://q1.qlogo.cn/g?b=qq&nk=10000&s=100`;
    }
}
setTimeout(updateCmAvatar, 100);

function addCmEmoji(emoji) {
    const ta = document.getElementById('cmContent');
    ta.value += emoji; 
    ta.focus();
}

function triggerReply(id, name) {
    replyParentId = id;
    const indicator = document.getElementById('replyIndicator');
    const replyText = document.getElementById('replyText');
    if (indicator && replyText) {
        indicator.classList.remove('hidden');
        replyText.innerText = `回复 @${name}`;
    }
    document.getElementById('cmContent').focus();
    document.getElementById('cmFormArea').scrollIntoView({ behavior: 'smooth', block: 'center' });
}

function cancelReply() {
    replyParentId = null;
    const indicator = document.getElementById('replyIndicator');
    if (indicator) indicator.classList.add('hidden');
}

function buildCommentTree(flatData) {
    const map = {};
    const roots = [];
    flatData.forEach(node => { map[node.id] = { ...node, children: [] }; });
    flatData.forEach(node => {
        if (node.parent_id && map[node.parent_id]) {
            map[node.parent_id].children.push(map[node.id]);
        } else {
            roots.push(map[node.id]);
        }
    });
    return roots;
}

window.handleCmFocus = function() {
    // 1. 清除失焦定时器，防止多输入框切换时垫底空间闪烁
    clearTimeout(window.cmBlurTimer);
    
    const container = document.getElementById('pageProfile');
    if (container) {
        // 2. 增加平滑过渡动画，让垫底空间随键盘自然撑开，避免瞬间高度突变引起的上下弹跳
        container.style.transition = 'padding-bottom 0.35s cubic-bezier(0.25, 0.8, 0.25, 1)';
        container.style.paddingBottom = '50vh'; 
    }
    
    // 3. 等待键盘完全弹起并腾出空间后，再执行平滑定位
    setTimeout(() => {
        const formArea = document.getElementById('cmFormArea');
        if (formArea) {
            formArea.scrollIntoView({ behavior: 'smooth', block: 'center' });
        }
    }, 350);
};

window.handleCmBlur = function() {
    // 1. 设置延迟，给予时间判断焦点是否只是转移到了另一个相邻输入框
    window.cmBlurTimer = setTimeout(() => {
        const active = document.activeElement;
        if (active && (active.id === 'cmName' || active.id === 'cmQQ' || active.id === 'cmContent')) return;
        
        const container = document.getElementById('pageProfile');
        if (container) {
            container.style.paddingBottom = ''; 
            // 等待回缩动画结束后清除 transition，避免污染其他操作
            setTimeout(() => { 
                if (container.style.paddingBottom === '') {
                    container.style.transition = ''; 
                }
            }, 400);
        }
    }, 150);
};

    async function triggerManualCmRefresh() {
        const btn = document.getElementById('cmRefreshBtn');
        const icon = btn.querySelector('svg') || btn.querySelector('i');
        if (icon) {
            icon.classList.add('animate-spin', 'text-blue-500');
            icon.classList.remove('text-slate-400');
        }
        await loadCm(true, ALL_COMMENT_ROOTS.length > 0);
        if (icon) {
            icon.classList.remove('animate-spin', 'text-blue-500');
            icon.classList.add('text-slate-400');
        }
        showToast("评论已同步", "success");
    }

    async function loadCm(reset = true, silent = false) {
        const list = document.getElementById('cmList');
        if (!list) return;

        if (reset) {
            currentCmPage = 1;
            if (!silent) {
                list.innerHTML = '<div class="p-8 text-center text-slate-400 text-[11px] font-bold animate-pulse">更新数据中...</div>';
            }
            try {
                const res = await fetch(CM_API);
                const data = await res.json();
                const comments = data.comments || [];
                GLOBAL_DEV_QQS = data.devQQs || [];

                if (comments.length === 0) {
                    list.innerHTML = '<div class="p-8 text-center text-slate-300 text-[11px] font-bold">暂无反馈</div>';
                    return;
                }
                ALL_COMMENT_ROOTS = buildCommentTree(comments);
            } catch (e) {
                if (!silent) {
                    list.innerHTML = '<div class="p-8 text-center text-red-300 text-[11px] font-bold">加载失败</div>';
                }
                return;
            }
        }


    const currentRoots = ALL_COMMENT_ROOTS.slice(0, currentCmPage * CM_PER_PAGE);

        function renderNode(c, isChild) {
        const isDev = c.qq && GLOBAL_DEV_QQS.includes(c.qq);
        const tagDev = isDev ? `<span class="bg-emerald-500 text-white px-1.5 py-0.5 rounded text-[9px] font-bold ml-1">开发者</span>` : '';
        const tagPin = c.is_pinned === 1 && !isChild ? `<span class="bg-amber-100 text-amber-600 px-1.5 py-0.5 rounded text-[9px] font-bold ml-1">置顶</span>` : '';
        
        let html = `
        <div class="p-4 ${isChild ? 'bg-slate-50/50 mt-2 rounded-xl border border-slate-100' : 'active:bg-slate-50 transition-colors'}">
            <div class="flex gap-3">
                <img src="${c.qq ? 'https://q1.qlogo.cn/g?b=qq&nk='+c.qq+'&s=100' : 'https://q1.qlogo.cn/g?b=qq&nk=10000&s=100'}" class="w-8 h-8 rounded-full border border-slate-100 shrink-0 object-cover">
                <div class="flex-1 min-w-0">
                    <div class="flex items-center justify-between mb-1">
                        <div class="flex items-center">
                            <span class="text-[12px] font-bold text-slate-700">${c.name}</span>
                            ${tagDev} ${tagPin}
                        </div>
                        <span class="text-[9px] font-bold text-slate-300">${new Date(c.created_at).toLocaleDateString()}</span>
                    </div>
                    <p class="text-[12px] text-slate-600 leading-relaxed break-words whitespace-pre-wrap">${c.content}</p>
                    <div class="mt-2 text-right">
                        <button onclick="triggerReply(${isChild ? c.parent_id : c.id}, '${c.name}')" class="text-[10px] text-slate-400 font-bold active:text-blue-500">回复</button>
                    </div>
                </div>
            </div>
        `;
        if (c.children && c.children.length > 0) {
            html += `<div class="ml-11">` + c.children.map(child => renderNode(child, true)).join('') + `</div>`;
        }
        html += `</div>`;
        return html;
    }


    let html = currentRoots.map(root => renderNode(root, false)).join('');

    if (ALL_COMMENT_ROOTS.length > currentCmPage * CM_PER_PAGE) {
        html += `
        <div class="p-4 flex justify-center border-t border-slate-50">
            <button onclick="loadMoreCm()" class="px-5 py-2 bg-white text-slate-500 text-[12px] font-bold rounded-xl border border-slate-200 active:bg-slate-50 shadow-sm transition-colors flex items-center gap-2">
                <i data-lucide="chevron-down" class="w-4 h-4"></i> 加载更多
            </button>
        </div>`;
    } else if (ALL_COMMENT_ROOTS.length > CM_PER_PAGE) {
        html += `
        <div class="p-4 flex justify-center border-t border-slate-50">
            <span class="text-slate-300 text-[11px] font-bold tracking-widest">到底了</span>
        </div>`;
    }

    list.innerHTML = html;
    if (typeof createLocalIcons === 'function') createLocalIcons();

    if (document.activeElement && document.activeElement.id.startsWith('cm')) {
        handleCmFocus();
    }
}

function loadMoreCm() {
    currentCmPage++;
    loadCm(false);
}

async function postCm() {
    const name = document.getElementById('cmName').value.trim();
    const qq = document.getElementById('cmQQ').value.trim();
    const content = document.getElementById('cmContent').value.trim();
    const btn = document.getElementById('cmBtn');

    if (!name) return showToast("请输入您的昵称", "warning");
    if (!content) return showToast("请填写反馈内容", "warning");

    localStorage.setItem('localCmName', name);
    localStorage.setItem('localCmQQ', qq);

    btn.innerText = "发送中"; btn.disabled = true; btn.style.opacity = "0.5";
    try {
        const res = await fetch(CM_API, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ name, qq, content, parent_id: replyParentId })
        });
        if (res.status === 403) throw new Error("你的IP已被管理员限制发言");
        if (!res.ok) throw new Error("服务器错误");
        
        document.getElementById('cmContent').value = '';
        cancelReply();
        showToast("发布成功", "success");
        loadCm(true, true);
    } catch (e) {
        showToast(e.message, "error");
    } finally {
        btn.innerText = "发送"; btn.disabled = false; btn.style.opacity = "1";
    }
}



function toggleCmCard() {
    const body = document.getElementById('cmCardBody');
    const icon = document.getElementById('cmCardIcon');
    if (body.classList.contains('hidden')) {
        body.classList.remove('hidden');
        icon.style.transform = 'rotate(180deg)';
    } else {
        body.classList.add('hidden');
        icon.style.transform = 'rotate(0deg)';
    }
}













function renderMediaPreview(path) {
    const ext = path.split('.').pop().toLowerCase();
    const container = document.getElementById('editorContainer');
    const url = getFileRawUrl(path); 

    if (['jpg', 'jpeg', 'png', 'gif', 'webp', 'svg', 'ico'].includes(ext)) {
        container.innerHTML = `<div class="flex items-center justify-center h-full p-4"><img src="${url}" class="max-w-full max-h-full object-contain shadow-lg" /></div>`;
    } else if (['mp3', 'wav', 'ogg'].includes(ext)) {
        container.innerHTML = `<div class="flex items-center justify-center h-full p-4"><audio controls src="${url}" class="w-full"></audio></div>`;
    } else if (['mp4', 'webm'].includes(ext)) {
        container.innerHTML = `<div class="flex items-center justify-center h-full p-4"><video controls src="${url}" class="max-w-full max-h-full"></video></div>`;
    }
}


        async function executeGlobalRefresh() {
            if (!navigator.onLine) throw new Error("网络未连接，请检查网络设置");
            const currPage = NAV_STACK[NAV_STACK.length - 1];
            if(currPage === 'pageRepos') await loadRepos();
            else if(currPage === 'pageStarred') await loadStarredRepos();
            else if(currPage === 'pageDeploy') { loadDeployRepos(); await new Promise(r => setTimeout(r, 500)); }
            else if(currPage === 'pageFiles') await loadFiles(CURRENT_PATH);
            else if(currPage === 'pageBranches') await openBranchManager();
            else if(currPage === 'pageReleases') await openReleaseManager();
            else await new Promise(r => setTimeout(r, 500));
        }

        function toggleProxyCard() {
            const body = document.getElementById('proxyCardBody');
            const icon = document.getElementById('proxyCardIcon');
            if (body.classList.contains('hidden')) {
                body.classList.remove('hidden');
                icon.style.transform = 'rotate(180deg)';
            } else {
                body.classList.add('hidden');
                icon.style.transform = 'rotate(0deg)';
            }
        }

        function saveProxySettings() {
            PROXY_ENABLED = document.getElementById('proxyToggle').checked;
            let purl = document.getElementById('proxyUrl').value.trim();
            if(purl && !purl.endsWith('/')) purl += '/';
            PROXY_URL = purl;
            localStorage.setItem('gh_proxy_enabled', PROXY_ENABLED);
            localStorage.setItem('gh_proxy_url', PROXY_URL);
            showToast("代理设置已更新", "success");
        }

        function getProxiedUrl(url) {
            if(PROXY_ENABLED && PROXY_URL && url) return PROXY_URL + url;
            return url;
        }

        // Base64 安全 UTF-8 解析器 (解决乱码崩溃)
        function decodeBase64UTF8(base64) {
            try {
                const binString = window.atob(base64);
                const bytes = new Uint8Array(binString.length);
                for (let i = 0; i < binString.length; i++) bytes[i] = binString.charCodeAt(i);
                return new TextDecoder().decode(bytes);
            } catch(e) {
                return "解析失败: 不是纯文本或已损坏";
            }
        }

        // --- 账号管理系统 ---
        const APP_START_TIME = Date.now();

        function removeStartupLoader() {
            const firstLoader = document.getElementById('first-paint-loader');
            if (!firstLoader) return;
            const elapsed = Date.now() - APP_START_TIME;
            const delay = Math.max(0, 3000 - elapsed);
            setTimeout(() => {
                firstLoader.style.opacity = '0';
                setTimeout(() => firstLoader.remove(), 500);
            }, delay);
        }

        function checkSavedAccounts() {
            const accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
            if(accounts.length > 0) {
                const active = accounts[0];
                document.getElementById('tokenInput').value = active.token;
                GITHUB_TOKEN = active.token;
                USER_DATA = active;
                initApp();
                handleLogin(active.token, true);
            } else {
                removeStartupLoader();
            }
        }




        function renderAccountsList() {
            const list = document.getElementById('accountsList');
            const loginList = document.getElementById('loginAccountsList');
            const accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
            const others = accounts.filter(a => a.token !== GITHUB_TOKEN);
            
            if (list) {
                list.innerHTML = others.map(acc => {
                    const cached = localStorage.getItem('gh_avatar_' + acc.login) || getProxiedUrl(acc.avatar_url);
                    return `
                    <div class="p-4 bg-white rounded-2xl flex items-center justify-between shadow-sm border border-slate-100 active:bg-slate-50 transition-colors">
                        <div onclick="switchAccount('${acc.login}', this)" class="flex items-center gap-3 flex-1 cursor-pointer">
                            <img id="list_avatar_prof_${acc.login}" src="${cached}" onerror="handleAvatarError(this)" class="w-10 h-10 rounded-full border border-slate-100 shadow-sm bg-slate-50">
                            <div class="min-w-0">
                                <h4 class="title-text text-sm font-bold text-slate-700 truncate">${acc.login}</h4>
                                <p class="sub-text text-[10px] text-slate-400">点击切换</p>
                            </div>
                        </div>
                        <button onclick="removeAccount('${acc.login}')" class="p-2 text-slate-300 active:text-red-500 transition-colors">
                            <i data-lucide="trash-2" class="w-5 h-5"></i>
                        </button>
                    </div>`;
                }).join('');
            }

            if (loginList) {
                loginList.innerHTML = others.map(acc => {
                    const cached = localStorage.getItem('gh_avatar_' + acc.login) || getProxiedUrl(acc.avatar_url);
                    return `
                    <div onclick="switchAccount('${acc.login}', this)" class="p-3 bg-white rounded-2xl flex items-center justify-between shadow-sm border border-slate-100 active:bg-slate-50 transition-colors cursor-pointer">
                        <div class="flex items-center gap-3 flex-1 min-w-0">
                            <img id="list_avatar_login_${acc.login}" src="${cached}" onerror="handleAvatarError(this)" class="w-9 h-9 rounded-full border border-slate-100 shadow-sm bg-slate-50">
                            <div class="min-w-0">
                                <h4 class="title-text text-[13px] font-bold text-slate-700 truncate">${acc.login}</h4>
                                <p class="sub-text text-[9px] font-bold text-slate-400 uppercase tracking-widest">点击快速登录</p>
                            </div>
                        </div>
                        <div class="right-icon flex items-center justify-center w-5 h-5">
                            <i data-lucide="chevron-right" class="w-4 h-4 text-slate-300"></i>
                        </div>
                    </div>`;
                }).join('');
            }

            others.forEach(acc => {
                const profImg = document.getElementById(`list_avatar_prof_${acc.login}`);
                const loginImg = document.getElementById(`list_avatar_login_${acc.login}`);
                const url = getProxiedUrl(acc.avatar_url);
                if (profImg) syncAvatarBackground(acc.login, url, profImg);
                if (loginImg) syncAvatarBackground(acc.login, url, loginImg);
            });
            createLocalIcons();
        }

        async function switchAccount(loginOrToken, cardEl = null) {
            const accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
            let targetToken = loginOrToken;
            
            if (!loginOrToken.startsWith('ghp_')) {
                const acc = accounts.find(a => a.login === loginOrToken);
                if (acc) targetToken = acc.token;
                else return;
            }
            
            document.getElementById('tokenInput').value = targetToken;
            
            let dummyBtn = null;
            if (cardEl) {
                dummyBtn = document.createElement('button');
                cardEl.style.pointerEvents = 'none';
                cardEl.classList.add('opacity-70');
                
                const rightIcon = cardEl.querySelector('.right-icon');
                const subText = cardEl.querySelector('.sub-text');
                if (rightIcon) rightIcon.innerHTML = `<div class="w-4 h-4 border-2 border-slate-200 border-t-blue-500 rounded-full animate-spin"></div>`;
                if (subText) subText.innerText = "正在验证...";
                
                const container = document.getElementById('loginAccountsList');
                if(container) container.style.pointerEvents = 'none';
            }

            const success = await handleLogin(targetToken, false, dummyBtn);
            
            if (cardEl) {
                const container = document.getElementById('loginAccountsList');
                if(container) container.style.pointerEvents = 'auto';
                if (!success) renderAccountsList();
            }
        }

        function removeAccount(login) {
            const warningHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="alert-circle" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认移除账号？</p>
                    <p class="text-[13px] text-slate-500 mb-4 leading-relaxed">账号 <b class="text-slate-700">${login}</b> 的本地登录凭证将被清除。</p>
                </div>
            `;
            
            showForm("移除确认", warningHtml, () => {
                let accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
                accounts = accounts.filter(a => a.login !== login);
                localStorage.setItem(ACCOUNTS_KEY, JSON.stringify(accounts));
                showToast("账号已移除", "success");
                renderAccountsList();
            });
            setTimeout(createLocalIcons, 10);
        }

        let currentAddAccMode = 'oauth';

        function toggleAddAccMode(mode) {
            currentAddAccMode = mode;
            const s = document.getElementById('addAccSlider');
            const bo = document.getElementById('btn-add-oauth');
            const bt = document.getElementById('btn-add-token');
            const po = document.getElementById('pane-add-oauth');
            const pt = document.getElementById('pane-add-token');
            if(!s || !bo || !bt || !po || !pt) return;
            if (mode === 'oauth') {
                s.style.transform = 'translateX(0)';
                bo.classList.replace('text-slate-400', 'text-slate-800'); bo.classList.replace('font-semibold', 'font-bold');
                bt.classList.replace('text-slate-800', 'text-slate-400'); bt.classList.replace('font-bold', 'font-semibold');
                po.style.opacity = '1'; po.style.pointerEvents = 'auto';
                pt.style.opacity = '0'; pt.style.pointerEvents = 'none';
            } else {
                s.style.transform = 'translateX(100%)';
                bt.classList.replace('text-slate-400', 'text-slate-800'); bt.classList.replace('font-semibold', 'font-bold');
                bo.classList.replace('text-slate-800', 'text-slate-400'); bo.classList.replace('font-bold', 'font-semibold');
                pt.style.opacity = '1'; pt.style.pointerEvents = 'auto';
                po.style.opacity = '0'; po.style.pointerEvents = 'none';
            }
        }

        function triggerAddAccount() {
            currentAddAccMode = 'oauth';
            showForm("添加新账号", `
                <div class="relative bg-slate-100 p-1 rounded-xl flex mb-5 border border-slate-200">
                    <div id="addAccSlider" class="absolute top-1 left-1 w-[calc(50%-4px)] h-[calc(100%-8px)] bg-white rounded-lg shadow-sm transition-transform duration-300"></div>
                    <button onclick="toggleAddAccMode('oauth')" id="btn-add-oauth" class="relative z-10 flex-1 py-2.5 text-[12px] font-bold text-slate-800 flex items-center justify-center gap-2">
                        <i data-lucide="zap" class="w-4 h-4"></i><span>官方授权</span>
                    </button>
                    <button onclick="toggleAddAccMode('token')" id="btn-add-token" class="relative z-10 flex-1 py-2.5 text-[12px] font-semibold text-slate-400 flex items-center justify-center gap-2">
                        <i data-lucide="key-round" class="w-4 h-4"></i><span>令牌访问</span>
                    </button>
                </div>
                <div class="relative h-[90px]">
                    <div id="pane-add-oauth" class="absolute inset-0 transition-opacity duration-300 opacity-100 flex flex-col items-center justify-center text-center">
                        <div class="w-10 h-10 bg-emerald-50 text-emerald-500 rounded-full flex items-center justify-center mb-2"><i data-lucide="shield-check" class="w-5 h-5"></i></div>
                        <p class="text-[11px] text-slate-500">点击下方确认，将拉起官方安全授权</p>
                    </div>
                    <div id="pane-add-token" class="absolute inset-0 transition-opacity duration-300 opacity-0 pointer-events-none flex flex-col justify-center">
                        <input type="text" id="newAccToken" placeholder="输入 Access Token (ghp_...)" class="w-full bg-slate-50 border border-slate-200 rounded-xl p-3 outline-none focus:border-blue-500 text-[13px] font-mono mb-2">
                        <div class="flex items-center gap-2 px-1 active:opacity-60" onclick="openExternalBrowser('https://github.com/settings/tokens/new')">
<i data-lucide="help-circle" class="w-3 h-3 text-indigo-500"></i>
<span class="text-[9px] font-bold text-slate-400 uppercase tracking-widest">如何获取 TOKEN？</span>
</div>

                    </div>
                </div>
            `, async () => {
                const btn = document.getElementById('formConfirmBtn');
                if (currentAddAccMode === 'oauth') {
                    oauth(btn);
                } else {
                    const token = document.getElementById('newAccToken').value.trim();
                    if (token) {
                        const success = await handleLogin(token, false, btn);
                        if (success) {
                            closeForm();
                        }
                    } else {
                        showToast("请输入 Token", "error");
                    }
                }
            });
            setTimeout(createLocalIcons, 50);
        }



        const COMMON_SCOPES = [
            { id: 'repo', cn: '仓库权限', en: 'repo', hasRead: 'read:repo_status' },
            { id: 'workflow', cn: '工作流', en: 'workflow' },
            { id: 'delete_repo', cn: '删除仓库', en: 'delete_repo' },
            { id: 'user', cn: '个人信息', en: 'user', hasRead: 'read:user' },
            { id: 'notifications', cn: '消息通知', en: 'notifications' }
        ];


function renderTokenScopes() {
    const grid = document.getElementById('scopeGrid');
    const container = document.getElementById('scopeContainer');
    if (!grid || !container) return;

    const accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
    const currentAcc = accounts.find(a => a.token === GITHUB_TOKEN);
    if (currentAcc && currentAcc.scopes) {
        ACTIVE_SCOPES = currentAcc.scopes;
    }

    const oldNotice = container.querySelector('.bg-amber-50');
    if (oldNotice) oldNotice.remove();
 


    const isNoScopes = ACTIVE_SCOPES.length === 0;

    grid.innerHTML = COMMON_SCOPES.map(s => {
        const isWrite = ACTIVE_SCOPES.some(scope => {
            if (s.id === 'repo') return scope === 'repo' || scope === 'public_repo';
            if (s.id === 'user') return scope === 'user' || scope === 'user:email' || scope === 'user:follow';
            return scope === s.id;
        });
        const isRead = s.hasRead ? ACTIVE_SCOPES.includes(s.hasRead) : false;
        const isActive = isWrite || isRead;
        
        const iconHtml = isActive ?
            '<i data-lucide="check-circle" class="w-4 h-4 text-emerald-500"></i>' :
            '<div class="w-3.5 h-3.5 rounded-full border-2 border-slate-200"></div>';
            
        return `
            <div class="flex items-start gap-2">
                <div class="mt-0.5 shrink-0 flex items-center justify-center w-4 h-4">
                    ${iconHtml}
                </div>
                <div class="flex-1 min-w-0">
                    <p class="text-[11px] font-bold ${isActive ? 'text-slate-800' : 'text-slate-400'} truncate">${s.en} (${s.cn})</p>
                    <p class="text-[9px] font-bold ${isActive ? (isWrite ? 'text-emerald-500' : 'text-amber-500') : 'text-slate-300'} mt-0.5">
                        ${isActive ? (isWrite ? '读写 (Read & Write)' : '只读 (Read Only)') : '无权限'}
                    </p>
                </div>
            </div>
        `;
    }).join('');

    if (isNoScopes) {
        const notice = document.createElement('div');
        notice.className = "mt-4 p-3 bg-amber-50 border border-amber-100 rounded-xl text-[10px] text-amber-700 leading-relaxed";
        notice.innerHTML = "<b>提示：</b>未检测到 OAuth 权限标识。这可能是因为您使用的是<b>细粒度令牌 (Fine-grained)</b>，此类令牌暂不支持通过 API 响应头公开权限列表。";
        container.appendChild(notice);
    }
    createLocalIcons();
}

        function toggleScopeCard() {
            const body = document.getElementById('scopeCardBody');
            const icon = document.getElementById('scopeCardIcon');
            if (body.classList.contains('hidden')) {
                body.classList.remove('hidden');
                icon.style.transform = 'rotate(180deg)';
            } else {
                body.classList.add('hidden');
                icon.style.transform = 'rotate(0deg)';
            }
        }


        function setBtnLoading(btn, isLoading, text = "处理中...") {
            if (!btn) return;
            btn.disabled = isLoading;
            if (isLoading) {
                const rect = btn.getBoundingClientRect();
                btn.style.minWidth = rect.width + 'px'; 
                btn.setAttribute('data-prev-html', btn.innerHTML);
                btn.innerHTML = `<span class="flex items-center justify-center gap-2"><div class="w-4 h-4 border-2 border-white/30 border-t-white rounded-full animate-spin"></div>${text}</span>`;
                btn.style.opacity = "0.7";
            } else {
                const prev = btn.getAttribute('data-prev-html');
                if (prev) btn.innerHTML = prev;
                btn.style.opacity = "1";
                btn.style.minWidth = '';
            }
        }



        async function handleLogin(autoToken = null, isSilent = false, customBtn = null) {
            let token = autoToken || document.getElementById('tokenInput').value.trim();
            if (!token) {
                removeStartupLoader();
                showToast("请输入 Token", "error");
                return false;
            }
            
            const loginBtn = customBtn instanceof HTMLElement ? customBtn : document.querySelector('#pane-token button');
            
            if (!isSilent && loginBtn && !autoToken) { 
                loginBtn.dataset.originHtml = loginBtn.innerHTML;
                loginBtn.innerHTML = '<div class="flex items-center justify-center gap-2 text-slate-500"><div class="w-4 h-4 border-2 border-slate-400 border-t-transparent rounded-full animate-spin"></div><span>正在联网验证...</span></div>';
                loginBtn.disabled = true;
            }

            try {
                const res = await fetch('https://api.github.com/user', {
                    headers: {
                        'Authorization': `token ${token}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                if (res.status === 401) {
                    removeStartupLoader();
                    removeAccountByToken(token);
                    if (isSilent) logout();
                    throw new Error("该账号 Token 已失效");
                }
                if (!res.ok) throw new Error(`验证失败 (${res.status})`);
                
                if (!isSilent && loginBtn && !autoToken) {
                    loginBtn.innerHTML = '<div class="flex items-center justify-center gap-2 text-white"><i data-lucide="check-circle" class="w-5 h-5"></i><span>验证成功！</span></div>';
                    loginBtn.style.backgroundColor = '#10B981';
                    loginBtn.style.borderColor = '#10B981';
                    loginBtn.style.color = '#ffffff';
                    createLocalIcons();
                }

                USER_DATA = await res.json();
                GITHUB_TOKEN = token;
                const scopesHeader = res.headers.get('X-OAuth-Scopes');
                ACTIVE_SCOPES = scopesHeader ? scopesHeader.split(',').map(s => s.trim()).filter(s => s !== "") : [];
                saveAccount(USER_DATA, token, ACTIVE_SCOPES);
                
                if (!isSilent) {
                    setTimeout(() => initApp(), 500); 
                } else {
                    if (!document.getElementById('pageProfile').classList.contains('hidden')) {
                        renderTokenScopes();
                    }
                }
                return true;
            } catch(e) {
                removeStartupLoader();
                if (!isSilent && loginBtn && !autoToken) {
                    loginBtn.innerHTML = '<div class="flex items-center justify-center gap-2 text-white"><i data-lucide="x-circle" class="w-5 h-5"></i><span>Token 无效或失败</span></div>';
                    loginBtn.style.backgroundColor = '#EF4444';
                    loginBtn.style.borderColor = '#EF4444';
                    loginBtn.style.color = '#ffffff';
                    createLocalIcons();
                    setTimeout(() => {
                        loginBtn.innerHTML = loginBtn.dataset.originHtml;
                        loginBtn.style.backgroundColor = '';
                        loginBtn.style.borderColor = '';
                        loginBtn.style.color = '';
                        loginBtn.disabled = false;
                        createLocalIcons();
                    }, 2500);
                } else if (!isSilent) {
                    showToast(e.message, "error");
                }
                return false;
            }
        }





        
        function removeAccountByToken(token) {
            let accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
            accounts = accounts.filter(a => a.token !== token);
            localStorage.setItem(ACCOUNTS_KEY, JSON.stringify(accounts));
            renderAccountsList();
        }


function saveAccount(user, token, scopes = []) {
    let accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
    accounts = accounts.filter(a => a.login !== user.login); 
    accounts.unshift({ ...user, token: token, scopes: scopes, expires: Date.now() + 3153600000000 }); 
    localStorage.setItem(ACCOUNTS_KEY, JSON.stringify(accounts));
    renderAccountsList();
}




        function logout() {
            if (USER_DATA && USER_DATA.login) {
                let accounts = JSON.parse(localStorage.getItem(ACCOUNTS_KEY) || '[]');
                accounts = accounts.filter(a => a.login !== USER_DATA.login);
                localStorage.setItem(ACCOUNTS_KEY, JSON.stringify(accounts));
            }
            GITHUB_TOKEN = ""; 
            USER_DATA = null;
            document.getElementById('tokenInput').value = "";
            document.getElementById('appView').classList.add('hidden');
            document.getElementById('appView').classList.remove('flex');
            const loginView = document.getElementById('loginView');
            loginView.classList.remove('hidden');
            setTimeout(() => { loginView.style.opacity = '1'; }, 10);
            ['pageFiles', 'pageBookmarks', 'pageEditor', 'pageBranches', 'pageReleases', 'pageSettings', 'pagePagesDeploy'].forEach(id => { document.getElementById(id)?.classList.add('translate-x-full'); });
            ['pageStarred', 'pageDeploy', 'pageProfile'].forEach(id => { document.getElementById(id)?.classList.add('hidden'); document.getElementById(id)?.classList.remove('translate-x-full'); });
            document.getElementById('pageRepos')?.classList.remove('hidden');
            document.getElementById('pageRepos')?.classList.remove('translate-x-full');
            document.querySelectorAll('.tab-btn').forEach(b => { b.classList.remove('text-blue-600'); b.classList.add('text-slate-400'); });
            const firstTabBtn = document.querySelectorAll('.tab-btn')[0];
            if (firstTabBtn) { firstTabBtn.classList.remove('text-slate-400'); firstTabBtn.classList.add('text-blue-600'); }
            NAV_STACK = ['pageRepos'];
            const navTitle = document.getElementById('navTitle');
            if (navTitle) navTitle.innerText = '我的仓库';
            renderAccountsList();
            showToast("已安全退出");
            removeStartupLoader();
        }




        // --- APP 路由 & Tab 机制 ---
        function initApp() {
            document.getElementById('loginView').style.opacity = '0';

            Object.keys(localStorage).forEach(key => {
                if (key.startsWith('gh_opt_') || key === 'gh_optimistic_deleted_repos') {
                    localStorage.removeItem(key);
                }
            });

            if(document.getElementById('profileAvatar')) {
                const avatarUrl = getProxiedUrl(USER_DATA.avatar_url);
                const cached = localStorage.getItem('gh_avatar_' + USER_DATA.login);
                const imgEl = document.getElementById('profileAvatar');
                imgEl.src = cached || avatarUrl;
                syncAvatarBackground(USER_DATA.login, avatarUrl, imgEl);
            }
            if(document.getElementById('profileName')) document.getElementById('profileName').innerText = USER_DATA.login;
            updateNavHeader('我的仓库');
            renderAccountsList();
            loadRepos(); 
            loadStarredRepos();
            
            IS_FIRST_LOAD = false;

            setTimeout(() => {
                document.getElementById('loginView').classList.add('hidden');
                document.getElementById('appView').classList.remove('hidden'); 
                document.getElementById('appView').classList.add('flex');
                
                removeStartupLoader();
            }, 500);
        }


        // --- 全局基础设施：Service Worker 强缓存机制 ---
        if ('serviceWorker' in navigator) {
            const swCode = `
                const CACHE_NAME = 'github-workbench-v1';
                const ASSETS = [
                    'https://cdn.tailwindcss.com',
                    'https://cdn.bootcdn.net/ajax/libs/marked/9.1.6/marked.min.js',
                    'https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js'
                ];
                self.addEventListener('install', e => {
                    e.waitUntil(caches.open(CACHE_NAME).then(c => c.addAll(ASSETS)));
                });
                self.addEventListener('fetch', e => {
                    e.respondWith(caches.match(e.request).then(r => r || fetch(e.request).then(res => {
                        const isLib = ASSETS.some(url => e.request.url.includes(url));
                        if (isLib) {
                            const clone = res.clone();
                            caches.open(CACHE_NAME).then(c => c.put(e.request, clone));
                        }
                        return res;
                    })));
                });
            `;
            const blob = new Blob([swCode], { type: 'text/javascript' });
            navigator.serviceWorker.register(URL.createObjectURL(blob)).catch(() => {});
        }

        createLocalIcons();


        function switchTab(tabId, btnEl) {
            ['pageFiles', 'pageBookmarks', 'pageEditor', 'pageBranches', 'pageReleases', 'pageSettings', 'pagePagesDeploy'].forEach(id => { document.getElementById(id)?.classList.add('translate-x-full'); });
            document.querySelectorAll('.base-tab').forEach(el => el.classList.add('hidden'));
            document.getElementById(tabId)?.classList.remove('hidden');

            document.querySelectorAll('.tab-btn').forEach(b => { b.classList.remove('text-blue-600'); b.classList.add('text-slate-400'); });
            btnEl.classList.remove('text-slate-400'); btnEl.classList.add('text-blue-600');
            
            NAV_STACK = [tabId];
            let titles = { 'pageRepos': '我的仓库', 'pageStarred': '星标仓库', 'pageDeploy': 'Pages 部署', 'pageProfile': '个人中心' };
            updateNavHeader(titles[tabId] || 'GitHub');

                  if(tabId === 'pageRepos') loadRepos();
        if(tabId === 'pageStarred') loadStarredRepos();
        if(tabId === 'pageDeploy') loadDeployRepos();
        if(tabId === 'pageProfile') { renderTokenScopes(); loadCm(true, ALL_COMMENT_ROOTS.length > 0); } 

        }

                function pushPage(pageId, title, subtitle = "") {
            history.pushState({ isPage: true, pageId: pageId }, "");
            document.getElementById(pageId)?.classList.remove('translate-x-full');
            NAV_STACK.push(pageId); updateNavHeader(title, subtitle);
        }

        window.handleAppBack = function() {
            if (document.getElementById('contextMenuOverlay') && !document.getElementById('contextMenuOverlay').classList.contains('hidden')) { closeContextMenu(); return true; }
            if (document.getElementById('uploadPanelModal') && !document.getElementById('uploadPanelModal').classList.contains('hidden')) { closeUploadPanel(); return true; }
            if (document.getElementById('formModal') && !document.getElementById('formModal').classList.contains('hidden')) { closeForm(); return true; }
            if (document.getElementById('promptModal') && !document.getElementById('promptModal').classList.contains('hidden')) { closePrompt(); return true; }
            if (document.getElementById('imagePreviewOverlay') && !document.getElementById('imagePreviewOverlay').classList.contains('hidden')) { closeImagePreview(); return true; }
            if (IS_BATCH_MODE) { toggleBatchMode(false); return true; }
            
            if (NAV_STACK.length === 1 && NAV_STACK[0] === 'pageStarred') {
                switchTab('pageRepos', document.querySelectorAll('.tab-btn')[0]);
                return true;
            }
            if (NAV_STACK.length > 1) {
                goBack();
                return true;
            }
            return false;
        };

        function performGoBackUI(fromPopState = false) {
            const currentPage = NAV_STACK[NAV_STACK.length - 1];
            
            if(!fromPopState && currentPage === 'pageFiles' && CURRENT_PATH !== "") {
                const parts = CURRENT_PATH.split('/'); parts.pop();
                CURRENT_PATH = parts.join('/'); 
                history.pushState({ isFolder: true, path: CURRENT_PATH }, "");
                loadFiles(CURRENT_PATH, true);
                return; 
            }
            
            const popped = NAV_STACK.pop(); 
            document.getElementById(popped)?.classList.add('translate-x-full');
            
            const prevPage = NAV_STACK[NAV_STACK.length - 1];
            if(prevPage === 'pageRepos') { updateNavHeader("我的仓库"); CURRENT_REPO = null; } 
            else if (prevPage === 'pageStarred') { updateNavHeader("星标仓库"); CURRENT_REPO = null; }
            else if (prevPage === 'pageDeploy') { updateNavHeader("Pages 部署"); }
            else if (prevPage === 'pageProfile') { updateNavHeader("个人中心"); }
            else if (prevPage === 'pageFiles') { updateNavHeader(CURRENT_REPO?.name, CURRENT_BRANCH); }
            else if (prevPage === 'pageBookmarks') { updateNavHeader("我的书签"); }
        }


        function goBack() {
            if (IS_BATCH_MODE) { toggleBatchMode(false); return; }
            if(NAV_STACK.length === 1 && NAV_STACK[0] === 'pageStarred') {
                switchTab('pageRepos', document.querySelectorAll('.tab-btn')[0]);
                return;
            }
            if(NAV_STACK.length <= 1) return;
            history.back();
        }

        

        window.addEventListener('popstate', function(event) {
            if (window._ignoreNextPop) {
                window._ignoreNextPop = false;
                return;
            }
            
            if (document.getElementById('contextMenuOverlay') && !document.getElementById('contextMenuOverlay').classList.contains('hidden')) { 
                closeContextMenu(true); 
            }
            else if (document.getElementById('uploadPanelModal') && !document.getElementById('uploadPanelModal').classList.contains('hidden')) { 
                closeUploadPanel(true); 
            }
            else if (document.getElementById('formModal') && !document.getElementById('formModal').classList.contains('hidden')) { 
                closeForm(true); 
            }
            else if (document.getElementById('promptModal') && !document.getElementById('promptModal').classList.contains('hidden')) { 
                closePrompt(true); 
            }
            else if (document.getElementById('imagePreviewOverlay') && !document.getElementById('imagePreviewOverlay').classList.contains('hidden')) { 
                closeImagePreview(true); 
            }
            else if (event.state && event.state.isFolder !== undefined) {
                CURRENT_PATH = event.state.path || "";
                loadFiles(CURRENT_PATH, true);
            }
            else if (NAV_STACK.length > 1) {
                performGoBackUI(true);
            }
        });



        function updateNavHeader(title, subtitle = "") {
            const navTitle = document.getElementById('navTitle'); if(navTitle) navTitle.innerText = title;
            const subEl = document.getElementById('navSubtitle');
            if(subEl) { if(subtitle) { subEl.innerText = subtitle; subEl.classList.remove('hidden'); } else { subEl.classList.add('hidden'); } }

            const currPage = NAV_STACK[NAV_STACK.length - 1];
            const isRoot = NAV_STACK.length === 1;
            
            document.getElementById('navBackBtn')?.classList.toggle('hidden', isRoot);
            
            const isOnlyRepos = (currPage === 'pageRepos');
            document.getElementById('fabBtn')?.classList.toggle('hidden', !isOnlyRepos);
            
            document.getElementById('bottomNav')?.classList.toggle('hidden', !isRoot);


            const navRight = document.getElementById('navRightArea');
            if(!navRight) return; navRight.innerHTML = '';
            const curr = NAV_STACK[NAV_STACK.length - 1];
            
            if(curr === 'pageEditor') { navRight.innerHTML = `<button id="navSaveBtn" disabled style="opacity: 0.5;" onclick="saveCurrentFile()" class="w-[80px] shrink-0 flex items-center justify-center py-1.5 bg-blue-600 text-white text-[13px] font-bold rounded-full active:bg-blue-700">保存</button>`; } 
            else if(curr === 'pageBranches') { navRight.innerHTML = `<button onclick="triggerNewBranch()" class="p-1.5 text-blue-600 active:bg-blue-50 rounded-full"><i data-lucide="plus" class="w-5 h-5"></i></button>`; } 
            else if(curr === 'pageReleases') { navRight.innerHTML = `<button onclick="triggerNewRelease()" class="p-1.5 text-blue-600 active:bg-blue-50 rounded-full"><i data-lucide="plus" class="w-5 h-5"></i></button>`; }
            else if(curr === 'pageRepos') {
                navRight.innerHTML = ` <button onclick="openBookmarksView()" class="p-2 text-blue-600 active:bg-blue-50 rounded-full"><i data-lucide="bookmark" class="w-5 h-5"></i></button>
                <button onclick="handleFabClick()" class="p-2 text-blue-600 active:bg-blue-50 rounded-full"><i data-lucide="plus" class="w-6 h-6"></i></button>`;
            }
                        else if(curr === 'pageFiles') {
                navRight.innerHTML = `
                    <button onclick="switchTab('pageRepos', document.querySelectorAll('.tab-btn')[0])" class="flex items-center justify-center w-8 h-8 text-slate-600 active:bg-slate-100 active:scale-95 rounded-full transition-all"><i data-lucide="home" class="w-5 h-5"></i></button>
                    <button onclick="toggleRecursiveSearch('toggle')" class="flex items-center justify-center w-8 h-8 text-slate-600 active:bg-slate-100 active:scale-95 rounded-full transition-all"><i data-lucide="search" class="w-5 h-5"></i></button>
                `;
            }

            createLocalIcons();
        }




function syncAvatarBackground(login, url, imgEl) {
    if (!imgEl) return;
    fetch(url, { cache: 'no-cache' })
        .then(res => res.blob())
        .then(blob => {
            const reader = new FileReader();
            reader.onloadend = () => {
                const base64data = reader.result;
                const cacheKey = 'gh_avatar_' + login;
                if (base64data !== localStorage.getItem(cacheKey)) {
                    localStorage.setItem(cacheKey, base64data);
                    imgEl.src = base64data;
                }
            };
            reader.readAsDataURL(blob);
        }).catch(() => {});
}

        // --- 搜索与多选批处理核心逻辑 ---
        function toggleRecursiveSearch(action) {
            const searchBar = document.getElementById('fileSearchBar');
            const isCurrentlyHidden = searchBar.classList.contains('hidden');
            const show = action === 'toggle' ? isCurrentlyHidden : action;

            document.getElementById('fileDefaultBar').classList.toggle('hidden', show);
            searchBar.classList.toggle('hidden', !show);
            searchBar.style.display = show ? 'flex' : 'none';
            if(show) {
                document.getElementById('fileSearchInput').focus();
            } else {
                document.getElementById('fileSearchInput').value = '';
                SELECTED_FILES.clear();
                if (IS_BATCH_MODE) updateBatchCount();
                renderFileListHTML(CURRENT_FILES);
            }
        }

        function debounceRecursiveSearch() {
            clearTimeout(searchDebounceTimer);
            searchDebounceTimer = setTimeout(performRecursiveSearch, 600);
        }

                async function performRecursiveSearch() {
            const term = document.getElementById('fileSearchInput').value.trim().toLowerCase();
            if(!term) {
                renderFileListHTML(CURRENT_FILES);
                return;
            }
            showToast("穿透子目录检索中...", "loading");
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            try {
                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/trees/${CURRENT_BRANCH}?recursive=1`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                const data = await res.json();
                if(data.tree) {
                    let prefix = CURRENT_PATH ? CURRENT_PATH + '/' : '';
                    let matched = data.tree.filter(item => 
                        item.path.startsWith(prefix) && 
                        item.path.split('/').pop().toLowerCase().includes(term)
                    );
                    const formatted = matched.map(item => ({
                        name: item.path.split('/').pop(),
                        path: item.path,
                        sha: item.sha,
                        type: item.type === 'tree' ? 'dir' : 'file',
                        download_url: `https://raw.githubusercontent.com/${repoOwner}/${CURRENT_REPO.name}/${CURRENT_BRANCH}/${item.path}`
                    }));
                    renderFileListHTML(formatted, CURRENT_PATH);
                }
            } catch(e) {
                showToast("搜索失败", "error");
            }
        }


        function toggleBatchMode(show) {
            IS_BATCH_MODE = show;
            SELECTED_FILES.clear();
            document.getElementById('fileDefaultBar').classList.toggle('hidden', show);
            document.getElementById('fileBatchBar').classList.toggle('hidden', !show);
            document.getElementById('fileBatchBar').style.display = show ? 'flex' : 'none';
            updateBatchCount();
            renderFileListHTML(CURRENT_FILES);
        }

        function toggleFileSelect(path) {
            if(SELECTED_FILES.has(path)) SELECTED_FILES.delete(path);
            else SELECTED_FILES.add(path);
            updateBatchCount();
            renderFileListHTML(CURRENT_FILES);
        }

        function updateBatchCount() {
            document.getElementById('batchCountText').innerText = `已选 ${SELECTED_FILES.size} 项`;
        }

        function selectAllBatch() {
            if(SELECTED_FILES.size === CURRENT_FILES.length) SELECTED_FILES.clear();
            else CURRENT_FILES.forEach(f => SELECTED_FILES.add(f.path));
            updateBatchCount();
            renderFileListHTML(CURRENT_FILES);
        }

                async function batchDeleteFiles() {
            if(SELECTED_FILES.size === 0) return showToast("未选择内容", "error");
            showForm("批量删除确认", `<p class="text-[13px] text-slate-500 text-center py-4">确定要删除选定的 <b class="text-red-500">${SELECTED_FILES.size}</b> 项吗？<br><br>注意：如果包含文件夹，将自动递归删除内部所有文件。</p>`, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "正在删除...");
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                let success = 0;
                let arr = Array.from(SELECTED_FILES);
                try {
                    for(let i=0; i<arr.length; i++) {
                        const path = arr[i];
                        const fileObj = CURRENT_FILES.find(f => f.path === path);
                        if(fileObj) {
                            if (fileObj.type === 'dir') {
                                const treeRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/trees/${fileObj.sha}?recursive=1`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                                if (treeRes.ok) {
                                    const treeData = await treeRes.json();
                                    const filesToDelete = treeData.tree.filter(item => item.type === 'blob');
                                    for(let j=0; j<filesToDelete.length; j++) {
                                        const fileItem = filesToDelete[j];
                                        showToast(`正在删除: ${fileItem.path}...`, "loading");
                                        await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}/${fileItem.path}`, {
                                            method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                            body: JSON.stringify({ message: `Batch delete ${path}/${fileItem.path}`, sha: fileItem.sha, branch: CURRENT_BRANCH })
                                        });
                                    }
                                }
                                success++;
                            } else {
                                showToast(`正在删除: ${fileObj.name}...`, "loading");
                                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}`, {
                                    method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                    body: JSON.stringify({ message: `Batch delete ${path}`, sha: fileObj.sha, branch: CURRENT_BRANCH })
                                });
                                if(res.ok) success++;
                            }
                        }
                    }
                    showToast(`已成功删除 ${success} 项`, "success");
                } catch (e) {
                    showToast(e.message, "error");
                } finally {
                    toggleBatchMode(false);
                    closeForm();
                    loadFiles(CURRENT_PATH);
                    setBtnLoading(btn, false);
                }
            });
            setTimeout(createLocalIcons, 10);
        }


                






        function openBookmarksView() {
            pushPage('pageBookmarks', "我的书签");
            renderBookmarks();
        }

        function renderBookmarks() {
            if(BOOKMARKS.length === 0) {
                document.getElementById('bookmarkListContainer').innerHTML = `<div class="text-center py-20 text-slate-400">暂无书签</div>`;
                return;
            }
            const html = BOOKMARKS.map(item => {
                const isDir = item.type === 'dir';
                const safeData = encodeURIComponent(JSON.stringify(item));
                return `
                <div onclick="handleBookmarkClick('${safeData}')" class="flex items-center gap-3 p-4 bg-white active:bg-slate-50 transition-colors cursor-pointer">
                    <i data-lucide="${isDir ? 'folder' : 'file-text'}" class="w-6 h-6 ${isDir ? 'text-amber-400 fill-amber-100' : 'text-slate-400'} shrink-0 pointer-events-none"></i>
                    <div class="flex-1 min-w-0 pointer-events-none">
                        <h4 class="text-[15px] font-medium text-slate-700 truncate">${item.name}</h4>
                        <p class="text-[11px] text-slate-400 truncate">${item.repoOwner}/${item.repoName}</p>
                    </div>
                    <button onclick="event.stopPropagation(); toggleBookmark('${safeData}');" class="p-2 text-blue-500 rounded-full active:bg-blue-50"><i data-lucide="bookmark" class="w-5 h-5 fill-blue-500"></i></button>
                </div>`;
            }).join('');
            document.getElementById('bookmarkListContainer').innerHTML = html;
            createLocalIcons();
        }

                async function handleBookmarkClick(encodedStr) {
            const item = JSON.parse(decodeURIComponent(encodedStr));
            CURRENT_REPO = { owner: { login: item.repoOwner }, name: item.repoName };
            CURRENT_BRANCH = item.branch;
            if(item.type === 'dir') {
                CURRENT_PATH = item.path;
                pushPage('pageFiles', CURRENT_REPO.name, CURRENT_BRANCH);
                loadFiles(CURRENT_PATH);
            } else {
                showToast("同步文件状态...", "loading");
                try {
                    const res = await fetch(`https://api.github.com/repos/${item.repoOwner}/${item.repoName}/contents/${item.path}?ref=${item.branch}`, {
                        headers: { 'Authorization': `token ${GITHUB_TOKEN}` }
                    });
                    if(!res.ok) throw new Error("文件路径已变更或已删除");
                    const latestItem = await res.json();
                    handleFileClick(latestItem.sha, latestItem);
                } catch(e) {
                    showToast(e.message, "error");
                }
            }
        }



        function toggleBookmark(encodedStr) {
            closeContextMenu();
            const item = JSON.parse(decodeURIComponent(encodedStr));
            const repoOwner = CURRENT_REPO?.owner?.login || CURRENT_REPO?.owner || item.repoOwner;
            const repoName = CURRENT_REPO?.name || item.repoName;
            const branch = CURRENT_BRANCH || item.branch;
            
            const existingIndex = BOOKMARKS.findIndex(b => b.path === item.path && b.repoName === repoName && b.repoOwner === repoOwner);
            if(existingIndex > -1) {
                BOOKMARKS.splice(existingIndex, 1);
                showToast("已移除书签");
            } else {
                BOOKMARKS.push({
                    type: item.type, name: item.name, path: item.path,
                    repoOwner: repoOwner, repoName: repoName, branch: branch
                });
                showToast("已添加至书签", "success");
            }
            localStorage.setItem(BOOKMARKS_KEY, JSON.stringify(BOOKMARKS));
            if(NAV_STACK[NAV_STACK.length-1] === 'pageBookmarks') renderBookmarks();
        }

        // --- 居中菜单 (Context Menu) ---
        function openContextMenu(htmlContent) {
            pushModalState();
            document.getElementById('contextMenuContent').innerHTML = htmlContent; createLocalIcons();
            const overlay = document.getElementById('contextMenuOverlay'); const menuBox = document.getElementById('contextMenu');
            overlay.classList.remove('hidden');
            setTimeout(() => { overlay.style.opacity = '1'; menuBox.classList.remove('scale-95'); menuBox.classList.add('scale-100'); }, 10);
        }

        function closeContextMenu(fromPopState = false) {
            const overlay = document.getElementById('contextMenuOverlay');
            if (overlay.classList.contains('hidden')) return;
            const menuBox = document.getElementById('contextMenu');
            overlay.style.opacity = '0'; menuBox.classList.remove('scale-100'); menuBox.classList.add('scale-95');
            setTimeout(() => { overlay.classList.add('hidden'); }, 200);
            popModalState(fromPopState);
        }


        function triggerVibrate() { if (navigator.vibrate) navigator.vibrate(50); }

        function handleFabClick() {
            const currentPage = NAV_STACK[NAV_STACK.length - 1];
            if(currentPage === 'pageRepos') {
                showForm("新建仓库", `
                    <div><label class="block text-[11px] font-bold text-slate-400 mb-1">仓库名称</label><input type="text" id="newRepoName" placeholder="输入名称..." oninput="this.value = this.value.replace(/[^a-zA-Z0-9_.-]/g, '')" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></div>
                    <div><label class="block text-[11px] font-bold text-slate-400 mb-1">仓库描述</label><textarea id="newRepoDesc" rows="3" placeholder="可选：输入仓库介绍..." class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></textarea></div>
                `, () => {
                    const name = document.getElementById('newRepoName').value.trim();
                    const desc = document.getElementById('newRepoDesc').value.trim();
                    handleCreateRepo(name, desc);
                });
            } 
            else if (currentPage === 'pageFiles') {
                triggerUploadMenu();
            }
        }


                function triggerUploadMenu() {
            openContextMenu(`
                <div class="px-4 py-2.5 text-[12px] font-bold text-slate-400 uppercase tracking-wider border-b border-slate-100 bg-slate-50">上传选项</div>
                <button onclick="document.getElementById('batchUploadInput').click(); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 bg-white border-b border-slate-50 active:bg-slate-50">
                    <i data-lucide="file-plus" class="w-[18px] h-[18px] text-blue-600"></i>
                    <span class="text-[14px] font-bold text-slate-800">选择文件</span>
                </button>
                <button onclick="document.getElementById('folderUploadInput').click(); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 bg-white border-b border-slate-50 active:bg-slate-50">
                    <i data-lucide="folder-plus" class="w-[18px] h-[18px] text-amber-500"></i>
                    <span class="text-[14px] font-bold text-slate-800">选择文件夹</span>
                </button>
            `);
        }

        function toggleReplaceBar(show) {
            document.getElementById('replaceToggleBtn').classList.toggle('hidden', show);
            document.getElementById('replaceInputRow').classList.toggle('hidden', !show);
        }


        // --- 数据安全传输解析 ---
        function getRepoFromGlobal(owner, name) { return REPOS.find(r => r.name === name && r.owner.login === owner) || STARRED_REPOS.find(r => r.name === name && r.owner.login === owner); }
        function getFileFromGlobal(sha) { return CURRENT_FILES.find(f => f.sha === sha); }

        // --- 核心突破能力实现：定制化权限菜单 ---
        function handleItemClick(encodedStr) {
            const item = JSON.parse(decodeURIComponent(encodedStr));
            if (item.type === 'dir') {
                if (item.name === '.github') {
                    CURRENT_PATH = item.path + '/workflows';
                } else {
                    CURRENT_PATH = item.path;
                }
                history.pushState({ isFolder: true, path: CURRENT_PATH }, "");
                loadFiles(CURRENT_PATH);
                return;
            }

            const ext = item.name.includes('.') ? item.name.split('.').pop().toLowerCase() : '';

            const audioExts = ['mp3', 'wav', 'ogg', 'm4a', 'aac', 'flac'];
            if (audioExts.includes(ext)) {
                handleAudioPlayback(item);
                return;
            }

            const imgExts = ['jpg', 'jpeg', 'png', 'gif', 'svg', 'webp', 'ico'];
            if (imgExts.includes(ext)) {
                previewImageViaProxy(item);
                return;
            }

            const binaryExts = ['zip', 'rar', '7z', 'tar', 'gz', 'apk', 'exe', 'dll', 'so', 'pdf', 'doc', 'docx', 'xls', 'xlsx', 'ppt', 'pptx', 'ttf', 'otf', 'woff', 'woff2', 'eot', 'mp4', 'avi', 'mkv', 'jar', 'class'];
            if (binaryExts.includes(ext)) {
                showToast("二进制或文档格式无法直接预览，请长按使用下载功能", "warning");
                return;
            }

            const MAX_EDIT_SIZE = 2 * 1024 * 1024;
            if (item.size && item.size > MAX_EDIT_SIZE) {
                showToast("文件体积过大，为防止浏览器崩溃已拦截，请直接下载", "warning");
                return;
            }

            handleFileClick(item.sha, item);
        }
        
        
        
        
        
        
                let CURRENT_IMAGE_BLOB_URL = null;

        async function previewImageViaProxy(item) {
            pushModalState();
            const overlay = document.getElementById('imagePreviewOverlay');
            const imgTarget = document.getElementById('imagePreviewTarget');
            const loader = document.getElementById('imagePreviewLoader');
            
            overlay.classList.remove('hidden');
            imgTarget.classList.add('hidden');
            imgTarget.onload = null;
            imgTarget.onerror = null;
            imgTarget.removeAttribute('src');
            loader.classList.remove('hidden');
            loader.classList.add('flex');
            setTimeout(() => overlay.style.opacity = '1', 10);

            try {
                if (CURRENT_IMAGE_BLOB_URL) {
                    URL.revokeObjectURL(CURRENT_IMAGE_BLOB_URL);
                    CURRENT_IMAGE_BLOB_URL = null;
                }

                if (!CURRENT_REPO.private) {
                    imgTarget.onload = () => {
                        loader.classList.add('hidden');
                        loader.classList.remove('flex');
                        imgTarget.classList.remove('hidden');
                        setTimeout(() => imgTarget.classList.remove('scale-95'), 10);
                    };
                    imgTarget.onerror = () => {
                        showToast("图片加载失败，请检查代理节点", "error");
                        closeImagePreview();
                    };
                    imgTarget.src = getProxiedUrl(item.download_url);
                } else {
                    const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                    const fetchUrl = `https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${item.sha}`;
                    
                    const res = await fetch(fetchUrl, {
                        headers: { 
                            'Authorization': `token ${GITHUB_TOKEN}`,
                            'Accept': 'application/vnd.github.v3.raw'
                        }
                    });
                    if (!res.ok) throw new Error("加载私有图片失败，请检查 Token 权限");
                    const blob = await res.blob();
                    CURRENT_IMAGE_BLOB_URL = URL.createObjectURL(blob);
                    
                    imgTarget.onload = () => {
                        loader.classList.add('hidden');
                        loader.classList.remove('flex');
                        imgTarget.classList.remove('hidden');
                        setTimeout(() => imgTarget.classList.remove('scale-95'), 10);
                    };
                    imgTarget.onerror = () => {
                        showToast("图片数据解析失败", "error");
                        closeImagePreview();
                    };
                    imgTarget.src = CURRENT_IMAGE_BLOB_URL;
                }
            } catch (e) {
                showToast(e.message, "error");
                closeImagePreview();
            }
        }

                function closeImagePreview(fromPopState = false) {
            const overlay = document.getElementById('imagePreviewOverlay');
            if (overlay.classList.contains('hidden')) return;
            const imgTarget = document.getElementById('imagePreviewTarget');
            
            overlay.style.opacity = '0';
            imgTarget.classList.add('scale-95');
            
            setTimeout(() => {
                overlay.classList.add('hidden');
                imgTarget.onload = null;
                imgTarget.onerror = null;
                imgTarget.removeAttribute('src');
                if (CURRENT_IMAGE_BLOB_URL) {
                    URL.revokeObjectURL(CURRENT_IMAGE_BLOB_URL);
                    CURRENT_IMAGE_BLOB_URL = null;
                }
            }, 300);
            popModalState(fromPopState);
        }




        let AUDIO_PLAYLIST = [];
        let CURRENT_AUDIO_INDEX = -1;

        function handleAudioPlayback(item) {
            if (CURRENT_AUDIO_SHA === item.sha) {
                if (window.AndroidBridge && window.AndroidBridge.stopAudio) {
                    window.AndroidBridge.stopAudio();
                } else if (CURRENT_AUDIO) {
                    CURRENT_AUDIO.pause();
                    CURRENT_AUDIO.currentTime = 0;
                }
                CURRENT_AUDIO = null;
                CURRENT_AUDIO_SHA = null;
                showToast("已停止播放", "info");
                renderFileListHTML(CURRENT_FILES);
                return;
            }

            const audioExts = ['mp3', 'wav', 'ogg', 'm4a', 'aac', 'flac'];
            AUDIO_PLAYLIST = CURRENT_FILES.filter(f => {
                const ext = f.name.includes('.') ? f.name.split('.').pop().toLowerCase() : '';
                return audioExts.includes(ext);
            });
            
            CURRENT_AUDIO_INDEX = AUDIO_PLAYLIST.findIndex(f => f.sha === item.sha);
            if (CURRENT_AUDIO_INDEX === -1) {
                AUDIO_PLAYLIST = [item];
                CURRENT_AUDIO_INDEX = 0;
            }
            
            window.playAudioAtIndex(CURRENT_AUDIO_INDEX);
        }

                window.playAudioAtIndex = function(index) {
            if (index < 0 || index >= AUDIO_PLAYLIST.length) return;
            
            if (!window.AndroidBridge && CURRENT_AUDIO) {
                CURRENT_AUDIO.pause();
                CURRENT_AUDIO.currentTime = 0;
            }

            CURRENT_AUDIO_INDEX = index;
            const item = AUDIO_PLAYLIST[index];
            const rawUrl = item.download_url;
            const proxyUrl = getProxiedUrl(rawUrl);
            const displayName = item.name.replace(/\.[^/.]+$/, "");
            
            CURRENT_AUDIO_SHA = item.sha;
            renderFileListHTML(CURRENT_FILES);

            if (window.AndroidBridge && window.AndroidBridge.playAudio) {
                // 直接发送新歌指令，原生端会自动接管无缝替换，保持灵动岛长亮！
                window.AndroidBridge.playAudio(proxyUrl, displayName);
                showToast("正在缓冲...", "loading");

                setTimeout(() => {
                    if (CURRENT_AUDIO_SHA === item.sha) {
                        showToast("正在播放", "success");
                    }
                }, 2000);
            } else {
                CURRENT_AUDIO = new Audio(proxyUrl);
                showToast("正在缓冲: " + displayName, "loading");
                CURRENT_AUDIO.addEventListener('waiting', () => {
                    if (CURRENT_AUDIO_SHA === item.sha) showToast("网络缓冲中...", "loading");
                });
                CURRENT_AUDIO.addEventListener('playing', () => {
                    if (CURRENT_AUDIO_SHA === item.sha) {
                        showToast("正在播放: " + displayName, "success");
                    }
                });
                CURRENT_AUDIO.play().catch(() => {});
                CURRENT_AUDIO.onended = () => {
                    window.playNextAudio();
                };
            }
        };


        window.playNextAudio = function() {
            if (!AUDIO_PLAYLIST || AUDIO_PLAYLIST.length <= 1) {
                showToast("当前目录没有其他歌曲", "info");
                return;
            }
            let nextIdx = CURRENT_AUDIO_INDEX + 1;
            if (nextIdx >= AUDIO_PLAYLIST.length) nextIdx = 0;
            window.playAudioAtIndex(nextIdx);
        };

        window.playPrevAudio = function() {
            if (!AUDIO_PLAYLIST || AUDIO_PLAYLIST.length <= 1) {
                showToast("当前目录没有其他歌曲", "info");
                return;
            }
            let prevIdx = CURRENT_AUDIO_INDEX - 1;
            if (prevIdx < 0) prevIdx = AUDIO_PLAYLIST.length - 1;
            window.playAudioAtIndex(prevIdx);
        };



        function downloadViaProxy(rawUrl, filename) {
            closeContextMenu();
            if (!PROXY_ENABLED || !PROXY_URL) {
                showToast("请先在「我的」开启资源代理设置", "warning");
                return;
            }
            const proxyUrl = getProxiedUrl(rawUrl);
            const separator = proxyUrl.includes('?') ? '&' : '?';
            const dlUrl = `${proxyUrl}${separator}_dl=${encodeURIComponent(filename)}`;
            showToast("正在拉取加速资源...", "success");
            const a = document.createElement('a');
            a.href = dlUrl;
            a.download = filename;
            a.target = '_blank';
            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
        }


                async function downloadFileViaAPI(sha, filename) {
            closeContextMenu();
            showToast("提取文件中...", "loading");
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            try {
                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${sha}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                if (!res.ok) throw new Error("获取文件数据失败");
                const data = await res.json();
                
                const cleanBase64 = data.content.replace(/\s/g, '');

                if (window.AndroidDown && window.AndroidDown.postBlob) {
                    window.AndroidDown.postBlob("data:application/octet-stream;base64," + cleanBase64, "", filename);
                } else {
                    const byteString = atob(cleanBase64);
                    const ab = new ArrayBuffer(byteString.length);
                    const ia = new Uint8Array(ab);
                    for (let i = 0; i < byteString.length; i++) {
                        ia[i] = byteString.charCodeAt(i);
                    }
                    const blob = new Blob([ab]);
                    
                    const a = document.createElement('a');
                    a.href = URL.createObjectURL(blob);
                    a.download = filename;
                    document.body.appendChild(a);
                    a.click();
                    document.body.removeChild(a);
                    setTimeout(() => URL.revokeObjectURL(a.href), 1000);
                }
                showToast("提取成功，正在保存...", "success");
            } catch (e) {
                showToast(e.message, "error");
            }
        }




        function showItemMenu(encodedStr) {
            if (Date.now() - (window.lastMenuToggleTime || 0) < 500) return;
            window.lastMenuToggleTime = Date.now();
            triggerVibrate();
            const item = JSON.parse(decodeURIComponent(encodedStr));
            const isDir = item.type === 'dir';
            const repoOwner = CURRENT_REPO?.owner?.login || CURRENT_REPO?.owner;
            const repoUrl = `https://github.com/${repoOwner}/${CURRENT_REPO.name}`;
            const isOwn = (repoOwner === USER_DATA.login);
            const repoOwnerName = CURRENT_REPO?.owner?.login || CURRENT_REPO?.owner;
            const isBookmarked = BOOKMARKS.some(b => b.path === item.path && b.repoName === CURRENT_REPO.name && b.repoOwner === repoOwnerName);

            let menuHtml = `<div class="px-4 py-2.5 text-[12px] font-bold text-slate-400 uppercase tracking-wider border-b border-slate-100 bg-slate-50 truncate">${item.name}</div>`;

            if (isOwn) {
                menuHtml += `<button onclick="triggerRenameItem('${item.path}', '${item.sha}', '${item.name}', ${isDir})" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="type" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">重命名</span></button>`;
            }

            menuHtml += `<button onclick="toggleBookmark('${encodedStr}')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="bookmark" class="w-4 h-4 ${isBookmarked?'text-blue-500 fill-blue-500':'text-slate-500'}"></i> <span class="text-[14px] font-medium text-slate-700">${isBookmarked?'取消书签':'添加至书签'}</span></button>`;

            const itemRepoUrl = `${repoUrl}/${isDir ? 'tree' : 'blob'}/${CURRENT_BRANCH}/${item.path}`;
            menuHtml += `<button onclick="copyLink('${itemRepoUrl}', '仓库链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="book" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">仓库链接</span></button>`;

            const homepageUrl = CURRENT_REPO.homepage?.startsWith('http') ? (CURRENT_REPO.homepage.endsWith('/') ? CURRENT_REPO.homepage + item.path : CURRENT_REPO.homepage + '/' + item.path) : null;

            if (CURRENT_REPO.has_pages) {
                const isMainSite = CURRENT_REPO.name.toLowerCase() === `${repoOwner.toLowerCase()}.github.io`;
                const defaultUrl = `https://${repoOwner}.github.io${isMainSite ? '' : '/' + CURRENT_REPO.name}/${item.path}`;
                menuHtml += `<button onclick="copyLink('${defaultUrl}', '网站链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="globe" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">网站链接</span></button>`;
                
                if (CURRENT_REPO.pagesInfo && CURRENT_REPO.pagesInfo.cname) {
                    const cnameUrl = `https://${CURRENT_REPO.pagesInfo.cname}/${item.path}`;
                    menuHtml += `<button onclick="copyLink('${cnameUrl}', '域名链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="external-link" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">域名链接</span></button>`;
                } else if (homepageUrl && (!CURRENT_REPO.pagesInfo || !CURRENT_REPO.pagesInfo.cname || !homepageUrl.includes(CURRENT_REPO.pagesInfo.cname))) {
                    menuHtml += `<button onclick="copyLink('${homepageUrl}', '第三方链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="link-2" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">第三方链接</span></button>`;
                }
            } else if (homepageUrl) {
                menuHtml += `<button onclick="copyLink('${homepageUrl}', '第三方链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="link-2" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">第三方链接</span></button>`;
            }

            if (!isDir) {
                const ext = item.name.split('.').pop().toLowerCase();
                if (ext === 'yml' || ext === 'yaml') {
                    menuHtml += `<button onclick="dispatchWorkflow('${item.path}')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-blue-50 border-b border-slate-50"><i data-lucide="play" class="w-4 h-4 text-blue-600"></i> <span class="text-[14px] font-bold text-blue-600">执行脚本 (Dispatch)</span></button>`;
                }
                const rawUrl = item.download_url;
                const jsdDomestic = `https://cdn.jsdmirror.com/gh/${repoOwner}/${CURRENT_REPO.name}@${CURRENT_BRANCH}/${item.path}`;
                const jsdGlobal = `https://gcore.jsdelivr.net/gh/${repoOwner}/${CURRENT_REPO.name}@${CURRENT_BRANCH}/${item.path}`;
                
                menuHtml += `<button onclick="copyLink('${rawUrl}', '官方 RAW')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="file-text" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">官方 RAW 链接</span></button>`;
                menuHtml += `<button onclick="copyLink('${jsdDomestic}', '国内直链')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="copy" class="w-4 h-4 text-emerald-500"></i> <span class="text-[14px] font-medium text-slate-700">加速直链 (国内推荐)</span></button>`;
                menuHtml += `<button onclick="copyLink('${jsdGlobal}', '国际直链')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="copy" class="w-4 h-4 text-blue-500"></i> <span class="text-[14px] font-medium text-slate-700">加速直链 (国际老牌)</span></button>`;
                menuHtml += `<button onclick="downloadViaProxy('${rawUrl}', '${item.name}')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="zap" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">代理加速下载</span></button>`;
                menuHtml += `<button onclick="downloadFileViaAPI('${item.sha}', '${item.name}')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="download" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">API 慢速下载（自定义代理使用）</span></button>`;
            }

            if (isOwn && !isDir && item.name.toLowerCase().endsWith('.zip')) {
                menuHtml += `<button onclick="unzipFileLocally('${item.path}', '${item.sha}');" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="file-archive" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">解压至当前目录</span></button>`;
            }

            if (isOwn) {
                menuHtml += `<button onclick="deleteItemDirectly('${item.path}', '${item.sha}', ${isDir})" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-red-50"><i data-lucide="trash-2" class="w-4 h-4 text-red-500"></i> <span class="text-[14px] font-bold text-red-600">删除${isDir?'目录':'文件'}</span></button>`;
            }
            
            openContextMenu(menuHtml);
        }



        function togglePinRepo(repoKey) {
            const index = PINNED_REPOS.indexOf(repoKey);
            if(index > -1) {
                PINNED_REPOS.splice(index, 1);
                showToast("已取消置顶");
            } else {
                PINNED_REPOS.unshift(repoKey);
                showToast("已添加置顶", "success");
            }
            localStorage.setItem(PINNED_KEY, JSON.stringify(PINNED_REPOS));
            if(NAV_STACK[NAV_STACK.length - 1] === 'pageRepos') loadRepos();
            if(NAV_STACK[NAV_STACK.length - 1] === 'pageStarred') loadStarredRepos();
        }

        

        async function downloadRepoZip(owner, name, branch, isPrivate) {
            closeContextMenu();
            
            const rawUrl = `https://codeload.github.com/${owner}/${name}/zip/refs/heads/${branch}`;
            
            let proxyUrl = rawUrl;
            if (typeof PROXY_ENABLED !== 'undefined' && PROXY_ENABLED && PROXY_URL) {
                proxyUrl = PROXY_URL + encodeURIComponent(rawUrl);
            }

            if (!isPrivate) {
                window.open(proxyUrl);
                return;
            }

            showToast("提取私有仓库 ZIP...", "loading");
            try {
                const apiUrl = `https://api.github.com/repos/${owner}/${name}/zipball/${branch}`;
                const res = await fetch(apiUrl, { 
                    headers: { 'Authorization': `token ${GITHUB_TOKEN}` } 
                });
                if (!res.ok) throw new Error("获取仓库 ZIP 失败 (可能无权限)");
                
                const blob = await res.blob();
                
                if (window.AndroidDown && window.AndroidDown.postBlob) {
                    const reader = new FileReader();
                    reader.onloadend = function() {
                        const base64data = reader.result;
                        window.AndroidDown.postBlob(base64data, "", `${name}-${branch}.zip`);
                    }
                    reader.readAsDataURL(blob);
                } else {
                    const a = document.createElement('a');
                    a.href = URL.createObjectURL(blob);
                    a.download = `${name}-${branch}.zip`;
                    document.body.appendChild(a);
                    a.click();
                    document.body.removeChild(a);
                    setTimeout(() => URL.revokeObjectURL(a.href), 1000);
                }
                showToast("提取成功，正在保存...", "success");
            } catch (e) {
                showToast(e.message, "error");
            }
        }


        function showRepoMenu(repoJson) {
            if (Date.now() - (window.lastMenuToggleTime || 0) < 500) return;
            window.lastMenuToggleTime = Date.now();
            triggerVibrate();
            const repo = JSON.parse(decodeURIComponent(repoJson));
            const owner = repo.owner.login; const name = repo.name;
            const isOwn = (owner === USER_DATA.login);
            const isPinned = PINNED_REPOS.includes(`${owner}/${name}`);

            let menuHtml = `<div class="px-4 py-2.5 text-[12px] font-bold text-slate-400 uppercase tracking-wider border-b border-slate-100 bg-slate-50 truncate">${name}</div>`;
            
            menuHtml += `<button onclick="togglePinRepo('${owner}/${name}'); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="star" class="w-4 h-4 ${isPinned ? 'text-amber-500 fill-amber-500' : 'text-slate-500'}"></i> <span class="text-[14px] font-medium text-slate-700">${isPinned ? '取消置顶' : '置顶仓库'}</span></button>`;
            
            if (!isOwn) {
                menuHtml += `<button onclick="triggerForkRepo('${owner}', '${name}');" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="git-fork" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">复刻仓库 (Fork)</span></button>`;
            }

            if (isOwn) {
                menuHtml += `<button onclick="openRepoSettings('${encodeURIComponent(JSON.stringify(repo))}'); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="settings" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">仓库设置</span></button>`;
                menuHtml += `<button onclick="openBranchManager('${encodeURIComponent(JSON.stringify(repo))}'); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="git-branch" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">分支管理</span></button>`;
                menuHtml += `<button onclick="openReleaseManager('${encodeURIComponent(JSON.stringify(repo))}'); closeContextMenu();" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="tag" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">版本管理 (Releases)</span></button>`;
            }

            menuHtml += `<button onclick="copyLink('${repo.html_url}', '仓库链接')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="book" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">仓库链接</span></button>`;
            
            // 绑定全新定制的下载组件逻辑
            menuHtml += `<button onclick="downloadRepoZip('${owner}', '${name}', '${repo.default_branch}', ${repo.private})" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-slate-50 border-b border-slate-50"><i data-lucide="zap" class="w-4 h-4 text-slate-500"></i> <span class="text-[14px] font-medium text-slate-700">代理下载 ZIP</span></button>`;

            if (isOwn) {
                menuHtml += `<button onclick="deleteRepoDirectly('${owner}', '${name}')" class="w-full text-left py-3 px-4 flex items-center gap-2.5 active:bg-red-50"><i data-lucide="trash-2" class="w-4 h-4 text-red-500"></i> <span class="text-[14px] font-bold text-red-600">删除仓库</span></button>`;
            }
            openContextMenu(menuHtml);
        }

        // --- 数据拉取与渲染 ---
                async function loadRepos() {
            const listEl = document.getElementById('repoList');
            if (REPOS.length === 0) {
                const spinnerHtml = IS_FIRST_LOAD ? '' : '<div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div>';
                listEl.innerHTML = `
                    <div class="flex flex-col items-center justify-center py-20">
                        ${spinnerHtml}
                        <p class="text-xs font-bold text-slate-400">读取仓库中...</p>
                    </div>`;
            }
            try {
                const res = await fetch(`https://api.github.com/user/repos?sort=updated&per_page=100&affiliation=owner&t=${Date.now()}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                REPOS = await res.json();
                listEl.innerHTML = renderRepoCards(REPOS, false);
                createLocalIcons();
            } catch(e) { 
                showToast("加载失败","error"); 
                if (REPOS.length === 0) listEl.innerHTML = '';
            }
        }

        async function loadStarredRepos() {
            const listEl = document.getElementById('starredList');
            if (STARRED_REPOS.length === 0) {
                const spinnerHtml = IS_FIRST_LOAD ? '' : '<div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div>';
                listEl.innerHTML = `
                    <div class="flex flex-col items-center justify-center py-20">
                        ${spinnerHtml}
                        <p class="text-xs font-bold text-slate-400">读取星标中...</p>
                    </div>`;
            }
            try {
                const res = await fetch(`https://api.github.com/user/starred?per_page=100&t=${Date.now()}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                STARRED_REPOS = await res.json();
                if(STARRED_REPOS.length === 0) {
                    listEl.innerHTML = `<div class="text-center py-20 text-slate-400">暂无星标仓库</div>`;
                } else {
                    listEl.innerHTML = renderRepoCards(STARRED_REPOS, true);
                    createLocalIcons();
                }
            } catch(e) { 
                showToast("加载失败","error"); 
                if (STARRED_REPOS.length === 0) listEl.innerHTML = '';
            }
        }
function loadDeployRepos() {
            const listEl = document.getElementById('deployList');
            if(REPOS.length === 0) {
                const spinnerHtml = IS_FIRST_LOAD ? '' : '<div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div>';
                listEl.innerHTML = `<div class="flex flex-col items-center justify-center py-20">${spinnerHtml}<p class="text-xs font-bold text-slate-400">同步部署信息...</p></div>`;
                return;
            }
            const sortedDeploy = [...REPOS].sort((a,b) => (a.has_pages === b.has_pages ? 0 : a.has_pages ? -1 : 1));
            const html = sortedDeploy.map(repo => {
                const repoStr = encodeURIComponent(JSON.stringify(repo));
                return `
                <div 
                    onclick="openPagesDeploy('${repoStr}')" 
                    class="bg-white p-4 rounded-2xl mb-3 shadow-sm border border-slate-100 active:scale-[0.98] transition-transform flex items-center justify-between cursor-pointer">
                    <div class="flex-1 min-w-0 pointer-events-none">
                        <div class="flex items-center gap-2">
                            <i data-lucide="server" class="w-4 h-4 ${repo.has_pages ? 'text-emerald-500' : 'text-slate-300'}"></i>
                            <h3 class="text-[16px] font-bold text-slate-800 truncate">${repo.name}</h3>
                        </div>
                    </div>
                    ${repo.has_pages ? '' : '<i data-lucide="chevron-right" class="w-5 h-5 text-slate-300"></i>'}
                </div>`;
            }).join('');
            document.getElementById('deployList').innerHTML = html; createLocalIcons();
        }
        

        function renderRepoCards(repos, showStarBtn = false) {
            const sorted = [...repos].sort((a, b) => {
                const aPinned = PINNED_REPOS.includes(`${a.owner.login}/${a.name}`);
                const bPinned = PINNED_REPOS.includes(`${b.owner.login}/${b.name}`);
                if (aPinned && !bPinned) return -1;
                if (!aPinned && bPinned) return 1;
                return 0;
            });
            const html = sorted.map(repo => {
                const isPinned = PINNED_REPOS.includes(`${repo.owner.login}/${repo.name}`);
                const isOwn = (repo.owner.login === USER_DATA.login);
                const repoStr = encodeURIComponent(JSON.stringify(repo));
                
                const typeIcon = isPinned ? 'star' : (repo.private ? 'lock' : 'book');
                const typeClass = isPinned ? 'text-amber-500 fill-amber-500' : 'text-slate-400';
                const typeSvg = `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="w-4 h-4 ${typeClass}">${SVG_ICONS[typeIcon]}</svg>`;
                const actionStarSvg = `<svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="w-5 h-5 text-blue-500 fill-blue-500 transition-colors">${SVG_ICONS['star']}</svg>`;

                return `
                    <div 
                        ontouchstart="pressTimer = setTimeout(()=>{ isLongPress=true; showRepoMenu('${repoStr}'); }, 500); isLongPress=false;"
                        ontouchend="clearTimeout(pressTimer);" ontouchmove="clearTimeout(pressTimer);"
                        oncontextmenu="event.preventDefault(); showRepoMenu('${repoStr}');"
                        onclick="if(!isLongPress) openRepo('${repo.owner.login}', '${repo.name}', '${repo.default_branch}')" 
                        class="bg-white p-4 rounded-2xl mb-3 shadow-sm border border-slate-100 active:scale-[0.98] transition-transform flex items-center justify-between cursor-pointer">
                        <div class="flex-1 min-w-0 pointer-events-none">
                            <div class="flex items-center gap-2 mb-1">
                                ${typeSvg}
                                <h3 class="text-[16px] font-bold text-slate-800 truncate">${repo.name}</h3>
                            </div>
                            <p class="text-[12px] text-slate-400 truncate">${repo.description || (isOwn ? '我创建的仓库' : repo.owner.login + ' 的仓库')}</p>
                        </div>
                        ${showStarBtn ? `
                        <button onclick="event.stopPropagation(); toggleStarRepo('${repo.owner.login}', '${repo.name}', this)" class="p-2 -mr-2 active:scale-110 transition-all">
                            ${actionStarSvg}
                        </button>` : ''}
                    </div>`;
            }).join('');
            return html;
        }



        async function dispatchWorkflow(path) {
            closeContextMenu();
            showToast("正在触发工作流...", "loading");
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            try {
                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/actions/workflows/${path.split('/').pop()}/dispatches`, {
                    method: 'POST',
                    headers: {
                        'Authorization': `token ${GITHUB_TOKEN}`,
                        'Accept': 'application/vnd.github.v3+json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({ ref: CURRENT_BRANCH })
                });
                if (res.status === 204) {
                    showToast("工作流已成功触发", "success");
                } else {
                    const err = await res.json();
                    throw new Error(err.message || "触发失败");
                }
            } catch (e) {
                showToast(e.message, "error");
            }
        }



        function toggleStarRepo(owner, name, btnEl) {
            const iconEl = btnEl.querySelector('svg');
            if (!iconEl) return;
            const isCurrentlyStarred = iconEl.classList.contains('fill-blue-500');
            if (isCurrentlyStarred) {
                iconEl.classList.remove('text-blue-500', 'fill-blue-500');
                iconEl.classList.add('text-slate-300', 'fill-transparent');
                STARRED_REPOS = STARRED_REPOS.filter(r => !(r.name === name && r.owner.login === owner));
                showToast("已取消", "info");
            } else {
                iconEl.classList.remove('text-slate-300', 'fill-transparent');
                iconEl.classList.add('text-blue-500', 'fill-blue-500');
                const repoObj = REPOS.find(r => r.name === name && r.owner.login === owner);
                if (repoObj && !STARRED_REPOS.some(r => r.name === name && r.owner.login === owner)) {
                    STARRED_REPOS.unshift(repoObj);
                }
                showToast("已关注", "success");
            }
            const method = isCurrentlyStarred ? 'DELETE' : 'PUT';
            fetch(`https://api.github.com/user/starred/${owner}/${name}`, {
                method: method,
                headers: {
                    'Authorization': `token ${GITHUB_TOKEN}`,
                    'Content-Length': '0'
                }
            }).catch(() => {});
        }


                async function deleteRepoDirectly(owner, name) {
            closeContextMenu();
            const confirmHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="alert-circle" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认删除仓库？</p>
                    <p class="text-[13px] text-slate-500 leading-relaxed">
                        仓库 <b class="text-slate-700">${name}</b> 将被永久移除，此操作无法撤销。
                    </p>
                </div>
            `;
            showForm("危险操作", confirmHtml, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "处理中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${owner}/${name}`, {
                        method: 'DELETE',
                        headers: {
                            'Authorization': `token ${GITHUB_TOKEN}`
                        }
                    });
                    if (!res.ok) throw new Error("删除失败，请检查 Token 是否包含 delete_repo 权限");
                    REPOS = REPOS.filter(r => !(r.name === name && r.owner.login === owner));
                    STARRED_REPOS = STARRED_REPOS.filter(r => !(r.name === name && r.owner.login === owner));
                    const currPage = NAV_STACK[NAV_STACK.length - 1];
                    if (currPage === 'pageRepos') {
                        document.getElementById('repoList').innerHTML = renderRepoCards(REPOS, false);
                        createLocalIcons();
                    }
                    if (currPage === 'pageStarred') {
                        document.getElementById('starredList').innerHTML = renderRepoCards(STARRED_REPOS, true);
                        createLocalIcons();
                    }
                    closeForm();
                    showToast("仓库已永久删除", "success");
                } catch (e) {
                    showToast(e.message, "error");
                } finally {
                    setBtnLoading(btn, false);
                }
            });
            setTimeout(createLocalIcons, 10);
        }





        function openRepo(owner, name, branch) {
            CURRENT_REPO = getRepoFromGlobal(owner, name) || {owner:{login: owner}, name: name};
            CURRENT_BRANCH = branch; CURRENT_PATH = "";
            pushPage('pageFiles', name, branch); loadFiles("");
            if (CURRENT_REPO.has_pages && CURRENT_REPO.pagesInfo === undefined) {
                fetch(`https://api.github.com/repos/${owner}/${name}/pages`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Accept': 'application/vnd.github.v3+json' } })
                    .then(res => res.ok ? res.json() : null)
                    .then(data => { CURRENT_REPO.pagesInfo = data || null; })
                    .catch(() => { CURRENT_REPO.pagesInfo = null; });
            }
        }

                async function loadFiles(path, isBack = false) {
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            const cacheKey = `${repoOwner}/${CURRENT_REPO.name}/${CURRENT_BRANCH}/${path}`;
            window.DIRECTORY_CACHE = window.DIRECTORY_CACHE || {};

            window.currentFetchId = (window.currentFetchId || 0) + 1;
            const expectedFetchId = window.currentFetchId;

            if (isBack && window.DIRECTORY_CACHE[cacheKey]) {
                renderFileListHTML(window.DIRECTORY_CACHE[cacheKey], path);
                return;
            }

            const listEl = document.getElementById('fileList');
            const emptyEl = document.getElementById('fileEmpty');
            emptyEl.classList.add('hidden');
            listEl.innerHTML = `<div class="flex flex-col items-center justify-center py-20"><div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div><p class="text-xs font-bold text-slate-400">读取目录中...</p></div>`;

            const isOwn = (repoOwner === USER_DATA.login);
            const nav = document.getElementById('fileActionNav');
            if(nav) {
                nav.style.display = isOwn ? 'flex' : 'none';
                const btns = nav.querySelectorAll('button');
                if(btns.length >= 4) {
                    btns[0].style.display = isOwn ? 'block' : 'none';
                    btns[1].style.display = isOwn ? 'block' : 'none';
                    btns[2].style.display = isOwn ? 'block' : 'none';
                    btns[3].style.display = isOwn ? 'block' : 'none';
                }
            }
            const batchDeleteBtn = document.querySelector('button[onclick="batchDeleteFiles()"]');
            if(batchDeleteBtn) {
                batchDeleteBtn.style.display = isOwn ? 'block' : 'none';
            }

            try {
                const url = `https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}?ref=${CURRENT_BRANCH}&t=${Date.now()}`;
                const res = await fetch(url, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                if(!res.ok) throw new Error("Load Failed");
                const data = await res.json(); 
                if (expectedFetchId !== window.currentFetchId) return;
                window.DIRECTORY_CACHE[cacheKey] = data;
                renderFileListHTML(data, path);
            } catch(e) { 
                if (expectedFetchId !== window.currentFetchId) return;
                showToast("读取失败", "error"); 
                listEl.innerHTML = "";
            }
        }



        function renderFileListHTML(items, path = CURRENT_PATH) {
            CURRENT_FILES = items;
            if (window.renderChunkTimer) cancelAnimationFrame(window.renderChunkTimer);

            const listEl = document.getElementById('fileList');
            const emptyEl = document.getElementById('fileEmpty');
            let breadcrumbHtml = `<span class="text-blue-500 font-bold cursor-pointer" onclick="history.pushState({isFolder:true, path: ''}, ''); CURRENT_PATH=''; loadFiles('', true)">/</span>`;
            if (path) {
                const parts = path.split('/');
                let cumulativePath = "";
                breadcrumbHtml += parts.map((p, i) => {
                    cumulativePath += (i === 0 ? p : '/' + p);
                    const target = cumulativePath;
                    return `<span class="text-slate-600 active:text-blue-500 transition-colors cursor-pointer" onclick="history.pushState({isFolder:true, path: '${target}'}, ''); CURRENT_PATH='${target}'; loadFiles('${target}', true)">${p}</span>`;
                }).join('<span class="text-slate-300 mx-1">/</span>');
            }
            document.getElementById('fileBreadcrumb').innerHTML = breadcrumbHtml;
            if (!items || items.length === 0) {
                listEl.innerHTML = "";
                emptyEl.classList.remove('hidden');
                emptyEl.classList.add('flex');
                return;
            }

            emptyEl.classList.add('hidden'); emptyEl.classList.remove('flex');
            const sortedItems = [...items].sort((a,b) => (a.type === b.type ? a.name.localeCompare(b.name) : a.type === 'dir' ? -1 : 1));
            
            const generateHtmlStr = (itemArray) => itemArray.map(item => {
                const isDir = item.type === 'dir';
                const safeData = encodeURIComponent(JSON.stringify(item));
                const isSelected = SELECTED_FILES.has(item.path);
                const checkboxHtml = IS_BATCH_MODE ? `
                    <div class="ml-2 flex items-center justify-center shrink-0 pointer-events-none">
                        <div class="w-5 h-5 rounded border ${isSelected ? 'bg-indigo-500 border-indigo-500' : 'border-slate-300'} flex items-center justify-center transition-colors">
                            ${isSelected ? '<i data-lucide="check" class="w-3 h-3 text-white"></i>' : ''}
                        </div>
                    </div>
                ` : '';
                return `
                <div 
                    ontouchstart="if(!IS_BATCH_MODE) { pressTimer = setTimeout(()=>{ isLongPress=true; showItemMenu('${safeData}'); }, 500); isLongPress=false; }"
                    ontouchend="clearTimeout(pressTimer);" ontouchmove="clearTimeout(pressTimer);"
                    oncontextmenu="if(!IS_BATCH_MODE) { event.preventDefault(); showItemMenu('${safeData}'); }"
                    onclick="if(!isLongPress) { ${IS_BATCH_MODE ? `toggleFileSelect('${item.path}')` : `handleItemClick('${safeData}')`} }"
                    class="flex items-center gap-3 p-4 bg-white active:bg-slate-50 transition-colors cursor-pointer border-b border-slate-50">
                    <i data-lucide="${isDir ? 'folder' : 'file-text'}" class="w-6 h-6 ${isDir ? 'text-amber-400 fill-amber-100' : 'text-slate-400'} shrink-0 pointer-events-none"></i>
                    <span class="text-[15px] font-medium text-slate-700 flex-1 truncate pointer-events-none">${item.name}</span>
                    ${CURRENT_AUDIO_SHA === item.sha ? '<i data-lucide="music" class="w-4 h-4 text-blue-500 animate-bounce shrink-0 pointer-events-none"></i>' : ''}
                    ${checkboxHtml}
                </div>`;
            }).join('');

            const chunkSize = 40;
            listEl.innerHTML = generateHtmlStr(sortedItems.slice(0, chunkSize));
            createLocalIcons();

            if (sortedItems.length > chunkSize) {
                let currentIndex = chunkSize;
                const renderNextChunk = () => {
                    const nextChunk = sortedItems.slice(currentIndex, currentIndex + chunkSize);
                    listEl.insertAdjacentHTML('beforeend', generateHtmlStr(nextChunk));
                    createLocalIcons();
                    currentIndex += chunkSize;
                    if (currentIndex < sortedItems.length) {
                        window.renderChunkTimer = requestAnimationFrame(renderNextChunk);
                    }
                };
                window.renderChunkTimer = requestAnimationFrame(renderNextChunk);
            }
        }

        // --- 核心突破能力实现 ---
        function triggerForkRepo(owner, name) {
            closeContextMenu();
            showPrompt("复刻仓库 (可自定义新名称)", "", "输入新仓库名称...", async (newName) => {
                const btn = document.getElementById('promptConfirmBtn');
                if(!newName) return closePrompt(); 
                setBtnLoading(btn, true, "复刻中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${owner}/${name}/forks`, {
                        method: 'POST', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ name: newName }) 
                    });
                    if(!res.ok) throw new Error("复刻失败"); 
                    showToast("已成功复刻", "success");
                    closePrompt();
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }


        async function openPagesDeploy(repoJson) {
            const repo = JSON.parse(decodeURIComponent(repoJson));
            CURRENT_REPO = repo;
            pushPage('pagePagesDeploy', "Pages 部署", repo.name);
            
            const container = document.getElementById('pagesDeployContainer');
            container.innerHTML = `
                <div class="flex flex-col items-center justify-center py-20">
                    <div class="w-8 h-8 border-4 border-slate-100 border-t-blue-600 rounded-full animate-spin mb-3"></div>
                    <p class="text-xs font-bold text-slate-400">获取配置中...</p>
                </div>`;
            
            let pagesInfo = null;
            try {
                const res = await fetch(`https://api.github.com/repos/${repo.owner.login}/${repo.name}/pages?t=${Date.now()}`, {
                    headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Accept': 'application/vnd.github.v3+json' }
                });
                if(res.ok) pagesInfo = await res.json();
            } catch(e) {}

            const isMainSite = repo.name.toLowerCase() === `${repo.owner.login.toLowerCase()}.github.io`;
            const defaultUrl = `https://${repo.owner.login}.github.io${isMainSite ? '' : '/'+repo.name}`;
            const homepageUrl = repo.homepage?.startsWith('http') ? repo.homepage : null;

            let html = `
                <div class="bg-white rounded-2xl p-5 shadow-sm border border-slate-100 mb-4">
                    <div class="flex items-center justify-between mb-6">
                        <div class="flex items-center gap-3">
                            <div class="w-9 h-9 rounded-xl bg-blue-50 flex items-center justify-center">
                                <i data-lucide="globe" class="w-5 h-5 text-blue-500"></i>
                            </div>
                            <div>
                                <h3 class="text-[15px] font-bold text-slate-800">服务状态</h3>
                                <p class="text-[11px] text-slate-400">${pagesInfo ? '站点已成功发布' : '尚未开启 Pages 部署'}</p>
                            </div>
                        </div>
                        ${pagesInfo ? '<i data-lucide="check-circle" class="w-5 h-5 text-emerald-500"></i>' : ''}
                    </div>
                    
                    ${!pagesInfo ? `
                        <div class="bg-slate-50 rounded-xl p-4 mb-4 text-center">
                            <p class="text-[13px] text-slate-500">开启后将代码作为静态网页发布。</p>
                        </div>
                        <button onclick="enablePages('${repo.name}', '${repo.default_branch}')" class="w-full py-4 bg-blue-600 text-white rounded-2xl text-[14px] font-bold active:opacity-80 transition-opacity">立即开启部署</button>
                    ` : `
                        <div class="space-y-2">
                            <div onclick="copyLink('${defaultUrl}', '默认域名')" class="flex items-center justify-between p-4 bg-slate-50/50 rounded-2xl active:bg-slate-100 transition-colors cursor-pointer">
                                <div class="min-w-0">
                                    <p class="text-[10px] text-slate-400 font-bold uppercase mb-0.5">默认路径</p>
                                    <p class="text-[13px] text-blue-600 font-mono truncate">${defaultUrl}</p>
                                </div>
                                <i data-lucide="copy" class="w-4 h-4 text-slate-300"></i>
                            </div>
                            
                            ${pagesInfo.cname ? `
                            <div onclick="copyLink('https://${pagesInfo.cname}', '自定义域名')" class="flex items-center justify-between p-4 bg-slate-50/50 rounded-2xl active:bg-slate-100 transition-colors cursor-pointer">
                                <div class="min-w-0">
                                    <p class="text-[10px] text-slate-400 font-bold uppercase mb-0.5">自定义域名 (CNAME)</p>
                                    <p class="text-[13px] text-emerald-600 font-mono truncate">https://${pagesInfo.cname}</p>
                                </div>
                                <i data-lucide="external-link" class="w-4 h-4 text-slate-300"></i>
                            </div>` : ''}

                            ${homepageUrl && (!pagesInfo.cname || !homepageUrl.includes(pagesInfo.cname)) ? `
                            <div onclick="copyLink('${homepageUrl}', '第三方链接')" class="flex items-center justify-between p-4 bg-slate-50/50 rounded-2xl active:bg-slate-100 transition-colors cursor-pointer">
                                <div class="min-w-0">
                                    <p class="text-[10px] text-slate-400 font-bold uppercase mb-0.5">第三方链接</p>
                                    <p class="text-[13px] text-slate-600 font-mono truncate">${homepageUrl}</p>
                                </div>
                                <i data-lucide="link-2" class="w-4 h-4 text-slate-300"></i>
                            </div>` : ''}
                        </div>
                    `}
                </div>

                ${pagesInfo ? `
                <div class="bg-white rounded-2xl p-5 shadow-sm border border-slate-100 mb-4">
                    <div class="flex items-center gap-3 mb-5">
                        <div class="w-9 h-9 rounded-xl bg-purple-50 flex items-center justify-center">
                            <i data-lucide="link-2" class="w-5 h-5 text-purple-500"></i>
                        </div>
                        <div>
                            <h3 class="text-[15px] font-bold text-slate-800">配置自定义域名</h3>
                            <p class="text-[11px] text-slate-400">${pagesInfo.cname ? '当前已绑定：' + pagesInfo.cname : '绑定独立域名提升品牌形象'}</p>
                        </div>
                    </div>
                    <div class="bg-slate-100/80 rounded-xl p-1.5 flex items-center border border-slate-200 focus-within:border-blue-400 focus-within:bg-white transition-colors">
                        <input type="text" id="customDomain" placeholder="输入域名，如: example.com" class="flex-1 bg-transparent text-[13px] outline-none text-slate-700 placeholder:text-slate-400 pl-3">
                        <button onclick="setCustomDomain('${repo.name}')" class="px-5 py-2.5 bg-blue-600 text-white rounded-lg text-[13px] font-bold shadow-sm shadow-blue-600/20 active:bg-blue-700 transition-colors">绑定</button>
                    </div>
                    <button onclick="cancelPages('${repo.name}')" class="w-full mt-6 py-3.5 bg-red-50 text-red-600 text-[14px] font-bold active:bg-red-100 rounded-xl transition-colors border border-red-100">停止 Pages 服务</button>
                </div>
                ` : ''}
            `;

            if(!isMainSite) {
                html += `
                <div class="bg-white rounded-2xl p-5 shadow-sm border border-slate-100">
                    <div class="flex items-center gap-3 mb-4">
                        <div class="w-9 h-9 rounded-xl bg-amber-50 flex items-center justify-center">
                            <i data-lucide="zap" class="w-5 h-5 text-amber-500"></i>
                        </div>
                        <h3 class="text-[15px] font-bold text-slate-800">站点进阶</h3>
                    </div>
                    <p class="text-[12px] text-slate-400 mb-5 leading-relaxed">重命名为 <b class="text-slate-600 font-mono">${repo.owner.login.toLowerCase()}.github.io</b> 即可直接通过根域名访问。</p>
                    <button onclick="setAsMainSite('${repo.name}')" class="w-full py-3 border-2 border-slate-100 text-slate-600 rounded-2xl text-sm font-bold active:bg-slate-50 transition-colors">升级为主站域名</button>
                </div>`;
            }
            document.getElementById('pagesDeployContainer').innerHTML = html;
            createLocalIcons();
        }



                async function enablePages(repoName, branch) {
            showToast("配置 Pages...", "loading");
            try {
                const res = await fetch(`https://api.github.com/repos/${USER_DATA.login}/${repoName}/pages`, {
                    method: 'POST', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json', 'Accept': 'application/vnd.github.v3+json' },
                    body: JSON.stringify({ source: { branch: branch, path: "/" } })
                });
                if(!res.ok) throw new Error("无法开启 (可能没有权限，或已由 Actions 控制)");
                showToast("Pages 开启请求已发送", "success");
                loadRepos(); goBack();
            } catch(e) { showToast(e.message, "error"); }
        }

        async function setCustomDomain(repoName) {
            const domain = document.getElementById('customDomain').value.trim();
            if(!domain) return showToast("请输入域名", "error");
            showToast("更新配置...", "loading");
            try {
                const res = await fetch(`https://api.github.com/repos/${USER_DATA.login}/${repoName}/pages`, {
                    method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                    body: JSON.stringify({ cname: domain })
                });
                if(!res.ok) throw new Error("域名配置失败"); showToast("已配置，等待 DNS 生效", "success");
            } catch(e) { showToast(e.message, "error"); }
        }

        async function saveRepoSettings(oldName) {
            const newName = document.getElementById('setRepoName').value.trim();
            const newDesc = document.getElementById('setRepoDesc').value.trim();
            const isPrivate = document.getElementById('setPrivateToggle').checked;
            showToast("保存设置...", "loading");
            try {
                const res = await fetch(`https://api.github.com/repos/${USER_DATA.login}/${oldName}`, {
                    method: 'PATCH', 
                    headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                    body: JSON.stringify({ name: newName, description: newDesc, private: isPrivate })
                });
                if(!res.ok) throw new Error("保存失败");
                showToast("更新成功", "success");
                loadRepos(); goBack();
            } catch(e) { showToast(e.message, "error"); }
        }

        
        
                        function cancelPages(repoName) {
            const warningHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="alert-circle" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认停止 Pages 服务？</p>
                    <p class="text-[13px] text-slate-500 mb-4 leading-relaxed">您的静态网页将立即下线，并且无法再通过关联域名进行外部访问。</p>
                </div>
            `;
            
            showForm("危险操作", warningHtml, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "停止中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${USER_DATA.login}/${repoName}/pages`, {
                        method: 'DELETE',
                        headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Accept': 'application/vnd.github.v3+json' }
                    });
                    if(!res.ok) throw new Error("停止失败");
                    showToast("部署已停止", "success");
                    closeForm();
                    loadRepos();
                    if(NAV_STACK[NAV_STACK.length-1] === 'pagePagesDeploy') goBack();
                    else loadDeployRepos();
                } catch(e) {
                    showToast(e.message, "error");
                    setBtnLoading(btn, false);
                }
            });
            setTimeout(createLocalIcons, 10);
        }


        function setAsMainSite(repoName) {
            const mainName = `${USER_DATA.login}.github.io`;
            const warningHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="alert-circle" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认升级为主站？</p>
                    <p class="text-[13px] text-slate-500 mb-5 leading-relaxed">这会将当前仓库直接重命名为 <br><b class="text-blue-600 font-mono">${mainName}</b></p>
                    <div class="bg-amber-50 border border-amber-100 p-3 rounded-xl text-left">
                        <p class="text-[12px] text-amber-700 leading-relaxed"><b>⚠️ 注意事项：</b><br>仓库重命名后，原有的本地 Git 关联链接将会失效，需要重新配置远程仓库地址。若已存在同名主站仓库则会失败。</p>
                    </div>
                </div>
            `;
            
            showForm("操作预警", warningHtml, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "重命名中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${USER_DATA.login}/${repoName}`, {
                        method: 'PATCH', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ name: mainName })
                    });
                    if(!res.ok) throw new Error("重命名失败 (可能主站已存在)");
                    showToast("已成功设为主站", "success");
                    closeForm();
                    loadRepos(); goBack();
                } catch(e) { 
                    showToast(e.message, "error"); 
                    setBtnLoading(btn, false);
                }
            });
            setTimeout(createLocalIcons, 10);
        }



        

        async function openRepoSettings(repoJson) {
            const repo = JSON.parse(decodeURIComponent(repoJson));
            CURRENT_REPO = repo; 
            pushPage('pageSettings', "仓库设置", repo.name);
            document.getElementById('settingsContainer').innerHTML = `
                <div class="bg-white rounded-2xl p-5 shadow-sm border border-slate-100">
                    <div class="flex items-center justify-between mb-4">
                        <h3 class="text-[15px] font-bold text-slate-800">基本信息</h3>
                        <div class="flex items-center gap-2">
                            <span class="text-xs text-slate-400 font-bold">私有</span>
                            <input type="checkbox" id="setPrivateToggle" ${repo.private?'checked':''} class="w-4 h-4 accent-blue-600">
                        </div>
                    </div>
                    <div class="space-y-4">
                        <div>
                            <label class="block text-xs text-slate-500 mb-1">仓库名称 (慎改)</label>
                            <input type="text" id="setRepoName" value="${repo.name}" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none focus:border-blue-500">
                        </div>
                        <div>
                            <label class="block text-xs text-slate-500 mb-1">仓库描述</label>
                            <textarea id="setRepoDesc" rows="3" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none focus:border-blue-500">${repo.description || ""}</textarea>
                        </div>
                        <button onclick="saveRepoSettings('${repo.name}')" class="w-full py-3 bg-slate-900 text-white rounded-xl text-[14px] font-bold active:bg-slate-800">保存修改</button>
                    </div>
                </div>
            `;
        }

        

        // 分支管理
                async function openBranchManager(repoJson) {
            if(repoJson) CURRENT_REPO = JSON.parse(decodeURIComponent(repoJson));
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            const repoFullName = `${repoOwner}/${CURRENT_REPO.name}`;
            pushPage('pageBranches', "分支管理", CURRENT_REPO.name); 
            showToast("加载分支...", "loading");
            try {
                const res = await fetch(`https://api.github.com/repos/${repoFullName}/branches?t=${Date.now()}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                let branches = await res.json();
                document.getElementById('branchList').innerHTML = branches.map(b => `
                    <div class="bg-white p-4 rounded-xl mb-2 shadow-sm border border-slate-100 flex items-center justify-between active:bg-slate-50 transition-colors" onclick="switchBranch('${b.name}')">
                        <div class="flex items-center gap-3">
                            <i data-lucide="git-branch" class="w-5 h-5 ${b.name === CURRENT_BRANCH ? 'text-blue-600' : 'text-slate-400'}"></i>
                            <span class="font-bold ${b.name === CURRENT_BRANCH ? 'text-blue-600' : 'text-slate-700'}">${b.name}</span>
                        </div>
                        <div class="flex items-center gap-2" onclick="event.stopPropagation()">
                            ${b.name === CURRENT_REPO.default_branch ? `<span class="text-[10px] font-bold text-slate-300 px-2">DEFAULT</span>` : `
                            <button onclick="triggerRenameBranch('${b.name}')" class="p-2 text-slate-400 active:text-blue-500"><i data-lucide="edit-3" class="w-5 h-5"></i></button>
                            <button onclick="deleteBranch('${b.name}')" class="p-2 text-slate-300 active:text-red-500"><i data-lucide="trash-2" class="w-5 h-5"></i></button>`}
                        </div>
                    </div>`).join('');
                createLocalIcons();
            } catch(e) {
                showToast("获取分支失败", "error");
            }
        }

        async function openReleaseManager(repoJson) {
            if(repoJson) CURRENT_REPO = JSON.parse(decodeURIComponent(repoJson));
            pushPage('pageReleases', "版本管理", CURRENT_REPO.name); 
            showToast("拉取历史版本...", "loading");
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            try {
                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/releases?t=${Date.now()}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                const releases = await res.json();
                if(releases.length === 0) { document.getElementById('releaseList').innerHTML = `<div class="text-center py-10 text-slate-400">暂无版本记录</div>`; }
                else {
                    document.getElementById('releaseList').innerHTML = releases.map(r => {
                        const rStr = encodeURIComponent(JSON.stringify(r));
                        return `
                        <div onclick="triggerEditRelease('${rStr}')" class="bg-white p-4 rounded-xl mb-3 border border-slate-100 active:bg-slate-50">
                            <div class="flex items-center justify-between mb-2">
                                <div class="flex items-center gap-2"><i data-lucide="tag" class="w-4 h-4 text-emerald-500"></i><span class="font-bold text-slate-800">${r.tag_name}</span></div>
                                <i data-lucide="edit-3" class="w-3 h-3 text-slate-300"></i>
                            </div>
                            <h4 class="text-[15px] font-bold text-slate-700 mb-1 truncate">${r.name||'无标题'}</h4>
                            <p class="text-xs text-slate-400 mb-2">${new Date(r.published_at).toLocaleDateString()}</p>
                            ${r.assets.length > 0 ? `<div class="text-xs text-blue-600 bg-blue-50 px-2 py-1 rounded inline-block">附件: ${r.assets[0].name}</div>` : ''}
                        </div>`;
                    }).join('');
                    createLocalIcons();
                }
            } catch(e) {}
        }


        function triggerNewBranch() {
            showPrompt("基于默认分支新建", "", "输入新分支名称...", async (name) => {
                const btn = document.getElementById('promptConfirmBtn');
                if(!name) return closePrompt();
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                setBtnLoading(btn, true, "创建中...");
                try {
                    const baseRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/refs/heads/${CURRENT_REPO.default_branch}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                    const baseData = await baseRes.json();
                    
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/refs`, {
                        method: 'POST', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ ref: `refs/heads/${name}`, sha: baseData.object.sha })
                    });
                    if(!res.ok) throw new Error("分支可能已存在");
                    openBranchManager();
                    setTimeout(() => {
                        showToast("分支创建成功", "success");
                        closePrompt();
                    }, 1000);
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }

        async function deleteBranch(branch) {
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            const confirmHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="alert-circle" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认删除分支？</p>
                    <p class="text-[13px] text-slate-500 mb-4 leading-relaxed">分支 <b class="text-slate-700">${branch}</b> 将被移除。如果该分支包含未合并的代码，将会永久丢失。</p>
                </div>
            `;
            showForm("删除确认", confirmHtml, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "删除中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/refs/heads/${branch}`, { method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                    if(!res.ok) throw new Error("删除失败");
                    openBranchManager();
                    setTimeout(() => {
                        showToast("分支已删除", "success");
                        closeForm();
                    }, 1000);
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
            setTimeout(createLocalIcons, 10);
        }

        function switchBranch(branchName) {
            CURRENT_BRANCH = branchName;
            showToast(`已切换至 ${branchName}`, "success");
            const filePageIdx = NAV_STACK.indexOf('pageFiles');
            if (filePageIdx > -1) {
                while (NAV_STACK.length > filePageIdx + 1) {
                    const popped = NAV_STACK.pop();
                    document.getElementById(popped)?.classList.add('translate-x-full');
                }
                updateNavHeader(CURRENT_REPO.name, CURRENT_BRANCH);
                loadFiles(CURRENT_PATH);
            } else {
                goBack();
            }
        }

        function triggerRenameBranch(oldName) {
            showPrompt(`重命名分支`, oldName, "输入新分支名称...", async (newName) => {
                const btn = document.getElementById('promptConfirmBtn');
                if (!newName || newName === oldName) return closePrompt();
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                const repoFullName = `${repoOwner}/${CURRENT_REPO.name}`;
                setBtnLoading(btn, true, "重命名中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoFullName}/branches/${oldName}/rename`, {
                        method: 'POST',
                        headers: { 
                            'Authorization': `token ${GITHUB_TOKEN}`,
                            'Content-Type': 'application/json',
                            'Accept': 'application/vnd.github.v3+json'
                        },
                        body: JSON.stringify({ new_name: newName })
                    });
                    if (!res.ok) throw new Error("重命名失败");
                    if (CURRENT_BRANCH === oldName) CURRENT_BRANCH = newName;
                    openBranchManager();
                    setTimeout(() => {
                        showToast("分支已重命名", "success");
                        closePrompt();
                    }, 3000);
                } catch(e) {
                    showToast(e.message, "error");
                } finally {
                    setBtnLoading(btn, false);
                }
            });
        }

        

        function triggerNewRelease() {
            showForm("发布新版本", `
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">TAG 名称</label><input type="text" id="relTag" placeholder="如 v1.0.0" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></div>
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">版本标题</label><input type="text" id="relTitle" placeholder="输入标题..." class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></div>
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">发布说明</label><textarea id="relBody" rows="2" placeholder="输入更新内容..." class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></textarea></div>
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">上传附件</label><input type="file" id="relFile" class="w-full text-xs"></div>
            `, async () => {
                const btn = document.getElementById('formConfirmBtn');
                const tag = document.getElementById('relTag').value.trim(); 
                const title = document.getElementById('relTitle').value.trim(); 
                const body = document.getElementById('relBody').value.trim();
                const fileInput = document.getElementById('relFile');
                if(!tag) return showToast("Tag 必填", "error"); 
                
                setBtnLoading(btn, true, "发布中...");
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/releases`, {
                        method: 'POST', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ tag_name: tag, name: title, body: body })
                    });
                    if(!res.ok) throw new Error("发布失败"); 
                    const relData = await res.json();
                    
                    if(fileInput.files.length > 0) {
                        setBtnLoading(btn, true, "上传附件...");
                        const file = fileInput.files[0];
                        const uploadUrl = relData.upload_url.split('{')[0] + `?name=${encodeURIComponent(file.name)}`;
                        await fetch(uploadUrl, {
                            method: 'POST', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': file.type || 'application/octet-stream' }, body: file
                        });
                    }
                    showToast("发布成功", "success"); 
                    closeForm();
                    openReleaseManager();
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }

        async function triggerEditRelease(rStr) {
            const r = JSON.parse(decodeURIComponent(rStr));
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            if (repoOwner !== USER_DATA.login) return showToast("非本人仓库无法修改", "error");

            showForm("修改版本信息", `
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">版本标题</label><input type="text" id="editRelTitle" value="${r.name || ''}" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></div>
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">发布说明</label><textarea id="editRelBody" rows="4" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none">${r.body || ''}</textarea></div>
            `, async () => {
                const btn = document.getElementById('formConfirmBtn');
                const title = document.getElementById('editRelTitle').value.trim();
                const body = document.getElementById('editRelBody').value.trim();
                setBtnLoading(btn, true, "更新中...");
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/releases/${r.id}`, {
                        method: 'PATCH',
                        headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ name: title, body: body })
                    });
                    if(!res.ok) throw new Error("修改失败");
                    showToast("修改成功", "success");
                    closeForm();
                    openReleaseManager();
                } catch(e) {
                    showToast(e.message, "error");
                } finally {
                    setBtnLoading(btn, false);
                }
            });
        }



                async function handleFileClick(sha, fullItemObj = null) {
            CURRENT_SCALE = 1;
            const wrapper = document.getElementById('editorTransformWrapper');
            if (wrapper) wrapper.style.zoom = 1;
            
            try {
                const item = fullItemObj || getFileFromGlobal(sha);
                if(!item) throw new Error("File not found in context");
                const path = item.path;
                const isImg = /\.(jpg|jpeg|png|gif|svg)$/i.test(path);
                CURRENT_FILE = item;
                document.getElementById('editorFilePath').innerText = path.split('/').pop();
                document.getElementById('editorBadge').classList.add('hidden');
                
                if(NAV_STACK[NAV_STACK.length-1] !== 'pageEditor') pushPage('pageEditor', "编辑");
                
                const mainContainer = document.getElementById('editorMainContainer');
                const preview = document.getElementById('filePreview'); 
                const localLoader = document.getElementById('editorLocalLoader');
                const btnPreview = document.getElementById('btnPreview');
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                const navSaveBtn = document.getElementById('navSaveBtn');
                const searchBar = document.getElementById('editorSearchBar');
                const bottomNav = document.getElementById('editorBottomNav');

                if(searchBar) searchBar.classList.add('hidden');
                if(mainContainer) mainContainer.classList.add('hidden');
                if(preview) preview.classList.add('hidden');
                if(btnPreview) btnPreview.classList.add('hidden');
                if(localLoader) {
                    localLoader.classList.remove('hidden');
                    localLoader.classList.add('flex');
                }

                if(isImg) {
                    if(localLoader) { localLoader.classList.add('hidden'); localLoader.classList.remove('flex'); }
                    preview.classList.remove('hidden');
                    preview.innerHTML = `<img src="${item.download_url}" class="w-full h-auto rounded-lg shadow-sm">`;
                    if(btnPreview) btnPreview.classList.add('hidden'); 
                    if(navSaveBtn) navSaveBtn.classList.add('hidden'); 
                    if(bottomNav) bottomNav.classList.add('hidden');
                } else {
                    const fetchUrl = `https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${item.sha}`;
                    
                    const res = await fetch(fetchUrl, {
                        headers: {
                            'Authorization': `token ${GITHUB_TOKEN}`,
                            'Accept': 'application/vnd.github.v3.raw'
                        }
                    });
                    if (!res.ok) throw new Error("获取文件内容失败");
                    const contentStr = await res.text();
                    
                    const richTa = document.getElementById('fileRichEditor');
                    
                    richTa.value = contentStr;
                    ORIGINAL_CONTENT = contentStr;
                    EDITOR_HISTORY = [contentStr];

                    const isMD = /\.md$/i.test(path);
                    const isOwn = (repoOwner === USER_DATA.login);

                    if(localLoader) { localLoader.classList.add('hidden'); localLoader.classList.remove('flex'); }

                    mainContainer.classList.remove('hidden');
                    preview.classList.add('hidden');

                    if (isMD) {
                        if(btnPreview) {
                            btnPreview.classList.remove('hidden'); 
                            btnPreview.innerText = "预览 MD";
                        }
                    } else {
                        if(btnPreview) btnPreview.classList.add('hidden'); 
                    }
                    
                    if(navSaveBtn) {
                        if (isOwn) navSaveBtn.classList.remove('hidden');
                        else navSaveBtn.classList.add('hidden');
                        navSaveBtn.disabled = true;
                        navSaveBtn.style.opacity = "0.5";
                    }
                    if(bottomNav) {
                        if (isOwn) bottomNav.classList.remove('hidden');
                        else bottomNav.classList.add('hidden');
                    }
                }
            } catch(e) { 
                showToast("读取失败", "error"); 
                const localLoader = document.getElementById('editorLocalLoader');
                if(localLoader) { localLoader.classList.add('hidden'); localLoader.classList.remove('flex'); }
            }
        }


        async function previewFileDirectly(sha, itemStr = null) {
            const itemObj = itemStr ? JSON.parse(decodeURIComponent(itemStr)) : null;
            await handleFileClick(sha, itemObj); togglePreview();
        }

        function togglePreview() {
            const mainContainer = document.getElementById('editorMainContainer');
            const rich = document.getElementById('fileRichEditor');
            const preview = document.getElementById('filePreview');
            const btn = document.getElementById('btnPreview');
            const searchBar = document.getElementById('editorSearchBar');
            const bottomNav = document.getElementById('editorBottomNav');
            const repoOwner = CURRENT_REPO?.owner?.login || CURRENT_REPO?.owner;
            const isOwn = (repoOwner === USER_DATA.login);

            if (!preview.classList.contains('hidden')) {
                preview.classList.add('hidden');
                btn.innerText = "预览 MD";
                
                if (isOwn) {
                    document.getElementById('navSaveBtn').classList.remove('hidden');
                    if (bottomNav) bottomNav.classList.remove('hidden');
                }
                mainContainer.classList.remove('hidden');
            } else {
                preview.innerHTML = `<div class="markdown-body">${marked.parse(rich.value)}</div>`;
                mainContainer.classList.add('hidden');
                preview.classList.remove('hidden');
                btn.innerText = "编辑 MD";
                document.getElementById('navSaveBtn').classList.add('hidden');
                
                if (searchBar) searchBar.classList.add('hidden');
                if (bottomNav) bottomNav.classList.add('hidden');
            }
        }



        // --- 直接文件 API 操作 (带强制同步) ---
        function triggerRenameItem(oldPath, oldSha, oldName, isDir) {
            closeContextMenu();
            showPrompt(`重命名${isDir ? '文件夹' : '文件'}`, oldName, "输入新名称...", async (newName) => {
                const btn = document.getElementById('promptConfirmBtn');
                if(!newName || newName === oldName) return closePrompt();
                const pathParts = oldPath.split('/'); pathParts.pop();
                const parentPath = pathParts.length ? pathParts.join('/') : '';
                const newPath = parentPath ? `${parentPath}/${newName}` : newName;
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                
                setBtnLoading(btn, true, "重命名中...");
                try {
                    if (isDir) {
                        const treeRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/trees/${oldSha}?recursive=1`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                        if (!treeRes.ok) throw new Error("获取目录结构失败");
                        const treeData = await treeRes.json();
                        const filesToMove = treeData.tree.filter(item => item.type === 'blob');
                        
                        for (let i = 0; i < filesToMove.length; i++) {
                            const fileItem = filesToMove[i];
                            showToast(`处理中 (${i + 1}/${filesToMove.length})...`, "loading");
                            
                            const blobRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${fileItem.sha}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                            const blobData = await blobRes.json();
                            
                            const targetFilePath = `${newPath}/${fileItem.path}`;
                            await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${targetFilePath}`, {
                                method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                body: JSON.stringify({ message: `Rename (Move) ${fileItem.path} to ${targetFilePath}`, content: blobData.content, branch: CURRENT_BRANCH })
                            });
                            
                            const oldFilePath = `${oldPath}/${fileItem.path}`;
                            await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${oldFilePath}`, {
                                method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                body: JSON.stringify({ message: `Delete old ${oldFilePath}`, sha: fileItem.sha, branch: CURRENT_BRANCH })
                            });
                        }
                    } else {
                        const blobRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${oldSha}`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                        const blobData = await blobRes.json();
                        
                        const putRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${newPath}`, {
                            method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                            body: JSON.stringify({ message: `Rename ${oldName} to ${newName}`, content: blobData.content, branch: CURRENT_BRANCH })
                        });
                        if(!putRes.ok) throw new Error("冲突或网络错误");

                        await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${oldPath}`, {
                            method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                            body: JSON.stringify({ message: `Delete ${oldName}`, sha: oldSha, branch: CURRENT_BRANCH })
                        });
                    }
                    showToast("重命名成功", "success"); 
                    closePrompt();
                    loadFiles(CURRENT_PATH);
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }

        async function deleteItemDirectly(path, sha, isDir) {
            closeContextMenu();
            const confirmHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-red-50 text-red-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="trash-2" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认删除${isDir ? '文件夹' : '文件'}？</p>
                    <p class="text-[13px] text-slate-500 mb-4 leading-relaxed">${isDir ? '文件夹及其内部所有内容' : '文件'} <b class="text-slate-700">${path.split('/').pop()}</b> 将从当前分支永久移除，此操作无法撤销。</p>
                </div>
            `;
            showForm("删除确认", confirmHtml, async () => {
                const btn = document.getElementById('formConfirmBtn');
                setBtnLoading(btn, true, "删除中...");
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                try {
                    if (isDir) {
                        const treeRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/trees/${sha}?recursive=1`, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` }});
                        if (!treeRes.ok) throw new Error("获取目录结构失败");
                        const treeData = await treeRes.json();
                        const filesToDelete = treeData.tree.filter(item => item.type === 'blob');
                        for (let i = 0; i < filesToDelete.length; i++) {
                            const fileItem = filesToDelete[i];
                            showToast(`正在删除 (${i + 1}/${filesToDelete.length})...`, "loading");
                            await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}/${fileItem.path}`, {
                                method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                body: JSON.stringify({ message: `Delete ${path}/${fileItem.path}`, sha: fileItem.sha, branch: CURRENT_BRANCH })
                            });
                        }
                    } else {
                        const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}`, {
                            method: 'DELETE', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                            body: JSON.stringify({ message: `Delete ${path}`, sha: sha, branch: CURRENT_BRANCH })
                        });
                        if (!res.ok) throw new Error("删除失败");
                    }
                    showToast(`${isDir ? '文件夹' : '文件'}已删除`, "success");
                    closeForm();
                    loadFiles(CURRENT_PATH);
                } catch (e) {
                    showToast(e.message, "error");
                } finally {
                    setBtnLoading(btn, false);
                }
            });
            setTimeout(createLocalIcons, 10);
        }

        function triggerNewFileWithContent() {
            showForm("新建文件", `
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">文件名 (含后缀)</label><input type="text" id="newFileName" placeholder="example.txt" class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></div>
                <div><label class="block text-[11px] font-bold text-slate-400 mb-1">初始内容 (可选)</label><textarea id="newFileContent" rows="4" placeholder="输入文件内容..." class="w-full bg-slate-50 p-3 rounded-xl border border-slate-200 text-sm outline-none"></textarea></div>
            `, async () => {
                const btn = document.getElementById('formConfirmBtn');
                const name = document.getElementById('newFileName').value.trim();
                const content = document.getElementById('newFileContent').value;
                if(!name) return showToast("文件名不能为空", "error");
                
                setBtnLoading(btn, true, "创建中...");
                const path = CURRENT_PATH ? `${CURRENT_PATH}/${name}` : name;
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                try {
                    const base64Content = window.btoa(unescape(encodeURIComponent(content)));
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}`, {
                        method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ message: `Create ${name}`, content: base64Content, branch: CURRENT_BRANCH })
                    });
                    if(!res.ok) throw new Error("创建失败，可能文件已存在");
                    showToast("文件已创建", "success");
                    closeForm();
                    loadFiles(CURRENT_PATH);
                } catch(e) {
                    showToast(e.message, "error");
                } finally {
                    setBtnLoading(btn, false);
                }
            });
        }

                function triggerNewFile() {
            showPrompt("新建文件", "", "输入包含后缀的文件名...", async (name) => {
                const btn = document.getElementById('promptConfirmBtn');
                if(!name) return closePrompt();
                const path = CURRENT_PATH ? `${CURRENT_PATH}/${name}` : name;
                setBtnLoading(btn, true, "创建中...");
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}`, {
                        method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ message: `Create ${name}`, content: btoa(""), branch: CURRENT_BRANCH })
                    });
                    if(!res.ok) throw new Error("创建失败，可能文件已存在");
                    showToast("创建成功", "success"); 
                    closePrompt();
                    loadFiles(CURRENT_PATH);
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }

        function triggerNewFolder() {
            showPrompt("新建文件夹 (将生成.gitkeep)", "", "输入文件夹名称...", async (name) => {
                const btn = document.getElementById('promptConfirmBtn');
                if(!name) return closePrompt();
                const path = CURRENT_PATH ? `${CURRENT_PATH}/${name}/.gitkeep` : `${name}/.gitkeep`;
                setBtnLoading(btn, true, "创建中...");
                const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                try {
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${path}`, {
                        method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ message: `Create Folder ${name}`, content: btoa(""), branch: CURRENT_BRANCH })
                    });
                    if(!res.ok) throw new Error("创建失败");
                    showToast("目录已建立", "success"); 
                    closePrompt();
                    loadFiles(CURRENT_PATH); 
                } catch(e) { 
                    showToast(e.message, "error"); 
                } finally { 
                    setBtnLoading(btn, false); 
                }
            });
        }


        async function saveCurrentFile() {
            const btn = document.getElementById('navSaveBtn');
            const content = document.getElementById('fileRichEditor').value;
            
            document.getElementById('fileRichEditor').blur();
            
            setBtnLoading(btn, true, "保存中"); 
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            try {

                try {
                    const shaRes = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${CURRENT_FILE.path}?ref=${CURRENT_BRANCH}&t=${Date.now()}`, {
                        headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Accept': 'application/vnd.github.v3+json', 'Cache-Control': 'no-cache' }
                    });
                    if (shaRes.ok) {
                        const shaData = await shaRes.json();
                        CURRENT_FILE.sha = shaData.sha;
                    }
                } catch(e) {} 

                const base64Content = window.btoa(unescape(encodeURIComponent(content)));
                const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${CURRENT_FILE.path}`, {
                    method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                    body: JSON.stringify({ message: `Update ${CURRENT_FILE.path}`, content: base64Content, sha: CURRENT_FILE.sha, branch: CURRENT_BRANCH })
                });
                
                if(!res.ok) throw new Error("保存失败，请检查网络");
                
                const data = await res.json();
                CURRENT_FILE.sha = data.content.sha;
                ORIGINAL_CONTENT = content;
                document.getElementById('editorBadge').classList.add('hidden');
                
                btn.disabled = false;
                btn.style.opacity = "1";
                btn.style.minWidth = '';
                btn.innerHTML = "已保存";
                btn.classList.replace('bg-blue-600', 'bg-emerald-500');

                setTimeout(() => { 
                    btn.classList.replace('bg-emerald-500', 'bg-blue-600');
                    if (document.getElementById('fileRichEditor').value === ORIGINAL_CONTENT) {
                        btn.innerHTML = "保存"; 
                        btn.disabled = true;
                        btn.style.opacity = "0.5";
                    } else {
                        btn.innerHTML = "保存"; 
                    }
                }, 2000);
            } catch(e) {
                showToast(e.message, "error");
                setBtnLoading(btn, false);
            }
        }



        // API不支持重命名和删除目录
        function renameFolder(path) { showToast("API不支持重命名目录，请转移文件", "info"); closeContextMenu();}
        function deleteFolder(path) { deleteFileDirectly(path, ""); showToast("若包含文件将删除失败, 请先进入清空内部所有文件", "info"); closeContextMenu();}

                        async function unzipFileLocally(path, sha) {
            closeContextMenu();
            const warningHtml = `
                <div class="text-center pt-2">
                    <div class="w-14 h-14 bg-blue-50 text-blue-500 rounded-full flex items-center justify-center mx-auto mb-4">
                        <i data-lucide="file-archive" class="w-7 h-7"></i>
                    </div>
                    <p class="text-[15px] font-bold text-slate-800 mb-2">确认解压文件？</p>
                    <p class="text-[13px] text-slate-500 mb-4 leading-relaxed">ZIP 内容将被提取并上传至当前目录。并发解压过程中请保持屏幕常亮。</p>
                </div>
            `;
            showForm("解压确认", warningHtml, async () => {
                showToast("拉取 ZIP...", "loading");
                                try {
                    const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
                  
                    const apiUrl = `https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/git/blobs/${sha}`;
                    const res = await fetch(apiUrl, { headers: { 'Authorization': `token ${GITHUB_TOKEN}` } });
                    if (!res.ok) throw new Error("获取 ZIP 失败");
                    const blobData = await res.json();
                    const zipDataStr = atob(blobData.content);
                    const arrayBuffer = new Uint8Array(zipDataStr.length);
                    for (let i = 0; i < zipDataStr.length; i++) arrayBuffer[i] = zipDataStr.charCodeAt(i);
                    showToast("解析中...", "loading");
                    const zip = await JSZip.loadAsync(arrayBuffer);
                    const filesList = Object.keys(zip.files).filter(k => !zip.files[k].dir);



                    
                    let successCount = 0;
                    let processedCount = 0;
                    const totalFiles = filesList.length;
                    
                    const uploadPool = async (iterator) => {
                        for (const [index, filename] of iterator) {
                            processedCount++;
                            showToast(`并发解压上传 (${processedCount}/${totalFiles})`, "loading");
                            try {
                                const zipEntry = zip.files[filename];
                                const contentBase64 = await zipEntry.async("base64");
                                const targetPath = CURRENT_PATH ? `${CURRENT_PATH}/${filename}` : filename;
                                const uploadApiUrl = `https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${targetPath}`;
                                const uploadRes = await fetch(uploadApiUrl, {
                                    method: 'PUT', headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                                    body: JSON.stringify({ message: `Extract: ${filename}`, content: contentBase64, branch: CURRENT_BRANCH })
                                });
                                if (uploadRes.ok) successCount++;
                            } catch (err) {}
                        }
                    };
                    const workers = Array(Math.min(4, totalFiles)).fill(filesList.entries()).map(uploadPool);
                    await Promise.all(workers);
                    closeForm();
                    showToast(`解压完成，成功: ${successCount}`, "success");
                    loadFiles(CURRENT_PATH);
                } catch (err) {
                    showToast(err.message, "error");
                }
            });
            setTimeout(createLocalIcons, 10);
        }





        async function handleCreateRepo(name, description = "") {
            if (!name) return;
            const btn = document.getElementById('formConfirmBtn');
            setBtnLoading(btn, true, "创建中...");
            try {
                const res = await fetch('https://api.github.com/user/repos', {
                    method: 'POST',
                    headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                    body: JSON.stringify({ name, description, auto_init: true, private: false })
                });
                if (!res.ok) throw new Error("创建失败");
                const newRepo = await res.json();
                REPOS.unshift(newRepo);
                document.getElementById('repoList').innerHTML = renderRepoCards(REPOS, false);
                createLocalIcons();
                showToast("仓库创建成功", "success");
                closeForm();
            } catch (e) {
                showToast(e.message, "error");
            } finally {
                setBtnLoading(btn, false);
            }
        }





        let PENDING_FILES = [];

        function handleAddFilesToPending(event, isFolder) {
            const files = event.target.files;
            if (!files.length) return;

            for (let i = 0; i < files.length; i++) {
                const f = files[i];
                let relPath = f.name;
                if (isFolder && f.webkitRelativePath) {
                    const parts = f.webkitRelativePath.split('/');
                    if (parts.length > 1) {
                        parts.shift();
                        relPath = parts.join('/');
                    }
                }
                
                const pathParts = relPath.split('/');
                const fileName = pathParts.pop();
                const dirPath = pathParts.length > 0 ? pathParts.join('/') + '/' : '';

                PENDING_FILES.push({
                    file: f,
                    dirPath: dirPath,
                    fileName: fileName,
                    targetPath: relPath,
                    id: Date.now() + Math.random()
                });
            }
            
            event.target.value = '';
            openUploadPanel();
        }


        function openUploadPanel() {
            pushModalState();
            document.getElementById('uploadPanelModal').classList.remove('hidden');
            renderPendingList();
        }

                function closeUploadPanel(fromPopState = false) {
            const modal = document.getElementById('uploadPanelModal');
            if (modal.classList.contains('hidden')) return;
            modal.classList.add('hidden');
            PENDING_FILES = [];
            popModalState(fromPopState);
        }



        function renderPendingList() {
            const list = document.getElementById('pendingUploadList');
            const btn = document.getElementById('startUploadBtn');
            btn.querySelector('span').innerText = `确认上传 (${PENDING_FILES.length})`;
            
            if (PENDING_FILES.length === 0) {
                list.innerHTML = `<div class="flex flex-col items-center justify-center py-20 text-slate-300"><i data-lucide="box" class="w-12 h-12 mb-2 opacity-20"></i><p>清单空空如也</p></div>`;
                createLocalIcons();
                return;
            }

            list.innerHTML = PENDING_FILES.map((item, idx) => `
                <div class="bg-white p-4 rounded-2xl mb-3 shadow-sm border border-slate-100 flex flex-col gap-3">
                    <div class="flex items-center justify-between">
                        <span class="text-[10px] font-bold text-slate-400 font-mono truncate mr-4">本地文件: ${item.file.name}</span>
                        <button onclick="removeFromPending(${idx})" class="text-red-400 p-1"><i data-lucide="x" class="w-4 h-4"></i></button>
                    </div>
                    <div class="relative">
                        <input type="text" value="${item.targetPath}" oninput="updatePendingPath(${idx}, this.value)" 
                            class="w-full bg-slate-50 border border-slate-200 rounded-lg py-2 px-3 text-xs outline-none focus:border-blue-500 font-mono" placeholder="可修改上传路径及文件名...">
                    </div>
                </div>
            `).join('');
            createLocalIcons();
        }

        function updatePendingPath(idx, val) { 
            PENDING_FILES[idx].targetPath = val;
        }
        function removeFromPending(idx) { PENDING_FILES.splice(idx, 1); renderPendingList(); }

                async function executeFinalUpload() {
            if (!PENDING_FILES.length) return;
            const repoOwner = CURRENT_REPO.owner.login || CURRENT_REPO.owner;
            const total = PENDING_FILES.length;
            let success = 0;
            
            const btn = document.getElementById('startUploadBtn');
            setBtnLoading(btn, true, `准备中...`);

            for (let i = 0; i < PENDING_FILES.length; i++) {
                const item = PENDING_FILES[i];
                showToast(`处理中 (${i + 1}/${total})\n${item.targetPath}`, "loading");
                try {
                    const contentBase64 = await new Promise((resolve) => {
                        const r = new FileReader();
                        r.onload = () => resolve(r.result.split(',')[1]);
                        r.readAsDataURL(item.file);
                    });
                    
                    const finalPath = CURRENT_PATH ? `${CURRENT_PATH}/${item.targetPath}` : item.targetPath;
                    
                    const res = await fetch(`https://api.github.com/repos/${repoOwner}/${CURRENT_REPO.name}/contents/${finalPath}`, {
                        method: 'PUT',
                        headers: { 'Authorization': `token ${GITHUB_TOKEN}`, 'Content-Type': 'application/json' },
                        body: JSON.stringify({ message: `Upload via Gitk: ${item.targetPath}`, content: contentBase64, branch: CURRENT_BRANCH })
                    });
                    
                    if (res.ok) success++;
                } catch (e) {}
            }

            setBtnLoading(btn, false);
            showToast(`同步完成：成功 ${success} / 总计 ${total}`, "success");
            PENDING_FILES = [];
            loadFiles(CURRENT_PATH);
        }


        function markFileEdited() {
            const editor = document.getElementById('fileRichEditor');
            const currentContent = editor.value;
            const navSaveBtn = document.getElementById('navSaveBtn');
            const isChanged = currentContent !== ORIGINAL_CONTENT;
            
            if (EDITOR_HISTORY.length === 0 || EDITOR_HISTORY[EDITOR_HISTORY.length - 1] !== currentContent) {
                if (EDITOR_HISTORY.length > 50) EDITOR_HISTORY.shift();
                EDITOR_HISTORY.push(currentContent);
            }

            if (navSaveBtn) {
                navSaveBtn.disabled = !isChanged;
                navSaveBtn.style.opacity = isChanged ? "1" : "0.5";
            }
            document.getElementById('editorBadge').classList.toggle('hidden', !isChanged);
        }

        function undoEditorAction() {
            if (EDITOR_HISTORY.length <= 1) return showToast("已回到最初状态");
            const rich = document.getElementById('fileRichEditor');
            const currentContent = rich.value;
            EDITOR_HISTORY.pop();
            const lastContent = EDITOR_HISTORY[EDITOR_HISTORY.length - 1];
            
            let diffIndex = 0;
            while(diffIndex < currentContent.length && diffIndex < lastContent.length && currentContent[diffIndex] === lastContent[diffIndex]) {
                diffIndex++;
            }
            
            rich.value = lastContent;
            syncRichToText();
            
            rich.focus();
            rich.setSelectionRange(diffIndex, diffIndex);
            
            const container = document.getElementById('editorMainContainer');
            const lines = rich.value.substring(0, diffIndex).split('\n').length;
            container.scrollTop = (lines * 21) + 16 - (container.clientHeight / 2);
            
            showToast("已撤销修改", "success");
        }

        let EDITOR_WORD_WRAP = localStorage.getItem('gh_word_wrap') === 'true';

        function applyWordWrap() {
            const editor = document.getElementById('fileRichEditor');
            const btn = document.getElementById('btnWordWrap');
            if (!editor || !btn) return;
            
            if (EDITOR_WORD_WRAP) {
                editor.setAttribute('wrap', 'soft');
                editor.style.whiteSpace = 'pre-wrap';
                editor.style.wordBreak = 'break-all';
                btn.classList.remove('text-slate-400');
                btn.classList.add('text-blue-600', 'bg-blue-50');
            } else {
                editor.setAttribute('wrap', 'off');
                editor.style.whiteSpace = 'pre';
                editor.style.wordBreak = 'normal';
                btn.classList.remove('text-blue-600', 'bg-blue-50');
                btn.classList.add('text-slate-400');
            }
        }

        function toggleWordWrap() {
            EDITOR_WORD_WRAP = !EDITOR_WORD_WRAP;
            localStorage.setItem('gh_word_wrap', EDITOR_WORD_WRAP);
            applyWordWrap();
            showToast(EDITOR_WORD_WRAP ? "已开启自动换行" : "已关闭自动换行", "info");
        }

        function editorSelectAll() {
            const rich = document.getElementById('fileRichEditor');
            rich.focus();
            if (rich.selectionStart === 0 && rich.selectionEnd === rich.value.length && rich.value.length > 0) {
                rich.setSelectionRange(0, 0);
            } else {
                rich.setSelectionRange(0, rich.value.length);
            }
        }

        let syncHighlightTimeout = null;

        function syncRichToText() {
            markFileEdited();
            clearTimeout(syncHighlightTimeout);
            syncHighlightTimeout = setTimeout(() => {
                updateSearchMatches();
            }, 300);
        }

        let SEARCH_MATCHES = [];
        let CURRENT_MATCH_INDEX = -1;

        function updateSearchMatches(autoFind = false) {
            const editor = document.getElementById('fileRichEditor');
            const term = document.getElementById('editorSearchInput').value;
            const counter = document.getElementById('searchMatchCount');
            SEARCH_MATCHES = [];
            
            if (!term) {
                if(counter) counter.innerText = '0/0';
                CURRENT_MATCH_INDEX = -1;
                return;
            }
            
            const content = editor.value;
            let index = content.indexOf(term);
            while (index !== -1) {
                SEARCH_MATCHES.push(index);
                index = content.indexOf(term, index + 1);
            }
            
            if (SEARCH_MATCHES.length === 0) {
                if(counter) counter.innerText = '0/0';
                CURRENT_MATCH_INDEX = -1;
            } else if (autoFind) {
                CURRENT_MATCH_INDEX = -1;
                editorFind(true, true);
            } else {
                if(counter) counter.innerText = `${CURRENT_MATCH_INDEX + 1}/${SEARCH_MATCHES.length}`;
            }
        }

        function editorFind(forward = true, keepSearchFocus = false) {
            const editor = document.getElementById('fileRichEditor');
            const searchInput = document.getElementById('editorSearchInput');
            const term = searchInput.value;
            
            if (!term || SEARCH_MATCHES.length === 0) {
                if (!keepSearchFocus) showToast("未找到匹配内容");
                return;
            }
            
            if (forward) {
                CURRENT_MATCH_INDEX++;
                if (CURRENT_MATCH_INDEX >= SEARCH_MATCHES.length) CURRENT_MATCH_INDEX = 0;
            } else {
                CURRENT_MATCH_INDEX--;
                if (CURRENT_MATCH_INDEX < 0) CURRENT_MATCH_INDEX = SEARCH_MATCHES.length - 1;
            }
            
            const index = SEARCH_MATCHES[CURRENT_MATCH_INDEX];
            
            if (!keepSearchFocus) {
                editor.focus();
            }
            
            editor.setSelectionRange(index, index + term.length);
            
            if (keepSearchFocus) {
                searchInput.focus();
            }
            
            const counter = document.getElementById('searchMatchCount');
            if(counter) counter.innerText = `${CURRENT_MATCH_INDEX + 1}/${SEARCH_MATCHES.length}`;
            
            const lines = editor.value.substring(0, index).split('\n').length;
            editor.scrollTop = (lines * 23) - (editor.clientHeight / 2);
        }

        function editorReplace(all = false) {
            const editor = document.getElementById('fileRichEditor');
            const term = document.getElementById('editorSearchInput').value;
            const replacement = document.getElementById('editorReplaceInput').value;
            if (!term) return;

            if (all) {
                const content = editor.value;
                const count = content.split(term).length - 1;
                if (count === 0) return showToast("无匹配内容可替换");
                editor.value = content.split(term).join(replacement);
                showToast(`已替换 ${count} 处`, "success");
                syncRichToText();
                updateSearchMatches(false);
            } else {
                if (CURRENT_MATCH_INDEX >= 0 && CURRENT_MATCH_INDEX < SEARCH_MATCHES.length) {
                    const start = SEARCH_MATCHES[CURRENT_MATCH_INDEX];
                    const content = editor.value;
                    if (content.substring(start, start + term.length) === term) {
                        editor.value = content.substring(0, start) + replacement + content.substring(start + term.length);
                        syncRichToText();
                        
                        updateSearchMatches(false);
                        
                        if (SEARCH_MATCHES.length > 0) {
                            if (CURRENT_MATCH_INDEX >= SEARCH_MATCHES.length) CURRENT_MATCH_INDEX = 0;
                            CURRENT_MATCH_INDEX--; 
                            editorFind(true, true);
                        } else {
                            const counter = document.getElementById('searchMatchCount');
                            if(counter) counter.innerText = '0/0';
                        }
                    } else {
                        editorFind(true, true);
                    }
                } else {
                    editorFind(true, true);
                }
            }
        }

        function toggleEditorSearch() {
            const bar = document.getElementById('editorSearchBar');
            bar.classList.toggle('hidden');
            if (!bar.classList.contains('hidden')) updateSearchMatches();
        }

        // --- UI Utils ---
        function copyLink(url, name="链接") {
            const el = document.createElement('textarea'); el.value = url; document.body.appendChild(el);
            el.select(); document.execCommand('copy'); document.body.removeChild(el); showToast(`${name}已复制`, "success"); closeContextMenu();
        }

        function showToast(msg, type = "info") {
            const el = document.getElementById('toast');
            const configs = {
                success: { icon: 'check-circle', color: 'text-emerald-500', bg: 'bg-white/95' },
                error: { icon: 'alert-circle', color: 'text-red-500', bg: 'bg-white/95' },
                warning: { icon: 'alert-triangle', color: 'text-amber-500', bg: 'bg-white/95' },
                info: { icon: 'info', color: 'text-blue-500', bg: 'bg-white/95' },
                loading: { icon: 'refresh-cw', color: 'text-blue-500', bg: 'bg-white/95', animate: 'animate-spin' }
            };
            const config = configs[type] || configs.info;
            el.innerHTML = `<i data-lucide="${config.icon}" class="w-4 h-4 ${config.color} ${config.animate || ''}"></i><span class="text-slate-600">${msg}</span>`;
            el.className = `fixed left-1/2 -translate-x-1/2 px-4 py-2 rounded-xl shadow-md border border-slate-100/50 backdrop-blur-md z-[500] flex items-center gap-2 text-[13px] font-bold whitespace-nowrap transition-all duration-500 opacity-0 pointer-events-none transform -translate-y-2 ${config.bg}`;
el.style.top = `calc(6rem + var(--safe-top))`;
            createLocalIcons();
            void el.offsetWidth;
            el.classList.remove('opacity-0', '-translate-y-4');
            if (window.toastTimer) clearTimeout(window.toastTimer);
            if (type !== 'loading') {
                window.toastTimer = setTimeout(() => {
                    el.classList.add('opacity-0', '-translate-y-4');
                }, 3000);
            }
        }

        function showLoader(text="...") { document.getElementById('loaderText').innerText = text; document.getElementById('loader').classList.remove('hidden'); document.getElementById('loader').classList.add('flex'); }
        function hideLoader() { document.getElementById('loader').classList.add('hidden'); document.getElementById('loader').classList.remove('flex'); }

        let promptCallback = null; let formCallback = null;
        function showPrompt(title, defaultVal, placeholderStr, cb) {
            pushModalState();
            document.getElementById('promptTitle').innerText = title; 
            const inputEl = document.getElementById('promptInput');
            inputEl.value = defaultVal; 
            inputEl.placeholder = placeholderStr || "";
            promptCallback = cb;
            const modal = document.getElementById('promptModal'); const box = document.getElementById('promptBox');
            modal.classList.remove('hidden'); setTimeout(() => box.classList.remove('scale-95'), 10);
            document.getElementById('promptConfirmBtn').onclick = () => { if(promptCallback) promptCallback(document.getElementById('promptInput').value.trim()); };
        }


                function closePrompt(fromPopState = false) {
            const modal = document.getElementById('promptModal');
            if (modal.classList.contains('hidden')) return;
            document.getElementById('promptBox').classList.add('scale-95');
            setTimeout(() => modal.classList.add('hidden'), 200);
            promptCallback = null;
            popModalState(fromPopState);
        }

        function showForm(title, htmlContent, cb) {
            pushModalState();
            document.getElementById('formTitle').innerText = title; document.getElementById('formContent').innerHTML = htmlContent; formCallback = cb;
            const modal = document.getElementById('formModal'); const box = document.getElementById('formBox');
            modal.classList.remove('hidden'); setTimeout(() => box.classList.remove('scale-95'), 10);
                        document.getElementById('formConfirmBtn').onclick = () => { if(formCallback) formCallback(); };

        }

        function closeForm(fromPopState = false) {
            const modal = document.getElementById('formModal');
            if (modal.classList.contains('hidden')) return;
            document.getElementById('formBox').classList.add('scale-95');
            setTimeout(() => modal.classList.add('hidden'), 200);
            formCallback = null;
            popModalState(fromPopState);
        }


                function syncSettingsUI() {
            const toggle = document.getElementById('proxyToggle');
            const input = document.getElementById('proxyUrl');
            if(toggle) toggle.checked = PROXY_ENABLED;
            if(input) input.value = PROXY_URL;
        }

        function toggleDarkTheme() {
            const isDark = document.documentElement.classList.toggle('dark-theme');
            localStorage.setItem('gh_dark_mode', isDark ? '1' : '0');
            const color = isDark ? '#141516' : '#f8fafc';
            const meta = document.getElementById('themeMeta');
            if (meta) meta.content = color;
            if (window.AndroidBridge) {
                window.AndroidBridge.postMessage(JSON.stringify({color: color}));
            }
        }

        const fileEditorPasteTarget = document.getElementById('fileRichEditor');


if (fileEditorPasteTarget) {
    fileEditorPasteTarget.addEventListener('paste', function(e) {
        e.preventDefault();
        const clipboardText = (e.clipboardData || window.clipboardData).getData('text/plain');
        const selectionStartPos = this.selectionStart;
        const selectionEndPos = this.selectionEnd;
        const currentVal = this.value;
        
        this.value = currentVal.substring(0, selectionStartPos) + clipboardText + currentVal.substring(selectionEndPos);
        this.selectionStart = this.selectionEnd = selectionStartPos + clipboardText.length;
        
        this.dispatchEvent(new Event('input', { bubbles: true }));
        
        const textUpToCursor = this.value.substring(0, this.selectionStart);
        const lineCount = textUpToCursor.split('\n').length;
        this.scrollTop = (lineCount * 21) + 16 - (this.clientHeight / 2);
    });
}









        function syncThemeToApp() {
            const isDark = document.documentElement.classList.contains('dark-theme');
            const color = isDark ? '#141516' : '#f8fafc';
            if (window.AndroidBridge) {
                window.AndroidBridge.postMessage(JSON.stringify({color: color}));
            }
        }

        syncThemeToApp();
        setTimeout(syncThemeToApp, 150);
        setTimeout(syncThemeToApp, 500);

        createLocalIcons();
        syncSettingsUI();
        initEditorZoom();
        initPullToRefresh();
        applyWordWrap();
        checkSavedAccounts();
        
        const themeToggle = document.getElementById('themeToggle');
        if (themeToggle) {
            themeToggle.checked = document.documentElement.classList.contains('dark-theme');
        }
    </script>
</body>
</html>

