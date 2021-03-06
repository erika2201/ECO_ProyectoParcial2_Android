package com.example.eco_proyectoparcial2_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MySavingsActivity extends AppCompatActivity {

    private Button addBtn, misahorrosBtn, logoutBtn;
    private ConstraintLayout bg;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private ListView list;
    private ArrayList<Saving>savings;
    private AdapterSaving adapter;

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

        list = findViewById(R.id.list);
        savings = new ArrayList<Saving>();

        adapter = new AdapterSaving(this, savings);
        list.setAdapter(adapter);

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
                loadSaving();
            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    protected void loadSaving(){
        DatabaseReference dbref = db.getReference("users/"+auth.getCurrentUser().getUid()+"/ahorros/");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot savings) {
               currentList(savings);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MySavingsActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void currentList(DataSnapshot savings){
        this.savings.clear();
        for(DataSnapshot child : savings.getChildren()){
            Saving saving = child.getValue(Saving.class);
            this.savings.add(saving);
        }
        adapter.notifyDataSetChanged();
    }
}