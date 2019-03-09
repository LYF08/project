package com.example.xin.dormitory.Student;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xin.dormitory.Common.Sign;
import com.example.xin.dormitory.Houseparent.ManagerSignUpActivity;
import com.example.xin.dormitory.Houseparent.Repair;
import com.example.xin.dormitory.Houseparent.SignAdapterForHouseparent;
import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Utility.HttpUtil;
import com.example.xin.dormitory.Utility.MyApplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

public class SignAdapterForStudent extends RecyclerView.Adapter<SignAdapterForStudent.ViewHolder>{

    private Context mContext;
    private List<Sign> mSignList;
    //为了获取方便定义为私有成员
    private Sign chosenSign;

    static class ViewHolder extends RecyclerView.ViewHolder{

        View signView;
        //这是发布编号
        TextView tv_theID;
        TextView tv_Rtime;
        TextView tv_title;
        TextView tv_houseparentID;

        public ViewHolder(View view){
            super(view);
            signView = view;
            tv_theID = view.findViewById(R.id.tv_theID);
            tv_Rtime = view.findViewById(R.id.tv_Rtime);
            tv_title = view.findViewById(R.id.tv_title);
            tv_houseparentID = view.findViewById(R.id.tv_houseparentID);
        }
    }

    public SignAdapterForStudent(List<Sign> signList){
        mSignList = signList;
    }

    @Override
    public SignAdapterForStudent.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.sign_for_student,parent,false);
        final SignAdapterForStudent.ViewHolder holder = new SignAdapterForStudent.ViewHolder(view);
        holder.signView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                chosenSign = mSignList.get(position);
                new AlertDialog.Builder(mContext).setTitle("你要现在签到吗？")
                        .setIcon(R.drawable.ic_sign_notice)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                studentSignHelp(chosenSign);
                            }
                        }).setNegativeButton("取消",null).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(SignAdapterForStudent.ViewHolder holder, int position) {
        Sign sign = mSignList.get(position);
        holder.tv_Rtime.setText("发布时间:"+sign.getRtime());
        holder.tv_title.setText("标题:"+sign.getTitle());
        holder.tv_theID.setText("编号:"+sign.getID());
        holder.tv_houseparentID.setText("宿管ID:"+sign.getHouseparentID());
    }

    @Override
    public int getItemCount() {
        return mSignList.size();
    }

    /**
     * 用于学生签到
     * @param sign 用于获取签到表编号
     */
    private void studentSignHelp(Sign sign){
        SharedPreferences pref = mContext.getSharedPreferences("data",MODE_PRIVATE);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String signedtime = formatter.format(new Date(System.currentTimeMillis()));
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("signedtime",signedtime).add("SID",pref.getString("ID","")).add("recordID",String.valueOf(sign.getID())).build();
        //服务器地址，ip地址需要时常更换
        String address=HttpUtil.address+"signTimeRecord.php";
        Request request = new Request.Builder().url(address).post(requestBody).build();
        //匿名内部类实现回调接口
        client.newCall(request).enqueue(new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                ((Activity)mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(),"服务器连接失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                //子线程中操作Toast会出现问题，所以用runOnUiThread
                if (HttpUtil.parseSimpleJSONData(responseData)) {
                    ((Activity)mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyApplication.getContext(), "签到成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    ((Activity)mContext).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MyApplication.getContext(), "签到失败,请不要重复签到哦", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
