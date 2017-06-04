package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class SuperSaldasBebidas_MC {
    private int imagen_bebidas;
    private String nombre_bebidas;
    private String descripcion_bebidas;
    private String precio_bebidas;
    //private Button boton_OrdenarHamburgesa;

    public SuperSaldasBebidas_MC(int imagen_bebidas, String nombre_bebidas, String descripcion_bebidas, String precio_bebidas) {
        this.imagen_bebidas = imagen_bebidas;
        this.nombre_bebidas = nombre_bebidas;
        this.descripcion_bebidas = descripcion_bebidas;
        this.precio_bebidas = precio_bebidas;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_bebidas() {
        return imagen_bebidas;
    }
    public String getNombre_bebidas() {
        return nombre_bebidas;
    }
    public String getDescripcion_bebidas() {
        return descripcion_bebidas;
    }
    public String getPrecio_bebidas() { return precio_bebidas; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
