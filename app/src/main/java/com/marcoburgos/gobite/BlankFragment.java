package com.marcoburgos.gobite;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BlankFragment extends Fragment  {

    String tituloRecibido;
    ImageView imagenCarrito;



    public BlankFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);


        String tituloDetalle;
        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null) {
                tituloDetalle= null;
            } else {
                tituloDetalle= extras.getString("TitularCarrito");
            }
        } else {
            tituloDetalle= (String) savedInstanceState.getSerializable("TitularCarrito");
        }
        tituloRecibido =tituloDetalle;

        imagenCarrito =(ImageView) rootView.findViewById(R.id.imageHamburgesaDetalle);
        byte[] byteArray = getActivity().getIntent().getByteArrayExtra("Imagen");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);



        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        ArrayList<Carrito_MC> datos = new ArrayList<Carrito_MC>();
        datos.add(new Carrito_MC(bmp, tituloDetalle, "Con Todo", "Grande", "$79.00"));

        MyAdapter adapter = new MyAdapter(datos);


        //MyAdapter adapter = new MyAdapter(new String[]{"Big Mac","Cuarto de Libra", "Mc Pollo", "Angus BCO", "Big Mac"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}


