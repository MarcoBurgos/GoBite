package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class WingsArmyAlistas_MC {
    private int imagen_alitas;
    private String nombre_alitas;
    private String descripcion_alitas;
    private String precio_alitas;
    //private Button boton_OrdenarHamburgesa;

    public WingsArmyAlistas_MC(int imagen_alitas, String nombre_alitas, String descripcion_alitas, String precio_alitas) {
        this.imagen_alitas = imagen_alitas;
        this.nombre_alitas = nombre_alitas;
        this.descripcion_alitas = descripcion_alitas;
        this.precio_alitas = precio_alitas;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_alitas() {
        return imagen_alitas;
    }
    public String getNombre_alitas() {
        return nombre_alitas;
    }
    public String getDescripcion_alitas() {
        return descripcion_alitas;
    }
    public String getPrecio_alitas() { return precio_alitas; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
