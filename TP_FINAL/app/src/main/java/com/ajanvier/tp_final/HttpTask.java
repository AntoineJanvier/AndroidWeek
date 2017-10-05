package com.ajanvier.tp_final;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Created by antoine on 05/10/17.
 */

public class HttpTask extends AsyncTask<String, Long, String> {

    TextView textView;

    public HttpTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText("Read : " + values[0].toString() + " characters");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    @Override
    protected String doInBackground(String... strings) {

        String valueToReturn = "";

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // Config
            httpURLConnection.setConnectTimeout(1500);
            httpURLConnection.setReadTimeout(1500);
            httpURLConnection.setRequestMethod("GET");

            // Connect
            httpURLConnection.connect();

            // Status
            int statusCode = httpURLConnection.getResponseCode();

            // Body
            InputStream inputStream = httpURLConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                valueToReturn += line + "\n";
                publishProgress((long) valueToReturn.length());
            }

            inputStreamReader.close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            valueToReturn = e.getLocalizedMessage();
        }

        return valueToReturn;
    }
}
