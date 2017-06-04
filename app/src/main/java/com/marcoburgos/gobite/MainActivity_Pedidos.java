package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 24/04/17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity_Pedidos extends AppCompatActivity  {
//public class MainActivity_Pedidos extends AppCompatActivity implements PedidosAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private PedidosAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Mis Pedidos");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_pedidos);
        ArrayList<Pedidos_MC> datos = new ArrayList<Pedidos_MC>();
        datos.add(new Pedidos_MC(R.drawable.mcdonalds, "MD-0001", "Status: Pedido recibido", "Entrega programada: 21:45 horas"));
        datos.add(new Pedidos_MC(R.drawable.dominos, "DP-001", "Status: Pedido en preparación", "Entrega programada: No"));
        datos.add(new Pedidos_MC(R.drawable.chilis, "CH-001", "Status: Pasar a recoger", "Entrega programada: No"));
        datos.add(new Pedidos_MC(R.drawable.subway, "SW-001", "Status: Entregado", "Fecha: 16/May/2017"));




        reciclador = (RecyclerView) findViewById(R.id.recicladorPedidos);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new PedidosAdaptador(datos); //agregado this
        reciclador.setAdapter(adaptador);
        //adaptador.setItemClickCallback(this);


    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.menu_main, menu);
     //   return true;
    //}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, Landing.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
        //}

        //return super.onOptionsItemSelected(item);
    }

    /*@Override
    public void onItemClick(int p) {
        switch(p){
            case 0:
                startActivity(new Intent(MainActivity_Pedidos.this, MainActivity_Menu.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Pedidos.this, MainActivity_Menu_Dominos.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Pedidos.this, MainActivity_Menu_Dominos.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity_Pedidos.this, MainActivity_Menu_Dominos.class));
                break;


            default:
                break;
        }

        // Intent i = new Intent(this, MainActivity_Menu.class);
        //startActivity(i);
    }
    */

}

