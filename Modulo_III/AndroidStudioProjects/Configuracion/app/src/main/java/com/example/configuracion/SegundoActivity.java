package com.example.configuracion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundoActivity extends AppCompatActivity {

    private Button privacidad, bateria, restaurar, btnOK, btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        privacidad = (Button) findViewById(R.id.switch1);
        bateria = (Button) findViewById(R.id.toggleButton);
        restaurar = (Button) findViewById(R.id.button2);
        btnOK = (Button) findViewById(R.id.BtnOK);
        btnAtras = (Button) findViewById(R.id.BtnAtras);

        privacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
                String email = getIntent().getStringExtra("email");
                Intent intent = new Intent(SegundoActivity.this, TercerActivity.class);
                intent.putExtra("nombreUsuario", nombreUsuario);
                intent.putExtra("email", email);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
