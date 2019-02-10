package com.example.xin.dormitory.Student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xin.dormitory.R;

public class CheckEleAndWaterActivity extends AppCompatActivity {

    private WebView wv_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ele_and_water);
        wv_view = findViewById(R.id.wv_view);
        wv_view.getSettings().setJavaScriptEnabled(true);
        wv_view.setWebViewClient(new WebViewClient());
        wv_view.loadUrl("https://ssp.scnu.edu.cn");
    }
}
