package com.proyecto.models.reserva;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import database.ReservaCanchaDao;
import database.ReservaCanchaDataBase;

public class ReservaCanchaLab implements ReservaCanchaDao {
    private static ReservaCanchaLab nReservaCanchaLab;

    private ReservaCanchaDao nReservaCanchaDao;

    private ReservaCanchaLab(Context context) {
        Context appContext = context.getApplicationContext();
        ReservaCanchaDataBase dataBase = Room.databaseBuilder(appContext, ReservaCanchaDataBase.class, "reservas_canchas")
                .allowMainThreadQueries().build();
        nReservaCanchaDao = dataBase.getReservaCanchaDao();
    }

    public static ReservaCanchaLab get(Context context) {
        if (nReservaCanchaLab == null) {
            nReservaCanchaLab = new ReservaCanchaLab(context);
        }
        return nReservaCanchaLab;
    }

    @Override
    public List<ReservaCancha> getReservas() { return nReservaCanchaDao.getReservas(); }

    @Override
    public List<ReservaCancha> getReservaById(String uid) { return nReservaCanchaDao.getReservaById(uid); }
}
