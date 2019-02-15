package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.xin.dormitory.R;

public class ManagerRepairActivity extends AppCompatActivity {

    private Button bt_unhandleApplication;
    private Button bt_handleApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_repair);
        bt_handleApplication = findViewById(R.id.bt_handleApplication);
        bt_unhandleApplication = findViewById(R.id.bt_unhandleApplication);
        Toolbar toolbar = findViewById(R.id.toolbar_repair);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_handleApplication.setOnClickListener(onClick);
        bt_unhandleApplication.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_handleApplication:
                    //       intent = new Intent(ManagerAnnouncementActivity.this,CheckStayAndLeftActivity.class);
                    break;
                case R.id.bt_unhandleApplication:
                    //       intent = new Intent(ManagerAnnouncementActivity.this,ManagerAnnouncementActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
