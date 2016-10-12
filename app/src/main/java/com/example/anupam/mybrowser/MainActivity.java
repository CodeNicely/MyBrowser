package com.example.anupam.mybrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button go1;
    EditText search;
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView1 = (WebView) findViewById(R.id.webView);
        search = (EditText) findViewById(R.id.search);
        go1 = (Button) findViewById(R.id.go);

        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setLoadWithOverviewMode(true);
        webView1.getSettings().setUseWideViewPort(true);
        webView1.loadUrl("http://www.google.com");
        webView1.setWebViewClient(new myclient());

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = search.getText().toString();
                webView1.loadUrl(link);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater me = getMenuInflater();
        me.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.back:
                if (webView1.canGoBack()) {

                    webView1.goBack();
                }
                break;

            case R.id.fwd:

                if (webView1.canGoForward()) {

                    webView1.goForward();
                }
                break;

            case R.id.rfsh:
                webView1.reload();
                break;

            case R.id.hstry:
                webView1.clearHistory();
                break;
        }
        return false;
    }
}