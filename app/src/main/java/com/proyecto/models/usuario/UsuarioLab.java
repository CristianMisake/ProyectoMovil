package com.proyecto.models.usuario;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import database.UsuarioDao;
import database.UsuarioDataBase;

public class UsuarioLab implements UsuarioDao {
    private static UsuarioLab nUsuarioLab;

    private UsuarioDao nUsuarioDao;

    public UsuarioLab(Context context) {
        Context appContext = context.getApplicationContext();
        UsuarioDataBase dataBase = Room.databaseBuilder(appContext, UsuarioDataBase.class, "usuarios")
                .allowMainThreadQueries().build();
        nUsuarioDao = dataBase.getUsuarioDao();
    }

    public static UsuarioLab get(Context context) {
        if (nUsuarioLab == null) {
            nUsuarioLab = new UsuarioLab(context);
        }
        return nUsuarioLab;
    }

    @Override
    public List<Usuario> getUsuarios() { return nUsuarioDao.getUsuarios(); }

    @Override
    public List<Usuario> getUsuarioById(String uid) { return nUsuarioDao.getUsuarioById(uid); }

    @Override
    public void addUsuario(Usuario usuario) { nUsuarioDao.addUsuario(usuario); }

    @Override
    public void updateUsuario(Usuario usuario) { nUsuarioDao.updateUsuario(usuario); }

    @Override
    public void deleteUsuario(String uid) { nUsuarioDao.deleteUsuario(uid); }

    @Override
    public List<Usuario> getLogin(String usuario, String password) {
        return nUsuarioDao.getLogin(usuario, password);
    }
}
