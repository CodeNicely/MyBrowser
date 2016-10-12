package com.example.anupam.mybrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;


public class myclient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        view.loadUrl(url);
        return true;
    }
}