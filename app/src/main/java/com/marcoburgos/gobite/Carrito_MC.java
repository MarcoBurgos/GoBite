package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 05/05/17.
 */

public class Carrito_MC {
    private int imagen_productoCarrito;
    private String nombre_productoCarrito;
    private String descripcion_productoCarrito;
    private String tamaño_productoCarrito;
    private String precio_productoCarrito;


    public Carrito_MC(int imagen_productoCarrito, String nombre_productoCarrito, String descripcion_productoCarrito, String tamaño_productoCarrito, String precio_productoCarrito) {
        this.imagen_productoCarrito = imagen_productoCarrito;
        this.nombre_productoCarrito = nombre_productoCarrito;
        this.descripcion_productoCarrito = descripcion_productoCarrito;
        this.tamaño_productoCarrito = tamaño_productoCarrito;
        this. precio_productoCarrito = precio_productoCarrito;
    }

    public int getImagen_productoCarrito() {
        return imagen_productoCarrito;
    }

    public String getNombre_productoCarrito() {
        return nombre_productoCarrito;
    }

    public String getDescripcion_productoCarrito() {
        return descripcion_productoCarrito;
    }

    public String getTamaño_productoCarrito() {
        return tamaño_productoCarrito;
    }

    public String getPrecio_productoCarrito() {
        return precio_productoCarrito;
    }
}


