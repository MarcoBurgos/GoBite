package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class Galletas_MC {
    private int imagen_extra;
    private String nombre_extra;
    private String descripcion_extra;
    private String precio_extra;
    //private Button boton_OrdenarHamburgesa;

    public Galletas_MC(int imagen_extra, String nombre_extra, String descripcion_extra, String precio_extra) {
        this.imagen_extra = imagen_extra;
        this.nombre_extra = nombre_extra;
        this.descripcion_extra = descripcion_extra;
        this.precio_extra = precio_extra;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_extra() {
        return imagen_extra;
    }
    public String getNombre_extra() {
        return nombre_extra;
    }
    public String getDescripcion_extra() {
        return descripcion_extra;
    }
    public String getPrecio_extra() { return precio_extra; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
