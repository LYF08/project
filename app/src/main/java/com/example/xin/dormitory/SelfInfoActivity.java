package com.example.xin.dormitory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SelfInfoActivity extends AppCompatActivity {

    private TextView alter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_info);
        Toolbar toolbar =findViewById(R.id.self_info_toolbar);
        setSupportActionBar(toolbar);
        alter = findViewById(R.id.alter);
        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelfInfoActivity.this,AlterSelfInfoActivity.class));
            }
        });
    }
}
