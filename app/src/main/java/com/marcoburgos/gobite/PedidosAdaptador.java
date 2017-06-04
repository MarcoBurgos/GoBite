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

public class PedidosAdaptador extends RecyclerView.Adapter<PedidosAdaptador.productoViewHolder>{
    private ArrayList<Pedidos_MC> item;

    private ItemClickCallback itemClickCallback;
    public interface ItemClickCallback {
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

        public PedidosAdaptador(ArrayList<Pedidos_MC> item) {
        this.item = item;
    }

    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_pedidos,viewGroup,false);
        productoViewHolder producto= new productoViewHolder(v);

        return producto;
    }

    @Override
    public void onBindViewHolder(productoViewHolder productoViewHolder, int i) {
        productoViewHolder.idPedido.setText(item.get(i).getIdPedido());
        productoViewHolder.status.setText(item.get(i).getStatusPedido());
        productoViewHolder.programacion.setText(item.get(i).getProgramacionPedido());
        productoViewHolder.imagen.setImageResource(item.get(i).getImageRestaurante());

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class productoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView idPedido,status, programacion;
        ImageView imagen;
        View contenedor;

        public productoViewHolder(View itemView) {
            super(itemView);
            idPedido=(TextView)itemView.findViewById(R.id.lblNombre);
            status=(TextView)itemView.findViewById(R.id.lblStatus);
            imagen=(ImageView)itemView.findViewById(R.id.imgRestaurantePedidos);
            programacion=(TextView)itemView.findViewById(R.id.lblProgramdo);
            contenedor=itemView.findViewById(R.id.cardPedidos);
            contenedor.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cardPedidos ){
                itemClickCallback.onItemClick(getAdapterPosition());
        }
    }

}
}

