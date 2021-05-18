package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.proyecto.models.usuario.Usuario;

@Database(entities = {Usuario.class}, version = 1)
public abstract class UsuarioDataBase extends RoomDatabase {
    public abstract UsuarioDao getUsuarioDao();
}
