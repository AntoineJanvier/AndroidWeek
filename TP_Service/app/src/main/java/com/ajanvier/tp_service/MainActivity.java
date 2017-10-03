package com.ajanvier.tp_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button) findViewById(R.id.startD);
        Button buttonStop = (Button) findViewById(R.id.stopD);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDownload();
            }
        });
        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopDownload();
            }
        });
    }

    public void startDownload() {
        Intent intent = new Intent(this, DownloaderService.class);
        startService(intent);
        connect();
    }
    public void stopDownload() {
        Intent intent = new Intent(this, DownloaderService.class);
        stopService(intent);
        disconnect();
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            connected = true;
            downloadBinder = (DownloaderService.DownloadBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            connected = false;
        }
    };

    private boolean connected = false;
    private DownloaderService.DownloadBinder downloadBinder;

    public void connect() {
        if (!connected)  {
            Intent intent = new Intent(this, DownloaderService.class);
            bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        } else {
            int nbByte = downloadBinder.getDownloadedByte();
            Toast.makeText(this, " => " + nbByte, Toast.LENGTH_SHORT).show();
        }
    }
    public void disconnect() {
        unbindService(serviceConnection);
        connected = false;
    }
}
