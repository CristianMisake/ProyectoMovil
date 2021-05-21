package com.proyecto.models.cancha;

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

import java.util.ArrayList;

public class AdaptadorCancha extends RecyclerView.Adapter<AdaptadorCancha.MyViewHolder> {
    private ArrayList<Cancha> listadoCanchas;
    private Context context;
    private Onclick clickEliminar;
    private Onclick clickEditar;

    public interface Onclick {
        void OnEvent(Cancha cancha, int pos);
    }

    public AdaptadorCancha(Context context, ArrayList<Cancha> listadoCanchas,
                           Onclick clickEditar, Onclick clickEliminar) {
        this.context = context;
        this.listadoCanchas = listadoCanchas;
        this.clickEditar = clickEditar;
        this.clickEliminar = clickEliminar;
    }

    View view;

    @NonNull
    @Override
    public AdaptadorCancha.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.cancha, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdaptadorCancha.MyViewHolder holder, int position) {
        Cancha canchaActual = listadoCanchas.get(position);
        holder.name.setText(canchaActual.getName());
        holder.price.setText("Precio: " + canchaActual.getPrice());
        holder.descripcion.setText(canchaActual.getDescription());
        holder.imageFoto.setImageResource(canchaActual.getUrlImg());
        holder.schedule.setText(canchaActual.getSchedule());
        holder.cancha = canchaActual;
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEliminar.OnEvent(canchaActual, position);
            }
        });
        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEditar.OnEvent(canchaActual, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listadoCanchas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView price;
        public TextView descripcion;
        public ImageView imageFoto;
        public TextView schedule;
        public Cancha cancha;
        public Button eliminar;
        public Button editar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtNameCancha);
            price = (TextView) itemView.findViewById(R.id.txtPriceCancha);
            descripcion = (TextView) itemView.findViewById(R.id.txtDecriptionCancha);
            imageFoto = (ImageView) itemView.findViewById(R.id.imgCancha);
            schedule = (TextView) itemView.findViewById(R.id.txtScheduleCancha);
            eliminar = (Button) itemView.findViewById(R.id.btnEliminar);
            editar = (Button) itemView.findViewById(R.id.btnEditar);
        }
    }
}
