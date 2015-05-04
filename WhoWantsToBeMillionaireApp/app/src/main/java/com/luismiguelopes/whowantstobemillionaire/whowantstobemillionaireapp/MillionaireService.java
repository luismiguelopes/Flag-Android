package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MillionaireService extends IntentService {

    public static final String SERVICE_LOG = "SERVICE_LOG";
    private static final String MILLIONAIRE_ID = "id";
    private static final String MILLIONAIRE_QUESTIONS = "question";
    public static final String MILLIONAIRE_ANSWERS = "answers";
    private static final String MILLIONAIRE_RESPONSE = "correct";



    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {



    /* Created a new thread, 'cause the services run in main thread */

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL("http://54.187.166.51:81/questions");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    String res = "";

                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = "";
                    while ((line = rd.readLine()) != null)
                        res += line;

                    JSONArray response = new JSONArray(res);


                    for (int i = 0; i < response.length(); i++) {
                        JSONObject c = response.getJSONObject(i);

                        String answers = c.getString(MILLIONAIRE_ANSWERS);

                    }


                    manager.save(new Answers(answers));






                }

                catch (Exception e) {
                    e.printStackTrace();


                }

            }
        }).start();

        return START_NOT_STICKY;



    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
