package com.example.xin.dormitory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AlterSelfInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_self_info);
        Toolbar toolbar =findViewById(R.id.alter_self_info_toolbar);
        setSupportActionBar(toolbar);
    }
}

