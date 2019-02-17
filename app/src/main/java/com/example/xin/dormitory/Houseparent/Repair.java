package com.example.xin.dormitory.Houseparent;

import android.widget.Toast;

import com.example.xin.dormitory.Utility.MyApplication;

import org.json.JSONObject;

import java.io.Serializable;

public class Repair implements Serializable {

    private int ApplyID;
    private String ApplyDate;
    private String dormID;
    private String RepairName;
    private String DamageCause;
    private String Details;
    private String Contact;
    private String OtherRemarks;
    private int Status;

    public Repair(int applyID, String applyDate, String dormID, String repairName, String damageCause, String details, String contact, String otherRemarks, int status) {
        ApplyID = applyID;
        ApplyDate = applyDate;
        this.dormID = dormID;
        RepairName = repairName;
        DamageCause = damageCause;
        Details = details;
        Contact = contact;
        OtherRemarks = otherRemarks;
        Status = status;
    }

    public Repair(JSONObject jsonObject){
        try {
            ApplyID = jsonObject.getInt("ApplyID");
            ApplyDate = jsonObject.getString("ApplyDate");
            this.dormID = jsonObject.getString("dormID");
            RepairName = jsonObject.getString("RepairName");
            DamageCause = jsonObject.getString("DamageCause");
            Details = jsonObject.getString("Details");
            Contact = jsonObject.getString("Contact");
            OtherRemarks = jsonObject.getString("OtherRemarks");
            Status = jsonObject.getInt("Status");
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MyApplication.getContext(), "初始化出错", Toast.LENGTH_SHORT).show();
        }
    }

    public int getApplyID() {
        return ApplyID;
    }

    public String getApplyDate() {
        return ApplyDate;
    }

    public String getDormID() {
        return dormID;
    }

    public String getRepairName() {
        return RepairName;
    }

    public String getDamageCause() {
        return DamageCause;
    }

    public String getDetails() {
        return Details;
    }

    public String getContact() {
        return Contact;
    }

    public String getOtherRemarks() {
        return OtherRemarks;
    }

    public int getStatus() {
        return Status;
    }

}
