package com.marcoburgos.gobite;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by marcoburgos on 01/05/17.
 */

public class PizzasAdaptador extends RecyclerView.Adapter<PizzasAdaptador.productoViewHolder>{
    private ArrayList<Pizzas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p, CharSequence nombre, CharSequence precio, byte[] imagen);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public PizzasAdaptador(ArrayList<Pizzas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle_dominos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_pizza());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_pizza());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_pizza());
        productoViewHolder.precio.setText(item.get(i).getprecio_pizza());
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
            nombre=(TextView)itemView.findViewById(R.id.nombrePizza);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónPizza);
            imagen=(ImageView)itemView.findViewById(R.id.imgPizza);
            precio=(TextView)itemView.findViewById(R.id.precioPizza);
            contenedor=itemView.findViewById(R.id.cardDetallesPizzas);
            contenedor.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesPizzas ){
                Bitmap bmp = ((BitmapDrawable)imagen.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                itemClickCallback.onItemClick(getAdapterPosition(), nombre.getText(), precio.getText(), byteArray);
            }
        }

    }
}