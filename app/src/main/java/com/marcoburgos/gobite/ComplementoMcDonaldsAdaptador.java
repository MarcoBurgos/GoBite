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

public class ComplementoMcDonaldsAdaptador extends RecyclerView.Adapter<ComplementoMcDonaldsAdaptador.productoViewHolder>{
    private ArrayList<ComplementosMcDonalds_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public ComplementoMcDonaldsAdaptador(ArrayList<ComplementosMcDonalds_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_complementos_mcd,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_complemento());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_complemento());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_complemento());
        productoViewHolder.precio.setText(item.get(i).getprecio_complemento());
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
        Button botonOrdenarHamburgesa;

        public productoViewHolder(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.nombreComplemento);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónComplemento);
            imagen=(ImageView)itemView.findViewById(R.id.imgComplemento);
            precio=(TextView)itemView.findViewById(R.id.precioComplemento);
            contenedor=itemView.findViewById(R.id.cardDetallesComplementosMcd);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesComplementosMcd ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}