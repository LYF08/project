package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.content.SharedPreferences;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

public class LoginHActivity extends AppCompatActivity {

    private TextView tv_userHname;
    private Button bt_repair;
    private Button bt_sign;
    private Button bt_announcement;
    private Button bt_infos;
    private DrawerLayout mSDrawlayout;
    private NavigationView navView;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_h);
        Toolbar toolbar = findViewById(R.id.toolbar_h);
        setSupportActionBar(toolbar);
        tv_userHname = findViewById(R.id.tv_userHname);
        bt_repair = findViewById(R.id.bt_repair);
        bt_sign = findViewById(R.id.bt_sign);
        bt_announcement = findViewById(R.id.bt_announcement);
        bt_infos = findViewById(R.id.bt_infos);
        mSDrawlayout = findViewById(R.id.drawer_layout_h);
        navView = findViewById(R.id.nav_view_h);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
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
        NavigationItem navigationItem = new NavigationItem();
        navView.setNavigationItemSelectedListener(navigationItem);
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

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_infos:
                    myAnimation= AnimationUtils.loadAnimation(LoginHActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(LoginHActivity.this,CheckStayAndDepartActivity.class);
                    break;
                case R.id.bt_announcement:
                    myAnimation= AnimationUtils.loadAnimation(LoginHActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(LoginHActivity.this,ManagerAnnouncementActivity.class);
                    break;
                case R.id.bt_repair:
                    myAnimation= AnimationUtils.loadAnimation(LoginHActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(LoginHActivity.this,ManagerRepairActivity.class);
                    break;
                case R.id.bt_sign:
                    myAnimation= AnimationUtils.loadAnimation(LoginHActivity.this, R.anim.anim_alpha);
                    v.startAnimation(myAnimation);
                    intent = new Intent(LoginHActivity.this,ManagerSignUpActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


    private class NavigationItem implements NavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            Intent intent = null;
            switch(item.getItemId()){
                case R.id.nav_info: {
                    intent = new Intent(LoginHActivity.this, SelfInfoHActivity.class);
                    break;
                }
                default:
                    break;
            }
            startActivity(intent);
            return true;
        }
    }
}
