package com.marcoburgos.gobite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static android.R.attr.thumbnail;
import static java.security.AccessController.getContext;

/**
 * Created by marcoburgos on 01/05/17.
 */

public class HamburgesasAdaptador extends RecyclerView.Adapter<HamburgesasAdaptador.productoViewHolder>{
    private ArrayList<Hamburgesas_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p, CharSequence nombre, CharSequence precio, byte[] imagen);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public HamburgesasAdaptador(ArrayList<Hamburgesas_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_detalle,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);
        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.nombre.setText(item.get(i).getNombre_hamburgesa());
        productoViewHolder.descripcion.setText(item.get(i).getDescripcion_hamburgesa());
        productoViewHolder.imagen.setImageResource(item.get(i).getImagen_hamburgesa());
        productoViewHolder.precio.setText(item.get(i).getprecio_hamburgesa());
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
            nombre=(TextView)itemView.findViewById(R.id.nombreHamburgesa);
            descripcion=(TextView)itemView.findViewById(R.id.descripciónHamburgesa);
            imagen=(ImageView)itemView.findViewById(R.id.imgHamburgesa);
            precio=(TextView)itemView.findViewById(R.id.precioHamburgesa);
            contenedor=itemView.findViewById(R.id.cardDetallesHamburgesas);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardDetallesHamburgesas ){
                Bitmap bmp = ((BitmapDrawable)imagen.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                itemClickCallback.onItemClick(getAdapterPosition(), nombre.getText(), precio.getText(), byteArray);
            }
        }

    }
}