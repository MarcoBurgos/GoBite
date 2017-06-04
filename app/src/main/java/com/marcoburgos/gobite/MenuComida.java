package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 30/04/17.
 */

public class MenuComida {
    private int imagen_plato;
    private String nombre_plato;
    private String descripcion_plato;

    public MenuComida(int imagen_plato, String nombre_plato, String descripcion_plato) {
        this.imagen_plato = imagen_plato;
        this.nombre_plato = nombre_plato;
        this.descripcion_plato = descripcion_plato;
    }

    public int getImagen_plato() {
        return imagen_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public String getDescripcion_plato() {
        return descripcion_plato;
    }
}