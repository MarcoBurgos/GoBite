package com.marcoburgos.gobite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BlankFragment extends Fragment  {


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

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        ArrayList<Carrito_MC> datos = new ArrayList<Carrito_MC>();
        datos.add(new Carrito_MC(R.drawable.bigmac, "Big Mac", "Con Todo", "Grande", "$79.00"));

        MyAdapter adapter = new MyAdapter(datos);


        //MyAdapter adapter = new MyAdapter(new String[]{"Big Mac","Cuarto de Libra", "Mc Pollo", "Angus BCO", "Big Mac"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}