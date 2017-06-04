package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 05/05/17.
 */

public class SuperSaladasMenu_MC {
    private int imagen_platoSS;
    private String nombre_platoSS;
    private String descripcion_platoSS;

    public SuperSaladasMenu_MC(int imagen_platoSS, String nombre_platoSS, String descripcion_platoSS) {
        this.imagen_platoSS = imagen_platoSS;
        this.nombre_platoSS = nombre_platoSS;
        this.descripcion_platoSS = descripcion_platoSS;
    }

    public int getImagen_platoSS() {
        return imagen_platoSS;
    }

    public String getNombre_platoSS() {
        return nombre_platoSS;
    }

    public String getDescripcion_platoSS() {
        return descripcion_platoSS;
    }
}


