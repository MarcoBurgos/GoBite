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

public class WingsArmy_Alitas extends AppCompatActivity implements WingsArmyAlitasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyAlitasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Alitas");
        setContentView(R.layout.activity_main_wingsarmy_alitas);
        ArrayList<WingsArmyAlistas_MC> datos = new ArrayList<WingsArmyAlistas_MC>();
        datos.add(new WingsArmyAlistas_MC(R.drawable.ahumadas, "Alitas Ahumadas", "Nuestras jugosas alitas bañadas en salsa BBQ con un toque ahumado.", "$79.00"));
        datos.add(new WingsArmyAlistas_MC(R.drawable.bbqhot, "Alitas BBQ Hot", "Nuestras jugosas alitas bañadas en una mezcla de salsa BBQ picosa. ¡Acompañalas con una cerveza tipo Pilsner!", "$79.00"));
        datos.add(new WingsArmyAlistas_MC(R.drawable.alitasbomba, "Alitas Bomba", "¡Para los valientes! Nuestras alitas bañadas con una combinación de 3 salsas ardientes.", "$79.00"));
        datos.add(new WingsArmyAlistas_MC(R.drawable.garlicparmesano, "Garlic Parmesan", "Nuestras alitas cubiertas de una combinación ganadora de ajo y queso parmesano. Pruébalas con una cerveza afrutada.", "$79.00"));
        datos.add(new WingsArmyAlistas_MC(R.drawable.happyoyster, "Alitas Happy Oyster", "Una sabrosa salsa con un toque de licor cubre en su totalidad nuestras jugosas alitas. Excelentes si buscas probar algo diferente.", "$79.00"));
        datos.add(new WingsArmyAlistas_MC(R.drawable.lemmonpeper, "Alitas Lemon Pepper", "Una mezcla especial de pimienta y limón le dan a estas alitas carácter de sobra. Seguro te van a encantar.", "$79.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleWAAlitas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyAlitasAdaptador(datos);
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

