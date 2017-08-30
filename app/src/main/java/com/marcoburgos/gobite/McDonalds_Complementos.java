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

public class McDonalds_Complementos extends AppCompatActivity implements ComplementoMcDonaldsAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private ComplementoMcDonaldsAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Complementos");
        setContentView(R.layout.activity_main_complementos_mcd);
        ArrayList<ComplementosMcDonalds_MC> complementosOpciones = new ArrayList<ComplementosMcDonalds_MC>();
        complementosOpciones.add(new ComplementosMcDonalds_MC(R.drawable.tarjetapapasfrancesas, "Papas a la francesa", "Nuestras papas provienen de campos especialmente cultivados para McDonald's, en los que se supervisa su tamaño, consistencia y valor nutricional. Además las preparamos en aceite libre de Ácidos Grasos Trans, a temperaturas reguladas y les añadimos la cantidad exacta de sal que te permite disfrutar de su excelente sabor, convirtiéndolas en una de las preferidas.", "$25.00"));
        complementosOpciones.add(new ComplementosMcDonalds_MC(R.drawable.mcpatatas, "McPatatas", "Deliciosas papas 100% naturales, cortadas en gajos, crujientes y sazonadas por completo. Las puedes aderezar con nuestra famosa salsa McQueso que les dará un exquisito sabor.", "$30.00"));
        complementosOpciones.add(new ComplementosMcDonalds_MC(R.drawable.hashbrown, "Papa Hash Brown", "Nuestra deliciosa papa Hashbrown es una papa 100% natural, rallada en forma de tortilla, muy doradita, crujiente y con un excelente sabor. Ideal para acompañar tu desayuno.", "$15.00"));
        complementosOpciones.add(new ComplementosMcDonalds_MC(R.drawable.ensaladamcd, "Ensalada", "La ensalada para acompañar tu McTrío fue mejorada con una mayor variedad de hojas, zanahorias y jitomate en rodajas.", "$40.00"));


        reciclador = (RecyclerView) findViewById(R.id.recicladorComplementosMcDonalds);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new ComplementoMcDonaldsAdaptador(complementosOpciones);
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
    public void onItemClick(int p, CharSequence titulo, CharSequence precio, byte[] byteArray) {
        //Toast.makeText(getApplicationContext(), "Posición " +(p+1), Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, ConfigurarComplemento.class);
        i.putExtra("Titulo", titulo.toString());
        i.putExtra("Precio", precio.toString());
        i.putExtra("Imagen", byteArray);
        startActivity(i);
    }
}