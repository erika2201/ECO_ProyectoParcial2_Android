package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MySavingActivity extends AppCompatActivity {

    private Button logoutBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_saving);

        logoutBtn3 = findViewById(R.id.logoutBtn3);
    }
}