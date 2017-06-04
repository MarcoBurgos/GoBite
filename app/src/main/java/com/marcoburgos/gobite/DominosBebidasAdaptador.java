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

public class DominosBebidasAdaptador extends RecyclerView.Adapter<DominosBebidasAdaptador.productoViewHolder>{
    private ArrayList<DominosBebidas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DominosBebidasAdaptador(ArrayList<DominosBebidas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_bebidas_dominos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_bebidasDs());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_bebidasDs());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_bebidasDs());
        productoViewHolder.precio.setText(item.get(i).getPrecio_bebidasDs());
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
            nombre=(TextView)itemView.findViewById(R.id.nombreBebidasDs);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónBebidasDs);
            imagen=(ImageView)itemView.findViewById(R.id.imgBebidasDs);
            precio=(TextView)itemView.findViewById(R.id.precioBebidasDs);
            contenedor=itemView.findViewById(R.id.cardDetallesBebidasDominos);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesBebidasDominos ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}