package com.example.xin.dormitory.Student;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.xin.dormitory.R;
import com.example.xin.dormitory.Utility.HttpUtil;

public class ForegroundService extends Service {
    public ForegroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent =  new Intent(this,PostsListActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("学生宿舍管理系统")
                .setContentText("有新鲜事？发个帖子聊天吧！")
                .setSmallIcon(R.drawable.ic_room)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
