package com.timetop.shark;

import android.app.Activity;
import android.webkit.JavascriptInterface;

/**
 * Created by lihongyong on 2016/3/22.
 */
public class SharkJavascriptInterface {
    SharkWebView webView;

    public SharkJavascriptInterface(SharkWebView webView){
        this.webView=webView;
    }

    @JavascriptInterface
    public String test(String msg){
        System.out.println(msg);
        return "ok";
    }

    @JavascriptInterface
    public void setTitle(final String title){
        webView.getWebView().getHandler().post(new Runnable() {
            @Override
            public void run() {
                Activity activity = (Activity) webView.getContext();
                activity.setTitle(title);
            }
        });
    }
}
