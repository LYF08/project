package com.example.xin.dormitory.Student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.xin.dormitory.R;

public class SelfInfoActivity extends AppCompatActivity {

    private TextView alter,nickname,phone,ID,dormID,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_info);
        Toolbar toolbar =findViewById(R.id.self_info_toolbar);
        setSupportActionBar(toolbar);
        alter = findViewById(R.id.alter);
        nickname = findViewById(R.id.tv_nickname);
        phone = findViewById(R.id.tv_phone);
        ID = findViewById(R.id.tv_ID);
        dormID = findViewById(R.id.tv_dorm);
        name = findViewById(R.id.tv_name);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        nickname.setText(pref.getString("nickname",""));
        phone.setText(pref.getString("phone",""));
        ID.setText(pref.getString("ID",""));
        dormID.setText(pref.getString("dormID",""));
        name.setText(pref.getString("name",""));
        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelfInfoActivity.this,AlterSelfInfoActivity.class);
                intent.putExtra("nickname",nickname.getText().toString());
                intent.putExtra("phone",phone.getText().toString());
                startActivityForResult(intent,1);
            }
        });
    }

    /**
     * 将返回的数据用于更新信息，同时更新sharedPreferences的内容
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String nicknameData = data.getStringExtra("nickname");
                    String phoneData = data.getStringExtra("phone");
                    nickname.setText(nicknameData);
                    phone.setText(phoneData);
                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("nickname",nicknameData);
                    editor.putString("phone",phoneData);
                    editor.apply();
                }
                break;
            default:break;
        }
    }
}
