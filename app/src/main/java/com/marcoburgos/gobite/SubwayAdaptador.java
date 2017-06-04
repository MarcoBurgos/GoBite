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

public class SubwayAdaptador extends RecyclerView.Adapter<SubwayAdaptador.productoViewHolder>{
    private ArrayList<SubwayMenu> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public SubwayAdaptador(ArrayList<SubwayMenu> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_menu_subway,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);

        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_sandwich());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_sandwich());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_sandwich());

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
            nombre=(TextView)itemView.findViewById(R.id.nombrePlatilloSubway);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónPlatilloSubway);
            imagen=(ImageView)itemView.findViewById(R.id.imgPlatilloSubway);
            contenedor=itemView.findViewById(R.id.cardMenusSubway);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardMenusSubway ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}