package com.proyecto.admin;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "canchas")
public class Cancha {
    @PrimaryKey
    @ColumnInfo(name = "idCancha")
    @NonNull
    private String idCancha;
    @ColumnInfo(name = "nombre")
    private String name;
    @ColumnInfo(name = "direccion")
    private String address;
    @ColumnInfo(name = "schedule")
    private String schedule;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "price")
    private long price;
    @ColumnInfo(name = "urlImg")
    private int urlImg;
    @ColumnInfo(name = "estado")
    private int estado;

    public Cancha(String name, String address, long price, String description, int urlImg, String schedule) {
        this.idCancha = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.schedule = schedule;
        this.description = description;
        this.price = price;
        this.urlImg = urlImg;
        this.estado = 1;
    }

    @NonNull
    public String getIdCancha() { return idCancha; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getSchedule() { return schedule; }
    public String getDescription() { return description; }
    public long getPrice() { return price; }
    public int getUrlImg() { return urlImg; }
    public int getEstado() { return estado; }

    public void setIdCancha(@NonNull String idCancha) { this.idCancha = idCancha; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(int price) { this.price = price; }
    public void setUrlImg(int urlImg) { this.urlImg = urlImg; }
    public void setEstado(int estado) { this.estado = estado; }
}