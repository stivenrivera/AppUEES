package com.example.miapp;

public class Producto {
    private String nombre;
    private double precio;
    private int imagen;

    public Producto(String nombre, double precio, int imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
