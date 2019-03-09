package com.example.xin.dormitory.Student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.xin.dormitory.R;

public class CheckNoticesActivity extends AppCompatActivity {

    private Button bt_announcement;
    private Button bt_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_notices);
        initLayout();
    }

    private void initLayout(){
        bt_announcement = findViewById(R.id.bt_announcement);
        bt_sign = findViewById(R.id.bt_sign);
        Toolbar toolbar = findViewById(R.id.toolbar_check);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_announcement.setOnClickListener(onClick);
        bt_sign.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_announcement:
                    intent = new Intent(CheckNoticesActivity.this,CheckAnnouncementNoticesActivity.class);
                    break;
                case R.id.bt_sign:
                    intent = new Intent(CheckNoticesActivity.this,CheckSignNoticesActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}
