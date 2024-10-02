package com.example.myapplication10;  // Adjust package name according to your project

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editPoids, editTaille;
    private RadioButton radioMetre, radioCentimetre;
    private CheckBox checkboxMegaFunction;
    private Button buttonCalculer, buttonRaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editPoids = findViewById(R.id.edit_poids);
        editTaille = findViewById(R.id.edit_taille);
        radioMetre = findViewById(R.id.radio_metre);
        radioCentimetre = findViewById(R.id.radio_centimetre);
        checkboxMegaFunction = findViewById(R.id.checkbox_mega_function);
        buttonCalculer = findViewById(R.id.button_calculer);
        buttonRaz = findViewById(R.id.button_raz);

        // Set the 'Calculer l'IMC' button's click listener
        buttonCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculerIMC();
            }
        });

        // Set the 'RAZ' button's click listener
        buttonRaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razForm();
            }
        });
    }

    // Method to calculate the IMC
    private void calculerIMC() {
        String poidsStr = editPoids.getText().toString();
        String tailleStr = editTaille.getText().toString();

        if (poidsStr.isEmpty() || tailleStr.isEmpty()) {
            Toast.makeText(MainActivity.this, "Veuillez entrer le poids et la taille", Toast.LENGTH_LONG).show();
            return;
        }

        // Parse inputs to float
        float poids = Float.parseFloat(poidsStr);
        float taille = Float.parseFloat(tailleStr);

        // Convert height to meters if Centimetre is selected
        if (radioCentimetre.isChecked()) {
            taille = taille / 100;  // Convert to meters
        }

        // Calculate IMC
        float imc = poids / (taille * taille);

        // Adjust calculation if "Mega fonction" is checked
        if (checkboxMegaFunction.isChecked()) {
            imc *= 1.1f;  // Applying an arbitrary factor for the Mega function
        }

        // Send the IMC result to the next activity
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("IMC_VALUE", imc);
        startActivity(intent);
    }

    // Method to reset the form
    private void razForm() {
        editPoids.setText("");
        editTaille.setText("");
        checkboxMegaFunction.setChecked(false);
        radioMetre.setChecked(true);
    }
}
