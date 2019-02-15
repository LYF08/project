package com.example.xin.dormitory.Student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xin.dormitory.R;

public class MyDormitory extends AppCompatActivity {

    private Button bt_water;
    private Button bt_ele;
    private Button repair;
    private TextView tv_dorm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dormitory);
        Toolbar toolbar =findViewById(R.id.toolbar_dorm2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bt_ele = findViewById(R.id.bt_ele);
        bt_water = findViewById(R.id.bt_water);
        repair = findViewById(R.id.repair);
        tv_dorm = findViewById(R.id.tv_dorm);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        tv_dorm.setText(pref.getString("dormID",""));

        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_ele.setOnClickListener(onClick);
        bt_water.setOnClickListener(onClick);
        repair.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null ;
            switch(v.getId()) {
                case R.id.bt_ele:
                case R.id.bt_water:
                    intent = new Intent(MyDormitory.this,CheckEleAndWaterActivity.class);
                    break;
                case R.id.repair:
                    intent = new Intent(MyDormitory.this, RepairApplicationActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
}

