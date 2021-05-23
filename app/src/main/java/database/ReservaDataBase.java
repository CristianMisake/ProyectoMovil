package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.registro.Registro;
import com.proyecto.models.reserva.Reserva;
import com.proyecto.models.usuario.Usuario;

@Database(entities = {Reserva.class, Cancha.class, Usuario.class, Registro.class}, version = 3, exportSchema = false)
public abstract class ReservaDataBase extends RoomDatabase {
    public abstract ReservaDao getReservaDao();
}
