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

public class SuperSalads_Bebidas extends AppCompatActivity implements SuperSaladsBebidasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SuperSaladsBebidasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Bebidas");
        setContentView(R.layout.activity_main_supersalads_bebidas);
        ArrayList<SuperSaldasBebidas_MC> datos = new ArrayList<SuperSaldasBebidas_MC>();
        datos.add(new SuperSaldasBebidas_MC(R.drawable.pepsids, "Pepsi", "Experimenta todo el sabor cola, refrescando y amplificando cada momento", "$30.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.plightds, "Pepsi Light", "Experimenta y comparte el gran sabor cola, sin calorías.", "$30.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.up7ds, "7 Up", "Agua, burbujas y los refrescantes sabores naturales de la lima y limón.", "$30.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.manzanitads, "Manzanita", "Con un toque de jugo natural de manzana, delicioso aroma y un sabor irresistible.", "$30.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.mirindads, "Mirinda", "Delicioso sabor naranja, muy burbujeante y de color intenso.", "$30.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.liptonds, "Lipton Limón", "Todo el delicioso y refescante sabor del té negro con un toque de limón.", "$28.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.liptonverdeds, "Liptón Verde", "Disfruta las bondades del té verde con cítricos.", "$28.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.epurads, "Epura", "Agua purificada que te hidrata y cuida tu corazón, por no contener sodio.", "$20.00"));
        datos.add(new SuperSaldasBebidas_MC(R.drawable.sabritas, "Papas Sabritas", "Deliciosas papas Sabritas sabor original de 60 gramos", "$25.00"));




        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSSBebidas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SuperSaladsBebidasAdaptador(datos);
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

