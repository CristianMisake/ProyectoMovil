package com.proyecto.cliente;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.R;
import com.proyecto.vista_principal.MainActivity;

import java.sql.Time;
import java.util.Calendar;


public class vistaReservaCliente extends AppCompatActivity {
    TextView tv,tv2;
    private Object TimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_reserva_cliente);
        tv = findViewById(R.id.txtFechaCliente);
        tv2 = findViewById(R.id.txtHoraCliente);
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
}
