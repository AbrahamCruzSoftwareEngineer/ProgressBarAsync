package com.evolutiondso.www.multithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MyTag" ;
    private TextView textView;
    private ProgressBar progresBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txtview);
        progresBar = (ProgressBar) findViewById(R.id.progbar);
        Log.d(TAG,"OnCreate: " + Thread.currentThread());

//        DaniTask danitask = new DaniTask();
//        danitask.execute();
    }

    public void arribaChivas(View view) {
        Log.d(TAG,"arribaChivas: " + "Just Kidding");

    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            Log.d(TAG,"OnCreate: " + Thread.currentThread());


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String date = (new Date()).toString();
                    textView.setText(date);
                }
            });

        }
    }

    public void doMagic(View view) {
//        MyThread myThread = new MyThread();
//        myThread.start();
        DaniTask danitask = new DaniTask(textView,progresBar);
        danitask.execute();

//        for (int i = 0; i < 25; i++) {
//            Log.d(TAG,"progress: " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }


}
