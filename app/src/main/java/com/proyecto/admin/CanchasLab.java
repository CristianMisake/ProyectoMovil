package com.proyecto.admin;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import database.CanchaDao;
import database.CanchaDataBase;

public class CanchasLab implements CanchaDao {
    private static CanchasLab sCanchasLab;

    private CanchaDao sCanchaDao;

    private CanchasLab(Context context) {
        Context appContext = context.getApplicationContext();
        CanchaDataBase dataBase = Room.databaseBuilder(appContext, CanchaDataBase.class, "canchas")
                .allowMainThreadQueries().build();
        sCanchaDao = dataBase.getCanchaDao();
    }

    public static CanchasLab get(Context context) {
        if (sCanchasLab == null) {
            sCanchasLab = new CanchasLab(context);
        }
        return sCanchasLab;
    }

    @Override
    public List<Cancha> getCanchas() {
        return sCanchaDao.getCanchas();
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
