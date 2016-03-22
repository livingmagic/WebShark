package com.timetop.shark;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by lihongyong on 2016/3/19.
 */
public abstract class SharkMode {
    /**
     * 处理URL跳转
     * @param view
     * @param url
     * @return
     */
    public abstract  boolean shouldOverrideUrlLoading(WebView view, String url);

    /**
     * 处理按键事件
     * @param v
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKey(View v, int keyCode, KeyEvent event){
        return false;
    }
}
