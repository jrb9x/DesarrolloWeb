package com.example.holamundoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Hola amigo " + nombreUsuario);
    }
}
