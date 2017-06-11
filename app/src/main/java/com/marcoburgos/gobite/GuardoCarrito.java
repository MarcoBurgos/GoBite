package com.marcoburgos.gobite;


import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 09/06/17.
 */

public class GuardoCarrito {
static ArrayList<CarritoCompra_MC> datos = new ArrayList<CarritoCompra_MC>();


    public static void reciboCarrito (Bitmap imagenCarrito, CharSequence tituloCarrito, CharSequence precioCarrito) {
        Log.d("ADebugRecibí", "Value: " + tituloCarrito);
        Log.d("ADebugRecibí", "Value: " + precioCarrito);
        Log.d("ADebugArregloE", "Value: " + datos.toString());
        datos.add(new CarritoCompra_MC(imagenCarrito, tituloCarrito, "Con Todo", "Grande", precioCarrito));
        Log.d("ADebugArreglo", "Value: " + datos.size());
        ArrayList arregloFinal = datos;

    }

    public static ArrayList<CarritoCompra_MC> mandoCarrito() {
        return datos;


    }



}
