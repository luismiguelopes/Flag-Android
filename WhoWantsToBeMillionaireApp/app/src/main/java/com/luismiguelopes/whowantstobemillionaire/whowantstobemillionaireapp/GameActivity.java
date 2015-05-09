package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;


public class GameActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        startService(new Intent(getApplicationContext(), MillionaireService.class));

        TextView txtQuestion = (TextView)findViewById(R.id.txtQuestion);



    }


}




