package com.ajanvier.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TP ", "A -> onCreate");

        Button button = (Button) findViewById(R.id.buttonOpen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this, Activity2.class);
                startActivity(next);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TP ", "A -> onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TP ", "A -> onResume");
    }

    @Override
    protected void onPause() {
        Log.i("TP ", "A -> onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("TP ", "A -> onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("TP ", "A -> onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TP ", "A -> onRestart");
    }
}
