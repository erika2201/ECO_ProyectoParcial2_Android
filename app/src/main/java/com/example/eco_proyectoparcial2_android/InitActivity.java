package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InitActivity extends AppCompatActivity {

    private Button addBtn, misahorrosBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        addBtn = findViewById(R.id.addBtn);

        //De Init a Create
        addBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, CreateActivity.class);
                    startActivity(i);
                    finish();
                });
    }
}