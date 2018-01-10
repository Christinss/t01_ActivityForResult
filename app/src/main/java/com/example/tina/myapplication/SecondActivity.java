package com.example.tina.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_OK = "kristina_knezevic.activityforresult.ok";
    public static final String EXTRA_CANCEL = "kristina_knezevic.activityforresult.cancel";
    public static final String EXTRA_BACK =  " kristina_knezevic.activityforresult.back";
    private Button bOk, bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        bOk = (Button) findViewById(R.id.bOk);
        bCancel = (Button) findViewById(R.id.bCancel);
}

    private void setupListeners() {
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(EXTRA_OK, RESULT_OK, "Korisnik je obavio registraciju.");
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(EXTRA_CANCEL, RESULT_CANCELED, "Korisnik je odustao.");
            }
        });

    }
    // overload metode finish
    public void finish(String extraKey, int result, String message) {
        Intent intent = new Intent();
        intent.putExtra(extraKey, message);
        setResult(result, intent);
        super.finish();
    }

    //override metode finish
    @Override
    public void finish() {
        finish(EXTRA_BACK, RESULT_CANCELED, "Back button");
    }
}