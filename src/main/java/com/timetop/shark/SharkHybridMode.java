package com.timetop.shark;

import android.content.Intent;
import android.webkit.WebView;

/**
 * Created by lihongyong on 2016/3/19.
 */
public class SharkHybridMode extends SharkMode{
    SharkWebView webView;

    public SharkHybridMode(SharkWebView webView){
        this.webView=webView;

        if(webView.getCls()==null){
            webView.setCls(SharkBrowseActivity.class);
        }
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.contains("sharkJump=0")){
            //页面内跳转
            return false;
        }

        Intent intent=new Intent(webView.getContext(), webView.getCls());
        intent.putExtra(SharkBrowseActivity.DATA_URL, url);
        webView.getContext().startActivity(intent);
        return true;
    }
}
