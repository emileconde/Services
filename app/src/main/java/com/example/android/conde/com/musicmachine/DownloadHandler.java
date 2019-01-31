package com.example.android.conde.com.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class DownloadHandler extends Handler {
    private DownloadService mService;
    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
        mService.stopSelf(msg.arg1);
    }

    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10*1000;
        while(System.currentTimeMillis() < endTime){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(MainActivity.TAG, song+" downloaded ");
    }

    public void setService(DownloadService downloadService) {
        this.mService = downloadService;
    }
}
