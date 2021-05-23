package com.proyecto.cliente;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.R;
import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.reserva.ReservaLab;
import com.proyecto.vista_principal.Login;
import com.proyecto.vista_principal.MainActivity;

import java.sql.Time;
import java.util.Calendar;


public class vistaReservaCliente extends AppCompatActivity {
    TextView tv,tv2;
    private Object TimePickerDialog;
    private ReservaLab nReservalab;
    private String idUsuario;
    private String idCancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_reserva_cliente);
        tv = findViewById(R.id.txtFechaCliente);
        tv2 = findViewById(R.id.txtHoraCliente);

        nReservalab = ReservaLab.get(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        idCancha = intent.getStringExtra(ListaCanchaCliente.ID_CANCHA);
        idUsuario = intent.getStringExtra(Login.ID_USUARIO);
    }

    public void abrirCalendario(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(vistaReservaCliente.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month + "/" + year;
                tv.setText(fecha);
            }
        }, year, month, day);
        dpd.show();
    }

    public void abrirHora(View view){
        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        TimePickerDialog tmd = new TimePickerDialog(vistaReservaCliente.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv2.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        },hora,min, false);
        tmd.show();
    }

    public void guardarCancha(View view) {
        TextView editFecha = findViewById(R.id.txtFechaCliente);
        TextView editHora = findViewById(R.id.txtHoraCliente);

        String horas = editHora.getText().toString();
        String fecha = editFecha.getText().toString();

        if (TextUtils.isEmpty(horas) || TextUtils.isEmpty(fecha) || TextUtils.isEmpty(idUsuario) || TextUtils.isEmpty(idCancha)) {
            Toast.makeText(this,"Por favor llene todos los campos.", Toast.LENGTH_LONG).show();
        } else {
            insertCanchaBD(horas, fecha);
        }
    }

    private void insertCanchaBD(String horas, String fecha) {
        Reserva nuevaReserva = new Reserva(horas, fecha, idUsuario, idCancha);
        nReservalab.addReserva(nuevaReserva);
        Toast.makeText(this,"Guardado", Toast.LENGTH_SHORT).show();
        finish();
    }
}
