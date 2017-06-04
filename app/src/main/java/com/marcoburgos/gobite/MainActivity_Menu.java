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


public class MainActivity_Menu extends AppCompatActivity implements MenuAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private MenuAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("McDonalds");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_menus);
        ArrayList<MenuComida> datos = new ArrayList<MenuComida>();
        datos.add(new MenuComida(R.drawable.tarjetahamburgesaalternativa, "Hamburgesas", "Desde el Clásico BigMac hasta el increíble Angus Tasty.\n" +
                "Disfruta de nuestras hamburguesas, hechas 100% de carne vacuna."));
        datos.add(new MenuComida(R.drawable.tarjetabebidaalternativa, "Bebidas", "Calma tu sed con refrescos o jugos. O disfruta nuestros smoothies o cafés"));
        datos.add(new MenuComida(R.drawable.tarjetacomplementoalternativa, "Complementos", "Papas a la francesa, McPatatas o ensaladas, lo necesario para cubrir tu hambre"));
        datos.add(new MenuComida(R.drawable.tarjetapostrealternativa, "Postres", "Si las galletas Oreo te gustan por sí solas ¡imagínate acompañarlas con nuestra deliciosa mezcla de helado 100% de leche!"));



        reciclador = (RecyclerView) findViewById(R.id.recicladormenus);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new MenuAdaptador(datos);
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
                startActivity(new Intent(MainActivity_Menu.this, McDonalds_Hamburgesas.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Menu.this, McDonalds_Bebidas.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Menu.this, McDonalds_Complementos.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity_Menu.this, McDonalds_Postres.class));
            default:
                break;
        }
    }
}