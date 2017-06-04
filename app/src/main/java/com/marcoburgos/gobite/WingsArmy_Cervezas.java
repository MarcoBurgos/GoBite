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

public class WingsArmy_Cervezas extends AppCompatActivity implements WingsArmyCervezasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private WingsArmyCervezasAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Boneless");
        setContentView(R.layout.activity_main_wingsarmy_cervezas);
        ArrayList<WingsArmyCervezas_MC> datos = new ArrayList<WingsArmyCervezas_MC>();
        datos.add(new WingsArmyCervezas_MC(R.drawable.coronawa, "Corona", "Con 90 años de historia y presencia en más de 180 países, Corona Extra es la cerveza mexicana de mayor venta en el mundo. Su sabor refrescante es ideal para nuestras alitas ardientes.", "$30.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.erdinger, "Erdinger Weissbier", "Esta rubia elaborada con excelentes ingredientes es la cerveza de trigo por excelencia. 130 años de experiencia resultan en un destacado aroma cítrico acompañado de un sabor dulce y equilibrado.", "$60.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.quilmeswa, "Quilmes", "Con 125 años de historia, Quilmes domina el 80 por ciento del mercado argentino de la cerveza. Es una cerveza suave pero con cuerpo, de amargura sutil y frescura adictiva.", "$65.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.caroluswa, "Gouden Carolus", "Gouden Carolus Classic combina la calidez del vino y la frescura de la cerveza. Disfruta el sabor frutal de esta cerveza artesanal a pequeños sorbos y acompañado de nuestras boneless.", "$65.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.stellawa, "Stella Artois", "Concebida como una cerveza de Navidad hace 90 años, esta refrescante lager es una de las cervezas más emblemáticas del mundo y sabe muy bien con nuestras hamburguesas.", "$55.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.millerwa, "Miller Genuine Draft", "Ha recibido premios internacionales gracias a que brinda todo el sabor de la cerveza de barril en una botella. Esta refrescante cerveza de notas amargas sabe mejor con nuestras entradas.", "$50.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.budwa, "Budweiser", "Desde su nacimiento en 1876, esta refrescante cerveza se ha convertido en un icono estadounidense. Con un perfecto balance entre dulce y amargo, Budweiser es universalmente popular.", "$65.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.guinness, "Guinness", "Con más de 250 años de historia y un inconfundible sabor tostado de textura aterciopelada, esta cautivadora irlandesa es la cerveza más famosa del mundo.", "$90.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.bombardier, "Bombardier", "De renombrada calidad inglesa, el lúpulo y la malta utilizados para su elaboración se obtienen mediante un meticuloso proceso de selección que da como resultado un inolvidable sabor con aroma a frutos secos y notas amargas.", "$85.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.minervacolonia, "Minerva Colonial", "Con un ligero aroma a malta de matices cítricos, esta cerveza presume un gran cuerpo resultado de un mayor tiempo de reposo posterior a la fermentación. Disfrútala con una Army Chicken a la Parrilla.", "$40.00"));
        datos.add(new WingsArmyCervezas_MC(R.drawable.tecatewa, "Tecate Light", "Tecate Light debutó en 1992 como la primera cerveza light en México. A pesar de tener sólo 110 calorías, esta light ofrece todo el cuerpo de una lager. Acompáñala con nuestras hamburgesas.", "$30.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleWACervezas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new WingsArmyCervezasAdaptador(datos);
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
                Intent intent = new Intent(this, MainActivity_Menu_WingsArmy.class);
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

