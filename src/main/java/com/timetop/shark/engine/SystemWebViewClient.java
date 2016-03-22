package com.timetop.shark.engine;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.timetop.shark.SharkClient;
import com.timetop.shark.SharkMode;

/**
 * Created by lihongyong on 2016/3/18.
 */
public class SystemWebViewClient extends WebViewClient{
    SharkMode sharkMode;

    public SystemWebViewClient(SharkMode sharkMode){
        this.sharkMode=sharkMode;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        return sharkMode.shouldOverrideUrlLoading(view, url);
    }
}
