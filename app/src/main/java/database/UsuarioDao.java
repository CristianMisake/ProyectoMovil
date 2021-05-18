package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.models.usuario.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuarios WHERE estado = 1")
    List<Usuario> getUsuarios();

    @Query("SELECT * FROM usuarios WHERE estado = 1 AND idUsuario = :uid")
    List<Usuario> getUsuarioById(String uid);

    @Insert
    void addUsuario(Usuario usuario);

    @Update
    void updateUsuario(Usuario usuario);

    @Query("UPDATE usuarios SET estado = 0 WHERE idUsuario = :uid")
    void deleteUsuario(String uid);
}
