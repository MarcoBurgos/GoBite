package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class PostresMcDonalds_MC {
    private int imagen_postre;
    private String nombre_postre;
    private String descripcion_postre;
    private String precio_postre;
    //private Button boton_OrdenarHamburgesa;

    public PostresMcDonalds_MC(int imagen_postre, String nombre_postre, String descripcion_postre, String precio_postre) {
        this.imagen_postre = imagen_postre;
        this.nombre_postre = nombre_postre;
        this.descripcion_postre = descripcion_postre;
        this.precio_postre = precio_postre;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_postre() {
        return imagen_postre;
    }
    public String getNombre_postre() {
        return nombre_postre;
    }
    public String getDescripcion_postre() {
        return descripcion_postre;
    }
    public String getprecio_postre() { return precio_postre; }
}
