package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class WingsArmyBoneless_MC {
    private int imagen_boneless;
    private String nombre_boneless;
    private String descripcion_boneless;
    private String precio_boneless;
    //private Button boton_OrdenarHamburgesa;

    public WingsArmyBoneless_MC(int imagen_boneless, String nombre_boneless, String descripcion_boneless, String precio_boneless) {
        this.imagen_boneless = imagen_boneless;
        this.nombre_boneless = nombre_boneless;
        this.descripcion_boneless = descripcion_boneless;
        this.precio_boneless = precio_boneless;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_boneless() {
        return imagen_boneless;
    }
    public String getNombre_boneless() {
        return nombre_boneless;
    }
    public String getDescripcion_boneless() {
        return descripcion_boneless;
    }
    public String getPrecio_boneless() { return precio_boneless; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
