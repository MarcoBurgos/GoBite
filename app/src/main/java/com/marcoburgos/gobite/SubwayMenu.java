package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 30/04/17.
 */

public class SubwayMenu {
    private int imagen_sandwich;
    private String nombre_sandwich;
    private String descripcion_sandwich;

    public SubwayMenu(int imagen_sandwich, String nombre_sandwich, String descripcion_sandwich) {
        this.imagen_sandwich = imagen_sandwich;
        this.nombre_sandwich = nombre_sandwich;
        this.descripcion_sandwich = descripcion_sandwich;
    }

    public int getImagen_sandwich() {
        return imagen_sandwich;
    }

    public String getNombre_sandwich() {
        return nombre_sandwich;
    }

    public String getDescripcion_sandwich() {
        return descripcion_sandwich;
    }

}