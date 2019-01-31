package com.example.android.conde.com.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;

public class DownloadService extends Service {
    private DownloadHandler mHandler;
    @Override
    public void onCreate() {
        DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();
        //Makes MainActivity wait until the handler has been
        //created to avoid nullPointerException
        //This by the way isn't the best practice.
        while(thread.mDownloadHandler == null){

        }

        mHandler = thread.mDownloadHandler;
        mHandler.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song =  intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = song;
        mHandler.sendMessage(message);
        message.obj = song;
        message.arg1 = startId;
        //START_STICKY tells the system to restart the service using the null intent
        //the service will continue until the user stops it. Best scenario for this would be
        //gps tracker or music player.

        //START_NOT_STICKY service won't be restarted after being killed
        //Best scenario is when checking email every 5 min. If the system kills it for memory,
        //it shouldn't be restarted.

        //START_REDELIVER_INTENT makes the service restart even when killed until it has done
        //its job. When the services restarts, it'll pick up right where it left off.


        //This return tells the system what to do do if the service is killed before
        //finishing its job
        return Service.START_REDELIVER_INTENT;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
