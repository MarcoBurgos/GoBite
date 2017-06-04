package com.marcoburgos.gobite;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class ConfigurarHamburgesa extends AppCompatActivity {
    Spinner spinnerCantidad;
    Spinner spinnerTamaño;
    ArrayAdapter<CharSequence> adaptador;
    ArrayAdapter<CharSequence> adaptadorTamaño;
    TextView titular;
    TextView precio;
    ImageView imagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Arma tu pedido");
        setContentView(R.layout.scrolldown);
        onButtonClickListener();
        adaptador = new ArrayAdapter<CharSequence>(this, R.layout.spinner_estilo);
        spinnerCantidad = (Spinner)findViewById(R.id.spinnerCantidadDetalle);
        adaptador = ArrayAdapter.createFromResource(this,R.array.spinnerCarritoCantidad, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerCantidad.setAdapter(adaptador);
        spinnerTamaño = (Spinner)findViewById(R.id.spinnerTamañoDetalle);
        adaptadorTamaño = ArrayAdapter.createFromResource(this,R.array.spinnerCarritoTamaño, android.R.layout.simple_spinner_item);
        adaptadorTamaño.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinnerTamaño.setAdapter(adaptadorTamaño);


        String tituloDetalle;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                tituloDetalle= null;
            } else {
                tituloDetalle= extras.getString("Titulo");
            }
        } else {
            tituloDetalle= (String) savedInstanceState.getSerializable("Titulo");
        }
        Log.d("ADebugTagPasado", "Value: " + tituloDetalle);
        titular = (TextView)findViewById(R.id.nombreDetalleHamburgesa);
        if (tituloDetalle == null) {
            titular.setText(tituloDetalle);
        }
        else {
            titular.setText(tituloDetalle);

        }

        String precioDetalle;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                precioDetalle= null;
            } else {
                precioDetalle= extras.getString("Precio");
            }
        } else {
            precioDetalle= (String) savedInstanceState.getSerializable("Precio");
        }

        precio = (TextView)findViewById(R.id.precioDetalleHamburgesa);
        if (precioDetalle == null) {
            precio.setText("Valio madre");
        }
        else {
            precio.setText(precioDetalle);

        }

        imagen =(ImageView)findViewById(R.id.imageHamburgesaDetalle);
        byte[] byteArray = getIntent().getByteArrayExtra("Imagen");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imagen.setImageBitmap(bmp);













    }

    public void onButtonClickListener() {
        Button agregarCarrito = (Button)findViewById(R.id.BotonAñadirACarrito);
        Switch conTodo = (Switch)findViewById(R.id.switch1);
        final Switch cebolla = (Switch)findViewById(R.id.CebollaSwitch);
        cebolla.setChecked(true);

        conTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cebolla.setChecked(false);
            }

        });

        agregarCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(ConfigurarHamburgesa.this);
                alerta_constructor.setMessage("¿Qué deseas hacer a continuación?")
                        .setCancelable(false)
                        .setPositiveButton("Ir al carrito", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarHamburgesa.this, MainActivityCarrito.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Regresar al Menú", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarHamburgesa.this, MainActivity_Menu.class);
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
                Intent intent = new Intent(this, McDonalds_Hamburgesas.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
