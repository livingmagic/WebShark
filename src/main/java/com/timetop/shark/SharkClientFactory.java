package com.timetop.shark;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.webkit.WebView;

import javax.xml.parsers.SAXParserFactory;

/**
 * Created by lihongyong on 2016/3/18.
 */
public abstract class SharkClientFactory {


    /**
     *
     * @param webView
     *
     * @return
     */
    public static SharkClient newInstance(Context context, WebView webView){
        return new SharkClientImpl(new SharkWebView(context, webView));
    }

    public static SharkClient newHybridInstance(Context context, WebView webView){
        SharkWebView sharkWebView= new SharkWebView(context, webView);
        return new SharkClientImpl(sharkWebView, new SharkHybridMode(sharkWebView));
    }

    /**
     *
     * @param context
     * @param webView
     * @param cls 浏览器模式的Activity
     * @return
     */
    public static SharkClient newHybridInstance(Context context, WebView webView, Class<?> cls){
        SharkWebView sharkWebView= new SharkWebView(context, webView, cls);
        return new SharkClientImpl(new SharkWebView(context, webView));
    }
}
