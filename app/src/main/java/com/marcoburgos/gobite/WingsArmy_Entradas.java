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

public class WingsArmy_Entradas extends AppCompatActivity implements WingsArmyEntradasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyEntradasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Entradas");
        setContentView(R.layout.activity_main_wingsarmy_entradas);
        ArrayList<WingsArmyEntradas_MC> datos = new ArrayList<WingsArmyEntradas_MC>();
        datos.add(new WingsArmyEntradas_MC(R.drawable.arosdecebolla, "Aros de Cebolla", "10 Crujientes aros de cebolla empanizados y sazonados al estilo de la casa.", "$45.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.dedoshotzarell, "Dedos de Queso Hotzarella", "6 irresistibles dedos de queso acompañados de salsa mozzarella con un toque picante.", "$49.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.dedosqeso, "Dedos de Queso", "Los tradicionales dedos de queso para comenzar la comida, acompañados de salsa mozzarella.", "$45.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.jalapenoscrema, "Jalapeños con Queso Crema", "Crujientes jalapeños rellenos de queso crema, acompañados de salsa mozzarella.", "$49.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.jalapenoscheddar, "Jalapeños con Queso Cheddar", "Jalapeños empanizados rellenos de irresistible queso cheddar, listos para bañarse en salsa mozzarella.", "$49.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.papaswa, "Papas de la Casa", "Una opción infalible mientras esperas tu platillo principal, 220g de papas a la francesa preparadas y sazonadas con el toque especial del cuartel.", "$40.00"));
        datos.add(new WingsArmyEntradas_MC(R.drawable.verduraswa, "Vegetales", "Para los que les gustan las opciones más saludables. 160g de zanahoria y apio acompañados de un sabroso dip de aderezo.", "$39.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleWAEntradas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyEntradasAdaptador(datos);
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

