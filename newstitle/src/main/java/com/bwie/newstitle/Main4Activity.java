package com.bwie.newstitle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main4Activity extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mWebview = (WebView) findViewById(R.id.webview);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        WebSettings settings = mWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.loadUrl(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //webview要释放内存
        mWebview.removeAllViews();
        mWebview.destroy();
    }
}
