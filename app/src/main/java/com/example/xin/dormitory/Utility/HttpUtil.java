package com.example.xin.dormitory.Utility;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.*;

public class HttpUtil {
    //服务器地址，ip地址需要时常更换
    public static final String address="http://192.168.88.100:8080/dormitoryPHP/";
    //由于Okhttp3的封装，难以获得php返回的数据，故记录用户ID，方便之后获取用户信息的操作
    public static String ID = null;
    /**
     * 根据服务器返回的JSON数据判断用户是否存在
     * @param JSONData 返回的JSON数据
     * @return true OR false 表示解析是否成功
     */
    public static boolean parseJSONDataForUserinfo(String JSONData){
        try {
            JSONObject jsonObject = new JSONObject(JSONData);
            //status代表状态
            String status = jsonObject.getString("status");
            switch (status){
                case"1": return true;
                case"2": return true;
                case"3": return true;
                default: return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

}
