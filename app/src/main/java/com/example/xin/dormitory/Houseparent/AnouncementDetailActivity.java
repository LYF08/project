package com.example.xin.dormitory.Houseparent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.xin.dormitory.R;

public class AnouncementDetailActivity extends AppCompatActivity {

    private TextView tv_title;
    private TextView tv_Atime;
    private TextView tv_content;
    private TextView tv_ID;
    private Announcement announcement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anouncement_detail);
        initLayout();
    }

    /**
     * 把布局初始化的代码写在一起
     */
    private void initLayout(){
        Toolbar toolbar = findViewById(R.id.toolbar_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_ID = findViewById(R.id.tv_ID);
        tv_Atime = findViewById(R.id.tv_Atime);
        tv_content = findViewById(R.id.tv_content);
        tv_content.setMovementMethod(new ScrollingMovementMethod());
        tv_title = findViewById(R.id.tv_title);
        announcement = (Announcement) getIntent().getSerializableExtra("announcement_data");
        tv_ID.setText(String.valueOf(announcement.getID()));
        tv_title.setText(announcement.getTitle());
        tv_content.setText(announcement.getContent());
        tv_Atime.setText(announcement.getAtime());
    }
}
