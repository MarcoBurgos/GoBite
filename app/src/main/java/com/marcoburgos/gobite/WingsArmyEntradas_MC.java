package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class WingsArmyEntradas_MC {
    private int imagen_entradas;
    private String nombre_entradas;
    private String descripcion_entradas;
    private String precio_entradas;
    //private Button boton_OrdenarHamburgesa;

    public WingsArmyEntradas_MC(int imagen_entradas, String nombre_entradas, String descripcion_entradas, String precio_entradas) {
        this.imagen_entradas = imagen_entradas;
        this.nombre_entradas = nombre_entradas;
        this.descripcion_entradas = descripcion_entradas;
        this.precio_entradas = precio_entradas;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_entradas() {
        return imagen_entradas;
    }
    public String getNombre_entradas() {
        return nombre_entradas;
    }
    public String getDescripcion_entradas() {
        return descripcion_entradas;
    }
    public String getPrecio_entradas() { return precio_entradas; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
