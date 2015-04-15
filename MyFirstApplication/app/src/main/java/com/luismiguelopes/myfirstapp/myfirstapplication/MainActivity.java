package com.luismiguelopes.myfirstapp.myfirstapplication;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    private final static String LOG_TAG = "LOG_TAG";
    private TextView txtCounter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(LOG_TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = (TextView) findViewById(R.id.txtCounter);
        txtCounter.setText("0");

        Button btnIncr = (Button) findViewById(R.id.btnIncr);
        btnIncr.setOnClickListener(this);

        Button btnDecr = (Button) findViewById(R.id.btnDecr);
        btnDecr.setOnClickListener(this);

        Button show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);




        /*
        Button btnIncr = (Button) findViewById(R.id.btnIncr);
        btnIncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(txtCounter.getText().toString());
                txtCounter.setText((current + 1) + "");
            }
        });

        Button btnDecr = (Button) findViewById(R.id.btnDecr);
        btnDecr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(txtCounter.getText().toString());
                txtCounter.setText((current - 1) + "");
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnIncr) {
            int current = Integer.parseInt(txtCounter.getText().toString());
            txtCounter.setText((current + 1) + "");
        }
        if (v.getId() == R.id.btnDecr) {
            int current = Integer.parseInt(txtCounter.getText().toString());
            txtCounter.setText((current - 1) + "");
        }
        if (v.getId() == R.id.show) {
            Context context = getApplicationContext();
            CharSequence text = txtCounter.getText();
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, text, duration).show();
        }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(LOG_TAG, "onSaveInstanceState");

        outState.putString("COUNTER_VALUE", txtCounter.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(LOG_TAG, "onRestoreInstanceState");
        txtCounter.setText(savedInstanceState.getString("COUNTER_VALUE"));
    }

    @Override
    protected void onStart() {

        Log.d(LOG_TAG,"onStart");

        super.onStart();
    }

    @Override
    protected void onResume() {

        Log.d(LOG_TAG,"onResume");

        super.onResume();
    }

    @Override
    protected void onStop() {

        Log.d(LOG_TAG,"onStop");

        super.onStop();
    }

    @Override
    protected void onRestart() {

        Log.d(LOG_TAG,"onRestart");

        super.onRestart();
    }

    @Override
    protected void onDestroy() {

        Log.d(LOG_TAG,"onDestroy");

        super.onDestroy();
    }
}
