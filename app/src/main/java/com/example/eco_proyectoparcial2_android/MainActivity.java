package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userImput, passwordImput;
    private TextView registerText;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        //De Main a Init
        loginBtn.setOnClickListener(
                (v) ->{

                    String user = userImput.getText().toString();
                    String password = passwordImput.getText().toString();

                    if(user==null || password==null || user.isEmpty() || password.isEmpty()){
                        Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show(); //mensaje cuando deja algo vacio
                    }else {
                        Intent i = new Intent(this, InitActivity.class);
                        i.putExtra("user", user);
                        i.putExtra("password", password);
                        startActivity(i);
                        finish();
                    }
                });
    }

}