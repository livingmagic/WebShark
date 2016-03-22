package com.timetop.shark;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lihongyong on 2016/3/16.
 */
public class SharkBrowseActivity extends AppCompatActivity {
    public final static String TAG="SharkBrowseActivity";
    public final static String DATA_URL="DATA_URL";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browse_shark);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView=(WebView)findViewById(R.id.webView);
        String url=getIntent().getStringExtra(DATA_URL);

        if(url!=null){
            SharkClient client=SharkClientFactory.newInstance(this, webView);
            client.loadUrl(url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
