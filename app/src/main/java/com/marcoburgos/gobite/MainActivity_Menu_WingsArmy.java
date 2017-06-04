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


public class MainActivity_Menu_WingsArmy extends AppCompatActivity implements WingsArmyMenuAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyMenuAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Wings Army");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main_menus_wingsarmy);
        ArrayList<WingsArmyMenu_MC> datos = new ArrayList<WingsArmyMenu_MC>();
        datos.add(new WingsArmyMenu_MC(R.drawable.tarjetaalitaswa, "Alitas","Encántate con nuestra variedad de alitas, las mejores de la ciudad."));
        datos.add(new WingsArmyMenu_MC(R.drawable.tarjetahamburwa, "Hamburgesas", "Carne a la parrilla con papas a la francesa para deleitar a los paladares más exclusivos."));
        datos.add(new WingsArmyMenu_MC(R.drawable.tarjetaentradaswa, "Entradas", "¿Hambre algo rápido? Prueba nuestras entradas que te dejarán chupando los dedos."));
        datos.add(new WingsArmyMenu_MC(R.drawable.tarjetaboneless, "Boneless", "Lo más delicioso del pollo, bañado con la salsa de tu preferencia, dulce o picante, tù eliges."));
        datos.add(new WingsArmyMenu_MC(R.drawable.tarjetacervezaswa, "Cervezas", "Échate un clavado en nuestra gran seleccion y pide la que más te guste."));



        reciclador = (RecyclerView) findViewById(R.id.recicladormenusWA);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyMenuAdaptador(datos);
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
                startActivity(new Intent(MainActivity_Menu_WingsArmy.this, WingsArmy_Alitas.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity_Menu_WingsArmy.this, WingsArmy_Hamburgesas.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity_Menu_WingsArmy.this, WingsArmy_Entradas.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity_Menu_WingsArmy.this, WingsArmy_Boneless.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity_Menu_WingsArmy.this, WingsArmy_Cervezas.class));
            default:
                break;
        }
    }
}