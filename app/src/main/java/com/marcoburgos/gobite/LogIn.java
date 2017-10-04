package com.marcoburgos.gobite;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.graphics.Color;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LogIn extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        mAuth = FirebaseAuth.getInstance();

    }


    public void signInExistingUser(View v)   {
        attemptLogin();

    }

    public void registerNewUser(View v) {
        Intent intent = new Intent(this, com.marcoburgos.gobite.Registrar.class);
        finish();
        startActivity(intent);
    }


    private void attemptLogin() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (email.equals("") || password.equals("")) return;
        Toast.makeText(this, "Login in progress...", Toast.LENGTH_SHORT).show();


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("Chat", "signWithEmail() onComplete: " + task.isSuccessful());

                if (!task.isSuccessful()) {
                    Log.d("Chat", "Problem signing in: " + task.getException());
                    showErrorDialog("There was a problem signing in");
                } else {
                    Intent intent = new Intent(LogIn.this, Landing.class);
                    finish();
                    startActivity(intent);
                }

            }
        });


    }

    private void showErrorDialog (String message) {
        new AlertDialog.Builder(this)
                .setTitle("Ooops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}
