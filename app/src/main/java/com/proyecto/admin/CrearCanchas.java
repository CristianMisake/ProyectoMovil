package com.proyecto.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.R;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;

import java.util.List;

public class CrearCanchas extends AppCompatActivity {
    private CanchaLab nCanchasLab;
    private String idCancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_canchas);
        nCanchasLab = CanchaLab.get(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        idCancha = intent.getStringExtra(ListaCanchas.ID_CANCHA);

        if (!idCancha.isEmpty()) {
            List<Cancha> cancha = nCanchasLab.getCanchaById(idCancha);
            cargarCancha(cancha.get(0));
        }
    }

    public void cargarCancha(Cancha cancha) {
        EditText editNombre = findViewById(R.id.editNombre);
        EditText editHorario = findViewById(R.id.editHorario);
        EditText editDireccion = findViewById(R.id.editDireccion);
        EditText editDescripcion = findViewById(R.id.editDescripcion);
        EditText editPrice = findViewById(R.id.editPrice);
        Button btnRegistrarseCancha = findViewById(R.id.btnRegistrarseCancha);

        editNombre.setText(cancha.getName());
        editHorario.setText(cancha.getSchedule());
        editDireccion.setText(cancha.getAddress());
        editDescripcion.setText(cancha.getDescription());
        editPrice.setText(String.valueOf(cancha.getPrice()));
        btnRegistrarseCancha.setText("Actualizar");
    }

    public void guardarCancha(View view) {
        EditText editNombre = findViewById(R.id.editNombre);
        EditText editHorario = findViewById(R.id.editHorario);
        EditText editDireccion = findViewById(R.id.editDireccion);
        EditText editDescripcion = findViewById(R.id.editDescripcion);
        EditText editPrice = findViewById(R.id.editPrice);

        String nombre = editNombre.getText().toString();
        String horario = editHorario.getText().toString();
        String direccion = editDireccion.getText().toString();
        String descripcion = editDescripcion.getText().toString();
        long price = Long.parseLong(editPrice.getText().toString());

        if (idCancha.isEmpty()) {
            insertCanchaBD(nombre, direccion, price, descripcion, R.drawable.balon, horario);
        } else {
            updateCanchaBD(nombre, direccion, price, descripcion, R.drawable.balon, horario);
        }
    }

    private void insertCanchaBD(String name, String address, long price, String description, int urlImg, String schedule) {
        Cancha nuevaCancha = new Cancha(name, address, price, description, urlImg, schedule);
        nCanchasLab.addCancha(nuevaCancha);
        Toast.makeText(this,"Guardado", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void updateCanchaBD(String name, String address, long price, String description, int urlImg, String schedule) {
        Cancha cancha = nCanchasLab.getCanchaById(idCancha).get(0);
        cancha.setName(name);
        cancha.setAddress(address);
        cancha.setPrice(price);
        cancha.setDescription(description);
        cancha.setUrlImg(urlImg);
        cancha.setSchedule(schedule);
        nCanchasLab.updateCancha(cancha);
        Toast.makeText(this,"Actualizado", Toast.LENGTH_SHORT).show();
        finish();
    }
}