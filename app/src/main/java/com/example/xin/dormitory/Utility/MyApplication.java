package com.example.xin.dormitory.Utility;

import android.app.Application;
import android.content.Context;

//这个类用于获得全局context，在难以获得context的情况下有用
public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
