package com.ajanvier.tp_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);

//        IncrementerTask incrementerTask = new IncrementerTask(textView);
//        incrementerTask.execute(50000000000000000L);

//        HttpTask httpTask = new HttpTask(textView);
//        httpTask.execute("http://jsonplaceholder.typicode.com/posts");

        BetterHttpTask betterHttpTask = new BetterHttpTask(textView);
        betterHttpTask.execute("http://jsonplaceholder.typicode.com/posts");
    }
}
