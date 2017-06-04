package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class SuperSaldasEnsaladas_MC {
    private int imagen_ensalada;
    private String nombre_ensalada;
    private String descripcion_ensalada;
    private String precio_ensalada;
    //private Button boton_OrdenarHamburgesa;

    public SuperSaldasEnsaladas_MC(int imagen_ensalada, String nombre_ensalada, String descripcion_ensalada, String precio_ensalada) {
        this.imagen_ensalada = imagen_ensalada;
        this.nombre_ensalada = nombre_ensalada;
        this.descripcion_ensalada = descripcion_ensalada;
        this.precio_ensalada = precio_ensalada;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_ensalada() {
        return imagen_ensalada;
    }
    public String getNombre_ensalada() {
        return nombre_ensalada;
    }
    public String getDescripcion_ensalada() {
        return descripcion_ensalada;
    }
    public String getPrecio_ensalada() { return precio_ensalada; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
