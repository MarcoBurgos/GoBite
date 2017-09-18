package com.marcoburgos.gobite;


import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 09/06/17.
 */

public class GuardoCarrito {
static ArrayList<CarritoCompra_MC> datos = new ArrayList<CarritoCompra_MC>();
    static Float precioTotalCarrito;
    static Float mandoPrecio = Float.valueOf(0);



    public static void reciboCarrito (Bitmap imagenCarrito, CharSequence tituloCarrito, CharSequence precioCarrito) {
        datos.add(new CarritoCompra_MC(imagenCarrito, tituloCarrito, "Con Todo", "Grande", precioCarrito));
        CharSequence cadenaCorta = precioCarrito.toString().substring(1);
        Float precioacumulado = Float.parseFloat(cadenaCorta.toString());
        mandoPrecio = mandoPrecio+precioacumulado;
        precioTotalCarrito = mandoPrecio;

    }

    public static void borroCarrito() {
        datos.clear();
    }

    public static ArrayList<CarritoCompra_MC> mandoCarrito() {
        return datos;

    }

    public static Float mandoPrecio(){
        /*Log.d("ADebugPrecio", "Value: " + precioTotalCarrito);
        Float precioFloat = Float.parseFloat(precioTotalCarrito);
        Log.d("ADebugPrecio", "Value: " + precioFloat.toString());*/
        return precioTotalCarrito;
    }


    public static int mandoTamañoCarrito(){
        int tamañoCarrito = datos.size();
        Log.d("ADebugTamaño", "Value: " + tamañoCarrito);
        return tamañoCarrito;
    }



}
