package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class DominosPostres_MC {
    private int imagen_postresDs;
    private String nombre_postresDs;
    private String descripcion_postresDS;
    private String precio_postresDS;
    //private Button boton_OrdenarHamburgesa;

    public DominosPostres_MC(int imagen_postresDs, String nombre_postresDs, String descripcion_postresDS, String precio_postresDS) {
        this.imagen_postresDs = imagen_postresDs;
        this.nombre_postresDs = nombre_postresDs;
        this.descripcion_postresDS= descripcion_postresDS;
        this.precio_postresDS = precio_postresDS;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_postresDs() {
        return imagen_postresDs;
    }
    public String getNombre_postresDs() {
        return nombre_postresDs;
    }
    public String getDescripcion_postresDS() {
        return descripcion_postresDS;
    }
    public String getPrecio_postresDS() { return precio_postresDS; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
