package com.ajanvier.tp_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class DownloaderService extends Service {

    public static final String DOWNLOADER_SERVICE = "DownloaderService";
    public static DownloaderThread downloaderThread;

    public DownloaderService() {
    }

    @Override
    public void onCreate() {
        Log.i(DOWNLOADER_SERVICE, "onCreate");
        downloaderThread = new DownloaderThread();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(DOWNLOADER_SERVICE, "onStartCommand");
        downloaderThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(DOWNLOADER_SERVICE, "onDestroy");
        downloaderThread.interrupt();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new DownloadBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(DOWNLOADER_SERVICE, "onUnbind");
        return super.onUnbind(intent);
    }

    public class DownloadBinder extends Binder {
        public int getDownloadedByte() {
            return downloaderThread.getNbByte();
        }
    }
}
