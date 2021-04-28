package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;

public class CrearCanchas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_canchas);
    }

    public void guardarCancha(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, ListaCanchas.class);
        startActivity(intent);
    }
}