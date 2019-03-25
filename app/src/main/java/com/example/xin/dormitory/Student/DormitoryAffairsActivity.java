package com.example.xin.dormitory.Student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.xin.dormitory.R;

public class DormitoryAffairsActivity extends AppCompatActivity {

    private TextView tv_dormID;
    private Button button_StayAway;
    private Button button_Stay;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory_affairs);
        tv_dormID = findViewById(R.id.tv_dormID);
        button_Stay = findViewById(R.id.button_Stay);
        button_StayAway = findViewById(R.id.button_StayAway);
        Toolbar toolbar_dor = findViewById(R.id.toolbar_dormitory);
        toolbar_dor.setTitle("");
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        tv_dormID.setText(pref.getString("dormID",""));
        setSupportActionBar(toolbar_dor);
        setSupportActionBar(toolbar_dor);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayShowTitleEnabled(false);
        }
        setListeners();
    }
    private void setListeners() {
        OnClick onClick = new OnClick();
        button_StayAway.setOnClickListener(onClick);
        button_Stay.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.button_StayAway:
                    myAnimation= AnimationUtils.loadAnimation(DormitoryAffairsActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(DormitoryAffairsActivity.this, DepartRegisterActivity.class);
                    break;
                case R.id.button_Stay:
                    myAnimation= AnimationUtils.loadAnimation(DormitoryAffairsActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(DormitoryAffairsActivity.this, StayRegisterActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
