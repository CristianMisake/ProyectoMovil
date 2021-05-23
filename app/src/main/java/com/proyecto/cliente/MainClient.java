package com.proyecto.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.R;
import com.proyecto.admin.ListaCanchas;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.vista_principal.Login;

import java.util.List;

public class MainClient extends AppCompatActivity {
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        idUsuario = intent.getStringExtra(Login.ID_USUARIO);
    }

    public void CerrarSesionCliente(View view) {
        finish();
    }

    public void ReservasCliente(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, ListaCanchaCliente.class);
        intent.putExtra(Login.ID_USUARIO, idUsuario);
        startActivity(intent);
    }
    public void goReservaCliente(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, vistaReservaCliente.class);
        intent.putExtra(Login.ID_USUARIO, idUsuario);
        startActivity(intent);
    }

}
