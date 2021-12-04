package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity {

    private Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createBtn = findViewById(R.id.createBtn);

        //De Create a ListaAhorros
        createBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingActivity.class);
                    startActivity(i);
                    finish();
                });
    }
}