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

public class SuperSalads_Ensaladas extends AppCompatActivity implements SuperSaladsEnsaladasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SuperSaladsEnsaladasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Ensaladas");
        setContentView(R.layout.activity_main_supersalads_ensaladas);
        ArrayList<SuperSaldasEnsaladas_MC> datos = new ArrayList<SuperSaldasEnsaladas_MC>();
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.quinioa, "Quinoa Chicken Grill", "Pollo siracha, garnish con quinoa roja, bulgur, cebollín edamame, pepino, zanahoria, germen de soya, lechuga italiana y sangría con aderezo de Jengibre.", "$129.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.pastaatun, "Pasta con atún", "Atún, pasta, jamón y queso cheddar, con aderezo especial.", "$120.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.bufalotender, "Buffalo Tender", "Pechuga empanizada, salsa buffalo, lechuga, jícama, apio, zanahoria rallada, queso cheddar, bacon bits, frituras y aderezo a tu elección.", "$135.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.capriparadiso, "Capri Paradiso", "Fresa, manzana, queso de cabra, nuez caramelizada, lechuga sangría, lechuga italiana con Raspberry Vinaigrette.", "$115.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.hawaiiancitric, "Hawaiian Citric", "Pollo empanizado con coco, lechuga, mandarina, arándanos, tomate, bolitas de queso crema con cacahuate tostado y perejil, con aderezo Raspberry.", "$98.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.chickenvegiegrilled, "Chicken & Veggie Grilled", "Mix de lechugas, pollo al grill, aguacate, calabazas asadas, tomate cherry, cebolla morada, queso mozarella con vinagreta balsámica o aderezo light a elección.", "$138.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.cesarpollo, "César Pollo", "Pollo, lechuga orejona, croutones, queso parmesano y aderezo César.", "$125.00"));
        datos.add(new SuperSaldasEnsaladas_MC(R.drawable.santafe, "Santa Fe", "Pollo, lechuga mixta, zanahoria, col morada, frituras, queso cheddar y aderezo Ranch.", "$118.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSSEnsaladas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SuperSaladsEnsaladasAdaptador(datos);
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

