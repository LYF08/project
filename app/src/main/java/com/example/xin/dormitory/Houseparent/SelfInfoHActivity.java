package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Student.AlterSelfInfoActivity;
import com.example.xin.dormitory.Student.SelfInfoActivity;
import com.example.xin.dormitory.Utility.HttpUtil;
import com.example.xin.dormitory.Utility.MyApplication;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SelfInfoHActivity extends AppCompatActivity {

    private TextView tv_alter,tv_govern,tv_name,tv_ID;
    private EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_info_h);
        Toolbar toolbar =findViewById(R.id.self_info_toolbar);
        setSupportActionBar(toolbar);
        tv_alter = findViewById(R.id.alter);
        et_phone = findViewById(R.id.et_phone);
        tv_name = findViewById(R.id.tv_name);
        tv_govern = findViewById(R.id.tv_govern);
        tv_ID = findViewById(R.id.tv_ID);
        SharedPreferences pref = getSharedPreferences("dataH",MODE_PRIVATE);
        et_phone.setText(pref.getString("phone",""));
        tv_govern.setText(pref.getString("govern",""));
        tv_name.setText(pref.getString("name",""));
        tv_ID.setText(pref.getString("ID",""));
        setListeners();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 监听器初始化
     */
    private void setListeners(){
        OnClick onClick = new OnClick();
        tv_alter.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            switch(v.getId()) {
                case R.id.alter:
                    String phone = et_phone.getText().toString();
                    if(phone.equals(getSharedPreferences("dataH",MODE_PRIVATE).getString("phone",""))){
                        Toast.makeText(MyApplication.getContext(),"你好像没有变更联系方式哦",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("dataH",MODE_PRIVATE).edit();
                    editor.putString("phone",phone);
                    editor.apply();

                    //更新数据库中用户的nickname和phone
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("ID",HttpUtil.HID).add("phone",phone).build();
                    //服务器地址，ip地址需要时常更换
                    String address=HttpUtil.address+"alterH.php";
                    Request request = new Request.Builder().url(address).post(requestBody).build();
                    //匿名内部类实现回调接口
                    client.newCall(request).enqueue(new okhttp3.Callback(){
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MyApplication.getContext(),"服务器连接失败",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String responseData = response.body().string();
                            //子线程中操作Toast会出现问题，所以用runOnUiThread
                            if(HttpUtil.parseSimpleJSONData(responseData)){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MyApplication.getContext(),"修改成功",Toast.LENGTH_SHORT).show();
                                    }
                                });
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
                    break;
                default:
                    break;
            }
        }
    }
}
