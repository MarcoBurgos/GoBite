package com.marcoburgos.gobite;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BlankFragment2 extends Fragment {
    Button btn;
    EditText numeroTarjeta;
    EditText nombreTitular;
    EditText vencimiento;
    EditText validador;

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
        numeroTarjeta= (EditText)rootView.findViewById(R.id.nombreVendedorEntrega);
        nombreTitular= (EditText)rootView.findViewById(R.id.detalleUbicacionEntrega);
        vencimiento= (EditText) rootView.findViewById(R.id.editTextFechaTarjeta);
        validador= (EditText)rootView.findViewById(R.id.CVV);


        btn=(Button)rootView.findViewById(R.id.botonPagarCarrito);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nTarjeta = numeroTarjeta.getText().toString();
                String nTitular = nombreTitular.getText().toString();
                String fVencimiento = vencimiento.getText().toString();
                String fValidador = validador.getText().toString();
                /*if (nTarjeta.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Número de Tarjeta vacío",Toast.LENGTH_SHORT).show();
                }
                if (nTitular.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Nombre del titular de la tarjeta vacío",Toast.LENGTH_SHORT).show();
                }
                if (fVencimiento.isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Fecha de vencimiento está vacía",Toast.LENGTH_SHORT).show();
                }
                if (fValidador.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(),
                            "CVV está vacío",Toast.LENGTH_SHORT).show();
                }
                */

                AlertDialog.Builder alerta_constructor = new AlertDialog.Builder(BlankFragment2.this.getActivity());
                alerta_constructor.setMessage("¿Deseas pagar $204 con la tarjeta terminación 0895?")
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