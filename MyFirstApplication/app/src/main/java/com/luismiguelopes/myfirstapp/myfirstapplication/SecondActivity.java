package com.luismiguelopes.myfirstapp.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {


    public static final String COUNTER_VALUE_KEY_EXTRA = "COUNTER_VALUE_KEY" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String counter = getIntent().getStringExtra(COUNTER_VALUE_KEY_EXTRA);
        ((TextView)findViewById(R.id.txtCounterResult)).setText(counter);
    }


}
