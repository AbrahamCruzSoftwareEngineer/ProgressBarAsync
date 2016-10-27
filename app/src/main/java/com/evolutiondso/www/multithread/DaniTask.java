package com.evolutiondso.www.multithread;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Albrtx on 27/10/2016.
 */

public class DaniTask extends AsyncTask<Void, Integer, Void>{
    private static final String TAG = "DaniTaskTAG_";

    private TextView textView;
    private ProgressBar progressBar;


    public DaniTask(TextView textView, ProgressBar progresBar) {
        this.textView = textView;
        this.progressBar = progresBar;
    }

    @Override
    protected Void doInBackground(Void... voids) {
//        publishProgress();
        Log.d(TAG,"doInBackground: " + Thread.currentThread());
//        publishProgress();

        for (int i = 0; i < 25; i++) {
            Log.d(TAG,"progress: " + i);
            publishProgress(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d(TAG,"onPostExecute: " + Thread.currentThread());

        String date = (new Date()).toString();
        textView.setText(date);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG,"onPreExwcute: " + Thread.currentThread());

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG,"onProgressUpdate: " + Thread.currentThread());
        textView.setText(values[0] + "");
        progressBar.setProgress(values[0]);
    }


}
