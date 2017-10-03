package com.ajanvier.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Log.i("TP ", "B -> onCreate");

        Button button = (Button) findViewById(R.id.buttonClose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TP ", "B -> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TP ", "B -> onResume");
    }

    @Override
    protected void onPause() {
        Log.i("TP ", "B -> onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("TP ", "B -> onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("TP ", "B -> onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TP ", "B -> onRestart");
    }
}
