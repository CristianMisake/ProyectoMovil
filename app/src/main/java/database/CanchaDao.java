package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.admin.Cancha;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CanchaDao {

    @Query("SELECT * FROM Canchas WHERE estado = 1")
    List<Cancha> getCanchas();

    @Insert
    void addCancha(Cancha cancha);

    @Update
    void updateCancha(Cancha cancha);

    @Query("UPDATE Canchas SET estado = 0 WHERE idCancha = :uid")
    void deleteCanchas(String uid);
}
