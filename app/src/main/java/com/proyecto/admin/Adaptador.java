package com.proyecto.admin;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Cancha> canchas;

    public Adaptador(Context context, ArrayList<Cancha> canchas) {
        this.context = context;
        this.canchas = canchas;
    }

    @Override
    public int getCount() {
        return canchas.size();
    }

    @Override
    public Object getItem(int position) {
        return canchas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cancha cancha = (Cancha) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.cancha, null);
        //
        TextView name = (TextView) convertView.findViewById(R.id.txtNameCancha);
        TextView price = (TextView) convertView.findViewById(R.id.txtPriceCancha);
        TextView descripcion = (TextView) convertView.findViewById(R.id.txtDecriptionCancha);
        ImageView imageFoto = (ImageView) convertView.findViewById(R.id.imgCancha);
        TextView schedule = (TextView) convertView.findViewById(R.id.txtScheduleCancha);
        //
        name.setText(cancha.getName());
        price.setText("precio: " + cancha.getPrice());
        descripcion.setText(cancha.getDescription());
        imageFoto.setImageResource(cancha.getUrlImg());
        schedule.setText(cancha.getSchedule());

        return convertView;
    }
}
