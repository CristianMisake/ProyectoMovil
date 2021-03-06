package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.models.cancha.AdaptadorCancha;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;

import java.util.ArrayList;
import java.util.List;

public class ListaCanchas extends AppCompatActivity {
    public static final String ID_CANCHA = "com.proyecto.admin.IdCancha";
    private ArrayList<Cancha> listadoCanchas = new ArrayList<>();
    private AdaptadorCancha adapter;
    private RecyclerView recycler;

    private CanchaLab nCanchasLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canchas);


        adapter = new AdaptadorCancha(this, listadoCanchas, new AdaptadorCancha.Onclick() {
            @Override
            public void OnEvent(Cancha cancha, int pos) {
                editarBDCancha(cancha);
            }
        }, new AdaptadorCancha.Onclick() {
            @Override
            public void OnEvent(Cancha cancha, int pos) {
                deleteBDCanchas(cancha);
            }
        });

        recycler = findViewById(R.id.recyclerCanchas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        //Carga de la interfaz DAO para la BD
        nCanchasLab = CanchaLab.get(this);
    }

    public void crearCanchas(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, CrearCanchas.class);
        intent.putExtra(ID_CANCHA, "");
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        leerBDCanchas();
        adapter.notifyDataSetChanged(); //Notificar los cambios en el modelo
        Toast.makeText(this,"Listado", Toast.LENGTH_SHORT).show();
    }

    private void leerBDCanchas() {
        listadoCanchas.clear();
        List<Cancha> canchas = nCanchasLab.getCanchas();
        listadoCanchas.addAll(canchas);
    }

    private void deleteBDCanchas(Cancha cancha) {
        nCanchasLab.deleteCancha(cancha.getIdCancha());
        leerBDCanchas();
        adapter.notifyDataSetChanged(); //Notificar los cambios en el modelo
        Toast.makeText(this,"Eliminado: " + cancha.getName(), Toast.LENGTH_SHORT).show();
    }

    public void editarBDCancha(Cancha cancha) {
        Intent intent = new Intent(this, CrearCanchas.class);
        intent.putExtra(ID_CANCHA, cancha.getIdCancha());
        startActivity(intent);
    }
}