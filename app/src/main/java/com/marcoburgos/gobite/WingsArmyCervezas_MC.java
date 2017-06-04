package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class WingsArmyCervezas_MC {
    private int imagen_cervezas;
    private String nombre_cervezas;
    private String descripcion_cervezas;
    private String precio_cervezas;
    //private Button boton_OrdenarHamburgesa;

    public WingsArmyCervezas_MC(int imagen_cervezas, String nombre_cervezas, String descripcion_cervezas, String precio_cervezas) {
        this.imagen_cervezas = imagen_cervezas;
        this.nombre_cervezas = nombre_cervezas;
        this.descripcion_cervezas = descripcion_cervezas;
        this.precio_cervezas = precio_cervezas;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_cervezas() {
        return imagen_cervezas;
    }
    public String getNombre_cervezas() {
        return nombre_cervezas;
    }
    public String getDescripcion_cervezas() {
        return descripcion_cervezas;
    }
    public String getPrecio_cervezas() { return precio_cervezas; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
