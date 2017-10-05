package com.ajanvier.tp_final;

import android.os.AsyncTask;
import android.widget.TextView;

/*
 * Created by antoine on 05/10/17.
 */

public class IncrementerTask extends AsyncTask<Long, Long, String> {

    public static final String INCREMENT_IS_FINISH = "Increment is finish";
    TextView textView;

    public IncrementerTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("");
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0].toString());
    }

    @Override
    protected String doInBackground(Long... longs) {
        Long maxValue = longs[0];
        long increment = 0;
        while (increment < maxValue) {
            increment++;
            if (increment % 5000 == 0) {
                publishProgress(increment);
            }
        }
        return INCREMENT_IS_FINISH;
    }
}
