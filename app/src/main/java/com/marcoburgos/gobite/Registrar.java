package com.marcoburgos.gobite;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by marcoburgos on 20/04/17.
 */

public class Registrar extends AppCompatActivity {
    public static final String CHAT_PREFS = "ChatPrefs";
    public static final String DISPLAY_NAME_KEY = "username";

    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mUsernameView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.ACTVEmail);
        mPasswordView = (EditText) findViewById(R.id.ACTVPassword);
        mConfirmPasswordView = (EditText) findViewById(R.id.ACTVConfirmPassowrd);
        mUsernameView = (AutoCompleteTextView) findViewById(R.id.ACTVUSuario);


        mConfirmPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.register_form_finished || id == EditorInfo.IME_NULL) {
                    attemptRegistration();
                    return true;
                }
                return false;
            }
        });


        mAuth = FirebaseAuth.getInstance();


    }


    public void signUp(View v) {
        attemptRegistration();
    }

    private void attemptRegistration() {


        mEmailView.setError(null);
        mPasswordView.setError(null);


        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }


        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {

            focusView.requestFocus();
        } else {
            createAFirebaseUser();

        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        String confirmPassword = mConfirmPasswordView.getText().toString();
        return confirmPassword.equals(password) && password.length() > 4;
    }


    private void createAFirebaseUser () {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Chat", "createUser onComplete: " +task.isSuccessful());


                if (!task.isSuccessful()) {
                    Log.d("Prueba", "User creation failed");
                    showErrorDialog("Registration attempt failed");
                }
                else {
                    saveDisplayName();
                    Log.d("Prueba", "nombrepasado: " );
                    Intent intent = new Intent(Registrar.this, Landing.class);
                    finish();
                    Toast.makeText(getApplicationContext(),
                            "Usuario creado con éxito...",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }

            }
        });
    }



    private void saveDisplayName() {

        String displayName = mUsernameView.getText().toString();
        SharedPreferences prefs = getSharedPreferences(CHAT_PREFS, 0);
        prefs.edit().putString(DISPLAY_NAME_KEY, displayName).apply();
    }


    private void showErrorDialog(String message) {

        new AlertDialog.Builder(this)
                .setTitle("Ooops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }


}

