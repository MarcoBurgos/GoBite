package com.marcoburgos.gobite;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.view.Window;
import android.view.WindowManager;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
public class Splash extends AppCompatActivity {

    private static final long DURACION_SPLASH = 1000;
    String usuario, password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        usuario = preferences.getString("Usuario", "");
        password = preferences.getString("Contraseña", "");
        Log.d("ADebugTag", "UsuarioSalvado: " + usuario);
        Log.d("ADebugTag", "ContraSalvada: " + usuario);
        if (usuario.isEmpty() && password.isEmpty() ) {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, LogIn.class);
                    startActivity(intent);
                    finish();
                }
            };

            Timer timer = new Timer();
            timer.schedule(task,DURACION_SPLASH);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Landing.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task,DURACION_SPLASH);

    }

}
