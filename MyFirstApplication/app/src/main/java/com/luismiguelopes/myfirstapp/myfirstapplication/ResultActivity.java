package com.luismiguelopes.myfirstapp.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends ActionBarActivity {

    public static final String NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        final EditText txtName = (EditText) findViewById(R.id.txtName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txtName.getText().toString();
                Intent intent = getIntent();
                intent.putExtra(NAME, text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
