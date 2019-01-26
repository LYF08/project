package com.example.xin.dormitory;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class DormitoryAffairsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_affairs);
        Toolbar toolbar_dor = findViewById(R.id.toolbar_dormitory);
        toolbar_dor.setTitle("");
        setSupportActionBar(toolbar_dor);
        setSupportActionBar(toolbar_dor);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
