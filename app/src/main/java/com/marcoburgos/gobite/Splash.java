package com.marcoburgos.gobite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;
public class Splash extends AppCompatActivity {

    private static final long DURACION_SPLASH = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
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

}
