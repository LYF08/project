package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Utility.HttpUtil;
import com.example.xin.dormitory.Utility.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginHActivity extends AppCompatActivity {

    private TextView tv_userHname;
    private Button bt_repair;
    private Button bt_sign;
    private Button bt_announcement;
    private Button bt_infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_h);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_userHname = findViewById(R.id.tv_userHname);
        bt_repair = findViewById(R.id.bt_repair);
        bt_sign = findViewById(R.id.bt_sign);
        bt_announcement = findViewById(R.id.bt_announcement);
        bt_infos = findViewById(R.id.bt_infos);
        setListeners();

        //把信息存到sharedpreferences里
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("ID",HttpUtil.HID).build();
        //服务器地址，ip地址需要时常更换
        String address=HttpUtil.address+"infoH.php";
        Request request = new Request.Builder().url(address).post(requestBody).build();
        //匿名内部类实现回调接口
        client.newCall(request).enqueue(new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(),"服务器连接失败，无法获取您的信息",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(responseData);
                    //存储除密码以外的所有信息
                    SharedPreferences.Editor editor = getSharedPreferences("dataH",MODE_PRIVATE).edit();
                    editor.putString("ID",jsonObject.getString("ID"));
                    editor.putString("name",jsonObject.getString("name"));
                    editor.putString("phone",jsonObject.getString("phone"));
                    editor.putString("govern",jsonObject.getString("govern"));
                    editor.apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        SharedPreferences pref = getSharedPreferences("dataH",MODE_PRIVATE);
        tv_userHname.setText(pref.getString("name","")+"宿管");

    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_repair.setOnClickListener(onClick);
        bt_announcement.setOnClickListener(onClick);
        bt_infos.setOnClickListener(onClick);
        bt_sign.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_infos:
                    intent = new Intent(LoginHActivity.this,CheckStayAndLeftActivity.class);
                    break;
                case R.id.bt_announcement:
                    intent = new Intent(LoginHActivity.this,ManagerAnnouncementActivity.class);
                    break;
                case R.id.bt_repair:
                    intent = new Intent(LoginHActivity.this,ManagerRepairActivity.class);
                    break;
                case R.id.bt_sign:
                    intent = new Intent(LoginHActivity.this,ManagerSignUpActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


}
