package com.marcoburgos.gobite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 30/04/17.
 */

public class Subway_Galletas extends AppCompatActivity implements GalletasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private GalletasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Galletas y postres");
        setContentView(R.layout.activity_main_galletas);
        ArrayList<Galletas_MC> datos = new ArrayList<Galletas_MC>();
        datos.add(new Galletas_MC(R.drawable.chispaschocolate, "Chispas de Chocolate", "Nuestras originales galletas que a todo el mundo en canta con un toque de chocolate que te fascinarán.", "$15.00"));
        datos.add(new Galletas_MC(R.drawable.doblechocolate, "Doble chocolate", "Para los amantes del chocolate, una ración doble para satisfacer a los paladares más exiguentes", "$15.00"));
        datos.add(new Galletas_MC(R.drawable.macadami, "Macadamia", "Todo el sabor exótico de la macadamia lo encontrarás en esta galleta, que simplemente te encantará", "$15.00"));
        datos.add(new Galletas_MC(R.drawable.avenapasas, "Avena con pasas", "El postre perfecto para no sentir culpa, avena y pasas ayudarán a tu digestión y satisfacirán a tu paladar", "$15.00"));
        datos.add(new Galletas_MC(R.drawable.raspberry, "Raspberry Cheescake", "El sabor de un pay de queso con fambruesa capturado en una galleta, que hará que no puedas dejar de comerlas", "$15.00"));
        datos.add(new Galletas_MC(R.drawable.paymanzana, "Pay de Manzana", "Delicioso pay de manzana, con cubierta bañada con jarabe.","$20.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleGalletas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new GalletasAdaptador(datos);
        reciclador.setAdapter(adaptador);
        adaptador.setItemClickCallback(this);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity_Menu_Subway.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}
    @Override
    public void onItemClick(int p) {
        Intent i = new Intent(this, ConfigurarPizza.class);
        startActivity(i);
    }
}