package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class SuperSaldasSopas_MC {
    private int imagen_sopa;
    private String nombre_sopa;
    private String descripcion_sopa;
    private String precio_sopa;
    //private Button boton_OrdenarHamburgesa;

    public SuperSaldasSopas_MC(int imagen_sopa, String nombre_sopa, String descripcion_sopa, String precio_sopa) {
        this.imagen_sopa = imagen_sopa;
        this.nombre_sopa = nombre_sopa;
        this.descripcion_sopa = descripcion_sopa;
        this.precio_sopa = precio_sopa;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_sopa() {
        return imagen_sopa;
    }
    public String getNombre_sopa() {
        return nombre_sopa;
    }
    public String getDescripcion_sopa() {
        return descripcion_sopa;
    }
    public String getPrecio_sopa() { return precio_sopa; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
