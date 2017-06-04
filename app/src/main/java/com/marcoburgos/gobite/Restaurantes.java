package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 24/04/17.
 */

public class Restaurantes {
    private int imagen_p;
    private String nombre_p;
    private String precio_p;

    public Restaurantes(int imagen_p, String nombre_p, String precio_p) {
        this.imagen_p = imagen_p;
        this.nombre_p = nombre_p;
        this.precio_p = precio_p;
    }

    public int getImagen_p() {
        return imagen_p;
    }

    public String getNombre_p() {
        return nombre_p;
    }

    public String getPrecio_p() {
        return precio_p;
    }
}

