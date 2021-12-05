package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class InitActivity extends AppCompatActivity {

    private Button addBtn, misahorrosBtn, logoutBtn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        auth = FirebaseAuth.getInstance();
        addBtn = findViewById(R.id.addBtn);
        misahorrosBtn = findViewById(R.id.misahorrosBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        //De Init a Create
        addBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, CreateActivity.class);
                    startActivity(i);
                    finish();
                });

        //De Init a my saving (la lista beia de ahorros)
        misahorrosBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingActivity.class);
                    startActivity(i);
                    finish();
                });

        //Cerrar sesion
        logoutBtn.setOnClickListener(
                (v) ->{
                    auth.signOut();
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                });
    }
}