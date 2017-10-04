package com.ajanvier.tp_intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by antoine on 04/10/17.
 */

public class SecondActivity extends AppCompatActivity {

    public static final String TAG_FROM_SECOND = "FROM_SECOND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String editTextValue = getIntent().getStringExtra(MainActivity.TAG_FROM_MAIN);
        EditText editText = (EditText) findViewById(R.id.et);
        editText.setText(editTextValue);

        MessageHolder messageHolder = (MessageHolder) getIntent().getSerializableExtra(MainActivity.TAG_MESSAGE);
        editText.setText(messageHolder.getMessage());

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText1 = (EditText) findViewById(R.id.et);
                String t = editText1.getText().toString();

                Intent intent = new Intent();
                intent.putExtra(TAG_FROM_SECOND, t);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
