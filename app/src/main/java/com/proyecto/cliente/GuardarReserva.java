package com.proyecto.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.R;
import com.proyecto.admin.ListaCanchas;
import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.cancha.CanchaLab;
import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.reserva.ReservaLab;
import com.proyecto.vista_principal.Login;

import org.w3c.dom.Text;

import java.util.List;

public class GuardarReserva extends AppCompatActivity {
    private ReservaLab nReservalab;
    private String idUsuario;
    private String idCancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_reserva_cliente);

        Intent intent = getIntent();
        idCancha = intent.getStringExtra(ListaCanchaCliente.ID_CANCHA);
        idUsuario = intent.getStringExtra(Login.ID_USUARIO);

        nReservalab = ReservaLab.get(this);
    }

    public void guardarCancha(View view) {
        TextView editFecha = findViewById(R.id.txtFechaCliente);
        TextView editHora = findViewById(R.id.txtHoraCliente);

        String hora = editFecha.getText().toString();
        String fecha = editHora.getText().toString();

        if (TextUtils.isEmpty(hora) || TextUtils.isEmpty(fecha)) {
            Toast.makeText(this,"Por favor llene todos los campos.", Toast.LENGTH_LONG).show();
        } else {
            insertCanchaBD(hora, fecha);
        }
    }

    private void insertCanchaBD(String hora, String fecha) {
        Reserva nuevaReserva = new Reserva(hora, fecha, idUsuario, idCancha);
        nReservalab.addReserva(nuevaReserva);
        Toast.makeText(this,"Guardado", Toast.LENGTH_SHORT).show();
        finish();
    }

}
