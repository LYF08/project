package com.example.xin.dormitory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class LoginSActivity extends AppCompatActivity {
    private DrawerLayout mSDrawlayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_s);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        mSDrawlayout = findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);

        ActionBar actionBar = getSupportActionBar();

        Button dormbutton=(Button) findViewById(R.id.button1);
        Button setbutton=(Button) findViewById(R.id.button2);
        OnClick onClick = new OnClick();
        dormbutton.setOnClickListener(onClick);
        setbutton.setOnClickListener(onClick);

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        /*navView.setCheckedItem(R.id.nav_info);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                mSDrawlayout.closeDrawers();
                return true;
            }
        });*/
        setListeners();
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
                case R.id.nav_info:
                    intent = new Intent(LoginSActivity.this, SelfInfoActivity.class);
                    break;

            }
            startActivity(intent);
            return true;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);
        return  super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.backup_item:
            {Toast.makeText(this,"you click backup",Toast.LENGTH_SHORT).show();break;}
            case android.R.id.home :
            {mSDrawlayout.openDrawer(GravityCompat.START);Toast.makeText(this,"you click home",Toast.LENGTH_SHORT).show();break;}
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class OnClick implements View.OnClickListener{

        @Override//主界面的点击事件（宿舍天地，事务管理）
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()){
                case R.id.button1:
                    intent = new Intent(LoginSActivity.this, dormitoryActivity.class);
                    break;
                case R.id.button2:
                    intent  = new Intent(LoginSActivity.this, MyDormitory.class);
                    break;
            }
           startActivity(intent);
        }
    }

}
