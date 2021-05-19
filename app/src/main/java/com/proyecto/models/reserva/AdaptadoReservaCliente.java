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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadoReservaCliente extends RecyclerView.Adapter<AdaptadoReservaCliente.MyViewHolder> {
    private ArrayList<ReservaCancha> listadoReservasCliente;
    private Context context;
    private Onclick clickReservar;

    public interface Onclick {
        void OnEvent(ReservaCancha reserva, int pos);
    }

    public AdaptadoReservaCliente(Context context, ArrayList<ReservaCancha> listadoReservasCliente,
                            Onclick clickReservar) {
        this.context = context;
        this.listadoReservasCliente = listadoReservasCliente;
        this.clickReservar = clickReservar;
    }

    View view;

    @NonNull
    @Override
    public AdaptadoReservaCliente.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.reservacliente, parent, false);
        return new AdaptadoReservaCliente.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadoReservaCliente.MyViewHolder holder, int position) {
        ReservaCancha reservaCliente = listadoReservasCliente.get(position);
        String price = "precio: " + reservaCliente.getPrice();

        holder.nameCancha.setText(reservaCliente.getNombre());
        holder.price.setText(price);
        holder.fecha.setText(reservaCliente.getFecha());
        holder.horas.setText(reservaCliente.getHoras());
        holder.direccion.setText(reservaCliente.getDireccion());
        holder.reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickReservar.OnEvent(reservaCliente, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoReservasCliente.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameCancha;
        public TextView price;
        public TextView fecha;
        public TextView horas;
        public TextView direccion;
        public Button reservar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCancha = (TextView) itemView.findViewById(R.id.txtNameCanchaCliente);
            price = (TextView) itemView.findViewById(R.id.txtPriceCanchaCliente);
            fecha = (TextView) itemView.findViewById(R.id.txtFechaReservaCliente);
            horas = (TextView) itemView.findViewById(R.id.txtHorasReservaCliente);
            direccion = (TextView) itemView.findViewById(R.id.txtDireccionCliente);
            reservar = (Button) itemView.findViewById(R.id.btnReservaCliente);

        }
    }

}

