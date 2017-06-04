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

public class WingsArmy_Hamburgesas extends AppCompatActivity implements WingsArmyHamburgesasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyHamburgesasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Hamburgesas");
        setContentView(R.layout.activity_main_wingsarmy_hamburgesas);
        ArrayList<WingsArmyHamburgesas_MC> datos = new ArrayList<WingsArmyHamburgesas_MC>();
        datos.add(new WingsArmyHamburgesas_MC(R.drawable.chickenparrilla, "Army Chicken a la Parrilla", "Pechuga de pollo al grill, Ranch, cebolla, tomate, lechuga, y queso blanco. Contenido: 150g pechuga de pollo y 220g de papa.", "$99.00"));
        datos.add(new WingsArmyHamburgesas_MC(R.drawable.chickenparrilla, "Army Chicken Crispy", "Pechuga de pollo empanizada, cebolla, tomate, lechuga, ranch, y queso blanco. 150 g pechuga de pollo- 220g de papa.", "$99.00"));
        datos.add(new WingsArmyHamburgesas_MC(R.drawable.armyburger, "Army Burger", "Carne de res, queso blanco, blue cheese y salsa original hot. Contenido: 180g de res y 220g de papa.", "$99.00"));
        datos.add(new WingsArmyHamburgesas_MC(R.drawable.army2, "Army 2", "Carne de res, queso blanco, aros de cebolla, Ranch, y salsa ahumada. Contenido: 180g de res, 3 pzas aros de cebolla y 220g de papa.", "$109.00"));
        datos.add(new WingsArmyHamburgesas_MC(R.drawable.armyclassic, "Army Clásica", "Carne de res, cebolla, tomate, lechuga, Ranch, y queso blanco. Contenido: 180g de res y 200g de papa.", "$89.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleWAHamburgesas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyHamburgesasAdaptador(datos);
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
                Intent intent = new Intent(this, MainActivity_Menu_WingsArmy.class);
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

