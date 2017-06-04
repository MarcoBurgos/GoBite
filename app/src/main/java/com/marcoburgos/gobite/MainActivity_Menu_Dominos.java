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


public class MainActivity_Menu_Dominos extends AppCompatActivity implements DominosAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private DominosAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Domino's Pizza");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_menus_dominos);
        ArrayList<DominosMenu> datos = new ArrayList<DominosMenu>();
        datos.add(new DominosMenu(R.drawable.tarjetapizza, "Pizzas","Elige tus ingredientes favoritos, masa o selecciona una de nuestras especialidades. ¡Te van a encantar! "));
        datos.add(new DominosMenu(R.drawable.tarjetaentradas, "Entradas", "Si tu hambre es monstruosa, cálmala con unos Papotas o Wings."));
        datos.add(new DominosMenu(R.drawable.tarjetapostres, "Postres", "Si guardas lo más delicioso para el final, estas opciones te van a maravillar"));
        datos.add(new DominosMenu(R.drawable.tarjetabebidas, "Bebidas", "La familia de productos Pepsi van a acompañar tus alimentos, cualquiera que sean tus gustos"));



        reciclador = (RecyclerView) findViewById(R.id.recicladormenusDominos);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new DominosAdaptador(datos);
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
                startActivity(new Intent(MainActivity_Menu_Dominos.this, Dominos_Pizzas.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Menu_Dominos.this, Dominos_Entradas.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Menu_Dominos.this, Dominos_Postres.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity_Menu_Dominos.this, Dominos_Bebidas.class));
            default:
                break;
        }
    }
}