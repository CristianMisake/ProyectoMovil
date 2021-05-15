package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.R;

public class CrearCanchas extends AppCompatActivity {
    private CanchasLab nCanchasLab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_canchas);

        nCanchasLab = CanchasLab.get(this);
    }

    public void guardarCancha(View view) {
        //
        EditText editNombre = findViewById(R.id.editNombre);
        EditText editHorario = findViewById(R.id.editHorario);
        EditText editDireccion = findViewById(R.id.editDireccion);
        EditText editDescripcion = findViewById(R.id.editDescripcion);
        EditText editPrice = findViewById(R.id.editPrice);
        //
        String nombre = editNombre.getText().toString();
        String horario = editHorario.getText().toString();
        String direccion = editDireccion.getText().toString();
        String descripcion = editDescripcion.getText().toString();
        long price = Long.parseLong(editPrice.getText().toString());
        //
        insertCanchaBD(nombre, direccion, price, descripcion, R.drawable.balon, horario);
    }

    private void insertCanchaBD(String name, String address, long price, String description, int urlImg, String schedule) {
        Cancha nuevaCancha = new Cancha(name, address, price, description, urlImg, schedule);
        nCanchasLab.addCancha(nuevaCancha);
        Toast.makeText(this,"Guardado", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}