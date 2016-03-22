package com.timetop.shark.engine;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.timetop.shark.SharkJavascriptInterface;
import com.timetop.shark.SharkMode;
import com.timetop.shark.SharkWebView;

/**
 * Created by lihongyong on 2016/3/18.
 */
public class SystemWebViewEngine {
    public final static String AGENT="Shark/1.0";
    SharkWebView webView;
    SharkMode sharkMode;

    public SystemWebViewEngine(SharkWebView webView, SharkMode mode) {
        this.webView=webView;
        this.sharkMode= mode;
        initSettings();
        initJavascript();
    }

    private void initJavascript() {
        WebView wv=webView.getWebView();

        wv.addJavascriptInterface(new SharkJavascriptInterface(webView), "sharkAndroid");
    }

    private void initSettings() {
        final WebSettings settings = webView.getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        //We don't save any form data in the application
        settings.setSaveFormData(false);
        //agent
        String agent=settings.getUserAgentString();
        settings.setUserAgentString(agent +" "+ AGENT);

        webView.getWebView().setWebChromeClient(new SystemWebChromeClient());
        webView.getWebView().setWebViewClient(new SystemWebViewClient(sharkMode));
        webView.getWebView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                    return sharkMode.onKey(v, keyCode, event);
            }
        });
    }
}
