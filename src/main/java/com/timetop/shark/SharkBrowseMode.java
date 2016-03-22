package com.timetop.shark;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by lihongyong on 2016/3/19.
 */
public class SharkBrowseMode extends SharkMode{
    SharkWebView webView;
    Intent intent;

    public SharkBrowseMode(SharkWebView webView) {
        this.webView=webView;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_DOWN){
            if(keyCode==KeyEvent.KEYCODE_BACK &&  webView.getWebView().canGoBack()){
                webView.getWebView().goBack();
                return true;
            }
        }
        return super.onKey(v, keyCode, event);
    }
}
