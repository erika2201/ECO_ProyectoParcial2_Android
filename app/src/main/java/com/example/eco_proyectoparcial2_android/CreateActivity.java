package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CreateActivity extends AppCompatActivity {

    private Button createBtn, misahorrosBtn2, logoutBtn2,dailyBtn,weeklyBtn,monthlyBtn;
    private String freq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        freq = "";
        createBtn = findViewById(R.id.createBtn);
        misahorrosBtn2 = findViewById(R.id.misahorrosBtn2);
        logoutBtn2 = findViewById(R.id.logoutBtn2);
        dailyBtn = findViewById(R.id.dailyBtn);
        weeklyBtn = findViewById(R.id.weeklyBtn);
        monthlyBtn = findViewById(R.id.monthlyBtn);
    savingFrequency();
        //De Create a ListaAhorros
        createBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingsActivity.class);
                    startActivity(i);
                    finish();
                });

        //De Create a my saving (la lista beia de ahorros)
        misahorrosBtn2.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingsActivity.class);
                    startActivity(i);
                    finish();
                });


    }
    //Cambio de color en los botones
    public void savingFrequency(){
dailyBtn.setOnClickListener((v) ->{
    dailyBtn.setBackgroundResource(R.drawable.activebtn);
    weeklyBtn.setBackgroundResource(R.drawable.noactivebtn);
    monthlyBtn.setBackgroundResource(R.drawable.noactivebtn);
    freq="daily";
        });
        weeklyBtn.setOnClickListener((v) ->{
            dailyBtn.setBackgroundResource(R.drawable.noactivebtn);
            weeklyBtn.setBackgroundResource(R.drawable.activebtn);
            monthlyBtn.setBackgroundResource(R.drawable.noactivebtn);
            freq="weekly";
        });
        monthlyBtn.setOnClickListener((v) ->{
            dailyBtn.setBackgroundResource(R.drawable.noactivebtn);
            weeklyBtn.setBackgroundResource(R.drawable.noactivebtn);
            monthlyBtn.setBackgroundResource(R.drawable.activebtn);
            freq="monthly";
        });
    }
}