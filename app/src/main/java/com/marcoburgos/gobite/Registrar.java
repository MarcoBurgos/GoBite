package com.marcoburgos.gobite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by marcoburgos on 20/04/17.
 */

public class Registrar extends AppCompatActivity implements View.OnClickListener{
    private TextView tvLogin;
    private Button buttonRegistrar;
    private EditText etEmail, etPassword, etPasswordConfirmar;
    public ArrayList<String> usuariosArray = new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);


        buttonRegistrar = (Button)findViewById(R.id.buttonRegistrar);
        tvLogin = (TextView)findViewById(R.id.textViewLoginRegistro);
        etEmail = (EditText)findViewById(R.id.editTextMailRegistro);
        etPassword = (EditText)findViewById(R.id.editTextPasswordRegistro);
        etPasswordConfirmar = (EditText)findViewById(R.id.editTextPasswordConfirmarRegistro);
        buttonRegistrar.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        setTitle("Únete");

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonRegistrar:
                String email = etEmail.getText().toString();
                String pass = etPassword.getText().toString();
                String passC = etPasswordConfirmar.getText().toString();

                if (email.isEmpty()&& pass.isEmpty())
                {
                    displayToast("Correo/password están vacíos");
                }
                else {
                    if (pass.equals(passC) ) {
                        Toast.makeText(getApplicationContext(),
                                "Usuario creado",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registrar.this, Landing.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),
                                "Contraseñas no coinciden",Toast.LENGTH_SHORT).show();

                    }

                }
                                //register();
                break;
            case R.id.textViewLoginRegistro:
                startActivity(new Intent(Registrar.this,LogIn.class));
                finish();
                break;
            default:

        }
    }

    //private void register(){
     //   String email = etEmail.getText().toString();
      //  String pass = etPassword.getText().toString();
      //  if(email.isEmpty() && pass.isEmpty()){
       //     displayToast("Correo/password están vacíos");
       // }else{
       //     db.addUser(email,pass);
       //     displayToast("Usuario registrado");
       //     finish();
        //}
    //}

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
