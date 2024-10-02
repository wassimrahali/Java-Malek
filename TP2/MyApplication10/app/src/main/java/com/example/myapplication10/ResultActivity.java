package com.example.myapplication10;  // Adjust package name according to your project

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView textResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textResultat = findViewById(R.id.text_resultat);

        // Get the IMC value from the Intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            float imc = extras.getFloat("IMC_VALUE");
            // Display the IMC result
            textResultat.setText(String.format("Votre IMC est %.2f", imc));
        }
    }
}
