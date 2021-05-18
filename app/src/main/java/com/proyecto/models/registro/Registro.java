package com.proyecto.models.registro;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "registros")
public class Registro {
    @PrimaryKey
    @ColumnInfo(name = "idRegistro")
    @NonNull
    private String idRegistro;
    @ColumnInfo(name = "primerNombre")
    private String primerNombre;
    @ColumnInfo(name = "segundoNombre")
    private String segundoNombre;
    @ColumnInfo(name = "primerApellido")
    private String primerApellido;
    @ColumnInfo(name = "segundoApellido")
    private String segundoApellido;
    @ColumnInfo(name = "telefono")
    private Long telefono;
    @ColumnInfo(name = "direccion")
    private String direccion;
    @ColumnInfo(name = "estadoRegistro")
    private int estado;

    public Registro(String primerNombre, String segundoNombre, String primerApellido,
                    String segundoApellido, Long telefono, String direccion) {
        this.idRegistro = UUID.randomUUID().toString();
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = 1;
    }

    @NonNull
    public String getIdRegistro() { return idRegistro; }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getPrimerApellido() { return primerApellido; }
    public String getSegundoApellido() { return segundoApellido; }
    public Long getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public int getEstado() { return estado; }

    public void setIdRegistro(@NonNull String idRegistro) { this.idRegistro = idRegistro; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }
    public void setTelefono(Long telefono) { this.telefono = telefono; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setEstado(int estado) { this.estado = estado; }
}
