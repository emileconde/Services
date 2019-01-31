package com.example.android.conde.com.musicmachine;

import android.os.Looper;

public class DownloadThread extends Thread {
    DownloadHandler mDownloadHandler;
    @Override
    public void run() {
        //old way- Not proper
//        for(String song : PlayList.songs) {
//            downloadSong();
//        }

        //Creates the looper for the thread as well as the message queue
        Looper.prepare();
        mDownloadHandler = new DownloadHandler();
        Looper.loop();
    }

}
