package com.ajanvier.tp_final;

import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by antoine on 05/10/17.
 */

public class BetterHttpTask extends AsyncTask<String, Long, Post[]> {

    TextView textView;

    public BetterHttpTask(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
        textView.setText("Read : " + values[0].toString() + " characters");
    }

    @Override
    protected void onPostExecute(Post[] s) {
        super.onPostExecute(s);
        textView.setText(s[0].toString());
    }

    @Override
    protected Post[] doInBackground(String... strings) {

        Post[] valueToReturn = null;

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
            valueToReturn = new Gson().fromJson(inputStreamReader, Post[].class);

            inputStreamReader.close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valueToReturn;
    }
}
