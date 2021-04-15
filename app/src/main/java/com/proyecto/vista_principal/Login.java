package com.proyecto.vista_principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void enviarRegistro(View view) {
        //Invocar a la actividad registro
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}

