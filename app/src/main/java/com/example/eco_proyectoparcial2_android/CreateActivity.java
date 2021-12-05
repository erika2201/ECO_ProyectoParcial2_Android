package com.example.eco_proyectoparcial2_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateActivity extends AppCompatActivity {

    private Button createBtn, misahorrosBtn2, logoutBtn2,dailyBtn,weeklyBtn,monthlyBtn;
    private EditText goalName, cantInput, dateInput;
    private String freq;
    private FirebaseDatabase db;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createBtn = findViewById(R.id.createBtn);
        misahorrosBtn2 = findViewById(R.id.misahorrosBtn2);
        logoutBtn2 = findViewById(R.id.logoutBtn2);
        dailyBtn = findViewById(R.id.dailyBtn);
        weeklyBtn = findViewById(R.id.weeklyBtn);
        monthlyBtn = findViewById(R.id.monthlyBtn);
        goalName = findViewById(R.id.goalName);
        cantInput = findViewById(R.id.cantInput);
        dateInput = findViewById(R.id.dateInput);
        freq = "";

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        savingFrequency();
        createSaving();

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

    //Crear el ahorro
    public void createSaving(){
        //De Create a ListaAhorros
        createBtn.setOnClickListener(
                (v) ->{
                    String saveName = goalName.getText().toString();
                    String saveCant = cantInput.getText().toString();
                    String saveDate = dateInput.getText().toString();
                    DatabaseReference dbRef = db.getReference("users/"+auth.getCurrentUser().getUid()+"/ahorros/"+saveName);
                   dbRef.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           Saving s = snapshot.getValue(Saving.class);
                           if(s!=null){
                               Toast.makeText(CreateActivity.this, "Ya existe un ahorro con ese nombre", Toast.LENGTH_SHORT).show();
                           }else{
                              Saving s1 = new Saving(saveName,saveCant,saveDate,freq);
                              dbRef.setValue(s1).addOnCompleteListener((task) -> {
                                  if(task.isSuccessful()){
                                      Intent i = new Intent(CreateActivity.this, MySavingsActivity.class);
                                      startActivity(i);
                                      finish();
                                  }

                                      });
                           }
                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                       }
                   });





                });
    }
}