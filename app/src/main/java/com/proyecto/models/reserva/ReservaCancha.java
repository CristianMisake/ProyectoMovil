package com.proyecto.models.reserva;

public class ReservaCancha {

    private String idReserva;
    private String fecha;
    private String horas;
    private String nombre;
    private Long price;
    private int urlImg;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public ReservaCancha(String idReserva, String fecha, String horas, String nombre, long price,
                         int urlImg, String primerNombre, String segundoNombre,
                         String primerApellido, String segundoApellido) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horas = horas;
        this.nombre = nombre;
        this.price = price;
        this.urlImg = urlImg;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getIdReserva() { return idReserva; }
    public String getFecha() { return fecha; }
    public String getHoras() { return horas; }
    public String getNombre() { return nombre; }
    public Long getPrice() { return price; }
    public int getUrlImg() { return urlImg; }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getPrimerApellido() { return primerApellido; }
    public String getSegundoApellido() { return segundoApellido; }

    public void setIdReserva(String idReserva) { this.idReserva = idReserva; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHoras(String horas) { this.horas = horas; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrice(Long price) { this.price = price; }
    public void setUrlImg(int urlImg) { this.urlImg = urlImg; }
    public void setPrimerNombre(String primerNombre) { this.primerNombre = primerNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }
    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }
    public void setSegundoApellido(String segundoApellido) { this.segundoApellido = segundoApellido; }
}
