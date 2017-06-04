package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class DominosBebidas_MC {
    private int imagen_bebidasDs;
    private String nombre_bebidasDs;
    private String descripcion_bebidasDs;
    private String precio_bebidasDs;
    //private Button boton_OrdenarHamburgesa;

    public DominosBebidas_MC(int imagen_bebidasDs, String nombre_bebidasDs, String descripcion_bebidasDs, String precio_bebidasDs) {
        this.imagen_bebidasDs = imagen_bebidasDs;
        this.nombre_bebidasDs = nombre_bebidasDs;
        this.descripcion_bebidasDs= descripcion_bebidasDs;
        this.precio_bebidasDs = precio_bebidasDs;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_bebidasDs() {
        return imagen_bebidasDs;
    }
    public String getNombre_bebidasDs() {
        return nombre_bebidasDs;
    }
    public String getDescripcion_bebidasDs() {
        return descripcion_bebidasDs;
    }
    public String getPrecio_bebidasDs() { return precio_bebidasDs; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
