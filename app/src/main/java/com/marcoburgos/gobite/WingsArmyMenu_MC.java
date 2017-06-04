package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 05/05/17.
 */

public class WingsArmyMenu_MC {
    private int imagen_platoWA;
    private String nombre_platoWA;
    private String descripcion_platoWA;

    public WingsArmyMenu_MC(int imagen_platoWA, String nombre_platoWA, String descripcion_platoWA) {
        this.imagen_platoWA = imagen_platoWA;
        this.nombre_platoWA = nombre_platoWA;
        this.descripcion_platoWA = descripcion_platoWA;
    }

    public int getImagen_platoWA() {
        return imagen_platoWA;
    }

    public String getNombre_platoWA() {
        return nombre_platoWA;
    }

    public String getDescripcion_platoWA() {
        return descripcion_platoWA;
    }
}


