package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;


import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.model.Question;
import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider.MillionaireManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MillionaireService extends IntentService {

    public static final String SERVICE_LOG = "SERVICE_LOG";
    private static final String MILLIONAIRE_QUESTION_ID = "id";
    private static final String MILLIONAIRE_QUESTIONS = "question";
    //public static final String MILLIONAIRE_ANSWERS = "answers";
    //private static final String MILLIONAIRE_RESPONSE = "correct";


    private final MillionaireManager manager;

    public MillionaireService() {
        super("MillionaireService");
        this.manager = new MillionaireManager(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

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

                        int id = c.getInt(MILLIONAIRE_QUESTION_ID);
                        String question = c.getString(MILLIONAIRE_QUESTIONS);


                        manager.save(new Question(id, question));

                        Log.i(SERVICE_LOG, question + " ?");
                    }

                }

                catch (Exception e) {
                    e.printStackTrace();


                }

            }

        }
