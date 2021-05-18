package com.proyecto.models.usuario;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.proyecto.models.registro.Registro;

import java.util.UUID;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "usuarios")
public class Usuario {
    @PrimaryKey
    @ColumnInfo(name = "idUsuario")
    @NonNull
    private String idUsuario;
    @ColumnInfo(name = "usuario")
    private String usuario;
    @ColumnInfo(name = "password")
    private String password;
    @ForeignKey(entity = Registro.class,
            parentColumns = "idRegistro",
            childColumns = "idRegistroFk",
            onDelete = CASCADE
    )
    @ColumnInfo(name = "idRegistroFk")
    private String idRegistroFk;
    @ColumnInfo(name = "estado")
    private int estado;

    public Usuario (String usuario, String password, String idRegistroFk) {
        this.idUsuario = UUID.randomUUID().toString();
        this.usuario = usuario;
        this.password = password;
        this.idRegistroFk = idRegistroFk;
        this.estado = 1;
    }

    @NonNull
    public String getIdUsuario() { return idUsuario; }
    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }
    public String getIdRegistroFk() { return idRegistroFk; }
    public int getEstado() { return estado; }

    public void setIdUsuario(@NonNull String idUsuario) { this.idUsuario = idUsuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setPassword(String password) { this.password = password; }
    public void setIdRegistroFk(String idRegistroFk) { this.idRegistroFk = idRegistroFk; }
    public void setEstado(int estado) { this.estado = estado; }
}
