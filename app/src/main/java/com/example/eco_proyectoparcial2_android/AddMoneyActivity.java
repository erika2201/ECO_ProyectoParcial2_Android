package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AddMoneyActivity extends AppCompatActivity {

    private Button logoutBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        logoutBtn4 = findViewById(R.id.logoutBtn4);
    }
}