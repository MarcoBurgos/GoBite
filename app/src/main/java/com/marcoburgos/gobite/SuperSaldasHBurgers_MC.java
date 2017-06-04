package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class SuperSaldasHBurgers_MC {
    private int imagen_burger;
    private String nombre_buger;
    private String descripcion_burger;
    private String precio_buerger;
    //private Button boton_OrdenarHamburgesa;

    public SuperSaldasHBurgers_MC(int imagen_burger, String nombre_buger, String descripcion_burger, String precio_buerger) {
        this.imagen_burger = imagen_burger;
        this.nombre_buger = nombre_buger;
        this.descripcion_burger = descripcion_burger;
        this.precio_buerger = precio_buerger;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_burger() {
        return imagen_burger;
    }
    public String getNombre_buger() {
        return nombre_buger;
    }
    public String getDescripcion_burger() {
        return descripcion_burger;
    }
    public String getPrecio_buerger() { return precio_buerger; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
