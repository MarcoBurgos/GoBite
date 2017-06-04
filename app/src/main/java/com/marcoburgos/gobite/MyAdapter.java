package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 04/05/17.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView mCardView;
        public TextView mTextView;
        //public TextView dTextView;
        //public TextView pTextView;
        public MyViewHolder(View v){
            super(v);

            mCardView = (ImageView) v.findViewById(R.id.imgProductoCarrito);
            mTextView = (TextView) v.findViewById(R.id.nombreProductoCarrito);
            //dTextView = (TextView) v.findViewById(R.id.descripcionArmado);
            //pTextView = (TextView) v.findViewById(R.id.precioProductoCarrito);

        }

    }

    public MyAdapter(String[] myDataset){
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.mTextView.setText(mDataset[position]);
        holder.mCardView.setImageResource(R.drawable.anguscbo);
        //holder.dTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() { return mDataset.length; }

}