package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 05/05/17.
 */

public class DominosMenu {
    private int imagen_platoDominos;
    private String nombre_platoDominos;
    private String descripcion_platoDominos;

    public DominosMenu(int imagen_platoDominos, String nombre_platoDominos, String descripcion_platoDominos) {
        this.imagen_platoDominos = imagen_platoDominos;
        this.nombre_platoDominos = nombre_platoDominos;
        this.descripcion_platoDominos = descripcion_platoDominos;
    }

    public int getImagen_platoDominos() {
        return imagen_platoDominos;
    }

    public String getNombre_platoDominos() {
        return nombre_platoDominos;
    }

    public String getDescripcion_platoDominos() {
        return descripcion_platoDominos;
    }
}


