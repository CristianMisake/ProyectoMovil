package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;
import com.proyecto.models.registro.RegistroLab;
import com.proyecto.models.reserva.AdaptadorReserva;
import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.reserva.ReservaCancha;
import com.proyecto.models.reserva.ReservaCanchaTest;
import com.proyecto.models.reserva.ReservaLab;
import com.proyecto.models.usuario.UsuarioLab;

import java.util.ArrayList;
import java.util.List;

public class ReservasPendientes extends AppCompatActivity {
    private ArrayList<ReservaCancha> listadoReservas = new ArrayList<>();
    private AdaptadorReserva adapter;
    private RecyclerView recycler;

    private ReservaLab nReservaLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_pendientes);


        adapter = new AdaptadorReserva(this, listadoReservas,
                new AdaptadorReserva.Onclick() {
            @Override
            public void OnEvent(ReservaCancha reservaCancha, int pos) {
                acceptBDReserva(reservaCancha);
            }
        }, new AdaptadorReserva.Onclick() {
            @Override
            public void OnEvent(ReservaCancha reservaCancha, int pos) {
                rejectBDReserva(reservaCancha);
            }
        });
        recycler = findViewById(R.id.recyclerPendientes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        //Carga de la interfaz DAO para la BD
        nReservaLab = ReservaLab.get(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        leerBDReservas();
        adapter.notifyDataSetChanged(); //Notificar los cambios en el modelo
        Toast.makeText(this,"Listado", Toast.LENGTH_SHORT).show();
    }

    private void leerBDReservas() {
        listadoReservas.clear();
        List<ReservaCancha> reservas = nReservaLab.getReservas();
        List<Reserva> reservas2 = nReservaLab.getReservasTest();

        if (reservas2.size() > 0) {
            Toast.makeText(this,"Miau: " + reservas2.size(), Toast.LENGTH_SHORT).show();
        }
        listadoReservas.addAll(reservas);
    }

    private void acceptBDReserva(ReservaCancha reservaCancha) {
        nReservaLab.acceptReserva(reservaCancha.getIdReserva());
        leerBDReservas();
        adapter.notifyDataSetChanged(); //Notificar los cambios en el modelo
        Toast.makeText(this,"Aceptado: " + reservaCancha.getNombre(), Toast.LENGTH_SHORT).show();
    }

    public void rejectBDReserva(ReservaCancha reservaCancha) {
        nReservaLab.rejectReserva(reservaCancha.getIdReserva());
        leerBDReservas();
        adapter.notifyDataSetChanged(); //Notificar los cambios en el modelo
        Toast.makeText(this,"Rechazado: " + reservaCancha.getNombre(), Toast.LENGTH_SHORT).show();
    }
}