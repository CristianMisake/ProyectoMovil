package com.proyecto.vista_principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;
import com.proyecto.admin.MainAdmin;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void enviarAdmin(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, MainAdmin.class);
        startActivity(intent);
    }

    public void enviarRegistro(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, RegistroPrincipal.class);
        startActivity(intent);
    }
}