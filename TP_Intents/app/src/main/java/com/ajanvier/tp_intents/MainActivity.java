package com.ajanvier.tp_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG_FROM_MAIN = "FROM_MAIN";
    public static final int REQUEST_CODE_FOR_SECOND = 10;
    public static final String TAG_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_main).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.et1);
        String text = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(TAG_FROM_MAIN, text);
        intent.putExtra(TAG_MESSAGE, new MessageHolder(text));
        startActivityForResult(intent, REQUEST_CODE_FOR_SECOND);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_FOR_SECOND && RESULT_OK == resultCode) {
            String text = data.getStringExtra(SecondActivity.TAG_FROM_SECOND);
            EditText editText = (EditText) findViewById(R.id.et1);
            editText.setText(text);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
