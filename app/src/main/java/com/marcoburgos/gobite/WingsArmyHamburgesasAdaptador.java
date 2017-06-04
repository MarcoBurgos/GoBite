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

public class WingsArmyHamburgesasAdaptador extends RecyclerView.Adapter<WingsArmyHamburgesasAdaptador.productoViewHolder>{
    private ArrayList<WingsArmyHamburgesas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public WingsArmyHamburgesasAdaptador(ArrayList<WingsArmyHamburgesas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_wingsarmy_hamburgesas,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_hamburgesa());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_hamburgesa());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_hamburgesa());
        productoViewHolder.precio.setText(item.get(i).getPrecio_hamburgesa());
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
            nombre=(TextView)itemView.findViewById(R.id.nombreWAHamburgesa);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónWAHamburgesa);
            imagen=(ImageView)itemView.findViewById(R.id.imgWAHamburgesa);
            precio=(TextView)itemView.findViewById(R.id.precioWAHamburgesa);
            contenedor=itemView.findViewById(R.id.cardDetallesWAHamburgesa);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesWAHamburgesa ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}