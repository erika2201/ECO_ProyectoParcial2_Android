package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddMoneyActivity extends AppCompatActivity {

    private Button logoutBtn4,accepBtn,misahorrosBtn3;
    private TextView nameSaving,cantText,dateText;
    private EditText addCantImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        nameSaving = findViewById(R.id.nameSaving);
        cantText = findViewById(R.id.cantText);
        dateText = findViewById(R.id.dateText);
        addCantImput = findViewById(R.id.addCantImput);
        accepBtn = findViewById(R.id.accepBtn);
        logoutBtn4 = findViewById(R.id.logoutBtn4);
        misahorrosBtn3 = findViewById(R.id.misahorrosBtn3);


        String savename = getIntent().getExtras().getString("name");
        String savecant = getIntent().getExtras().getString("cant");
        String savedate = getIntent().getExtras().getString("date");
        nameSaving.setText(savename);
        cantText.setText(savecant);
        dateText.setText(savedate);
    }
}