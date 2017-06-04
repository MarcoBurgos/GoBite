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

public class SuperSalads_HBurgers extends AppCompatActivity implements SuperSaladsHBurgerAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SuperSaladsHBurgerAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Healthy Burgers");
        setContentView(R.layout.activity_main_supersalads_hburgers);
        ArrayList<SuperSaldasHBurgers_MC> datos = new ArrayList<SuperSaldasHBurgers_MC>();
        datos.add(new SuperSaldasHBurgers_MC(R.drawable.avocadojack, "Avocado Jack", "Hamburgesa de pollo, aguacate y queso jack, con ingredientes 100% orgánicos", "$109.00"));
        datos.add(new SuperSaldasHBurgers_MC(R.drawable.chilaca, "Chilaca Burger", "Pechuga de pollo, jamón de pavo, queso gouda, lechuga, alfalfa y tomate con aderezo Ranch.", "$114.00"));
        datos.add(new SuperSaldasHBurgers_MC(R.drawable.spicybuffalo, "Spicy Buffalo", "Deliciosa hamburgesa con pollo empanizado, bañado en salsa búffalo.", "$105.00"));
        datos.add(new SuperSaldasHBurgers_MC(R.drawable.crispychiken, "Crispy Chicken", "Pechuga de pollo empanizada, queso cheddar, queso pepper jack, tocino, aguacate, tomate, cebolla y salsa de queso.", "$130.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSSHBurgers);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SuperSaladsHBurgerAdaptador(datos);
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

