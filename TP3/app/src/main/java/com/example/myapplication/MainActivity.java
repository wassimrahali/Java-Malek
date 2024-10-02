package com.example.myapplication;  // Adjust package name according to your app

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioMale, radioFemale;
    private CheckBox checkboxC, checkboxJava, checkboxCOBOL, checkboxPerl;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);
        checkboxC = findViewById(R.id.checkbox_c);
        checkboxJava = findViewById(R.id.checkbox_java);
        checkboxCOBOL = findViewById(R.id.checkbox_cobol);
        checkboxPerl = findViewById(R.id.checkbox_perl);
        buttonSubmit = findViewById(R.id.button_submit);

        // Set button click listener
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();

                // Check selected gender
                if (radioMale.isChecked()) {
                    result.append("Sexe: Masculin\n");
                } else if (radioFemale.isChecked()) {
                    result.append("Sexe: Feminin\n");
                }

                // Check selected languages
                result.append("Langages maîtrisés: ");
                if (checkboxC.isChecked()) {
                    result.append("C ");
                }
                if (checkboxJava.isChecked()) {
                    result.append("Java ");
                }
                if (checkboxCOBOL.isChecked()) {
                    result.append("COBOL ");
                }
                if (checkboxPerl.isChecked()) {
                    result.append("Perl ");
                }

                // Pass data to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("resultData", result.toString());
                startActivity(intent);
            }
        });
    }
}
