package com.travtusworks.adam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by teodora on 14.06.2018.
 */

public class AdamActivity extends AppCompatActivity{

    private static final String TAG = "AdamActivity";

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adam);

        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progress_bar);

        String url = "http://adamwidget.travtus.com";
        if (getIntent().getExtras() != null) {
            int companyID = getIntent().getExtras().getInt(AdamButton.EXTRA_COMPANY_ID, 0);
            if (companyID != 0)
                url = url + "?companyId=" + companyID;
        }

        Log.i(TAG,"url = " + url);

        webView.setWebViewClient(new InnerWebViewClient());
        webView.loadUrl(url);
        webView.getSettings().setJavaScriptEnabled(true);

    }

    private class InnerWebViewClient extends WebViewClient {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            try {
                Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_splash);
                webView.startAnimation(fadeIn);

                fadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        progressBar.setVisibility(View.GONE);
                        webView.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            } catch (Exception e) {}

        }
    }

}
