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

public class Dominos_Postres extends AppCompatActivity implements DominosPostresAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private DominosPostresAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Postres");
        setContentView(R.layout.activity_main_dominos_postres);
        ArrayList<DominosPostres_MC> datos = new ArrayList<DominosPostres_MC>();
        datos.add(new DominosPostres_MC(R.drawable.canelabitz, "Canela Baitz", "Deliciosos y pequeños bocados horneados espolvoreados con canela y azúcar, acompañados con dip de capuchino.", "$35.00"));
        datos.add(new DominosPostres_MC(R.drawable.sweetbread, "Sweet Bread de Manzana", "Delicioso pan horneado relleno de mermelada con trozos de manzana, espolvoreado con un dulce toque de canela y azúcar.", "$40.00"));
        //datos.add(new DominosPostres_MC(R.drawable.wings, "Wings", "Alitas de pollo doraditas al horno y bañadas en salsa picante.", "$98.00"));
        //datos.add(new Pizzas_MC(R.drawable.tarjetamexicana, "Mexicana", "Chorizo, Carne Molida, Cebolla, Jalapeño.", "$90.00"));
        //datos.add(new Pizzas_MC(R.drawable.tarjetacfrias, "Carnes Frías", "Salami, Pepperoni, Jamón, Finas Hierbas.", "$98.00"));
        //datos.add(new Pizzas_MC(R.drawable.tarjetabrava, "Bravísima", "Pollo, Chorizo, Queso Crema, Salsa 3 Chiles.", "$98.00"));
        //datos.add(new Pizzas_MC(R.drawable.tarjetaqueso, "4 Quesos", "Mozzarella, Cheddar, Queso Crema y Parmesano.", "$98.00"));
        //datos.add(new Pizzas_MC(R.drawable.tarjetaveggie, "Veggie", "Pimiento, Champiñones, Aceitunas, Cebolla.", "$98.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetallePostresDominos);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new DominosPostresAdaptador(datos);
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
                Intent intent = new Intent(this, MainActivity_Menu_Dominos.class);
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