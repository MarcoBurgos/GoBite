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

public class SuperSalads_Sopas extends AppCompatActivity implements SuperSaladsSopasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SuperSaladsSopasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Sopas");
        setContentView(R.layout.activity_main_supersalads_sopas);
        ArrayList<SuperSaldasSopas_MC> datos = new ArrayList<SuperSaldasSopas_MC>();
        datos.add(new SuperSaldasSopas_MC(R.drawable.tlalpeno, "Caldo Tlalpeño", "Caldo tradicional mexicano que contiene carne de pollo, elote, garbanzo, papa y zanahoria, sumergidas en un caldo de pollo, con ajo y cebolla, sazonado con epazote y chile chipotle.", "$79.00"));
        datos.add(new SuperSaldasSopas_MC(R.drawable.sopatortilla, "Sopa de Tortilla", "Sopa tradicional mexicana elaborada a partir de tiras de tortilla de maíz frita, que se sumergen en un caldo de jitomates molidos con ajo y cebolla, sazonado con perejil y chiles de árbol molidos.", "$70.00"));
        datos.add(new SuperSaldasSopas_MC(R.drawable.sbrocolo, "Crema de Brócoli", "Muy simple pero deliciosa para una tarde fría o una cena sencilla.", "$99.00"));
        datos.add(new SuperSaldasSopas_MC(R.drawable.celote, "Crema de elote", "La mejor opción para abrir apetito, con esta sopa de elote caliente y nutritiva", "$84.00"));
        datos.add(new SuperSaldasSopas_MC(R.drawable.talarines, "Tallarines con Verduras y Pollo", "La forma más sana de comer y con gran sabor que te encantará", "$98.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSSSopas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SuperSaladsSopasAdaptador(datos);
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

