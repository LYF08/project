package com.example.xin.dormitory.Student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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


public class LoginSActivity extends AppCompatActivity {

    private DrawerLayout mSDrawlayout;
    private NavigationView navView;
    private TextView tv_username;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_s);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //启动服务
        startService(new Intent(this,ForegroundService.class));

        mSDrawlayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        tv_username = findViewById(R.id.tv_username);

        //初始化HttpUtil中的水电费地址
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        HttpUtil.waterCheck = pref.getString("waterCheck",null);
        HttpUtil.electricityCheck = pref.getString("electricityCheck",null);
        //把信息存到sharedpreferences里
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("ID",HttpUtil.ID).build();
        //服务器地址，ip地址需要时常更换
        String address=HttpUtil.address+"infoS.php";
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
                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("ID",jsonObject.getString("ID"));
                    editor.putString("name",jsonObject.getString("name"));
                    editor.putString("dormID",jsonObject.getString("dormID"));
                    editor.putString("phone",jsonObject.getString("phone"));
                    editor.putString("nickname",jsonObject.getString("nickname"));
                    editor.putString("belong",jsonObject.getString("belong"));
                    editor.apply();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        tv_username.setText(pref.getString("nickname",""));

        Button dormbutton= findViewById(R.id.button1);
        Button setbutton= findViewById(R.id.button2);
        OnClick onClick = new OnClick();
        dormbutton.setOnClickListener(onClick);
        setbutton.setOnClickListener(onClick);

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        setListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setListeners(){
        NavigationItem navigationItem = new NavigationItem();
        navView.setNavigationItemSelectedListener(navigationItem);

    }


    private class NavigationItem implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Intent intent = null;
            switch(item.getItemId()){
                case R.id.nav_info: {
                    intent = new Intent(LoginSActivity.this, SelfInfoActivity.class);
                    break;
                }
                case R.id.nav_dormitory:{
                    intent = new Intent(LoginSActivity.this, MyDormitory.class);
                    break;
                }
                case R.id.nav_notice:{
                    intent = new Intent(LoginSActivity.this,CheckNoticesActivity.class);
                    break;
                }
                default:
                    break;
            }
            startActivity(intent);
            return true;
        }
    }


//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.toolbar,menu);
//        return  super.onCreateOptionsMenu(menu);
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,ForegroundService.class));
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home :
            {mSDrawlayout.openDrawer(GravityCompat.START);break;}
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }


    private class OnClick implements View.OnClickListener{

        @Override//主界面的点击事件（宿舍天地，宿舍事务）
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()){
                case R.id.button1:
                    myAnimation= AnimationUtils.loadAnimation(LoginSActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(LoginSActivity.this, PostsListActivity.class);
                    break;
                case R.id.button2:
                    myAnimation= AnimationUtils.loadAnimation(LoginSActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent  = new Intent(LoginSActivity.this, DormitoryAffairsActivity.class);
                    break;
            }
           startActivity(intent);
        }
    }

}
