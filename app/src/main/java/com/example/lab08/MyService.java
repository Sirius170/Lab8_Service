package com.example.lab08;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public void onCreate(){
        super.onCreate();

        // 使用Thread來模擬執行耗時任務
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000); //延遲5秒

                    // 建立intent，啟動MainActivity2
                    Intent intent = new Intent(MyService.this, MainActivity2.class);

                    //從Service啟動 Activity
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    MyService.this.startActivity(intent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int stratId){
        super.onStartCommand(intent, flags, stratId);
        return START_STICKY;  //Service 被結束時會重啟並清空Intent
    }

    @Override
    public void onDestroy() {super.onDestroy();}

    @Override
    public IBinder onBind(Intent intent){
        //TODO: Return the communication channel to the service
        throw new UnsupportedOperationException("Not yet implemented");
    }
}