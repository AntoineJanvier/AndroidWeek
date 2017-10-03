package com.ajanvier.tp_service;

import android.util.Log;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by antoine on 03/10/17.
 */

public class DownloaderThread extends Thread {

    public static final String TAG_DOWNLOADER_THREAD = "DownloaderThread";
    private AtomicInteger nbByte = new AtomicInteger(0);

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if (nbByte.incrementAndGet() % 10000 == 0)
                Log.i(TAG_DOWNLOADER_THREAD, "Downloaded : " + nbByte.get());
        }
    }

    public int getNbByte() {
        return nbByte.get();
    }
}
