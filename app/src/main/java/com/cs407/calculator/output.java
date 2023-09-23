package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class output extends AppCompatActivity {
    TextView outTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        outTextView = findViewById(R.id.outTextView);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        if (result != null) {
            outTextView.setText("Result: " + result);
        } else {
            outTextView.setText("No result available.");
        }
    }
}