package com.marcoburgos.gobite;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 30/04/17.
 */

public class McDonalds_Hamburgesas extends AppCompatActivity implements HamburgesasAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private HamburgesasAdaptador adaptador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Hamburgesas");
        setContentView(R.layout.activity_main_hamburgesas);
        ArrayList<Hamburgesas_MC> hamguergesasOpciones = new ArrayList<Hamburgesas_MC>();
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.bigmac, "Big Mac", "Prueba la deliciosa Big Mac de McDonald's Mexico. Dos hamburguesas de pura carne con salsa especial Big Mac y queso derretido", "$79.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.cuartodelibra, "Cuarto de libra", "Un clásico de McDonald's, el Cuarto de libra se prepara con deliciosa carne 100% de res, queso americano y se adereza en cebolla, pepinillos, catsup y mostaza", "$58.50"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.mcnifica, "McNífica", "Dos deliciosas carnes 100% de res, queso americano y se adereza en cebolla, pepinillos, catsup y mostaza.", "$64.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.conqueso, "Hamburgesa con queso", "Dos jugosas carnes 100% de res acompañadas de queso tipo americano, pepinillos, cebolla, catsup y mostaza en un fresco y esponjadito pan. ¡Quedarás doblemente encantado con su sabor!", "$40.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.pollo, "Mc Pollo", "Deliciosa pechuga de pollo empanizada, acompañada de lechuga y mayonesa.", "$48.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.angussupreme, "Angus Premium Deluxe", "Grande, tentadora, inigualable, la mejor opción para quien tiene un paladar exquisito", "$98.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.anguscbo, "Angus CBO", "Descubre un sabor simplemente grandioso. Carne Angus, queso cheddar, tocino y cebolla. Un sabor simplemente inigualable.", "$98.00"));
        hamguergesasOpciones.add(new Hamburgesas_MC(R.drawable.angustocino, "Angus Premium Tocino", "Grande, tentadora, inigualable, la mejor opción para quien tiene un paladar exquisito.", "$98.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleHamburgesas);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new HamburgesasAdaptador(hamguergesasOpciones);
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
        Intent i = new Intent(this, ConfigurarHamburgesa.class);
        i.putExtra("Titulo",titulo.toString());
        //Log.d("ADebugTagPasando", "Value: " + titulo);
        i.putExtra("Precio", precio.toString());
        i.putExtra("Imagen", byteArray);
        startActivity(i);
    }
}