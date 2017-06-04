package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class ComplementosMcDonalds_MC {
    private int imagen_complemento;
    private String nombre_complemento;
    private String descripcion_complemento;
    private String precio_complemento;
    //private Button boton_OrdenarHamburgesa;

    public ComplementosMcDonalds_MC(int imagen_complemento, String nombre_complemento, String descripcion_complemento, String precio_complemento) {
        this.imagen_complemento = imagen_complemento;
        this.nombre_complemento = nombre_complemento;
        this.descripcion_complemento = descripcion_complemento;
        this.precio_complemento = precio_complemento;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_complemento() {
        return imagen_complemento;
    }
    public String getNombre_complemento() {
        return nombre_complemento;
    }
    public String getDescripcion_complemento() {
        return descripcion_complemento;
    }
    public String getprecio_complemento() { return precio_complemento; }
}
