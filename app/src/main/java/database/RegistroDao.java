package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.models.registro.Registro;

import java.util.List;

@Dao
public interface RegistroDao {
    @Query("SELECT * FROM registros WHERE estadoRegistro = 1")
    List<Registro> getRegistros();

    @Query("SELECT * FROM registros WHERE estadoRegistro = 1 AND idRegistro = :uid")
    List<Registro> getRegistroById(String uid);

    @Insert
    void addRegistro(Registro registro);

    @Update
    void updateRegistro(Registro registro);

    @Query("UPDATE registros SET estadoRegistro = 0 WHERE idRegistro = :uid")
    void deleteRegistro(String uid);
}
