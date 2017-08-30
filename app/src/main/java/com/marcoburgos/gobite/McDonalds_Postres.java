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

public class McDonalds_Postres extends AppCompatActivity implements PostresMcDonaldsAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private PostresMcDonaldsAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Postres");
        setContentView(R.layout.activity_main_postres_mcd);
        ArrayList<PostresMcDonalds_MC> postresOpciones = new ArrayList<PostresMcDonalds_MC>();
        postresOpciones.add(new PostresMcDonalds_MC(R.drawable.mcflurry, "McFLurry Oreo", "Si las galletas Oreo te gustan por sí solas ¡imagínate acompañarlas con nuestra deliciosa mezcla de helado 100% de leche!", "$35.00"));
        postresOpciones.add(new PostresMcDonalds_MC(R.drawable.sundae, "Sundae", "Prueba nuestro delicioso helado preparado con 100% leche de vaca y acompáñalo con jarabe de fresa, caramelo o chocolate. ¡Disfrútalo!", "$20.00"));
        postresOpciones.add(new PostresMcDonalds_MC(R.drawable.elcono, "Cono", "Prueba nuestro delicioso helado preparado con 100% leche de vaca. ¡Disfrútalo!.", "$15.00"));
        postresOpciones.add(new PostresMcDonalds_MC(R.drawable.paymcd, "Pay de queso", "Deliciosos trozos de fruta envueltas con una cubierta crujiente para darle un delicioso sabor a tu paladar, todo el tiempo calientitos y listos para disfrutar. Elije tu favorito: manzana o queso", "$40.00"));
        //postresOpciones.add(new PostresMcDonalds_MC(R.drawable.pollo, "Mc Pollo", "Deliciosa pechuga de pollo empanizada, acompañada de lechuga y mayonesa.", "$48.00"));
        //postresOpciones.add(new PostresMcDonalds_MC(R.drawable.angussupreme, "Angus Premium Deluxe", "Grande, tentadora, inigualable, la mejor opción para quien tiene un paladar exquisito", "$98.00"));
        //postresOpciones.add(new PostresMcDonalds_MC(R.drawable.anguscbo, "Angus CBO", "Descubre un sabor simplemente grandioso. Carne Angus, queso cheddar, tocino y cebolla. Un sabor simplemente inigualable.", "$98.00"));
        //postresOpciones.add(new PostresMcDonalds_MC(R.drawable.angustocino, "Angus Premium Tocino", "Grande, tentadora, inigualable, la mejor opción para quien tiene un paladar exquisito.", "$98.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorpostreMcDonalds);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new PostresMcDonaldsAdaptador(postresOpciones);
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
                Intent intent = new Intent(this, MainActivity_Menu.class);
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
        Intent i = new Intent(this, ConfigurarPostre.class);
        i.putExtra("Titulo",titulo.toString());
        i.putExtra("Precio", precio.toString());
        i.putExtra("Imagen", byteArray);
        startActivity(i);
    }
}