package com.proyecto.models.reserva;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.R;
import com.proyecto.cliente.ListaCanchaCliente;
import com.proyecto.models.cancha.AdaptadorCancha;
import com.proyecto.models.cancha.Cancha;

import java.util.ArrayList;

public class AdaptadorCliente extends RecyclerView.Adapter<AdaptadorCliente.MyViewHolder> {
    private ArrayList<ReservaCancha> listadoReservasCliente;
    private Context contextCliente;
    private Onclick clickReserva;


    public interface Onclick {
        void OnEvent(ReservaCancha reservaCliente, int posC);
    }

    public AdaptadorCliente(Context contextCliente, ArrayList<ReservaCancha> listadoReservasCliente,
                            Onclick clickReserva) {
        this.contextCliente = contextCliente;
        this.listadoReservasCliente = listadoReservasCliente;
        this.clickReserva = clickReserva;
    }

    View view;

    @NonNull
    @Override
    public AdaptadorCliente.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.reservacliente, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCliente.MyViewHolder holder, int position) {
        ReservaCancha canchaActual = listadoReservasCliente.get(position);
        holder.name.setText(canchaActual.getNombre());
        holder.price.setText("precio: " + canchaActual.getPrice());
        holder.hora.setText(canchaActual.getHoras());
        holder.fecha.setText(canchaActual.getFecha());
        holder.direccion.setText(canchaActual.getDireccion());
        holder.imageFoto.setImageResource(canchaActual.getUrlImg());
        holder.reserva = canchaActual;

        holder.reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickReserva.OnEvent(canchaActual, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoReservasCliente.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView price;
        public TextView hora;
        public TextView fecha;
        public TextView direccion;
        public ImageView imageFoto;
        public ReservaCancha reserva;
        public Button reservar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtNameCanchaCliente);
            price = (TextView) itemView.findViewById(R.id.txtPriceCanchaCliente);
            hora = (TextView) itemView.findViewById(R.id.txtHorasReservaCliente);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaReservaCliente);
            direccion = (TextView) itemView.findViewById(R.id.txtDireccionCliente);
            imageFoto = (ImageView) itemView.findViewById(R.id.imgCanchaCliente);
            reservar = (Button) itemView.findViewById(R.id.btnReservar);
        }
    }
}
