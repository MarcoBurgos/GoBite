package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class Pizzas_MC {
    private int imagen_pizza;
    private String nombre_pizza;
    private String descripcion_pizza;
    private String precio_pizza;
    //private Button boton_OrdenarHamburgesa;

    public Pizzas_MC(int imagen_pizza, String nombre_pizza, String descripcion_pizza, String precio_pizza) {
        this.imagen_pizza = imagen_pizza;
        this.nombre_pizza = nombre_pizza;
        this.descripcion_pizza = descripcion_pizza;
        this.precio_pizza = precio_pizza;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_pizza() {
        return imagen_pizza;
    }
    public String getNombre_pizza() {
        return nombre_pizza;
    }
    public String getDescripcion_pizza() {
        return descripcion_pizza;
    }
    public String getprecio_pizza() { return precio_pizza; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
