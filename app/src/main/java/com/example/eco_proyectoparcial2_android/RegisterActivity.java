package com.example.eco_proyectoparcial2_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameImput, userImput2, passwordImput2;
    private TextView loginText;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameImput = findViewById(R.id.nameImput);
        userImput2 = findViewById(R.id.userImput2);
        passwordImput2 = findViewById(R.id.passwordImput2);
        loginText = findViewById(R.id.loginText);
        registerBtn = findViewById(R.id.registerBtn);

        register();


        //De Register a main (iniciar sesion)
        loginText.setOnClickListener(
                (v) ->{
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    finish();
                });
    }

    public void register(){
        //De Register a init (donde comienza a crear todo)
        registerBtn.setOnClickListener(
                (v) ->{
                    String name = nameImput.getText().toString();
                    String user = userImput2.getText().toString();
                    String password = passwordImput2.getText().toString();

                    if(name==null || user==null || password==null || name.isEmpty() || user.isEmpty() || password.isEmpty()){
                        Toast.makeText(this, "Ingresa todos los datos", Toast.LENGTH_SHORT).show(); //mensaje cuando deja algo vacio
                    }else {
                        Intent i = new Intent(this, MainActivity.class);
                        i.putExtra("name", name);
                        i.putExtra("user2", user);
                        i.putExtra("password2", password);
                        startActivity(i);
                        finish();
                    }
                });
    }
}