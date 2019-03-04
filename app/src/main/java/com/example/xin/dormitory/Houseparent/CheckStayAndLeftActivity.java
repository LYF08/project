package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.xin.dormitory.R;

public class CheckStayAndLeftActivity extends AppCompatActivity {

    private Button bt_stay,bt_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_stay_and_left);
        bt_stay = findViewById(R.id.bt_stay);
        bt_left = findViewById(R.id.bt_left);
        Toolbar toolbar = findViewById(R.id.toolbar_check);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_stay.setOnClickListener(onClick);
        bt_left.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_stay:
                    intent = new Intent(CheckStayAndLeftActivity.this,CheckStayStudentsActivity.class);
                    break;
                case R.id.bt_left:
                    intent = new Intent(CheckStayAndLeftActivity.this,CheckLeftStudentsActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
