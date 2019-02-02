package com.example.xin.dormitory.Student;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.xin.dormitory.R;

import java.util.ArrayList;
import java.util.List;


public class DormitoryActivity extends AppCompatActivity {

    private List<Talk> talkList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dormitory);
            Toolbar mToolbar = findViewById(R.id.toolbar_dorm1);
            setSupportActionBar(mToolbar);
            initTalkers();
            RecyclerView recyclerView = findViewById(R.id.list_view);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new TestDecoration(this));
            TalkAdapter adapter = new TalkAdapter(talkList);
            recyclerView.setAdapter(adapter);
    }


    private  void initTalkers(){
        Talk talk1=new Talk("Mike",R.drawable.bg_checkbox);
        talkList.add(talk1);
        Talk talk2=new Talk("John",R.drawable.bg_checkbox);
        talkList.add(talk2);
        Talk talk3=new Talk("Peter",R.drawable.bg_checkbox);
        talkList.add(talk3);
        Talk talk4=new Talk("Bob",R.drawable.bg_checkbox);
        talkList.add(talk4);
    }


    public boolean onCreateOptionsMenu(Menu menu)//选择标题栏选项
    {
        getMenuInflater().inflate(R.menu.add,menu);
        return true;
    }
}

//自定义分割线
class TestDecoration extends RecyclerView.ItemDecoration {

    private static final int[] attrs=new int[]{android.R.attr.listDivider};
    private Drawable mDivider;

    public TestDecoration(Context context) {
        TypedArray typedArray=context.obtainStyledAttributes(attrs);
        mDivider=typedArray.getDrawable(0);
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++) {
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int top=child.getBottom()+layoutParams.bottomMargin;
            int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }


    @Override               //设置分割线
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,mDivider.getIntrinsicHeight(),0);
    }
}


