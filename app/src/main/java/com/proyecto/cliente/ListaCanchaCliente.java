package com.proyecto.cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.admin.CrearCanchas;
import com.proyecto.models.cancha.AdaptadorCancha;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;
import com.proyecto.models.reserva.AdaptadorCliente;
import com.proyecto.models.reserva.ReservaCancha;
import com.proyecto.models.reserva.ReservaLab;
import com.proyecto.vista_principal.Login;

import java.util.ArrayList;
import java.util.List;

public class ListaCanchaCliente extends AppCompatActivity {
    public static final String ID_RESERVA = "com.proyecto.client.idReserva";
    public static final String ID_CANCHA = "com.proyecto.client.idCancha";
    private ArrayList<Cancha> listadoCanchasCliente = new ArrayList<>();
    private AdaptadorCliente adapterCliente;
    private RecyclerView recyclerCliente;

    private CanchaLab nCanchasLab;
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cancha_cliente);

        adapterCliente = new AdaptadorCliente(this, listadoCanchasCliente, new AdaptadorCliente.Onclick(){
            @Override
            public void OnEvent(Cancha canchaC, int posC) {
                reservadoBDCanchas(canchaC);
            }
        });

        recyclerCliente = findViewById(R.id.recyclerCanchasCliente);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerCliente.setLayoutManager(layoutManager);
        recyclerCliente.setItemAnimator(new DefaultItemAnimator());
        recyclerCliente.setAdapter(adapterCliente);

        //Carga de la interfaz DAO para la BD
        nCanchasLab = CanchaLab.get(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        idUsuario = intent.getStringExtra(Login.ID_USUARIO);
        leerBDCanchas();
        Toast.makeText(this,"Listado", Toast.LENGTH_SHORT).show();
    }

    private void leerBDCanchas() {
        listadoCanchasCliente.clear();
        List<Cancha> canchas = nCanchasLab.getCanchas();
        listadoCanchasCliente.addAll(canchas);
    }

    private void reservadoBDCanchas(Cancha cancha) {
        Intent intent = new Intent(this, vistaReservaCliente.class);
        intent.putExtra(ID_CANCHA, cancha.getIdCancha());
        intent.putExtra(Login.ID_USUARIO, idUsuario);
        startActivity(intent);
    }

}