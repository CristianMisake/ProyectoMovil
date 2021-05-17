package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.proyecto.models.cancha.Cancha;

@Database(entities = {Cancha.class}, version = 1)
public abstract class CanchaDataBase extends RoomDatabase {
    public abstract CanchaDao getCanchaDao();
}
