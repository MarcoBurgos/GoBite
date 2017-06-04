package com.marcoburgos.gobite;



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

public class MenuAdaptador extends RecyclerView.Adapter<MenuAdaptador.productoViewHolder>{
    private ArrayList<MenuComida> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public MenuAdaptador(ArrayList<MenuComida> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_menu,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);

        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_plato());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_plato());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_plato());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class productoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nombre,descripcion;
        ImageView imagen;
        View contenedor;

        public productoViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.nombrePlatillo);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónPlatillo);
            imagen=(ImageView)itemView.findViewById(R.id.imgPlatillo);
            contenedor=itemView.findViewById(R.id.cardMenus);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardMenus ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}