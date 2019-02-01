package com.example.xin.dormitory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AlterSelfInfoActivity extends AppCompatActivity {
    private TextView save;
    private EditText et_nickname,et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_self_info);
        Toolbar toolbar =findViewById(R.id.alter_self_info_toolbar);
        setSupportActionBar(toolbar);
        save = findViewById(R.id.save);
        et_nickname = findViewById(R.id.nickname);
        et_phone = findViewById(R.id.phone);
        Intent intent = getIntent();
        et_nickname.setText(intent.getStringExtra("nickname"));
        et_phone.setText(intent.getStringExtra("phone"));

        setListeners();
    }


    /**
     * 监听器初始化
     */
    private void setListeners(){
        OnClick onClick = new OnClick();
        save.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = new Intent() ;
            switch(v.getId()) {
                case R.id.save:
                    String phone = et_phone.getText().toString();
                    String nickname = et_nickname.getText().toString();
                    intent.putExtra("nickname",nickname);
                    intent.putExtra("phone",phone);
                    setResult(RESULT_OK,intent);

                    //更新数据库中用户的nickname和phone
                    //此处有bug，数据库未更新，原因未知
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("phone",phone).add("nickname",nickname).build();
                    //服务器地址，ip地址需要时常更换
                    String address=HttpUtil.address+"alter.php";
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
                                        Toast.makeText(MyApplication.getContext(),"修改成功",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                finish();
                            }else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(),"修改失败",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    finish();
                    break;
                default:
                    break;
            }
        }
    }
}

