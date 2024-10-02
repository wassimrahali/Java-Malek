package com.example.myapplication;  // Adjust package name according to your app

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize TextView
        textResult = findViewById(R.id.text_result);

        // Get data from Intent
        String resultData = getIntent().getStringExtra("resultData");

        // Display the result
        textResult.setText(resultData);
    }
}
