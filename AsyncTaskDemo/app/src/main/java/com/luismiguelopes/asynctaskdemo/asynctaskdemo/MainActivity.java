package com.luismiguelopes.asynctaskdemo.asynctaskdemo;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);

        final TextView txtTemperature = (TextView) findViewById(R.id.txtTemperature);

        findViewById(R.id.btnGet).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                new GetWeather().execute(new Weatherinfo("Lisbon"));


                return true;
            }
        });
    }
    private class GetWeather extends AsyncTask<Weatherinfo, Integer, Weatherinfo> {


        @Override
        protected Weatherinfo doInBackground(Weatherinfo... params) {

            Weatherinfo info = params[0];

            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + info.getCity() + "&mode=json&units=metric");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                String res = "";
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                while ((line = rd.readLine()) != null)
                    res += line;

                JSONObject response = new JSONObject(res);
                double temp = response.getJSONObject("main").getDouble("temp");

                info.setTemp(temp);
                return info;

            }

            catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Weatherinfo info) {


            String txt = (info != null) ? info.getTemp() + " ºC" : " Error ";
            ((TextView) findViewById(R.id.txtTemperature)).setText(info.getTemp() + " ºC");


        }
    }

}
