package com.ajanvier.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String NB_CLICK = "nbClick";
    public static final String TP = "TP ";
    int nbClick = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TP, "A -> onSaveInstanceState");
        outState.putInt(NB_CLICK, nbClick);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TP ", "A -> onCreate");
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String carrierName = manager.getNetworkOperatorName();
        ((TextView) findViewById(R.id.tv)).setText(carrierName);

//        if (savedInstanceState != null) {
//            ((TextView) findViewById(R.id.tv)).setText(savedInstanceState.getInt("nbClick", 0));
//        }

        findViewById(R.id.buttonOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });

    }

    public void goToSecondActivity() {
        nbClick++;
        Intent next = new Intent(MainActivity.this, Activity2.class);
        startActivity(next);
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
