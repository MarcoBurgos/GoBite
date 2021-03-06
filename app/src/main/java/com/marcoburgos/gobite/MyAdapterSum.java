package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 04/05/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapterSum extends RecyclerView.Adapter<MyAdapterSum.MyViewHolder> {
    private ArrayList<CarritoCompra_MC> item = null;
    //private String[] mDataset;

    public MyAdapterSum(ArrayList<CarritoCompra_MC> item) {
        this.item = item;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,descripcion, precio, tamaño;
        ImageView imagen;
        View contenedor;

        //public ImageView mCardView;
        //public TextView mTextView;
        //public TextView dTextView;
        //public TextView pTextView;
        public MyViewHolder(View v){
            super(v);

            nombre=(TextView) v.findViewById(R.id.nombreProductoCarrito);
            descripcion=(TextView) v.findViewById(R.id.descripcionArmado);
            imagen=(ImageView) v.findViewById(R.id.imgProductoCarrito);
            precio=(TextView) v.findViewById(R.id.precioProductoCarrito);
            tamaño=(TextView) v.findViewById(R.id.tamañoProductoCarrito);
            contenedor= v.findViewById(R.id.card_view);


            //mCardView = (ImageView) v.findViewById(R.id.imgProductoCarrito);
            //mTextView = (TextView) v.findViewById(R.id.nombreProductoCarrito);
            //dTextView = (TextView) v.findViewById(R.id.descripcionArmado);
            //pTextView = (TextView) v.findViewById(R.id.precioProductoCarrito);

        }

    }


    @Override
    public MyAdapterSum.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i){
        holder.nombre.setText(item.get(i).getNombre_productoCarrito());
        holder.descripcion.setText(item.get(i).getDescripcion_productoCarrito());
        holder.imagen.setImageBitmap(item.get(i).getImagen_productoCarrito());
        holder.precio.setText(item.get(i).getPrecio_productoCarrito());
        holder.tamaño.setText(item.get(i).getTamaño_productoCarrito());


        //holder.mTextView.setText(mDataset[i]);
        //holder.mCardView.setImageResource(R.drawable.anguscbo);
        //holder.dTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}