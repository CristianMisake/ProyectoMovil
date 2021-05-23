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

    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.direccion, C.price, C.urlImg, " +
            "RE.primerNombre, RE.segundoNombre, RE.primerApellido, RE.segundoApellido " +
            "FROM reservas R " +
            "INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "INNER JOIN usuarios U ON U.idUsuario = R.idUsuarioFk " +
            "INNER JOIN registros RE ON RE.idRegistro = U.idRegistroFk " +
            "WHERE R.estadoReserva = 1")
    List<ReservaCancha> getReservas();

    @Query("SELECT * FROM reservas WHERE estadoReserva = 1")
    List<Reserva> getReservasAll();

    @Insert
    void addReserva(Reserva reserva);

    @Update
    void updateReserva(Reserva reserva);

    @Query("UPDATE reservas SET estadoReserva = 2 WHERE idReserva = :uid")
    void acceptReserva(String uid);

    @Query("UPDATE reservas SET estadoReserva = 0 WHERE idReserva = :uid")
    void rejectReserva(String uid);
}
