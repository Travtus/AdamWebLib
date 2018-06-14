package com.travtusworks.adam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by teodora on 14.06.2018.
 */

public class AdamActivity extends AppCompatActivity{

    private static final String TAG = "AdamActivity";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adam);

        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");

    }

}
