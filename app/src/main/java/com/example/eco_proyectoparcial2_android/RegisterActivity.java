package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameImput, userImput2, passwordImput2;
    private TextView loginText;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginText = findViewById(R.id.loginText);


        //De Register a main
        loginText.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                });
    }
}