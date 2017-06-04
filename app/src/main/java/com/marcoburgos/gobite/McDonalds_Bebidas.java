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

public class McDonalds_Bebidas extends AppCompatActivity implements BebidasMcDonaldsAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private BebidasMcDonaldsAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Bebidas");
        setContentView(R.layout.activity_main_bebidas_mcd);
        ArrayList<BebidasMcDonalds_MC> bebidasOpciones = new ArrayList<BebidasMcDonalds_MC>();
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.coca, "Coca-Cola", "Diversión contra la sed. Preparate para vencer la sed con una bebida helada.", "$30.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.coca, "Coca-Cola Light", "Diversión contra la sed. Preparate para vencer la sed con una bebida helada.", "$30.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.coca, "Coca-Cola Zero", "Diversión contra la sed. Preparate para vencer la sed con una bebida helada.", "$30.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.fanta, "Fanta", "Diversión contra la sed. Preparate para vencer la sed con una bebida helada.", "$30.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.bebidanaranja, "Bebida de naranja", "Empieza todas tus mañanas con nuestra deliciosa y refrescante bebida de naranja, ideal para acompañar tu desayuno. Esta bebida tuvo hace más de un año una reducción en el azúcar agregado.", "$40.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.aguanat, "Agua", "Para los que prefieren acompañar su comida con agua, tenemos botellas de agua Ciel, que es agua fresca 100% pura, muy saludable, que te refresca y te renueva a cada sorbo. Disfruta también de nuestras aguas frescas de Jamaica y de limón.", "$20.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.cafe, "Café", "Disfruta un fresco y aromático café de clase mundial, orgullosamente mexicano, de la zona Pluma de Oaxaca. Blasón proveé a McDonald's de este delicioso café de exquisito sabor, aroma y gran cuerpo.", "$28.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.latte, "Latte", "Café espresso y leche espumosa se combinan para formar una deliciosa bebida para ti.", "$38.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.capuccino, "Capuccino", "El placer de un sabroso café con la mejor leche espumosa..", "$45.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.mocca, "Mocha", "Déjate tentar con un espresso con leche cubierto de crema batida y chocolate líquido.", "$50.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.caramel, "Caramel", "A todo el sabor del mejor café espresso, agrégale jarabe de caramelo y una deliciosa crema batida.", "$50.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.mangopi_a, "Mango Piña", "Haz realidad tu deseo de saborear una bebida con hielo, dulce mango y jugosa piña, mezclados con yogurt.", "$55.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.moccafrappe, "Mocha Frappé", "Refréscate con esta bebida helada a base de café con sabor a chocolate y crema batida.", "$58.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.caramelfrape, "Caramel Frappé", "Date el gusto de probar esta deliciosa bebida helada de café con un toque de caramelo y crema batida.", "$58.00"));
        bebidasOpciones.add(new BebidasMcDonalds_MC(R.drawable.strawberrybanana, "Strawberry Banana", "Haz realidad tu deseo de saborear una bebida con hielo, dulce fresa y jugoso plátano, mezclados con yogurt.", "$55.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorbebidasMcDonalds);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new BebidasMcDonaldsAdaptador(bebidasOpciones);
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
    public void onItemClick(int p) {
        Intent i = new Intent(this, ConfigurarHamburgesa.class);
        startActivity(i);
    }
}