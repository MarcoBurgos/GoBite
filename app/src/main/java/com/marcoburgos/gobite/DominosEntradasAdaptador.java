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

public class DominosEntradasAdaptador extends RecyclerView.Adapter<DominosEntradasAdaptador.productoViewHolder>{
    private ArrayList<DominosEntradas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DominosEntradasAdaptador(ArrayList<DominosEntradas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_entradas_dominos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_entrada());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_entrada());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_entrada());
        productoViewHolder.precio.setText(item.get(i).getPrecio_entrada());
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
            nombre=(TextView)itemView.findViewById(R.id.nombreEntradas);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónEntradas);
            imagen=(ImageView)itemView.findViewById(R.id.imgEntradas);
            precio=(TextView)itemView.findViewById(R.id.precioEntradas);
            contenedor=itemView.findViewById(R.id.cardDetallesEntradasDominos);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesEntradasDominos ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}