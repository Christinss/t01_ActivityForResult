package com.example.tina.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    private Button bStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            bStart = findViewById(R.id.bStart);

            bStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivityForResult(intent,REQUEST_CODE);
                }
            });

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            //super.onActivityResult(requestCode, resultCode, data);

            String extraKey = null;

            if (requestCode == REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    extraKey = SecondActivity.EXTRA_OK;
                }
                if (resultCode == RESULT_CANCELED) {
                    if (data.hasExtra(SecondActivity.EXTRA_CANCEL)) {
                        extraKey = SecondActivity.EXTRA_CANCEL;
                    }
                    if (data.hasExtra(SecondActivity.EXTRA_BACK)) {
                        extraKey = SecondActivity.EXTRA_BACK;
                    }

                }
                if (extraKey != null) {

                    String returningString = data.getStringExtra(extraKey);
                    Toast.makeText(this, "Povratak u MA: " + returningString, Toast.LENGTH_LONG).show();
                }
    }
}
}
