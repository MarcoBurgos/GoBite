package com.marcoburgos.gobite;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class BlankFragment2 extends Fragment {

    Float precioCarrito;
    int tamañoCarrito;
    TextView articulosTotales, precioTotal;
    List<EditText> campos;
    Button btn;
    EditText numeroTarjeta;
    EditText nombreTitular;
    EditText vencimiento;
    EditText validador;
    String tarjeta;
    int count = 0;
    CheckBox guardarDatos;

    public BlankFragment2() {
        // Required empty public constructor
    }

    public void recuperoPrecioCarrito(GuardoCarrito clase) {
        precioCarrito = clase.mandoPrecio();
    }
    public void recuperoTamañoCarrito(GuardoCarrito clase) {
        tamañoCarrito = clase.mandoTamañoCarrito();
    }

    public void borroCarrito(GuardoCarrito reciboCarrito) {
         reciboCarrito.borroCarrito();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank2, container, false);

        recuperoPrecioCarrito(new GuardoCarrito());
        recuperoTamañoCarrito(new GuardoCarrito());

        articulosTotales = (TextView)rootView.findViewById(R.id.numItems);
        precioTotal = (TextView) rootView.findViewById(R.id.totalPagar);
        articulosTotales.setText("Artículos: "+ tamañoCarrito);
        precioTotal.setText("El total a pagar es de: $"+ precioCarrito + "0 pesos");
        numeroTarjeta = (EditText)rootView.findViewById(R.id.nombreVendedorEntrega);
        nombreTitular = (EditText)rootView.findViewById(R.id.detalleUbicacionEntrega);
        vencimiento = (EditText) rootView.findViewById(R.id.editTextFechaTarjeta);
        validador = (EditText)rootView.findViewById(R.id.CVV);
        guardarDatos = (CheckBox) rootView.findViewById(R.id.guardarDatosPago);
        campos = Arrays.asList(numeroTarjeta, nombreTitular, vencimiento, validador);

        pongodatos();Log.d("prueba", "datos");

        if (guardarDatos.isChecked()) {
            pongodatos();
            Log.d("prueba", "los dejo");
            Log.d("prueba", "tarjeta es: " + numeroTarjeta.getText().toString());
        }
        else {
            Log.d("prueba", "los qquito");
            eliminoTarjetaDatos();
            numeroTarjeta.setText("");
            nombreTitular.setText("");
            vencimiento.setText("");
            guardarDatos.setChecked(false);
        }















        numeroTarjeta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (count <= numeroTarjeta.getText().toString().length()
                        &&(numeroTarjeta.getText().toString().length()==4
                        ||numeroTarjeta.getText().toString().length()==9
                        ||numeroTarjeta.getText().toString().length()==14)){
                    numeroTarjeta.setText(numeroTarjeta.getText().toString()+" ");
                    int pos = numeroTarjeta.getText().length();
                    numeroTarjeta.setSelection(pos);
                }else if (count >= numeroTarjeta.getText().toString().length()
                        &&(numeroTarjeta.getText().toString().length()==4
                        ||numeroTarjeta.getText().toString().length()==9
                        ||numeroTarjeta.getText().toString().length()==14)){
                    numeroTarjeta.setText(numeroTarjeta.getText().toString().substring(0,numeroTarjeta.getText().toString().length()-1));
                    int pos = numeroTarjeta.getText().length();
                    numeroTarjeta.setSelection(pos);
                }
                count = numeroTarjeta.getText().toString().length();
            }
        });

        guardarDatos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (guardarDatos.isChecked()) {
                    if (verificaContenido()) {
                        guardarTarjetaDatos(numeroTarjeta,nombreTitular,vencimiento,guardarDatos.isChecked());
                    } else {
                        Toast.makeText(getActivity(), "Faltan campos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    numeroTarjeta.setText("");
                    nombreTitular.setText("");
                    vencimiento.setText("");
                    eliminoTarjetaDatos();
                }

            }
        });


        btn=(Button)rootView.findViewById(R.id.botonPagarCarrito);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                verificaContenido();


                tarjeta = numeroTarjeta.getText().toString();

                if (tarjeta != null) {
                    tarjeta = tarjeta.substring(tarjeta.length()-4);
                }




                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(BlankFragment2.this.getActivity());
                alerta_constructor.setMessage("¿Deseas pagar $" +precioCarrito +"0 con la tarjeta terminación " + tarjeta + " ?")
                        .setCancelable(true)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "Pedido exitosamente enviado",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BlankFragment2.this.getActivity(), Landing.class);
                                guardarTarjetaDatos(numeroTarjeta,nombreTitular,vencimiento,guardarDatos.isChecked());
                                borroCarrito(new GuardoCarrito());
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = alerta_constructor.create();
                alert.setTitle(("Confirma tu pago"));
                alert.show();


            }
        });
        return rootView;




    }

   /* @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("tarjeta", tarjeta);
        outState.putString("nombre", nombreTitular.toString());
        outState.putString("fecha", vencimiento.toString());
        super.onSaveInstanceState(outState);
    }*/

    private boolean verificaContenido() {
        boolean falta = false;
        for (EditText texto : campos) {
            texto.setHintTextColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        }
        for (EditText texto : campos) {
            if (texto.getText().toString().trim().isEmpty()) {
                texto.setHintTextColor(ContextCompat.getColor(getActivity(), R.color.Rojo));
                falta = true;
            }
        }
        return !falta;
    }

    private void guardarTarjetaDatos(EditText tarjetaAGuardar, EditText usuarioAGuardar, EditText fechaAGuardar, boolean checkbox) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Tarjeta",tarjetaAGuardar.getText().toString());
        editor.putString("NombreUsuario",usuarioAGuardar.getText().toString());
        editor.putString("FechaTarjeta", fechaAGuardar.getText().toString());
        editor.putBoolean("CheckBox", checkbox);
        editor.apply();
        Log.d("prueba", "tarjetaGuardada: " + tarjetaAGuardar.getText().toString());

    }

    private void eliminoTarjetaDatos() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        Log.d("Prueba", "Eliminñe");
        Log.d("Prueba", "tarjeta es. " + numeroTarjeta.getText().toString());
        editor.apply();

    }


    private void pongodatos () {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String tarjetaGuardada = preferences.getString("Tarjeta", " ");
        String nombreGuardado = preferences.getString("NombreUsuario", " ");
        String fechaGuardada = preferences.getString("FechaTarjeta", " ");
        Boolean checkboxGuardado = preferences.getBoolean("CheckBox", true);
        Log.d("prueba", "tarjetaPuesta: " +tarjetaGuardada);


        numeroTarjeta.setText(tarjetaGuardada);
        nombreTitular.setText(nombreGuardado);
        vencimiento.setText(fechaGuardada);
        guardarDatos.setChecked(checkboxGuardado);


    }

}