package com.example.xin.dormitory.Common;

import android.widget.Toast;

import com.example.xin.dormitory.Utility.MyApplication;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * 签到记录类
 */
public class Sign implements Serializable {

    private int ID;
    private String Rtime;
    private String houseparentID;
    private int nums;
    private String title;
    private String govern;
    //totalnums是发起签到时应签到的总人数
    private int totalnums;

    public Sign(JSONObject jsonObject){
        try {
            this.ID = jsonObject.getInt("ID");
            this.Rtime = jsonObject.getString("Rtime");
            this.houseparentID = jsonObject.getString("houseparentID");
            this.nums = jsonObject.getInt("nums");
            this.title = jsonObject.getString("title");
            this.govern = jsonObject.getString("govern");
            this.totalnums = jsonObject.getInt("totalnums");
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MyApplication.getContext(), "初始化出错", Toast.LENGTH_SHORT).show();
        }
    }

    public int getTotalnums(){
        return this.totalnums;
    }

    public int getID() {
        return ID;
    }

    public String getRtime() {
        return Rtime;
    }

    public String getHouseparentID() {
        return houseparentID;
    }

    public int getNums() {
        return nums;
    }

    public String getTitle() {
        return title;
    }

    public String getGovern() {
        return govern;
    }
}
