package com.timetop.shark;

import android.content.Context;
import android.graphics.PorterDuff;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.timetop.shark.engine.SystemWebViewEngine;

/**
 * Created by lihongyong on 2016/3/18.
 */
public class SharkClientImpl implements SharkClient{
    SharkWebView webView;
    SystemWebViewEngine engine;

    public SharkClientImpl(SharkWebView webView) {
        this.webView = webView;
        this.engine = new SystemWebViewEngine(webView, new SharkBrowseMode(webView));
    }

    public SharkClientImpl(SharkWebView webView, SharkMode mode) {
        this.webView = webView;
        this.engine = new SystemWebViewEngine(webView, mode);
    }

    @Override
    public void loadUrl(String url) {
        webView.getWebView().loadUrl(url);
    }
}
