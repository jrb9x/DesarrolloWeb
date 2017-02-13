package com.example.configuracion;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SegundoActivity extends AppCompatActivity {

    private Button btnOK, btnAtras;
    private FloatingActionButton restaurar;
    private Switch privacidad;
    private ToggleButton bateria;
    private CheckBox wifi;
    private RadioGroup rgOpciones;
    private Spinner spinner;
    private String botonPrivacidad = "Desactivado", botonBateria = "Desactivado",
            tema = "Silver", opcion = "Automático";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        privacidad = (Switch) findViewById(R.id.switch1);
        bateria = (ToggleButton) findViewById(R.id.toggleButton);
        restaurar = (FloatingActionButton) findViewById(R.id.button2);
        btnOK = (Button) findViewById(R.id.BtnOK);
        btnAtras = (Button) findViewById(R.id.BtnAtras);
        wifi = (CheckBox) findViewById(R.id.checkBox);
        rgOpciones = (RadioGroup) findViewById(R.id.GrbGrupo1);

        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        opcion = "G";
                        break;
                    case R.id.radioButton2:
                        opcion = "3G";
                        break;
                    case R.id.radioButton3:
                        opcion = "4G";
                        break;
                    case R.id.radioButton5:
                        opcion = "Automático";
                        break;
                }
            }
        });

        String[] listaTema = {"Dark", "Light", "Blue", "Silver"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaTema);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cadenaElegida = (String) parent.getItemAtPosition(position);
                tema = cadenaElegida;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tema = "No se ha seleccionado nada";
            }
        });

        privacidad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    botonPrivacidad = "Activado";
                } else {
                    botonPrivacidad = "Desactivado";
                }
            }
        });

        bateria.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    botonBateria = "Activado";
                } else {
                    botonBateria = "Desactivado";
                }
            }
        });

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Log.i("PRUEBA CHECKBOX", "TRUE");
                } else {
                    Log.i("PRUEBA CHECKBOX", "FALSE");
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
                intent.putExtra("red", opcion);
                intent.putExtra("tema", tema);

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

        restaurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privacidad.setChecked(false);
                bateria.setChecked(false);
                wifi.setChecked(false);
                rgOpciones.check(R.id.radioButton5);
                int spinnerPosition = adapter.getPosition("Silver");
                spinner.setSelection(spinnerPosition);
            }
        });

    }
}
