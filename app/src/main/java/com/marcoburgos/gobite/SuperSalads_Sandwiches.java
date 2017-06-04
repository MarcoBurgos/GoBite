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

public class SuperSalads_Sandwiches extends AppCompatActivity implements SuperSaladsSandAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SuperSaladsSandAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Sándwiches");
        setContentView(R.layout.activity_main_supersalads_sandwiches);
        ArrayList<SuperSaldasSandwiches_MC> datos = new ArrayList<SuperSaldasSandwiches_MC>();
        datos.add(new SuperSaldasSandwiches_MC(R.drawable.chickenswiss, "Chicken Swiss", "Pollo empanizado, lechuga, tomate, cebolla morada, queso suizo y aderezo Ranch.", "$99.00"));
        datos.add(new SuperSaldasSandwiches_MC(R.drawable.ranchero, "Ranchero", "Jamón de pechuga de pavo, jamón de pavo, queso gouda, lechuga, alfalfa y tomate con aderezo Ranch.", "$98.00"));
        datos.add(new SuperSaldasSandwiches_MC(R.drawable.tunacheese, "Tuna Cheese", "Mezcla de atún especial y queso suizo.", "$105.00"));
        datos.add(new SuperSaldasSandwiches_MC(R.drawable.hamycheese, "Ham & Cheese", "Pan de 3 chiles, jamón y pechuga de pavo, queso cheddar, queso pepper jack, tocino, aguacate, tomate, cebolla y salsa de queso.", "$115.00"));
        datos.add(new SuperSaldasSandwiches_MC(R.drawable.vegetariansand, "Vegetarian Grill", "Pan de 3 chiles, portobello, calabaza y tomate asado, guacamole, cebolla morada, aceite de olivo, queso oaxaca y mayonesa ahumada.", "$88.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSSSand);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SuperSaladsSandAdaptador(datos);
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
                Intent intent = new Intent(this, MainActivity_Menu_SuperSalad.class);
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

