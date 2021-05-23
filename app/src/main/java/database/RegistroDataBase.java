package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.proyecto.models.registro.Registro;

@Database(entities = {Registro.class}, version = 2)
public abstract class RegistroDataBase extends RoomDatabase {
    public abstract RegistroDao getRegistroDao();
}
