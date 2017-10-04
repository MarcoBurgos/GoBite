package com.marcoburgos.gobite;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Landing extends AppCompatActivity {
Button buttonNuevaOrden;
Button buttonPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio");
        setContentView(R.layout.activity_landing);




        buttonNuevaOrden = (Button)findViewById(R.id.buttonNuevaOrden);
        buttonPedidos = (Button)findViewById(R.id.buttonMisPedidos);

        buttonNuevaOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, MainActivity_Restaurantes.class);
                startActivity(intent);
            }
        });

        buttonPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, MainActivity_Pedidos.class);
                startActivity(intent);
            }
        });

    }

    private void deleteLoggedIn() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}