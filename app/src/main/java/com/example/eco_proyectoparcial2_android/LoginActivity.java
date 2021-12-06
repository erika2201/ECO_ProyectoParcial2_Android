package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText userImput, passwordImput;
    private TextView registerText;
    private Button loginBtn;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        userImput = findViewById(R.id.userImput);
        passwordImput = findViewById(R.id.passwordImput);
        registerText = findViewById(R.id.registerText);
        loginBtn = findViewById(R.id.loginBtn);

        login();

        //De Main a Register
        registerText.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, RegisterActivity.class);
                    startActivity(i);
                    finish();
                });
    }



    public void login(){
        //De login a Init
        loginBtn.setOnClickListener(
                (v) ->{

                    String user = userImput.getText().toString();
                    String password = passwordImput.getText().toString();

                    if(user==null || password==null || user.isEmpty() || password.isEmpty()){
                        Toast.makeText(this, "Por favor, ingresa todos los datos", Toast.LENGTH_SHORT).show(); //mensaje cuando deja algo vacio
                    }else {
                        auth.signInWithEmailAndPassword(user,password)
                                .addOnCompleteListener((task)->{
                                 if(task.isSuccessful()){
                            Intent i = new Intent(this, MySavingsActivity.class);
                        startActivity(i);
                        finish();
                                 }else{
                                     Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                 }
                                });


                    }
                });
    }

}