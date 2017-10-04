package com.ajanvier.tp_broadcatreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myReceiver = new MyReceiver();
        registerReceiver(myReceiver,
                new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));

        Button button = (Button) findViewById(R.id.buttonCallReceiver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callReceiver();
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }

    public void callReceiver() {
        // Intent intent = new Intent(this, MyReceiver.class);
        Intent intent = new Intent("MY_CUSTOM_LITTLE_ACTION");
        sendBroadcast(intent);
    }
}
