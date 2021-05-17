package com.proyecto.models.reserva;

public class ReservaCancha {

    private String idReserva;
    private String fecha;
    private String horas;
    private String nombre;
    private Long price;
    private int urlImg;

    public ReservaCancha(String idReserva, String fecha, String horas, String nombre, long price, int urlImg) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horas = horas;
        this.nombre = nombre;
        this.price = price;
        this.urlImg = urlImg;
    }

    public String getIdReserva() { return idReserva; }
    public String getFecha() { return fecha; }
    public String getHoras() { return horas; }
    public String getNombre() { return nombre; }
    public Long getPrice() { return price; }
    public int getUrlImg() { return urlImg; }

    public void setIdReserva(String idReserva) { this.idReserva = idReserva; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHoras(String horas) { this.horas = horas; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrice(Long price) { this.price = price; }
    public void setUrlImg(int urlImg) { this.urlImg = urlImg; }
}
