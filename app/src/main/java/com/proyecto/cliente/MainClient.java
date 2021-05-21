package com.proyecto.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;
import com.proyecto.admin.ListaCanchas;

public class MainClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
    }

    public void CerrarSesionCliente(View view) {
        finish();
    }

    public void ReservasCliente(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, ListaCanchaCliente.class);
        startActivity(intent);
    }
    public void goReservaCliente(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, vistaReservaCliente.class);
        startActivity(intent);
    }

}
