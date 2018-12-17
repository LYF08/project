package com.example.xin.dormitory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private RadioGroup rrg1;
    private EditText ret2;
    private Button rbt2;
    private EditText ret3;
    private EditText ret4;
    private TextView rtv3;
    private View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        rrg1 = (RadioGroup) findViewById(R.id.rrg_1);
        ret2 = (EditText) findViewById(R.id.ret_2);
        rbt2 = (Button) findViewById(R.id.rbt_2);
        ret3 = (EditText) findViewById(R.id.ret_3);
        ret4 = (EditText) findViewById(R.id.ret_4);
        rtv3 = (TextView) findViewById(R.id.rtv_3) ;
        rrg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(((RadioButton)group.findViewById(checkedId)).getId()){
                    case R.id.rrb_1:
                        ret2.setFocusable(false);
                        ret2.setFocusableInTouchMode(false);
                        break;
                    case R.id.rrb_2:
                        ret2.setFocusableInTouchMode(true);
                        ret2.setFocusable(true);
                        ret2.requestFocus();
                        break;
                }
            }
        });
        ret4.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temp = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str1;
                String str2;
                str1 = ret3.getText().toString();
                str2 = ret4.getText().toString();
                if(str1.equals(str2)){
                    rtv3.setText("");
                    rbt2.setEnabled(true);
                }else{
                    rtv3.setText("两次输入的密码不一致，请重新输入");
                    rbt2.setEnabled(false);
                }
            }
        });
        setListeners();

    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        rbt2.setOnClickListener(onClick);

    }
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            switch(v.getId()){
                case R.id.rbt_2:
                    String ID = ret2.getText().toString();
                    String pwd = ret3.getText().toString();
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    rbt2.setEnabled(false);
                    intent.putExtra("ID", ID);
                    intent.putExtra("pwd", pwd);
                    intent.setClass(RegisterActivity.this, LoginActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
