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

public class Dominos_Pizzas extends AppCompatActivity implements PizzasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private PizzasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Pizzas");
        setContentView(R.layout.activity_main_pizzas);
        ArrayList<Pizzas_MC> datos = new ArrayList<Pizzas_MC>();
        datos.add(new Pizzas_MC(R.drawable.tarjeta1ingretiente, "De un ingrediente", "Pepperoni, Salami, Carne Molida, Salchicha Italiana, Pollo, Jamón, Tocino, Chorizo, Queso Mozzarella, Queso Cheddar, Queso Parmesano, Queso Crema, Piña, Pimiento, Jalapeño, Aceitunas, Champiñones, Cebolla.", "$79.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetahawaiana, "Hawaiana", "Un clásico de Jamón y Piña", "$98.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetapperon, "Pepperoni Especial", "Pepperoni, Champiñones, Extra Queso.", "$98.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetamexicana, "Mexicana", "Chorizo, Carne Molida, Cebolla, Jalapeño.", "$90.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetacfrias, "Carnes Frías", "Salami, Pepperoni, Jamón, Finas Hierbas.", "$98.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetabrava, "Bravísima", "Pollo, Chorizo, Queso Crema, Salsa 3 Chiles.", "$98.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetaqueso, "4 Quesos", "Mozzarella, Cheddar, Queso Crema y Parmesano.", "$98.00"));
        datos.add(new Pizzas_MC(R.drawable.tarjetaveggie, "Veggie", "Pimiento, Champiñones, Aceitunas, Cebolla.", "$98.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetallePizzas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new PizzasAdaptador(datos);
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
                Intent intent = new Intent(this, MainActivity_Menu_Dominos.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}
    @Override
    public void onItemClick(int p, CharSequence titulo, CharSequence precio,  byte[] byteArray) {
        //Toast.makeText(getApplicationContext(), "Posición " +(p+1), Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, ConfigurarPizza.class);
        i.putExtra("Titulo",titulo.toString());
        i.putExtra("Precio", precio.toString());
        i.putExtra("Imagen", byteArray);
        startActivity(i);
    }
}