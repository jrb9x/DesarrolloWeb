package com.example.configuracion;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout til1, til2, til3;
    private EditText editTextNombre, editTextEmail, editTextPassw;
    private Button buttonAceptar, buttonCancelar;
    private boolean error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til1 = (TextInputLayout)findViewById(R.id.TiLayout);
        til1.setErrorEnabled(true);
        til2 = (TextInputLayout)findViewById(R.id.TiLayout2);
        til2.setErrorEnabled(true);
        til3 = (TextInputLayout)findViewById(R.id.TiLayout3);
        til3.setErrorEnabled(true);

        buttonAceptar = (Button) findViewById(R.id.BtnAceptar);
        buttonCancelar = (Button) findViewById(R.id.BtnCancelar);
        editTextNombre = (EditText) findViewById(R.id.editText);
        editTextEmail = (EditText) findViewById(R.id.editText2);
        editTextPassw = (EditText) findViewById(R.id.editText3);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = editTextNombre.getText().toString();
                if(nombreUsuario.length() < 4) {
                    til1.setError("Error: Debe contener mas de 4 caracteres!");
                    error = true;
                }
                else {
                    til1.setError(null);
                    error = false;
                }

                String email = editTextEmail.getText().toString();
                if(email.length() < 4){
                    til2.setError("Error: Email no tiene un formato valido!");
                    error = true;
                }
                else {
                    til1.setError(null);
                    error = false;
                }

                String passw = editTextPassw.getText().toString();
                if(passw.length() < 6){
                    til3.setError("Error: Debe contener mas de 6 caracteres!");
                    error = true;
                }
                else {
                    til1.setError(null);
                    error = false;
                }

                if(!error) {
                    Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                    intent.putExtra("nombreUsuario", nombreUsuario);
                    intent.putExtra("email", email);
                    intent.putExtra("passw", passw);
                    startActivity(intent);
                }
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextEmail.setText("");
                editTextPassw.setText("");
            }
        });
    }
}
