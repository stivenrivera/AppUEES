package com.example.miapp;

public class Evento {
    private String nombre;
    private String textoEvento;
    private int imagenPerfil;
    private int imagenEvento;

    public Evento(String nombre, String textoEvento, int imagenPerfil, int imagenEvento) {
        this.nombre = nombre;
        this.textoEvento = textoEvento;
        this.imagenPerfil = imagenPerfil;
        this.imagenEvento = imagenEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTextoEvento() {
        return textoEvento;
    }

    public int getImagenPerfil() {
        return imagenPerfil;
    }

    public int getImagenEvento() {
        return imagenEvento;
    }
}