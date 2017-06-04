package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class DominosEntradas_MC {
    private int imagen_entrada;
    private String nombre_entrada;
    private String descripcion_entrada;
    private String precio_entrada;
    //private Button boton_OrdenarHamburgesa;

    public DominosEntradas_MC(int imagen_entrada, String nombre_entrada, String descripcion_entrada, String precio_entrada) {
        this.imagen_entrada = imagen_entrada;
        this.nombre_entrada = nombre_entrada;
        this.descripcion_entrada = descripcion_entrada;
        this.precio_entrada = precio_entrada;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_entrada() {
        return imagen_entrada;
    }
    public String getNombre_entrada() {
        return nombre_entrada;
    }
    public String getDescripcion_entrada() {
        return descripcion_entrada;
    }
    public String getPrecio_entrada() { return precio_entrada; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
