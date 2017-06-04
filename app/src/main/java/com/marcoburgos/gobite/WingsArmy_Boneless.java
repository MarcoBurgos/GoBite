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

public class WingsArmy_Boneless extends AppCompatActivity implements WingsArmyBonelessAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyBonelessAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Boneless");
        setContentView(R.layout.activity_main_wingsarmy_boneless);
        ArrayList<WingsArmyBoneless_MC> datos = new ArrayList<WingsArmyBoneless_MC>();
        datos.add(new WingsArmyBoneless_MC(R.drawable.empanizados, "Empanizado", "Jugosos trocitos de pechuga de pollo empanizados, bañados con tu salsa favorita y acompañados con zanahoria y apio.", "$65.00"));
        datos.add(new WingsArmyBoneless_MC(R.drawable.empanizadoslight, "Empanizados Light", "Trocitos de pechuga sazonados a la plancha.", "$60.00"));
        datos.add(new WingsArmyBoneless_MC(R.drawable.tirasboneless, "Boneless Tiras", "Lo mejor del pollo, sin huesos, para que degustes con tu salsa favorita.", "$65.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleWABoneless);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyBonelessAdaptador(datos);
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

