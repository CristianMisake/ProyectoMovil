package database;

import androidx.room.Dao;
import androidx.room.Query;

import com.proyecto.models.reserva.ReservaCancha;

import java.util.List;

@Dao
public interface ReservaCanchaDao {
    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.direccion, C.price, C.urlImg, " +
            "RE.primerNombre, RE.segundoNombre, RE.primerApellido, RE.segundoApellido " +
            "FROM reservas R " +
            "INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "INNER JOIN usuarios U ON U.idUsuario = R.idUsuarioFk " +
            "INNER JOIN registros RE ON RE.idRegistro = U.idRegistroFk " +
            "WHERE R.estadoReserva = 1")
    List<ReservaCancha> getReservas();

    @Query("SELECT R.idReserva, R.fecha, R.horas, C.nombre, C.direccion, C.price, C.urlImg, " +
            "RE.primerNombre, RE.segundoNombre, RE.primerApellido, RE.segundoApellido " +
            "FROM reservas R " +
            "INNER JOIN canchas C ON C.idCancha = R.idCanchaFk " +
            "INNER JOIN usuarios U ON U.idUsuario = R.idUsuarioFk " +
            "INNER JOIN registros RE ON RE.idRegistro = U.idRegistroFk " +
            "WHERE R.estadoReserva = 1 AND R.idReserva = :uid")
    List<ReservaCancha> getReservaById(String uid);
}
