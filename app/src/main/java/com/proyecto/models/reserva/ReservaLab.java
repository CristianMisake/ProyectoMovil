package com.proyecto.models.reserva;

import android.content.Context;

import androidx.room.Query;
import androidx.room.Room;

import java.util.List;

import database.ReservaDao;
import database.ReservaDataBase;

public class ReservaLab implements ReservaDao {
    private static ReservaLab nReservaLab;

    private ReservaDao nReservaDao;

    private ReservaLab(Context context) {
        Context appContext = context.getApplicationContext();
        ReservaDataBase dataBase = Room.databaseBuilder(appContext, ReservaDataBase.class, "reservas")
                .allowMainThreadQueries().build();
        nReservaDao = dataBase.getReservaDao();
    }

    public static ReservaLab get(Context context) {
        if (nReservaLab == null) {
            nReservaLab = new ReservaLab(context);
        }
        return nReservaLab;
    }

    @Override
    public void addReserva(Reserva reserva) { nReservaDao.addReserva(reserva); }

    @Override
    public void updateReserva(Reserva reserva) { nReservaDao.updateReserva(reserva); }

    @Override
    public void acceptReserva(String uid) { nReservaDao.acceptReserva(uid); }

    @Override
    public void rejectReserva(String uid) { nReservaDao.rejectReserva(uid); }
}
