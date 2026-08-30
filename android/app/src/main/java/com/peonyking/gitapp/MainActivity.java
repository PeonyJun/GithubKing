package com.peonyking.gitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

import androidx.documentfile.provider.DocumentFile;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends Activity {

    private static final int REQ_FILE_CHOOSER = 0x1001;
    private static final int REQ_FOLDER = 0x1002;
    private static final long MAX_FOLDER_FILE_BYTES = 20L * 1024 * 1024;

    private static final int COLOR_DARK = 0xFF04091A;
    private static final int COLOR_LIGHT = 0xFFF0F2F5;

    private static final int REQ_UNKNOWN_SOURCE = 0x2001;

    // GitHub OAuth 授权登录配置
    private static final String OAUTH_CLIENT_ID = "Ov23li6NLp7oqOQW5oBG";
    private static final String OAUTH_CLIENT_SECRET = "3743c626a2c25ab73a9ed909dda6b5a00abf7205";
    private static final String OAUTH_REDIRECT_URI = "gk://login";
    private static final String OAUTH_AUTH_ENDPOINT = "https://github.com/login/oauth/authorize";
    private static final String OAUTH_TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token";
    private static final String OAUTH_SCOPES =
            "repo,repo:status,repo_deployment,public_repo,repo:invite,security_events," +
            "admin:repo_hook,write:repo_hook,read:repo_hook,admin:org,write:org,read:org," +
            "admin:public_key,write:public_key,read:public_key,admin:org_hook,gist,notifications," +
            "user,read:user,user:email,user:follow,project,read:project,delete_repo," +
            "write:packages,read:packages,delete:packages,admin:gpg_key,write:gpg_key," +
            "read:gpg_key,workflow";

    private String pendingAuthToken = null;
    private boolean oauthFlowActive = false;
    private boolean pageLoaded = false;
    private boolean isLight = true;

    private WebView webView;
    private ValueCallback<Uri[]> filePathCallback;
    private final List<DocumentFile> folderFiles = new ArrayList<>();
    private final List<String> folderRelPaths = new ArrayList<>();
    private int folderToken = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String savedTheme = getSharedPreferences("gkPrefs", MODE_PRIVATE).getString("app_theme", "light");
        setTheme("dark".equals(savedTheme) ? R.style.AppTheme : R.style.AppTheme_Light);
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        s.setCacheMode(WebSettings.LOAD_DEFAULT);

        webView.addJavascriptInterface(this, "AndroidBridge");

        final WebViewAssetLoader assetLoader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this))
                .build();

        webView.setWebViewClient(new WebViewClientCompat() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return assetLoader.shouldInterceptRequest(request.getUrl());
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pageLoaded = true;
                if (pendingAuthToken != null) {
                    final String token = pendingAuthToken;
                    pendingAuthToken = null;
                    if (token != null) {
                        String escaped = token.replace("\\", "\\\\").replace("'", "\\'");
                        evalJs("window.onReceiveAuthToken && window.onReceiveAuthToken('" + escaped + "')");
                    } else {
                        evalJs("window.onReceiveAuthToken && window.onReceiveAuthToken(null)");
                    }
                }
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView wv, ValueCallback<Uri[]> callback, FileChooserParams params) {
                if (filePathCallback != null) {
                    filePathCallback.onReceiveValue(null);
                }
                filePathCallback = callback;
                showUploadPicker(params);
                return true;
            }

            @Override
            public void onPermissionRequest(PermissionRequest request) {
                runOnUiThread(() -> request.grant(request.getResources()));
            }
        });

        webView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) ->
                startDownload(url, userAgent, contentDisposition, mimetype));

        applyThemeUi(savedTheme);

        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT,
                    this::handleWebBack);
        }

        webView.loadUrl("https://appassets.androidplatform.net/assets/index.html");

        handleLaunchIntent(getIntent());

        checkForUpdate();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleLaunchIntent(intent);
    }

    private void handleLaunchIntent(Intent intent) {
        if (intent == null) return;
        Uri data = intent.getData();
        if (data != null && "gk".equalsIgnoreCase(data.getScheme())) {
            handleOAuthDeepLink(data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) webView.onResume();
    }

    @Override
    protected void onPause() {
        if (webView != null) webView.onPause();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        handleWebBack();
    }

    private void handleWebBack() {
        if (webView == null) {
            handleExitDoublePress();
            return;
        }
        webView.evaluateJavascript(
                "(function(){ try { return handleNativeBack(); } catch(e){} return 'exit'; })()",
                value -> {
                    if (value != null && value.contains("handled")) {
                        return;
                    }
                    handleExitDoublePress();
                });
    }

    private long lastBackPressMs = 0;

    private void handleExitDoublePress() {
        long now = System.currentTimeMillis();
        if (now - lastBackPressMs < 2000) {
            finish();
        } else {
            lastBackPressMs = now;
            toast("再按一次返回键退出应用");
        }
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.loadUrl("about:blank");
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FILE_CHOOSER) {
            Uri[] uris = null;
            if (resultCode == RESULT_OK && data != null) {
                uris = collectUris(data);
            }
            if (filePathCallback != null) {
                filePathCallback.onReceiveValue(uris);
                filePathCallback = null;
            }
        } else if (requestCode == REQ_FOLDER) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) {
                handleFolderPicked(data.getData());
            }
            cancelFilePicker();
        }
    }

    // ============ 主题 ============

    @JavascriptInterface
    public void setTheme(final String theme) {
        getSharedPreferences("gkPrefs", MODE_PRIVATE)
                .edit().putString("app_theme", theme).apply();
        runOnUiThread(() -> {
            applyThemeUi(theme);
            if (currentDownloadUi != null) currentDownloadUi.refreshTheme();
        });
    }

    // ============ GitHub OAuth 授权登录 ============

    @JavascriptInterface
    public void startGithubAuth() {
        runOnUiThread(() -> {
            try {
                oauthFlowActive = true;
                String url = OAUTH_AUTH_ENDPOINT
                        + "?client_id=" + OAUTH_CLIENT_ID
                        + "&redirect_uri=" + Uri.encode(OAUTH_REDIRECT_URI)
                        + "&scope=" + Uri.encode(OAUTH_SCOPES);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            } catch (Exception e) {
                toast("无法打开授权页面: " + e.getMessage());
            }
        });
    }

    private void handleOAuthDeepLink(Uri data) {
        if (data == null) return;
        String code = data.getQueryParameter("code");
        String error = data.getQueryParameter("error");
        if (error != null) {
            injectAuthResult(null);
            return;
        }
        if (code == null || code.isEmpty()) {
            return;
        }
        exchangeCodeForToken(code);
    }

    private void exchangeCodeForToken(final String code) {
        new Thread(() -> {
            String token = null;
            HttpURLConnection conn = null;
            try {
                URL url = new URL(OAUTH_TOKEN_ENDPOINT);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(15000);
                conn.setDoOutput(true);
                conn.setRequestProperty("Accept", "application/json");
                String body = "client_id=" + Uri.encode(OAUTH_CLIENT_ID)
                        + "&client_secret=" + Uri.encode(OAUTH_CLIENT_SECRET)
                        + "&code=" + Uri.encode(code)
                        + "&redirect_uri=" + Uri.encode(OAUTH_REDIRECT_URI);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(body.getBytes(StandardCharsets.UTF_8));
                }
                int status = conn.getResponseCode();
                InputStream is = status >= 200 && status < 300 ? conn.getInputStream() : conn.getErrorStream();
                String resp = is == null ? "" : readStream(is);
                if (status >= 200 && status < 300) {
                    try {
                        JSONObject obj = new JSONObject(resp);
                        if (obj.has("access_token")) {
                            token = obj.getString("access_token");
                        } else if (obj.has("error")) {
                            token = null;
                        }
                    } catch (JSONException e) {
                        token = null;
                    }
                }
            } catch (Exception e) {
                token = null;
            } finally {
                if (conn != null) conn.disconnect();
            }
            final String finalToken = token;
            runOnUiThread(() -> injectAuthResult(finalToken));
        }, "oauth-exchange").start();
    }

    private void injectAuthResult(String token) {
        oauthFlowActive = false;
        if (webView == null) return;
        if (pageLoaded) {
            if (token != null) {
                String escaped = token.replace("\\", "\\\\").replace("'", "\\'");
                evalJs("window.onReceiveAuthToken && window.onReceiveAuthToken('" + escaped + "')");
            } else {
                evalJs("window.onReceiveAuthToken && window.onReceiveAuthToken(null)");
            }
        } else {
            pendingAuthToken = token;
        }
    }

    private void applyThemeUi(String theme) {
        boolean light = theme != null && theme.equals("light");
        isLight = light;
        int barColor = light ? COLOR_LIGHT : COLOR_DARK;
        getWindow().setStatusBarColor(barColor);
        if (webView != null) {
            webView.setBackgroundColor(barColor);
        }
        getWindow().getDecorView().setBackgroundColor(barColor);
        if (Build.VERSION.SDK_INT >= 26) {
            getWindow().setNavigationBarColor(barColor);
            int flags = light
                    ? (View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR)
                    : 0;
            getWindow().getDecorView().setSystemUiVisibility(flags);
        }
    }

    // ============ 上传：文件选择 ============

    private void showUploadPicker(FileChooserParams params) {
        final boolean multi = params != null && params.getMode() == FileChooserParams.MODE_OPEN_MULTIPLE;
        new AlertDialog.Builder(this)
                .setTitle("上传")
                .setItems(new String[]{"选择文件", "选择文件夹"}, (dialog, which) -> {
                    if (which == 0) {
                        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        i.addCategory(Intent.CATEGORY_OPENABLE);
                        i.setType("*/*");
                        if (multi) i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                        try {
                            startActivityForResult(i, REQ_FILE_CHOOSER);
                        } catch (ActivityNotFoundException e) {
                            cancelFilePicker();
                            toast("系统文件选择器不可用");
                        }
                    } else {
                        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
                        try {
                            startActivityForResult(i, REQ_FOLDER);
                        } catch (ActivityNotFoundException e) {
                            cancelFilePicker();
                            toast("系统文件夹选择器不可用");
                        }
                    }
                })
                .setOnCancelListener(d -> cancelFilePicker())
                .show();
    }

    private void cancelFilePicker() {
        if (filePathCallback != null) {
            filePathCallback.onReceiveValue(null);
            filePathCallback = null;
        }
    }

    private Uri[] collectUris(Intent data) {
        if (data.getClipData() != null) {
            int n = data.getClipData().getItemCount();
            if (n > 0) {
                Uri[] uris = new Uri[n];
                for (int k = 0; k < n; k++) uris[k] = data.getClipData().getItemAt(k).getUri();
                return uris;
            }
        }
        if (data.getData() != null) {
            return new Uri[]{data.getData()};
        }
        return null;
    }

    // ============ 上传：文件夹 ============

    private void handleFolderPicked(Uri treeUri) {
        folderFiles.clear();
        folderRelPaths.clear();
        DocumentFile root = DocumentFile.fromTreeUri(this, treeUri);
        if (root == null || !root.isDirectory()) {
            toast("无法读取所选文件夹");
            return;
        }
        collectFolderFiles(root, "");
        if (folderFiles.isEmpty()) {
            toast("所选文件夹内没有可上传的文件");
            return;
        }
        final int token = ++folderToken;
        try {
            JSONArray meta = new JSONArray();
            for (int i = 0; i < folderFiles.size(); i++) {
                DocumentFile f = folderFiles.get(i);
                JSONObject o = new JSONObject();
                o.put("i", i);
                o.put("name", f.getName() != null ? f.getName() : "file_" + i);
                o.put("path", folderRelPaths.get(i));
                o.put("size", f.length());
                o.put("mime", f.getType() != null ? f.getType() : "application/octet-stream");
                meta.put(o);
            }
            final String metaJson = meta.toString();
            runOnUiThread(() -> evalJs("window.__nativeInjectFolderFiles(" + quote(metaJson) + "," + token + ")"));
        } catch (JSONException ignored) {
        }
    }

    private void collectFolderFiles(DocumentFile dir, String relPath) {
        DocumentFile[] children = dir.listFiles();
        if (children == null) return;
        for (DocumentFile c : children) {
            if (c == null) continue;
            if (c.isDirectory()) {
                String childRel = relPath.isEmpty() ? (c.getName() + "/") : (relPath + c.getName() + "/");
                collectFolderFiles(c, childRel);
            } else if (c.isFile()) {
                folderFiles.add(c);
                folderRelPaths.add(relPath + c.getName());
            }
        }
    }

    @JavascriptInterface
    public void readFileAsync(final int token, final int index) {
        runOnUiThread(() -> {
            if (token != folderToken || index < 0 || index >= folderFiles.size() || webView == null) {
                evalJs("window.__nativeFolderFileContent(" + token + "," + index + ",null,\"invalid\")");
                return;
            }
            final DocumentFile file = folderFiles.get(index);
            final long len = file.length();
            if (len > MAX_FOLDER_FILE_BYTES) {
                evalJs("window.__nativeFolderFileContent(" + token + "," + index + ",null,\"文件超过 20MB 已跳过\")");
                return;
            }
            new Thread(() -> {
                try {
                    final String b64 = readBase64(file.getUri(), len);
                    runOnUiThread(() -> evalJs("window.__nativeFolderFileContent(" + token + "," + index + ",\"" + b64 + "\",null)"));
                } catch (final Exception e) {
                    final String msg = e.getMessage() == null ? "读取失败" : e.getMessage();
                    runOnUiThread(() -> evalJs("window.__nativeFolderFileContent(" + token + "," + index + ",null," + quote(msg) + ")"));
                }
            }, "folder-read").start();
        });
    }

    private String readBase64(Uri uri, long knownLength) throws IOException {
        try (InputStream is = getContentResolver().openInputStream(uri)) {
            if (is == null) throw new IOException("无法打开文件");
            int initial = knownLength > 0 && knownLength <= (1 << 22)
                    ? (int) knownLength : (1 << 16);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(initial);
            byte[] buf = new byte[8192];
            int n;
            while ((n = is.read(buf)) > 0) bos.write(buf, 0, n);
            return Base64.encodeToString(bos.toByteArray(), Base64.NO_WRAP);
        }
    }

    private String readStream(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = is.read(buf)) > 0) bos.write(buf, 0, n);
        return bos.toString("UTF-8");
    }

    private void evalJs(String js) {
        if (webView != null) webView.evaluateJavascript(js, null);
    }

    // ============ 下载 ============

    private void startDownload(String url, String userAgent, String contentDisposition, String mimetype) {
        try {
            String fileName = resolveUniqueFileName(resolveFileName(contentDisposition, url, mimetype));
            DownloadManager.Request req = new DownloadManager.Request(Uri.parse(url));
            if (userAgent != null && !userAgent.isEmpty()) {
                req.addRequestHeader("User-Agent", userAgent);
            }
            if (mimetype != null) req.setMimeType(mimetype);
            req.setDescription(fileName);
            req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            req.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            if (dm == null) throw new IllegalStateException("下载服务不可用");
            dm.enqueue(req);
            toast("开始下载: " + fileName);
        } catch (Exception e) {
            toast("下载启动失败: " + e.getMessage());
        }
    }

    private String resolveUniqueFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) return fileName;
        String clean = fileName.replaceAll("[\\\\/]", "_");
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File target = new File(dir, clean);
        if (!target.exists()) return clean;

        String base = clean;
        String ext = "";
        int dot = clean.lastIndexOf('.');
        if (dot > 0) {
            base = clean.substring(0, dot);
            ext = clean.substring(dot);
        }
        for (int i = 1; i < 1000; i++) {
            String candidate = base + " (" + i + ")" + ext;
            if (!new File(dir, candidate).exists()) {
                return candidate;
            }
        }
        return base + " (999)" + ext;
    }

    private String resolveFileName(String contentDisposition, String url, String mimetype) {
        String name = parseFileNameFromDisposition(contentDisposition);
        if (name == null || name.isEmpty() || name.contains("/") || name.contains("..")) {
            name = Uri.parse(url).getLastPathSegment();
        }
        if (name == null || name.isEmpty()) {
            String ext = MimeTypeMap.getSingleton().getExtensionFromMimeType(mimetype);
            name = "download" + (ext != null ? "." + ext : "");
        }
        name = name.replaceAll("[^\\p{L}\\p{N}._\\-]", "_");
        if (name.length() > 120) name = name.substring(name.length() - 120);
        return name;
    }

    private String parseFileNameFromDisposition(String disposition) {
        if (disposition == null) return null;
        Matcher m = Pattern.compile("filename\\*?=(?:\"|'|)([^;\\s\"]+)").matcher(disposition);
        if (m.find()) {
            String name = m.group(1).trim();
            if (name.startsWith("UTF-8''")) name = name.substring(7);
            try {
                String decoded = URLDecoder.decode(name, "UTF-8");
                // 兼容双重编码（代理将 filename 二次 encode），确保解码到可读明文
                if (decoded.contains("%") && decoded.matches(".*%[0-9A-Fa-f]{2}.*")) {
                    decoded = URLDecoder.decode(decoded, "UTF-8");
                }
                return decoded;
            } catch (Exception e) {
                return name;
            }
        }
        return null;
    }

    // ============ 远程更新 ============

    private static final String UPDATE_REPO = "PeonyJun/GithubKing";
    private static final String UPDATE_RELEASES_URL = "https://api.github.com/repos/" + UPDATE_REPO + "/releases/latest";
    private final String[] APK_DOWNLOAD_PROXIES = {
            "https://gh-proxy.org/",
            "https://down.ksx.qzz.io/"
    };

    private void checkForUpdate() {
        new Thread(() -> {
            HttpURLConnection conn = null;
            String updateInfo = null;
            try {
                URL url = new URL(UPDATE_RELEASES_URL);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(15000);
                conn.setRequestProperty("Accept", "application/vnd.github+json");
                conn.setRequestProperty("User-Agent", "GithubKing");
                int status = conn.getResponseCode();
                if (status < 200 || status >= 300) {
                    return;
                }
                InputStream is = conn.getInputStream();
                if (is == null) return;
                JSONObject rel = new JSONObject(readStream(is));
                String tag = rel.optString("tag_name", "");
                String body = rel.optString("body", "");
                String downloadUrl = null;
                JSONArray assets = rel.optJSONArray("assets");
                if (assets != null) {
                    for (int i = 0; i < assets.length(); i++) {
                        JSONObject asset = assets.optJSONObject(i);
                        if (asset == null) continue;
                        String name = asset.optString("name", "");
                        if (name.endsWith(".apk")) {
                            downloadUrl = asset.optString("browser_download_url", "");
                            break;
                        }
                    }
                }
                if (tag.isEmpty() || downloadUrl == null || downloadUrl.isEmpty()) return;
                String currentVersion = BuildConfig.VERSION_NAME;
                if (compareVersions(tag, currentVersion) <= 0) {
                    return;
                }
                updateInfo = tag + "\u0001" + body + "\u0001" + downloadUrl;
            } catch (Exception ignored) {
                return;
            } finally {
                if (conn != null) conn.disconnect();
            }
            final String info = updateInfo;
            if (info != null) {
                runOnUiThread(() -> promptUpdate(info));
            }
        }, "update-check").start();
    }

    private void promptUpdate(String info) {
        if (webView == null) return;
        try {
            String[] parts = info.split("\u0001", 3);
            final String tag = parts.length > 0 ? parts[0] : "新版本";
            final String body = parts.length > 1 ? parts[1] : "";
            final String downloadUrl = parts.length > 2 ? parts[2] : "";

            String currentVersion = BuildConfig.VERSION_NAME;

            LinearLayout root = new LinearLayout(this);
            root.setOrientation(LinearLayout.VERTICAL);
            root.setPadding(dp(28), dp(24), dp(28), dp(18));

            TextView title = new TextView(this);
            title.setText("发现新版本");
            title.setTextColor(dlgTitle());
            title.setTextSize(19);
            title.setTypeface(Typeface.DEFAULT_BOLD);
            root.addView(title);

            TextView tagView = new TextView(this);
            tagView.setText(tag);
            tagView.setTextColor(dlgAccent());
            tagView.setTextSize(13);
            tagView.setPadding(0, dp(4), 0, dp(12));
            root.addView(tagView);

            TextView bodyView = new TextView(this);
            bodyView.setText(body == null || body.isEmpty() ? "已检测到新版本可用，是否立即更新？" : body);
            bodyView.setTextColor(dlgBody());
            bodyView.setTextSize(14);
            bodyView.setLineSpacing(dp(5), 1.0f);
            bodyView.setPadding(0, 0, 0, dp(12));
            root.addView(bodyView);

            TextView curView = new TextView(this);
            curView.setText("当前版本: v" + currentVersion);
            curView.setTextColor(dlgSub());
            curView.setTextSize(12);
            curView.setPadding(0, 0, 0, dp(16));
            root.addView(curView);

            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER);

            TextView cancelBtn = buildActionButton("暂不更新", false);
            row.addView(cancelBtn, new LinearLayout.LayoutParams(0, dp(46), 1f) {{ rightMargin = dp(6); }});
            TextView updateBtn = buildActionButton("立即更新", true);
            row.addView(updateBtn, new LinearLayout.LayoutParams(0, dp(46), 1f) {{ leftMargin = dp(6); }});

            root.addView(row);

            final AlertDialog dlg = new AlertDialog.Builder(this).setView(root).setCancelable(true).create();
            dlg.setCanceledOnTouchOutside(true);
            if (dlg.getWindow() != null) {
                dlg.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
            updateBtn.setOnClickListener(v -> { dlg.dismiss(); startApkDownload(downloadUrl); });
            cancelBtn.setOnClickListener(v -> dlg.dismiss());
            dlg.show();
            applyDialogStyle(dlg);
        } catch (Exception ignored) {
        }
    }

    private int dlgBg() {
        return isLight ? 0xFFFFFFFF : 0xFF1B2130;
    }
    private int dlgTitle() {
        return isLight ? 0xFF111827 : 0xFFFFFFFF;
    }
    private int dlgAccent() {
        return isLight ? 0xFF2563EB : 0xFF4C8BF5;
    }
    private int dlgBody() {
        return isLight ? 0xFF475569 : 0xFF8A93A5;
    }
    private int dlgSub() {
        return isLight ? 0xFF6B7280 : 0xFF8A93A5;
    }
    private int dlgPrimaryBtnBg() {
        return 0xFF10B981;
    }
    private int dlgPrimaryBtnText() {
        return 0xFFFFFFFF;
    }
    private int dlgSecondaryBtnBg() {
        return isLight ? 0xFFF3F4F6 : 0x26FFFFFF;
    }
    private int dlgSecondaryBtnText() {
        return isLight ? 0xFF374151 : 0xFFCFD6E3;
    }

    private TextView buildActionButton(String text, boolean primary) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(14);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setPadding(0, 0, 0, 0);
        tv.setOnTouchListener(null);
        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(dp(12));
        if (primary) {
            bg.setColor(dlgPrimaryBtnBg());
            tv.setTextColor(dlgPrimaryBtnText());
        } else {
            bg.setColor(dlgSecondaryBtnBg());
            tv.setTextColor(dlgSecondaryBtnText());
        }
        tv.setBackground(bg);
        return tv;
    }

    private void applyDialogStyle(AlertDialog dlg) {
        try {
            if (dlg.getWindow() == null) return;
            GradientDrawable bg = new GradientDrawable();
            bg.setColor(dlgBg());
            bg.setCornerRadius(dp(18));
            dlg.getWindow().setBackgroundDrawable(bg);
        } catch (Exception ignored) {
        }
    }

    private void startApkDownload(final String url) {
        new Thread(() -> {
            final Handler uiHandler = new Handler(Looper.getMainLooper());
            final DownloadUi downloadUi = new DownloadUi(uiHandler);
            uiHandler.post(downloadUi::show);
            boolean ok = false;
            File target = new File(getFilesDir(), "GithubKing_new.apk");
            for (int i = 0; i < APK_DOWNLOAD_PROXIES.length; i++) {
                String full = APK_DOWNLOAD_PROXIES[i] + url;
                final int attempt = i;
                final boolean last = (i == APK_DOWNLOAD_PROXIES.length - 1);
                try {
                    uiHandler.post(() -> downloadUi.setStatus("连接下载服务器 (" + (attempt + 1) + "/" + APK_DOWNLOAD_PROXIES.length + ")"));
                    ok = downloadApk(full, target, downloadUi, uiHandler, last);
                    if (ok) break;
                } catch (Exception ignored) {
                    uiHandler.post(() -> downloadUi.setStatus("下载中断，正在重试..."));
                }
            }
            final boolean success = ok;
            uiHandler.post(() -> {
                downloadUi.dismiss();
                if (success) {
                    installApk(target);
                } else {
                    toast("下载失败，请稍后重试");
                }
            });
        }, "update-download").start();
    }

    private final java.util.concurrent.atomic.AtomicBoolean updateDownloadCancelled = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.atomic.AtomicLong lastProgressPost = new java.util.concurrent.atomic.AtomicLong(0);
    private AlertDialog updateUiDialog;
    private DownloadUi currentDownloadUi = null;

    private class DownloadUi {
        private final Handler handler;
        ProgressBar bar;
        TextView title;
        TextView pct;
        TextView status;

        DownloadUi(Handler handler) {
            this.handler = handler;
        }

        void show() {
            currentDownloadUi = this;
            LinearLayout root = new LinearLayout(MainActivity.this);
            root.setOrientation(LinearLayout.VERTICAL);
            root.setPadding(dp(28), dp(26), dp(28), dp(18));

            title = new TextView(MainActivity.this);
            title.setText("更新下载中");
            title.setTextColor(dlgTitle());
            title.setTextSize(17);
            title.setTypeface(Typeface.DEFAULT_BOLD);
            root.addView(title);

            status = new TextView(MainActivity.this);
            status.setText("准备开始...");
            status.setTextColor(dlgSub());
            status.setTextSize(13);
            status.setPadding(0, dp(6), 0, dp(16));
            root.addView(status);

            bar = new ProgressBar(MainActivity.this, null, android.R.attr.progressBarStyleHorizontal);
            bar.setMax(100);
            bar.setProgress(0);
            bar.setProgressTintList(android.content.res.ColorStateList.valueOf(dlgAccent()));
            GradientDrawable progressDrawable = new GradientDrawable();
            progressDrawable.setColor(dlgAccent());
            progressDrawable.setCornerRadius(dp(6));
            GradientDrawable progressTrack = new GradientDrawable();
            progressTrack.setColor(isLight ? 0xFFE5E7EB : 0xFF2A3140);
            progressTrack.setCornerRadius(dp(6));
            bar.setProgressDrawable(new android.graphics.drawable.LayerDrawable(
                    new android.graphics.drawable.Drawable[]{progressTrack, progressDrawable}));
            root.addView(bar);

            pct = new TextView(MainActivity.this);
            pct.setText("0%");
            pct.setTextColor(dlgTitle());
            pct.setTextSize(15);
            pct.setGravity(Gravity.CENTER_HORIZONTAL);
            pct.setPadding(0, dp(10), 0, 0);
            root.addView(pct);

            updateUiDialog = new AlertDialog.Builder(MainActivity.this)
                    .setView(root)
                    .setCancelable(false)
                    .setNegativeButton("取消", (d, w) -> updateDownloadCancelled.set(true))
                    .create();
            if (updateUiDialog.getWindow() != null) {
                updateUiDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
            updateUiDialog.show();
            try {
                GradientDrawable bg = new GradientDrawable();
                bg.setColor(dlgBg());
                bg.setCornerRadius(dp(18));
                if (updateUiDialog.getWindow() != null) {
                    updateUiDialog.getWindow().setBackgroundDrawable(bg);
                }
            } catch (Exception ignored) {
            }
        }

        void setProgress(long done, long total) {
            if (bar == null) return;
            int pctVal = total > 0 ? (int) (Math.min(done, total) * 100 / total) : 0;
            bar.setProgress(pctVal);
            if (pct != null) pct.setText(pctVal + "%");
        }

        void setStatus(String s) {
            if (status != null) status.setText(s);
        }

        void refreshTheme() {
            if (updateUiDialog == null) return;
            int accent = dlgAccent();
            if (title != null) title.setTextColor(dlgTitle());
            if (status != null) status.setTextColor(dlgSub());
            if (pct != null) pct.setTextColor(dlgTitle());
            if (bar != null) {
                bar.setProgressTintList(android.content.res.ColorStateList.valueOf(accent));
                GradientDrawable pd = new GradientDrawable();
                pd.setColor(accent);
                pd.setCornerRadius(dp(6));
                GradientDrawable pt = new GradientDrawable();
                pt.setColor(isLight ? 0xFFE5E7EB : 0xFF2A3140);
                pt.setCornerRadius(dp(6));
                bar.setProgressDrawable(new android.graphics.drawable.LayerDrawable(
                        new android.graphics.drawable.Drawable[]{pt, pd}));
            }
            try {
                GradientDrawable bgd = new GradientDrawable();
                bgd.setColor(dlgBg());
                bgd.setCornerRadius(dp(18));
                if (updateUiDialog.getWindow() != null) {
                    updateUiDialog.getWindow().setBackgroundDrawable(bgd);
                }
            } catch (Exception ignored) {
            }
        }

        void dismiss() {
            try {
                if (updateUiDialog != null && updateUiDialog.isShowing()) updateUiDialog.dismiss();
            } catch (Exception ignored) {
            }
        }
    }

    private int dp(int v) {
        return Math.round(getResources().getDisplayMetrics().density * v);
    }

    private boolean downloadApk(String url, File target, final DownloadUi ui, final Handler uiHandler, final boolean lastAttempt) throws IOException {
        HttpURLConnection conn = null;
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(30000);
            conn.setRequestProperty("User-Agent", "GithubKing");
            conn.setInstanceFollowRedirects(true);
            int status = conn.getResponseCode();
            if (status == 404) {
                if (!lastAttempt) uiHandler.post(() -> ui.setStatus("服务器响应失败，切换渠道..."));
                return false;
            }
            if (status < 200 || status >= 300) {
                if (!lastAttempt) uiHandler.post(() -> ui.setStatus("服务器响应异常，切换渠道..."));
                return false;
            }
            long total = conn.getContentLengthLong();
            InputStream is = conn.getInputStream();
            if (is == null) return false;
            OutputStream os = new java.io.FileOutputStream(target);
            byte[] buf = new byte[16384];
            long done = 0;
            int n;
            long lastPct = -1;
            while ((n = is.read(buf)) > 0) {
                if (updateDownloadCancelled.get()) {
                    os.close();
                    is.close();
                    return false;
                }
                os.write(buf, 0, n);
                done += n;
                int curPct = total > 0 ? (int) (Math.min(done, total) * 100 / total) : 0;
                long now = System.currentTimeMillis();
                long last = lastProgressPost.get();
                if (curPct != lastPct && now - last >= 80) {
                    lastPct = curPct;
                    lastProgressPost.set(now);
                    final long pDone = done;
                    final long pTotal = total;
                    uiHandler.post(() -> {
                        ui.setProgress(pDone, pTotal);
                        ui.setStatus("正在下载更新包");
                    });
                }
            }
            os.flush();
            os.close();
            is.close();
            return target.length() > 0;
        } finally {
            if (conn != null) conn.disconnect();
        }
    }

    private void installApk(File apkFile) {
        if (apkFile == null || !apkFile.exists()) {
            toast("更新文件不存在");
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            PackageManager pm = getPackageManager();
            boolean canInstall = false;
            try {
                canInstall = pm.canRequestPackageInstalls();
            } catch (Exception ignored) {
            }
            if (!canInstall) {
                new AlertDialog.Builder(this)
                        .setTitle("需要授权安装")
                        .setMessage("首次更新需允许“安装未知应用”，请在弹出的设置中开启。")
                        .setPositiveButton("去开启", (d, w) -> openInstallPermissionSettings())
                        .setNegativeButton("取消", null)
                        .show();
                return;
            }
        }
        try {
            Uri apkUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", apkFile);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
        } catch (Exception e) {
            toast("无法打开安装: " + e.getMessage());
        }
    }

    private void openInstallPermissionSettings() {
        try {
            Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                    Uri.parse("package:" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            toast("请在系统设置中开启“允许安装未知应用”");
        }
    }

    private int compareVersions(String v1, String v2) {
        String[] a = extractVersionParts(v1);
        String[] b = extractVersionParts(v2);
        int n = Math.max(a.length, b.length);
        for (int i = 0; i < n; i++) {
            int ai = i < a.length ? parseNum(a[i]) : 0;
            int bi = i < b.length ? parseNum(b[i]) : 0;
            if (ai != bi) return Integer.compare(ai, bi);
        }
        return 0;
    }

    private String[] extractVersionParts(String v) {
        if (v == null) v = "";
        String cleaned = v.replaceAll("[^0-9.]", "");
        return cleaned.split("\\.");
    }

    private int parseNum(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    // ============ 工具 ============

    private void toast(String msg) {
        runOnUiThread(() -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show());
    }

    private static String quote(String s) {
        if (s == null) return "null";
        StringBuilder sb = new StringBuilder("\"");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '"': sb.append("\\\""); break;
                case '\\': sb.append("\\\\"); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                default:
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
            }
        }
        return sb.append("\"").toString();
    }
}
