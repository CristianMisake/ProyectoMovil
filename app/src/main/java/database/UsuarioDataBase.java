package database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.proyecto.models.usuario.Usuario;

@Database(entities = {Usuario.class}, version = 2)
public abstract class UsuarioDataBase extends RoomDatabase {
    public abstract UsuarioDao getUsuarioDao();
}
