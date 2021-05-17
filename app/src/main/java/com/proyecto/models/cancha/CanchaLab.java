package com.proyecto.models.cancha;

import android.content.Context;

import androidx.room.Room;

import com.proyecto.models.reserva.ReservaCancha;

import java.util.List;

import database.CanchaDao;
import database.CanchaDataBase;

public class CanchaLab implements CanchaDao {
    private static CanchaLab sCanchasLab;

    private CanchaDao sCanchaDao;

    private CanchaLab(Context context) {
        Context appContext = context.getApplicationContext();
        CanchaDataBase dataBase = Room.databaseBuilder(appContext, CanchaDataBase.class, "canchas")
                .allowMainThreadQueries().build();
        sCanchaDao = dataBase.getCanchaDao();
    }

    public static CanchaLab get(Context context) {
        if (sCanchasLab == null) {
            sCanchasLab = new CanchaLab(context);
        }
        return sCanchasLab;
    }

    @Override
    public List<Cancha> getCanchas() {
        return sCanchaDao.getCanchas();
    }

    @Override
    public List<Cancha> getCanchaById(String uid) {
        return sCanchaDao.getCanchaById(uid);
    }

    @Override
    public void addCancha(Cancha cancha) {
        sCanchaDao.addCancha(cancha);
    }

    @Override
    public void updateCancha(Cancha cancha) {
        sCanchaDao.updateCancha(cancha);
    }

    @Override
    public void deleteCanchas(String uid) {
        sCanchaDao.deleteCanchas(uid);
    }
}
