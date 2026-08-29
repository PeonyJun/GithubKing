package com.peonyking.gitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
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
import android.widget.Toast;

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

    private WebView webView;
    private ValueCallback<Uri[]> filePathCallback;
    private final List<DocumentFile> folderFiles = new ArrayList<>();
    private final List<String> folderRelPaths = new ArrayList<>();
    private int folderToken = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        applyThemeUi("dark");

        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT,
                    this::handleWebBack);
        }

        webView.loadUrl("https://appassets.androidplatform.net/assets/index.html");

        handleLaunchIntent(getIntent());
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
        runOnUiThread(() -> applyThemeUi(theme));
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
        int barColor = light ? COLOR_LIGHT : COLOR_DARK;
        getWindow().setStatusBarColor(barColor);
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
