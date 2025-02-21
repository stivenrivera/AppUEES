package com.example.miapp;

public class Publicacion {
    private String nombre;
    private String textoPublicacion;
    private int imagenPerfil;
    private int imagenPublicacion;

    public Publicacion(String nombre, String textoPublicacion, int imagenPerfil, int imagenPublicacion) {
        this.nombre = nombre;
        this.textoPublicacion = textoPublicacion;
        this.imagenPerfil = imagenPerfil;
        this.imagenPublicacion = imagenPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTextoPublicacion() {
        return textoPublicacion;
    }

    public int getImagenPerfil() {
        return imagenPerfil;
    }

    public int getImagenPublicacion() {
        return imagenPublicacion;
    }
}
