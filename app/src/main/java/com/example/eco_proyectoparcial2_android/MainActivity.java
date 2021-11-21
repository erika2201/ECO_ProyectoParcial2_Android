package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userImput, passwordImput;
    private TextView registerText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerText = findViewById(R.id.registerText);
        loginBtn = findViewById(R.id.loginBtn);


        //De Main a Register
        registerText.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, RegisterActivity.class);
                    startActivity(i);
                });

        //De Main a Init
       loginBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, InitActivity.class);
                    startActivity(i);
                });
    }
}