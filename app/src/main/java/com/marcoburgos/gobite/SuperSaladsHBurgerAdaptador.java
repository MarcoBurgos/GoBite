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

public class SuperSaladsHBurgerAdaptador extends RecyclerView.Adapter<SuperSaladsHBurgerAdaptador.productoViewHolder>{
    private ArrayList<SuperSaldasHBurgers_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public SuperSaladsHBurgerAdaptador(ArrayList<SuperSaldasHBurgers_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_supersalads_hburger,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_buger());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_burger());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_burger());
        productoViewHolder.precio.setText(item.get(i).getPrecio_buerger());
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
            nombre=(TextView)itemView.findViewById(R.id.nombreSSBurger);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónSSBurger);
            imagen=(ImageView)itemView.findViewById(R.id.imgSSBurger);
            precio=(TextView)itemView.findViewById(R.id.precioSSBurger);
            contenedor=itemView.findViewById(R.id.cardDetallesSSBurger);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesSSBurger ){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}