package com.example.xin.dormitory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private CheckBox cb1;
    private EditText et1,et2;
    private Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et1 = (EditText)findViewById(R.id.et_1);
        et2 = (EditText)findViewById(R.id.et_2);
        cb1 = (CheckBox)findViewById(R.id.cb_1);
        bt1 = (Button) findViewById(R.id.bt_1);
        bt2 = (Button) findViewById(R.id.bt_2);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb1.isChecked())
                {
                    et2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    et2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        Intent intent = getIntent();
        String ID = intent.getStringExtra("ID");
        String pwd = intent.getStringExtra("pwd");
        et1.setText(ID);
        et2.setText(pwd);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        bt1.setOnClickListener(onClick);
        bt2.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch(v.getId()){
                case R.id.bt_1:
                    intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    break;
                case R.id.bt_2:
                    intent  = new Intent(LoginActivity.this, LoginSActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
