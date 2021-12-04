package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity {

    private Button createBtn, misahorrosBtn2, logoutBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createBtn = findViewById(R.id.createBtn);
        misahorrosBtn2 = findViewById(R.id.misahorrosBtn2);
        logoutBtn2 = findViewById(R.id.logoutBtn2);

        //De Create a ListaAhorros
        createBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingActivity.class);
                    startActivity(i);
                    finish();
                });

        //De Create a my saving (la lista beia de ahorros)
        misahorrosBtn2.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingActivity.class);
                    startActivity(i);
                    finish();
                });
    }
}