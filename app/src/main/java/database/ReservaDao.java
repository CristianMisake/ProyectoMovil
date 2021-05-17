package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.reserva.ReservaCancha;

import java.util.List;

@Dao
public interface ReservaDao {

    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.price, C.urlImg " +
            "FROM reservas R INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "WHERE R.estado = 1")
    List<ReservaCancha> getReservas();

    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.price, C.urlImg " +
            "FROM reservas R INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "WHERE R.estado = 1 AND R.idReserva = :uid")
    List<ReservaCancha> getReservaById(String uid);

    @Insert
    void addReserva(Reserva reserva);

    @Update
    void updateReserva(Reserva reserva);

    @Query("UPDATE reservas SET estado = 2 WHERE idReserva = :uid")
    void acceptReserva(String uid);

    @Query("UPDATE reservas SET estado = 0 WHERE idReserva = :uid")
    void rejectReserva(String uid);
}
