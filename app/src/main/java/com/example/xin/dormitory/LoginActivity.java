package com.example.xin.dormitory;

import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.*;

public class LoginActivity extends AppCompatActivity {

    private CheckBox cb1;
    private EditText et_account,et_pwd;
    private Button bt_register,bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //组件初始化
        et_account = findViewById(R.id.et_account);
        et_pwd = findViewById(R.id.et_pwd);
        cb1 = findViewById(R.id.cb_1);
        bt_register = findViewById(R.id.bt_register);
        bt_login = findViewById(R.id.bt_login);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb1.isChecked())
                {
                    et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String pwd = intent.getStringExtra("pwd");
        et_account.setText(ID);
        et_pwd.setText(pwd);

        setListeners();
    }


    /**
     * 监听器初始化
     */
    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_register.setOnClickListener(onClick);
        bt_login.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent ;
            switch(v.getId()) {
                case R.id.bt_register:
                    intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.bt_login:
                    loginHelp();
                    break;
            }
        }
    }


    /**
     * 验证账号密码是否一致
     */
    private void loginHelp(){
        String ID = et_account.getText().toString();
        HttpUtil.ID = ID;
        String pwd = et_pwd.getText().toString();
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("ID",ID).add("password",pwd).build();
        //服务器地址，ip地址需要时常更换
        String address=HttpUtil.address+"login.php";
        Request request = new Request.Builder().url(address).post(requestBody).build();
        //匿名内部类实现回调接口
        client.newCall(request).enqueue(new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                if(HttpUtil.parseJSONDataForUserinfo(responseData)){
                    //子线程中操作Toast会出现问题，所以用runOnUiThread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent intent = new Intent(LoginActivity.this, LoginSActivity.class);
                    startActivity(intent);
                }else{
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"账号不存在或账号密码不匹配",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

}
