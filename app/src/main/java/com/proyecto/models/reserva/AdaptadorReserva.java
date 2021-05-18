package com.proyecto.models.reserva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.R;

import java.util.ArrayList;

public class AdaptadorReserva extends RecyclerView.Adapter<AdaptadorReserva.MyViewHolder> {
    private ArrayList<ReservaCancha> listadoReservas;
    private Context context;
    private Onclick clickAceptar;
    private Onclick clickRechazar;

    public interface Onclick {
        void OnEvent(ReservaCancha reserva, int pos);
    }

    public AdaptadorReserva(Context context, ArrayList<ReservaCancha> listadoReservas,
                           Onclick clickAceptar, Onclick clickRechazar) {
        this.context = context;
        this.listadoReservas = listadoReservas;
        this.clickAceptar = clickAceptar;
        this.clickRechazar = clickRechazar;
    }

    View view;

    @NonNull
    @Override
    public AdaptadorReserva.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.reserva, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorReserva.MyViewHolder holder, int position) {
        ReservaCancha reservaActual = listadoReservas.get(position);
        String nameUsuario = reservaActual.getPrimerNombre() + " "
                + reservaActual.getSegundoNombre() + " " + reservaActual.getPrimerApellido()
                + " " + reservaActual.getSegundoApellido();
        String price = "precio: " + reservaActual.getPrice();

        holder.name.setText(reservaActual.getNombre());
        holder.nameUsuario.setText(nameUsuario);
        holder.price.setText(price);
        holder.fecha.setText(reservaActual.getFecha());
        holder.horas.setText(reservaActual.getHoras());
        holder.reserva = reservaActual;
        holder.aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAceptar.OnEvent(reservaActual, position);
            }
        });
        holder.rechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickRechazar.OnEvent(reservaActual, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoReservas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView nameUsuario;
        public TextView price;
        public TextView fecha;
        public TextView horas;
        public ReservaCancha reserva;
        public Button aceptar;
        public Button rechazar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtNameCanchaR);
            nameUsuario = (TextView) itemView.findViewById(R.id.txtNameUsuarioR);
            price = (TextView) itemView.findViewById(R.id.txtPriceCanchaR);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaReserva);
            horas = (TextView) itemView.findViewById(R.id.txtHorasReserva);
            aceptar = (Button) itemView.findViewById(R.id.btnAceptar);
            rechazar = (Button) itemView.findViewById(R.id.btnRechazar);
        }
    }
}
