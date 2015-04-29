package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Button to View in Order to go to the GameActivity
        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToOpenGameActivity = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(intentToOpenGameActivity);
            }
        });

        // Add Button to View in order to go to the SettingsActivity
        Button btnSettings = (Button) findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToOpenSettingsActivity = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intentToOpenSettingsActivity);
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
