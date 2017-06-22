package com.marcoburgos.gobite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BlankFragment2 extends Fragment {

    Float precioCarrito;
    int tamañoCarrito;
    TextView articulosTotales, precioTotal;

    public void recuperoPrecioCarrito(GuardoCarrito clase) {
        precioCarrito = clase.mandoPrecio();
    }
    public void recuperoTamañoCarrito(GuardoCarrito clase) {
        tamañoCarrito = clase.mandoTamañoCarrito();
    }

    Button btn;
    EditText numeroTarjeta;
    EditText nombreTitular;
    EditText vencimiento;
    EditText validador;
    String tarjeta;
    int count = 0;

    public BlankFragment2() {
        // Required empty public constructor
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
        precioTotal.setText("El total a pagar es de: $"+ precioCarrito + " pesos");
        numeroTarjeta= (EditText)rootView.findViewById(R.id.nombreVendedorEntrega);
        nombreTitular= (EditText)rootView.findViewById(R.id.detalleUbicacionEntrega);
        vencimiento= (EditText) rootView.findViewById(R.id.editTextFechaTarjeta);
        validador= (EditText)rootView.findViewById(R.id.CVV);



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



        btn=(Button)rootView.findViewById(R.id.botonPagarCarrito);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nTarjeta = numeroTarjeta.getText().toString();
                String nTitular = nombreTitular.getText().toString();
                String fVencimiento = vencimiento.getText().toString();
                String fValidador = validador.getText().toString();



                if (nTarjeta.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Número de Tarjeta vacío", Toast.LENGTH_SHORT).show();
                }
                 else {
                    if (nTitular.isEmpty()) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Nombre del titular de la tarjeta vacío", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (fVencimiento.isEmpty()) {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "Fecha de vencimiento está vacía", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (fValidador.isEmpty()) {
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "CVV está vacío", Toast.LENGTH_SHORT).show();

                            }

                        }

                    }

                }


                tarjeta = numeroTarjeta.getText().toString();
                if (tarjeta != null) {
                    tarjeta = tarjeta.substring(tarjeta.length()-4);
                    //Log.d("ADebugTagTarjeta", "Value: " + tarjeta);
                }




                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(BlankFragment2.this.getActivity());
                alerta_constructor.setMessage("¿Deseas pagar $" +precioCarrito +" con la tarjeta terminación " + tarjeta + " ?")
                        .setCancelable(true)
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "Pedido exitosamente enviado",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BlankFragment2.this.getActivity(), Landing.class);
                                startActivity(intent);
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

}