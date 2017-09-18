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

import java.util.ArrayList;

public class BlankFragment extends Fragment {


    ArrayList productosCarrito;



    public void recuperoCarrito(GuardoCarrito reciboCarrito) {
        productosCarrito = reciboCarrito.mandoCarrito();
    }







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
        recuperoCarrito(new GuardoCarrito());
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);


        rv.setHasFixedSize(true);

        MyAdapterSum adapter = new MyAdapterSum(productosCarrito);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;




    }


}


