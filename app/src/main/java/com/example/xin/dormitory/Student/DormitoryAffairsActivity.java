package com.example.xin.dormitory.Student;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.xin.dormitory.R;

public class DormitoryAffairsActivity extends AppCompatActivity {

    private TextView tv_dormID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_affairs);
        Toolbar toolbar_dor = findViewById(R.id.toolbar_dormitory);
        toolbar_dor.setTitle("");
        tv_dormID = findViewById(R.id.tv_dormID);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        tv_dormID.setText(pref.getString("dormID",""));
        setSupportActionBar(toolbar_dor);
        setSupportActionBar(toolbar_dor);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayShowTitleEnabled(false);
        }
    }
}
