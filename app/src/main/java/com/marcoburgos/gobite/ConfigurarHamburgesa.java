package com.marcoburgos.gobite;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class ConfigurarHamburgesa extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerCantidad;
    Spinner spinnerTamaño;
    ArrayAdapter<CharSequence> adaptador;
    ArrayAdapter<CharSequence> adaptadorTamaño;
    TextView titular;
    TextView precio;
    ImageView imagen;
    byte[] byteArray;
    Bitmap imagenparaMandar;






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


        Button agregarCarrito = (Button)findViewById(R.id.BotonAñadirACarrito);
        agregarCarrito.setOnClickListener(this);
        final Switch conTodo = (Switch)findViewById(R.id.switch1);
        conTodo.setOnClickListener(this);
        final Switch cebolla = (Switch)findViewById(R.id.CebollaSwitch);
        cebolla.setOnClickListener(this);
        final Switch tomate = (Switch)findViewById(R.id.TomateSwitch);
        tomate.setOnClickListener(this);
        final Switch lechuga = (Switch)findViewById(R.id.LechugaSwitch);
        lechuga.setOnClickListener(this);
        final Switch queso = (Switch)findViewById(R.id.QuesoSwitch);
        queso.setOnClickListener(this);


        cebolla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if (tomate.isChecked() && lechuga.isChecked() && queso.isChecked()) {
                        conTodo.setChecked(true);
                    }
                }else{
                    conTodo.setChecked(false);
                }
            }
        });

        tomate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if (cebolla.isChecked() && lechuga.isChecked() && queso.isChecked()) {
                        conTodo.setChecked(true);
                    }
                }else{
                    conTodo.setChecked(false);
                }
            }
        });

        lechuga.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if (tomate.isChecked() && cebolla.isChecked() && queso.isChecked()) {
                        conTodo.setChecked(true);
                    }
                }else{
                    conTodo.setChecked(false);
                }
            }
        });

        queso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if (tomate.isChecked() && lechuga.isChecked() && cebolla.isChecked()) {
                        conTodo.setChecked(true);
                    }
                }else{
                    conTodo.setChecked(false);
                }
            }
        });


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
        //Log.d("ADebugTagPasado", "Value: " + tituloDetalle);
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
        imagenparaMandar = bmp;
        imagen.setImageBitmap(bmp);


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



    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.BotonAñadirACarrito:
                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(ConfigurarHamburgesa.this);
                alerta_constructor.setMessage("¿Qué deseas hacer a continuación?")
                        .setCancelable(false)
                        .setPositiveButton("Ir al carrito", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarHamburgesa.this, MainActivityCarrito.class);
                                intent.putExtra("TitularCarrito", titular.getText());
                                Bitmap bmp = ((BitmapDrawable)imagen.getDrawable()).getBitmap();
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byteArray = stream.toByteArray();
                                intent.putExtra("Imagen", byteArray);
                                intent.putExtra("Precio", precio.getText());
                                guardarCarrito(new GuardoCarrito());
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Regresar al Menú", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ConfigurarHamburgesa.this, MainActivity_Menu.class);
                                guardarCarrito(new GuardoCarrito());
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = alerta_constructor.create();
                alert.setTitle(("El producto ha sido añadido a tu carrito"));
                alert.show();
                break;

            //case R.id.switch1:
                // do your code
            //    break;

            //case R.id.CebollaSwitch:
                //conTodo.setChecked(false);
            //    break;

            //case R.id.TomateSwitch:
                //conTodo.setChecked(false);
            //    break;

            //case R.id.LechugaSwitch:
                //conTodo.setChecked(false);
            //    break;

            //case R.id.QuesoSwitch:
                //conTodo.setChecked(false);
            //    break;

            default:
                break;
        }

    }

    public void guardarCarrito(GuardoCarrito clase) {
        Log.d("ADebugMando", "Value: " + titular.getText());
        Log.d("ADebugMando", "Value: " + precio.getText());
        clase.reciboCarrito(imagenparaMandar, titular.getText(), precio.getText());
    }



    /*public static void guardoDatos(byte[] imagenCarrito, CharSequence tituloCarrito, CharSequence precioCarrito) {
        ArrayList<CarritoCompra_MC> datos = new ArrayList<CarritoCompra_MC>();
        datos.add(new CarritoCompra_MC(imagenCarrito, tituloCarrito, precioCarrito));

    }*/



}
