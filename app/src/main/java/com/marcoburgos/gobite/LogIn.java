package com.marcoburgos.gobite;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.graphics.Color;


public class LogIn extends AppCompatActivity {

    private Button buttonIngresar;
    private EditText editTextPassword, editTextUsuario;
    private TextView textViewIntentos;
    private TextView textViewRegistrate;
    private TextView textViewOlvido;


    private int contadorIntentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        buttonIngresar = (Button)findViewById(R.id.buttonIngresar);
        editTextUsuario = (EditText)findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        textViewRegistrate = (TextView) findViewById(R.id.textViewSingIn);
        textViewOlvido = (TextView) findViewById(R.id.textViewOlvido);

        textViewIntentos = (TextView)findViewById(R.id.textViewIntentos);
        textViewIntentos.setVisibility(View.GONE);

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextUsuario.getText().toString().equals("admin") &&
                        editTextPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Ingresando...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogIn.this, Landing.class);
                    startActivity(intent);
                    finish();

                }
                else
                    {
                    Toast.makeText(getApplicationContext(), "Credenciales erroneas",Toast.LENGTH_SHORT).show();

                    textViewIntentos.setVisibility(View.VISIBLE);
                    textViewIntentos.setBackgroundColor(Color.RED);
                    contadorIntentos--;
                    textViewIntentos.setText(Integer.toString(contadorIntentos));

                    if (contadorIntentos == 0) {
                        buttonIngresar.setEnabled(false);
                    }
                }
            }
        });

        textViewRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, Registrar.class);
                startActivity(intent);
                finish();
            }
        });

    }
}