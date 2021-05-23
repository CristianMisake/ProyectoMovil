package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.reserva.ReservaCancha;

import java.util.List;
import java.util.UUID;

@Dao
public interface ReservaDao {

    @Insert
    void addReserva(Reserva reserva);

    @Update
    void updateReserva(Reserva reserva);

    @Query("UPDATE reservas SET estadoReserva = 2 WHERE idReserva = :uid")
    void acceptReserva(String uid);

    @Query("UPDATE reservas SET estadoReserva = 0 WHERE idReserva = :uid")
    void rejectReserva(String uid);
}
