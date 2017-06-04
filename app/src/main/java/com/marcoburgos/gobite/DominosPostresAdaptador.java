package com.marcoburgos.gobite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 01/05/17.
 */

public class DominosPostresAdaptador extends RecyclerView.Adapter<DominosPostresAdaptador.productoViewHolder>{
    private ArrayList<DominosPostres_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DominosPostresAdaptador(ArrayList<DominosPostres_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_postres_dominos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_postresDs());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_postresDS());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_postresDs());
        productoViewHolder.precio.setText(item.get(i).getPrecio_postresDS());
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
            nombre=(TextView)itemView.findViewById(R.id.nombrePostresDs);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónPostresDs);
            imagen=(ImageView)itemView.findViewById(R.id.imgPostresDs);
            precio=(TextView)itemView.findViewById(R.id.precioPostresDs);
            contenedor=itemView.findViewById(R.id.cardDetallesPostresDominos);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesPostresDominos ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}