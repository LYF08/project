package com.example.xin.dormitory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    //private RadioGroup rg;
    private EditText et_ID;
    private Button bt_confirm;
    private EditText et_pwd;
    private EditText et_confirm;
    private EditText et_name;
    private EditText et_dorm;
    private EditText et_phone;
    private EditText et_nickname;
    private TextView rtv;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //rg = findViewById(R.id.rg);
        et_ID = findViewById(R.id.et_ID);
        bt_confirm = findViewById(R.id.bt_confirm);
        et_pwd = findViewById(R.id.et_pwd);
        et_confirm = findViewById(R.id.et_confirm);
        et_dorm = findViewById(R.id.et_dorm);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_nickname = findViewById(R.id.et_nickname);
        rtv = findViewById(R.id.rtv);
        /*
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.findViewById(checkedId).getId()){
                    case R.id.rb_manager:
                        et_ID.setFocusable(false);
                        et_ID.setFocusableInTouchMode(false);
                        break;
                    case R.id.rb_student:
                        et_ID.setFocusableInTouchMode(true);
                        et_ID.setFocusable(true);
                        et_ID.requestFocus();
                        break;
                }
            }
        });
    */

        rtv.setText("密码不能为空");
        bt_confirm.setEnabled(false);

        et_confirm.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str1;
                String str2;
                str1 = et_pwd.getText().toString();
                str2 = et_confirm.getText().toString();
                if(str1.length()==0){
                    rtv.setText("密码不能为空");
                    bt_confirm.setEnabled(false);
                } else if(str1.length()<6||str1.length()>10){
                    rtv.setText("密码长度应该为6-10个字符");
                    bt_confirm.setEnabled(false);
                }else if(str1.equals(str2)){
                    rtv.setText("");
                    bt_confirm.setEnabled(true);
                }else{
                    rtv.setText("两次输入的密码不一致，请重新输入");
                    bt_confirm.setEnabled(false);
                }
            }
        });
        setListeners();

    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_confirm.setOnClickListener(onClick);

    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.bt_confirm:
                    String ID = et_ID.getText().toString();
                    String pwd = et_pwd.getText().toString();
                    String name = et_name.getText().toString();
                    String phone = et_phone.getText().toString();
                    String dorm = et_dorm.getText().toString();
                    String nickname = et_nickname.getText().toString();

                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("ID",ID).add("password",pwd).add("dormID",dorm)
                            .add("phone",phone).add("name",name).add("nickname",nickname).build();
                    //服务器地址，ip地址需要时常更换
                    String address=HttpUtil.address+"register.php";
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
                            //子线程中操作Toast会出现问题，所以用runOnUiThread
                            if(HttpUtil.parseJSONDataForUserinfo(responseData)){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(),"注册成功",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                finish();
                            }else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(),"注册失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    }
}
