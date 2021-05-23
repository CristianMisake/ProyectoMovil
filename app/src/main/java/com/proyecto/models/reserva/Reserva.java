package com.proyecto.models.reserva;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import static androidx.room.ForeignKey.CASCADE;

import com.proyecto.models.cancha.Cancha;
import com.proyecto.models.usuario.Usuario;

import java.util.UUID;

@Entity(tableName = "reservas")
public class Reserva {
    @PrimaryKey
    @ColumnInfo(name = "idReserva")
    @NonNull
    private String idReserva;
    @ColumnInfo(name = "horas")
    private String horas;
    @ColumnInfo(name = "fecha")
    private String fecha;
    @ForeignKey(entity = Usuario.class,
            parentColumns = "idUsuario",
            childColumns = "idUsuarioFk",
            onDelete = CASCADE
    )
    @ColumnInfo(name = "idUsuarioFk")
    private String idUsuarioFk;
    @ForeignKey(entity = Cancha.class,
            parentColumns = "idCancha",
            childColumns = "idCanchaFk",
            onDelete = CASCADE
    )
    @ColumnInfo(name = "idCanchaFk")
    private String idCanchaFk;
    @ColumnInfo(name = "estadoReserva")
    private int estadoReserva;

    public Reserva(String horas, String fecha, String idUsuarioFk, String idCanchaFk) {
        this.idReserva = UUID.randomUUID().toString();
        this.fecha = fecha;
        this.horas = horas;
        this.idUsuarioFk = idUsuarioFk;
        this.idCanchaFk = idCanchaFk;
        this.estadoReserva = 1;
    }

    @NonNull
    public String getIdReserva() { return idReserva; }
    public String getHoras() { return horas; }
    public String getFecha() { return fecha; }
    public String getIdUsuarioFk() { return idUsuarioFk; }
    public String getIdCanchaFk() { return idCanchaFk; }

    public int getEstadoReserva() { return estadoReserva; }

    public void setIdReserva(@NonNull String idReserva) { this.idReserva = idReserva; }
    public void setHoras(String horas) { this.horas = horas; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setIdUsuarioFk(String idUsuarioFk) { this.idUsuarioFk = idUsuarioFk; }
    public void setIdCanchaFk(String idCanchaFk) { this.idCanchaFk = idCanchaFk; }
    public void setEstadoReserva(int estadoReserva) { this.estadoReserva = estadoReserva; }
}

