package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameImput, userImput2, passwordImput2;
    private TextView loginText;
    private Button registerBtn;
    private FirebaseDatabase db;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        nameImput = findViewById(R.id.nameImput);
        userImput2 = findViewById(R.id.userImput2);
        passwordImput2 = findViewById(R.id.passwordImput2);
        loginText = findViewById(R.id.loginText);
        registerBtn = findViewById(R.id.registerBtn);

        register();


        //De Register a main (iniciar sesion)
        loginText.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    finish();
                });
    }

    public void register(){
        //De Register a init (donde comienza a crear el ahorrito)
        registerBtn.setOnClickListener(
                (v) ->{
                    String name = nameImput.getText().toString();
                    String user = userImput2.getText().toString();
                    String password = passwordImput2.getText().toString();
                    if(name==null || user==null || password==null || name.isEmpty() || user.isEmpty() || password.isEmpty()){
                        Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show(); //mensaje cuando deja algo vacio
                    }else{
                        auth.createUserWithEmailAndPassword(user,password)
                                .addOnCompleteListener((task) ->{
                                    if(task.isSuccessful()){
                                        String id = task.getResult().getUser().getUid();
                                        String id2 = auth.getCurrentUser().getUid();
                                        User u = new User(
                                                id,
                                                name,
                                                user,
                                                password
                                        );
                                        DatabaseReference dbRef = db.getReference("users/"+id);
                                        dbRef.setValue(u).addOnCompleteListener((task2) -> {
                                            if(task2.isSuccessful()){
                                                Intent i = new Intent(this, MySavingsActivity.class);
                                                startActivity(i);
                                                finish();
                                            }

                                        });
                                    }else {
                                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                });
                    }


                });
    }
}