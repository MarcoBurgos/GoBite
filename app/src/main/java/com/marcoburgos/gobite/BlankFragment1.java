package com.marcoburgos.gobite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

;

public class BlankFragment1 extends Fragment {

    Float precioCarrito;
    int tamañoCarrito;
    TextView articulosTotales, precioTotal;

    public void recuperoPrecioCarrito(GuardoCarrito clase) {
        precioCarrito = clase.mandoPrecio();
    }
    public void recuperoTamañoCarrito(GuardoCarrito clase) {
        tamañoCarrito = clase.mandoTamañoCarrito();
    }

    public BlankFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank1, container, false);

        recuperoPrecioCarrito(new GuardoCarrito());
        recuperoTamañoCarrito(new GuardoCarrito());

        articulosTotales = (TextView)rootView.findViewById(R.id.numItems);
        precioTotal = (TextView) rootView.findViewById(R.id.totalPagar);
        articulosTotales.setText("Artículos: "+ tamañoCarrito);
        precioTotal.setText("El total a pagar es de: $"+ precioCarrito + " pesos");




        return rootView;
    }

}

//totalPagar
//numItems