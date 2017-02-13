package com.example.configuracion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TercerActivity extends AppCompatActivity {

    private Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        String email = getIntent().getStringExtra("email");
        String privacidad = getIntent().getStringExtra("privacidad");
        String bateria = getIntent().getStringExtra("bateria");

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        if(privacidad.equals("activada"))
            textView10.setTextColor(0xFF00FF00);
        else
            textView10.setTextColor(0xffff0000);
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        if(bateria.equals("activado"))
            textView11.setTextColor(0xFF00FF00);
        else
            textView11.setTextColor(0xffff0000);

        textView4.setText("Bienvenid@ " + nombreUsuario);
        textView10.setText(privacidad);
        textView11.setText(bateria);

        inicio = (Button) findViewById(R.id.button);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TercerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
