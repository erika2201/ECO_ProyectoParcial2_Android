package com.example.eco_proyectoparcial2_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddMoneyActivity extends AppCompatActivity {

    private Button logoutBtn4,accepBtn,misahorrosBtn3,addBtn3;
    private TextView nameSaving,cantText,dateText;
    private EditText addCantImput;
    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        nameSaving = findViewById(R.id.nameSaving);
        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        cantText = findViewById(R.id.cantText);
        dateText = findViewById(R.id.dateText);
        addCantImput = findViewById(R.id.addCantImput);
        accepBtn = findViewById(R.id.accepBtn);
        logoutBtn4 = findViewById(R.id.logoutBtn4);
        misahorrosBtn3 = findViewById(R.id.misahorrosBtn3);
        addBtn3 = findViewById(R.id.addBtn3);


        String savename = getIntent().getExtras().getString("name");
        String savecant = getIntent().getExtras().getString("cant");
        String savedate = getIntent().getExtras().getString("date");
        nameSaving.setText(savename);
        cantText.setText(savecant);
        dateText.setText(savedate);
        addProgress();

        //De Add Money a Create
        addBtn3.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, CreateActivity.class);
                    startActivity(i);
                    finish();
                });

        //Cerrar sesion
        logoutBtn4.setOnClickListener(
                (v) ->{
                    auth.signOut();
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    finish();
                });
        //De Add Money a my savings (la lista beia de ahorros)
        misahorrosBtn3.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MySavingsActivity.class);
                    startActivity(i);
                    finish();
                });
    }

    private void addProgress() {
        accepBtn.setOnClickListener(
                (v)->{

                    String savename = getIntent().getExtras().getString("name");
                    DatabaseReference dbRef = db.getReference("users/"+auth.getCurrentUser().getUid()+"/ahorros/"+savename+"/progress");
    dbRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DataSnapshot> task) {
            if (task.isSuccessful()) {
              Long p = (Long) task.getResult().getValue();
              setProgressValue(p);
            }

        }
    });

                });
    }

    private void setProgressValue(Long p) {
        int progress = Integer.parseInt(addCantImput.getText().toString());
        String savename = getIntent().getExtras().getString("name");
        DatabaseReference dbRef = db.getReference("users/"+auth.getCurrentUser().getUid()+"/ahorros/"+savename+"/progress");
        dbRef.setValue(p+progress).addOnCompleteListener((task) ->{
            if(task.isSuccessful()){
                Intent i = new Intent(AddMoneyActivity.this, MySavingsActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}