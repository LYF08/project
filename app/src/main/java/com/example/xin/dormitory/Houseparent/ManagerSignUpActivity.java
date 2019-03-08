package com.example.xin.dormitory.Houseparent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.xin.dormitory.R;

public class ManagerSignUpActivity extends AppCompatActivity {

    private Button bt_newSign;
    private Button bt_situation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_sign_up);
        bt_newSign = findViewById(R.id.bt_newSign);
        bt_situation = findViewById(R.id.bt_situation);
        Toolbar toolbar = findViewById(R.id.toolbar_sign);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setListeners();
    }


    private void setListeners(){
        OnClick onClick = new OnClick();
        bt_newSign.setOnClickListener(onClick);
        bt_situation.setOnClickListener(onClick);
    }


    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()) {
                case R.id.bt_newSign:
                    //       intent = new Intent(ManagerAnnouncementActivity.this,CheckStayAndDepartActivity.class);
                    break;
                case R.id.bt_situation:
                    //       intent = new Intent(ManagerAnnouncementActivity.this,ManagerAnnouncementActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }

}
