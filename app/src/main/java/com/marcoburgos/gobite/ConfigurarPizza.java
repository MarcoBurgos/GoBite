package com.marcoburgos.gobite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ConfigurarPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Arma tu pizza");
        setContentView(R.layout.scrolldown_pizza);
        onButtonClickListener();

    }

    public void onButtonClickListener() {
        Button agregarCarrito = (Button)findViewById(R.id.BotonAñadirACarritoPizza);

        agregarCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(ConfigurarPizza.this);
                alerta_constructor.setMessage("¿Qué deseas hacer a continuación?")
                        .setCancelable(false)
                        .setPositiveButton("Ir al carrito", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarPizza.this, MainActivityCarrito.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Regresar al Menú", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarPizza.this, MainActivity_Menu.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = alerta_constructor.create();
                alert.setTitle(("El producto ha sido añadido a tu carrito"));
                alert.show();
            }

        });

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
                Intent intent = new Intent(this, Dominos_Pizzas.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
