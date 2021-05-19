package com.proyecto.cliente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;
import com.proyecto.models.reserva.AdaptadoReservaCliente;

import java.util.ArrayList;
import java.util.List;

public class activity_lista_cancha_cliente extends AppCompatActivity {
    private ArrayList<Cancha> listadoCanchasCliente = new ArrayList<>();
    private AdaptadoReservaCliente adapterCliente;
    private RecyclerView recyclerCliente;

    private CanchaLab nCanchasLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservacliente);


        recyclerCliente = findViewById(R.id.recyclerCanchasCliente);
        RecyclerView.LayoutManager layoutManagerCliente = new LinearLayoutManager(getApplicationContext());
        recyclerCliente.setLayoutManager(layoutManagerCliente);
        recyclerCliente.setItemAnimator(new DefaultItemAnimator());
        recyclerCliente.setAdapter(adapterCliente);

        //Carga de la interfaz DAO para la BD
        nCanchasLab = CanchaLab.get(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        leerBDCanchas();
        Toast.makeText(this,"Listado", Toast.LENGTH_SHORT).show();
    }

    private void leerBDCanchas() {
        listadoCanchasCliente.clear();
        List<Cancha> canchas = nCanchasLab.getCanchas();
        listadoCanchasCliente.addAll(canchas);
    }

}