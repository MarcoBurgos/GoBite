package com.marcoburgos.gobite;


import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by marcoburgos on 24/04/17.
 */

public class RestauranteAdaptador extends RecyclerView.Adapter<RestauranteAdaptador.productoViewHolder>{
    private ArrayList<Restaurantes> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

        public RestauranteAdaptador(ArrayList<Restaurantes> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_restaurantes,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);

        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_p());
        productoViewHolder.precio.setText(item.get(i).getPrecio_p());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_p());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class productoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nombre,precio;
        ImageView imagen;
        View contenedor;

        public productoViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.lblNombre);
            precio=(TextView)itemView.findViewById(R.id.lblPrecio);
            imagen=(ImageView)itemView.findViewById(R.id.imgRestaurante);
            contenedor=itemView.findViewById(R.id.cardRestaurantes);
            contenedor.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardRestaurantes ){
                itemClickCallback.onItemClick(getAdapterPosition());
        }
    }

}
}

