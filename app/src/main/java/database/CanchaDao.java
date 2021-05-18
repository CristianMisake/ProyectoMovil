package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.models.cancha.Cancha;

import java.util.List;

@Dao
public interface CanchaDao {

    @Query("SELECT * FROM canchas WHERE estado = 1")
    List<Cancha> getCanchas();

    @Query("SELECT * FROM canchas WHERE estado = 1 AND idCancha = :uid")
    List<Cancha> getCanchaById(String uid);

    @Insert
    void addCancha(Cancha cancha);

    @Update
    void updateCancha(Cancha cancha);

    @Query("UPDATE canchas SET estado = 0 WHERE idCancha = :uid")
    void deleteCancha(String uid);
}
