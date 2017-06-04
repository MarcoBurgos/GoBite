package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 30/04/17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity_Menu_Subway extends AppCompatActivity implements SubwayAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SubwayAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Subway");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_menus_subway);
        ArrayList<SubwayMenu> datos = new ArrayList<SubwayMenu>();
        datos.add(new SubwayMenu(R.drawable.tarjetasubwaysubway, "Sándwiches","Ordena nuestros famosos Subways, una cascada de sabor en 15 o 30 centímetros"));
        datos.add(new SubwayMenu(R.drawable.tarjetasubwaygalleta, "Galletas y postres", "Complementa tu orden con una de nuestras deliciosas galletas o papas fritas"));
        datos.add(new SubwayMenu(R.drawable.tarjetabebidas, "Bebidas", "La familia de productos Pepsi van a acompañar tus alimentos, cualquiera que sean tus gustos."));
        //datos.add(new DominosMenu(R.drawable.tarjetabebidas, "Bebidas", "La familia de productos Pepsi van a acompañar tus alimentos, cualquiera que sean tus gustos"));



        reciclador = (RecyclerView) findViewById(R.id.recicladormenusSubway);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SubwayAdaptador(datos);
        reciclador.setAdapter(adaptador);
        adaptador.setItemClickCallback(this);


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
                Intent intent = new Intent(this, MainActivity_Restaurantes.class);
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

    @Override
    public void onItemClick(int p) {
        switch(p){
            case 0:
                startActivity(new Intent(MainActivity_Menu_Subway.this, Subway_Sandwiches.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Menu_Subway.this, Subway_Galletas.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Menu_Subway.this, Subway_Bebidas.class));
                break;
            default:
                break;
        }
    }
}