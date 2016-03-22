package com.timetop.shark;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by lihongyong on 2016/3/21.
 */
public class SharkWebView {
    Context context;
    WebView webView;
    Class<?> cls;

    public SharkWebView(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    public SharkWebView(Context context, WebView webView, Class<?> cls) {
        this.context = context;
        this.webView = webView;
        this.cls=cls;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public WebView getWebView() {
        return webView;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }
}
