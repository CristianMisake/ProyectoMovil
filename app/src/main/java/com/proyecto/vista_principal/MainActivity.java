package com.proyecto.vista_principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarLogin(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}