package com.example.configuracion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEmail;
    private Button buttonAceptar, buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAceptar = (Button) findViewById(R.id.BtnAceptar);
        buttonCancelar = (Button) findViewById(R.id.BtnCancelar);
        editTextNombre = (EditText) findViewById(R.id.editText);
        editTextEmail = (EditText) findViewById(R.id.editText2);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = editTextNombre.getText().toString();
                String email = editTextEmail.getText().toString();
                Log.i("PRUEBA NOMBRE", nombreUsuario);
                Log.i("PRUEBA EMAIL", email);
                Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                intent.putExtra("nombreUsuario", nombreUsuario);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNombre.setText("");
                editTextEmail.setText("");
            }
        });
    }
}
