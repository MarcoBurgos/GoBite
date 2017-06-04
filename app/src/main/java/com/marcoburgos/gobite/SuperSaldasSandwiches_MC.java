package com.marcoburgos.gobite;


/**
 * Created by marcoburgos on 01/05/17.
 */

public class SuperSaldasSandwiches_MC {
    private int imagen_sandwiches;
    private String nombre_sandwiches;
    private String descripcion_sandwiches;
    private String precio_sandwiches;
    //private Button boton_OrdenarHamburgesa;

    public SuperSaldasSandwiches_MC(int imagen_sandwiches, String nombre_sandwiches, String descripcion_sandwiches, String precio_sandwiches) {
        this.imagen_sandwiches = imagen_sandwiches;
        this.nombre_sandwiches = nombre_sandwiches;
        this.descripcion_sandwiches = descripcion_sandwiches;
        this.precio_sandwiches = precio_sandwiches;
        //this.boton_OrdenarHamburgesa = boton_OrdenarHamburgesa;
    }
    public int getImagen_sandwiches() {
        return imagen_sandwiches;
    }
    public String getNombre_sandwiches() {
        return nombre_sandwiches;
    }
    public String getDescripcion_sandwiches() {
        return descripcion_sandwiches;
    }
    public String getPrecio_sandwiches() { return precio_sandwiches; }
    //public Button getBoton_OrdenarHamburgesa() { return boton_OrdenarHamburgesa; }
}
