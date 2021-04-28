package com.proyecto.admin;

public class Cancha {
    private String name;
    private int price;
    private String description;
    private int urlImg;
    private String schedule;

    public Cancha(String name, int price, String description, int urlImg, String schedule) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.urlImg = urlImg;
        this.schedule = schedule;
    }

    public int getPrice() { return price; }

    public int getUrlImg() { return urlImg; }

    public String getDescription() { return description; }

    public String getName() { return name; }

    public String getSchedule() { return schedule; }
}