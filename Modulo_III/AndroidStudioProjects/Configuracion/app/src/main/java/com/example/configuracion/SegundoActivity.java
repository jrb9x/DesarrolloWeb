package com.example.configuracion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SegundoActivity extends AppCompatActivity {

    private Button restaurar, btnOK, btnAtras;
    private Switch privacidad;
    private ToggleButton bateria;
    private String botonPrivacidad = "desactivada", botonBateria = "desactivado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        privacidad = (Switch) findViewById(R.id.switch1);
        bateria = (ToggleButton) findViewById(R.id.toggleButton);
        restaurar = (Button) findViewById(R.id.button2);
        btnOK = (Button) findViewById(R.id.BtnOK);
        btnAtras = (Button) findViewById(R.id.BtnAtras);

        privacidad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    botonPrivacidad = "activada";
                }
                else{
                    botonPrivacidad = "desactivada";
                }
            }
        });

        bateria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    botonBateria = "activado";
                }
                else{
                    botonBateria = "desactivado";
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoActivity.this, TercerActivity.class);
                String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
                String email = getIntent().getStringExtra("email");


                intent.putExtra("nombreUsuario", nombreUsuario);
                intent.putExtra("email", email);
                intent.putExtra("privacidad", botonPrivacidad);
                intent.putExtra("bateria", botonBateria);
                startActivity(intent);
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
