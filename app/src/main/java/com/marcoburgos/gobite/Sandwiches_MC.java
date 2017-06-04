package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class Sandwiches_MC {
    private int imagen_sand;
    private String nombre_sand;
    private String descripcion_sand;
    private String precio_sand;
    //private Button boton_OrdenarHamburgesa;

    public Sandwiches_MC(int imagen_sand, String nombre_sand, String descripcion_sand, String precio_sand) {
        this.imagen_sand = imagen_sand;
        this.nombre_sand = nombre_sand;
        this.descripcion_sand = descripcion_sand;
        this.precio_sand = precio_sand;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_sand() {
        return imagen_sand;
    }
    public String getNombre_sand() {
        return nombre_sand;
    }
    public String getDescripcion_sand() {
        return descripcion_sand;
    }
    public String getprecio_sand() { return precio_sand; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
