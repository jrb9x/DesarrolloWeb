package com.example.holamundoandroid;

import android.content.Intent;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private EditText inputTexto;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebaframe);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton toggleButton1 = (ToggleButton) v;
                if(toggleButton1.isChecked())
                    Log.i("PRUEBA TOGGLE", "TRUE");
                else
                    Log.i("PRUEBA TOGGLE", "FALSE");
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Log.i("PRUEBA TOGGLE 2", "TRUE");
                else
                    Log.i("PRUEBA TOGGLE 2", "FALSE");
            }
        });

        /*boton = (Button) findViewById(R.id.button);
        inputTexto = (EditText) findViewById(R.id.editText);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = inputTexto.getText().toString();
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("nombreUsuario", nombreUsuario);
                startActivity(intent);
            }
        });*/
    }

}
