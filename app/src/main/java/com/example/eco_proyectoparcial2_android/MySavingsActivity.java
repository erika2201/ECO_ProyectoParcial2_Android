package com.example.eco_proyectoparcial2_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MySavingsActivity extends AppCompatActivity {

    private Button addBtn, misahorrosBtn, logoutBtn;
    private ConstraintLayout bg;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_savings);
        auth = FirebaseAuth.getInstance();
        db =FirebaseDatabase.getInstance();
        addBtn = findViewById(R.id.addBtn);
        bg = findViewById(R.id.bg);
        misahorrosBtn = findViewById(R.id.misahorrosBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        //De Init a Create
        addBtn.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, CreateActivity.class);
                    startActivity(i);
                    finish();
                });

        //Cerrar sesion
        logoutBtn.setOnClickListener(
                (v) ->{
                    auth.signOut();
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    finish();
                });
    }
    @Override
    protected void onResume() {
        super.onResume();
        DatabaseReference dbref = db.getReference("users/"+auth.getCurrentUser().getUid()+"/ahorros/");

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            if(snapshot.getValue()==null){
            bg.setBackgroundResource(R.drawable.misahorros);
            }else{
                bg.setBackgroundResource(R.drawable.listaahorros);
            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}