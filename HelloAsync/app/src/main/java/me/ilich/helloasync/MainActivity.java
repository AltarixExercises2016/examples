package me.ilich.helloasync;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyTask task = new MyTask(this);
        //MyWeakTask task = new MyWeakTask(this);
        //task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        startService(new Intent(this, MyService.class));
    }

    static class MyTask extends AsyncTask<Void, Void, Void> {

        private final Context context;

        MyTask(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v("Sokolov", "A " + i + " " + context);
            }
            return null;
        }
    }

    static class MyWeakTask extends AsyncTask<Void, Void, Void> {

        private final WeakReference<Context> ref;

        MyWeakTask(Context context) {
            this.ref = new WeakReference<Context>(context);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.v("Sokolov", "A " + i + " " + ref.get());
            }
            return null;
        }
    }

}
