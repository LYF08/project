package com.example.xin.dormitory.Student;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Utility.HttpUtil;

public class MyDormitory extends AppCompatActivity {

    private Button bt_water;
    private Button bt_ele;
    private TextView tv_set;
    private Button repair;
    private TextView tv_dorm;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dormitory);
        Toolbar toolbar =findViewById(R.id.toolbar_dorm2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bt_ele = findViewById(R.id.bt_ele);
        bt_water = findViewById(R.id.bt_water);
        tv_set = findViewById(R.id.tv_set);
        repair = findViewById(R.id.repair);
        tv_dorm = findViewById(R.id.tv_dorm);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        tv_dorm.setText(pref.getString("dormID",""));
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_ele.setOnClickListener(onClick);
        bt_water.setOnClickListener(onClick);
        tv_set.setOnClickListener(onClick);
        repair.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null ;
            switch(v.getId()) {
                case R.id.bt_ele:
                    myAnimation= AnimationUtils.loadAnimation(MyDormitory.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    if(HttpUtil.electricityCheck == null){
                        new AlertDialog.Builder(MyDormitory.this)
                                .setMessage("你好像还没有设置电费查询地址哦！快去设置吧！只需填写一次哦！")
                                .setPositiveButton("好的", null).show();
                        break;
                    }
                    intent = new Intent(MyDormitory.this,CheckEleAndWaterActivity.class);
                    intent.putExtra("source","electricity");
                    startActivity(intent);
                    break;
                case R.id.bt_water:
                    myAnimation= AnimationUtils.loadAnimation(MyDormitory.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    if(HttpUtil.waterCheck == null){
                        new AlertDialog.Builder(MyDormitory.this)
                                .setMessage("你好像还没有设置水费查询地址哦！快去设置吧！只需填写一次哦！")
                                .setPositiveButton("好的", null).show();
                        break;
                    }
                    intent = new Intent(MyDormitory.this,CheckEleAndWaterActivity.class);
                    intent.putExtra("source","water");
                    startActivity(intent);
                    break;
                case R.id.repair:
                    myAnimation= AnimationUtils.loadAnimation(MyDormitory.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(MyDormitory.this, RepairApplicationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_set:
                    final View dialogView = LayoutInflater.from(MyDormitory.this)
                            .inflate(R.layout.water_and_electricity,null);
                    final EditText et_water = dialogView.findViewById(R.id.et_water);
                    final EditText et_electricity = dialogView.findViewById(R.id.et_electricity);
                    et_water.setText(HttpUtil.waterCheck);
                    et_electricity.setText(HttpUtil.electricityCheck);
                    new AlertDialog.Builder(MyDormitory.this).setTitle("请输入水费和电费查询地址:\n(示例:https://ssp.scnu.edu.cn)")
                            .setView(dialogView)
                            .setPositiveButton("填好啦", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //按下确定键后的事件
                                    HttpUtil.waterCheck  = et_water.getText().toString();
                                    HttpUtil.electricityCheck = et_electricity.getText().toString();
                                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                                    editor.putString("waterCheck",HttpUtil.waterCheck);
                                    editor.putString("electricityCheck",HttpUtil.electricityCheck);
                                    editor.apply();
                                }
                            }).setNegativeButton("取消",null).show();
                default:
                    break;
            }
        }
    }

}

