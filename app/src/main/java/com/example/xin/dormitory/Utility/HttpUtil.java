package com.example.xin.dormitory.Utility;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;

public class HttpUtil {
    //服务器地址，ip地址需要时常更换
    public static final String address="http://192.168.88.100:8080/dormitoryPHP/";
    //由于Okhttp3的封装，难以获得php返回的数据，故记录学生ID以及宿管HID，方便之后获取信息的操作,其中学生信息的sharedpreferences文件名为data，宿管为dataH
    public static String ID = null;
    public static String HID = null;
    /**
     * 根据服务器返回的JSON数据判断用户是否存在
     * @param JSONData 返回的JSON数据
     * @return true OR false 表示解析是否成功
     */
    public static boolean parseSimpleJSONData(String JSONData){
        try {
            JSONObject jsonObject = new JSONObject(JSONData);
            /**
             * status代表状态
             * 1代表学生用户名密码匹配
             * 2代表学生注册成功
             * 3代表学生信息修改成功
             * 4代表宿管用户名密码匹配
             * 5代表维修申请提交成功
             * 6代表维修申请状态修改成功
             * 7代表公告发布成功
             * 8代表签到发起成功
             * 9代表签到成功
             * 10代表离宿登记提交成功、
             * 11代表留宿登记提交成功
             * -1代表学生不存在
             * -2代表学生密码错误
             * -3代表学生已注册过
             * -4代表注册失败
             * -5代表学生信息修改失败
             * -6代表宿管密码错误
             * -7代表宿管不存在
             * -8代表维修申请提交失败
             * -9代表维修申请状态修改失败
             * -10代表公告发布失败
             * -11代表签到发起失败
             * -12代表签到失败
             * -13代表离宿登记提交失败
             * -14代表留宿登记提交失败
             */
            String status = jsonObject.getString("status");
            switch (status){
                case"1": return true;
                case"2": return true;
                case"3": return true;
                case"4": return true;
                case"5": return true;
                case"6": return true;
                case"7": return true;
                case"8": return true;
                case"9": return true;
                case"10":return true;
                case"11":return true;
                default: return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
