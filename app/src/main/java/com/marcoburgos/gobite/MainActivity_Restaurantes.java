package com.marcoburgos.gobite;

/**
 * Created by marcoburgos on 24/04/17.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity_Restaurantes extends AppCompatActivity implements RestauranteAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private RestauranteAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Restaurantes");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_restaurantes);
        ArrayList<Restaurantes> datos = new ArrayList<Restaurantes>();
        datos.add(new Restaurantes(R.drawable.mcdonalds, "McDonalds", "Me encanta"));
        datos.add(new Restaurantes(R.drawable.dominos, "Domino's Pizza", "Somos los experto en pizzas"));
        datos.add(new Restaurantes(R.drawable.subway, "Subway", "Come rico y sano"));
        datos.add(new Restaurantes(R.drawable.supersalads, "Super Salads", "Ensaladas saludables"));
        datos.add(new Restaurantes(R.drawable.logowingsarmy, "Wings Army", "Las mejores alitas en la ciudad"));



        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new RestauranteAdaptador(datos); //agregado this
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

    @Override
    public void onItemClick(int p) {
        switch(p){
            case 0:
                startActivity(new Intent(MainActivity_Restaurantes.this, MainActivity_Menu.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Restaurantes.this, MainActivity_Menu_Dominos.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Restaurantes.this, MainActivity_Menu_Subway.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity_Restaurantes.this, MainActivity_Menu_SuperSalad.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity_Restaurantes.this, MainActivity_Menu_WingsArmy.class));
            default:
                break;
        }

    }
}

