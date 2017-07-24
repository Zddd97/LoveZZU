package com.gjf.lovezzu.activity.schoolnewsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.gjf.lovezzu.R;

/**
 * Created by BlackBeard丶 on 2017/6/19.
 */

public class SchoolNewsWebView  extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_news2);

        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        //Log.i("传递过来的url:",url);

        webView=(WebView)findViewById(R.id.news_show);
        webView.loadUrl(url);
    }
}
