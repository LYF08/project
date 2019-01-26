package com.example.xin.dormitory;


import okhttp3.*;

public class HttpUtil {
    //服务器地址，ip地址需要时常更换
    public static final String address="http://192.168.88.100:8080/dormitoryPHP/";
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

}
