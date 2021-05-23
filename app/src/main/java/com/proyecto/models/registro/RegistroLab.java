package com.proyecto.models.registro;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import database.RegistroDao;
import database.RegistroDataBase;

public class RegistroLab implements RegistroDao {
    private static RegistroLab nRegistroLab;

    private RegistroDao nRegistroDao;

    public RegistroLab(Context context) {
        Context appContext = context.getApplicationContext();
        RegistroDataBase dataBase = Room.databaseBuilder(appContext, RegistroDataBase.class, "registros")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        nRegistroDao = dataBase.getRegistroDao();
    }

    public static RegistroLab get(Context context) {
        if (nRegistroLab == null) {
            nRegistroLab = new RegistroLab(context);
        }
        return nRegistroLab;
    }

    @Override
    public List<Registro> getRegistros() { return nRegistroDao.getRegistros(); }

    @Override
    public List<Registro> getRegistroById(String uid) { return nRegistroDao.getRegistroById(uid); }

    @Override
    public void addRegistro(Registro registro) { nRegistroDao.addRegistro(registro); }

    @Override
    public void updateRegistro(Registro registro) { nRegistroDao.updateRegistro(registro); }

    @Override
    public void deleteRegistro(String uid) { nRegistroDao.deleteRegistro(uid); }
}
