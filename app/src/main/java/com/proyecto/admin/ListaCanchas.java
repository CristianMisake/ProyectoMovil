package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.proyecto.R;

import java.util.ArrayList;

public class ListaCanchas extends AppCompatActivity {

    private ListView listViewCancha;
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canchas);

        listViewCancha = (ListView) findViewById(R.id.listViewCancha);

        adaptador = new Adaptador(this, GetCanchas());
        listViewCancha.setAdapter(adaptador);
    }

    public void crearCanchas(View view) {
        //Invocar a la tercera actividad
        Intent intent = new Intent(this, CrearCanchas.class);
        startActivity(intent);
    }

    private ArrayList<Cancha> GetCanchas() {
        //buscar canchas
        ArrayList<Cancha> canchas = new ArrayList<>();
        canchas.add(new Cancha("Tiburon",120000,"Hola mundo",R.drawable.balon,"12:00 PM - 10:00 PM"));
        canchas.add(new Cancha("Cancha 2",6000,"Hola mundo",R.drawable.cancha,"12:00 PM - 10:00 PM"));

        return canchas;
    }
}