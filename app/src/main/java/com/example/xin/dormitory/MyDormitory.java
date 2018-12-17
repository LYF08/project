package com.example.xin.dormitory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MyDormitory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dormitory);
        Toolbar toolbar =findViewById(R.id.toolbar_dorm2);
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
}

