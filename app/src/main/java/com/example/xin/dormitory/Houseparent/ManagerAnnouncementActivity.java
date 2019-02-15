package com.example.xin.dormitory.Houseparent;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.xin.dormitory.R;

public class ManagerAnnouncementActivity extends AppCompatActivity {

    private Button bt_newAnnouncement;
    private Button bt_oldAnnouncement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_announcement);
        bt_newAnnouncement = findViewById(R.id.bt_newAnnouncement);
        bt_oldAnnouncement = findViewById(R.id.bt_oldAnnouncement);
        Toolbar toolbar = findViewById(R.id.toolbar_announcement);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_oldAnnouncement.setOnClickListener(onClick);
        bt_newAnnouncement.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_oldAnnouncement:
             //       intent = new Intent(ManagerAnnouncementActivity.this,CheckStayAndLeftActivity.class);
                    break;
                case R.id.bt_newAnnouncement:
             //       intent = new Intent(ManagerAnnouncementActivity.this,ManagerAnnouncementActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

}
