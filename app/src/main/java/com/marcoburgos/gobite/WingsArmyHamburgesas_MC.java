package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class WingsArmyHamburgesas_MC {
    private int imagen_hamburgesa;
    private String nombre_hamburgesa;
    private String descripcion_hamburgesa;
    private String precio_hamburgesa;
    //private Button boton_OrdenarHamburgesa;

    public WingsArmyHamburgesas_MC(int imagen_hamburgesa, String nombre_hamburgesa, String descripcion_hamburgesa, String precio_hamburgesa) {
        this.imagen_hamburgesa = imagen_hamburgesa;
        this.nombre_hamburgesa = nombre_hamburgesa;
        this.descripcion_hamburgesa = descripcion_hamburgesa;
        this.precio_hamburgesa = precio_hamburgesa;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_hamburgesa() {
        return imagen_hamburgesa;
    }
    public String getNombre_hamburgesa() {
        return nombre_hamburgesa;
    }
    public String getDescripcion_hamburgesa() {
        return descripcion_hamburgesa;
    }
    public String getPrecio_hamburgesa() { return precio_hamburgesa; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
