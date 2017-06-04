package com.marcoburgos.gobite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 05/05/17.
 */


public class DominosAdaptador extends RecyclerView.Adapter<DominosAdaptador.productoViewHolder>{
    private ArrayList<DominosMenu> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DominosAdaptador(ArrayList<DominosMenu> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_menu_dominos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);

        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_platoDominos());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_platoDominos());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_platoDominos());

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
            nombre=(TextView)itemView.findViewById(R.id.nombrePlatilloDominos);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónPlatilloDominos);
            imagen=(ImageView)itemView.findViewById(R.id.imgPlatilloDominos);
            contenedor=itemView.findViewById(R.id.cardMenusDominos);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardMenusDominos ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}