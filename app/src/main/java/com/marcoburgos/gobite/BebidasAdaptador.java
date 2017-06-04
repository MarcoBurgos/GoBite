package com.marcoburgos.gobite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 01/05/17.
 */

public class BebidasAdaptador extends RecyclerView.Adapter<BebidasAdaptador.productoViewHolder>{
    private ArrayList<Bebidas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public BebidasAdaptador(ArrayList<Bebidas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_bebidas_subway,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_bebidas());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_bebidas());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_bebidas());
        productoViewHolder.precio.setText(item.get(i).getPrecio_bebidas());
        //productoViewHolder.botonOrdenarHamburgesa.setImageResource(item.get(i).getBoton_OrdenarHamburgesa());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class productoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nombre,descripcion, precio;
        ImageView imagen;
        View contenedor;


        public productoViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.nombreBebidasSw);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónBebidasSw);
            imagen=(ImageView)itemView.findViewById(R.id.imgBebidasSw);
            precio=(TextView)itemView.findViewById(R.id.precioBebidasSw);
            contenedor=itemView.findViewById(R.id.cardDetallesBebidasSubway);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesBebidasSubway ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}