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
    public List<ReservaCancha> getReservas() { return nReservaDao.getReservas(); }

    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.price, C.urlImg, " +
            "RE.primerNombre, RE.segundoNombre, RE.primerApellido, RE.segundoApellido " +
            "FROM reservas R INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "INNER JOIN usuarios U ON U.idUsuario = R.idUsuarioFk " +
            "INNER JOIN registros RE ON RE.idRegistro = U.idRegistroFk " +
            "WHERE R.estadoReserva = 1 AND R.idReserva = :uid")
    @Override
    public List<ReservaCancha> getReservaById(String uid) { return nReservaDao.getReservaById(uid); }

    @Override
    public void addReserva(Reserva reserva) { nReservaDao.addReserva(reserva); }

    @Override
    public void updateReserva(Reserva reserva) { nReservaDao.updateReserva(reserva); }

    @Override
    public void acceptReserva(String uid) { nReservaDao.acceptReserva(uid); }

    @Override
    public void rejectReserva(String uid) { nReservaDao.rejectReserva(uid); }
}
