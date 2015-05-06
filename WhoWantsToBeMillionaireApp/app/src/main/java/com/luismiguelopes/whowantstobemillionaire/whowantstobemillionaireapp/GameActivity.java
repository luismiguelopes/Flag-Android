package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        startService(new Intent(getApplicationContext(), MillionaireService.class));

    }



}
