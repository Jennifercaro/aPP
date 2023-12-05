package com.example.miformulario;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    DatePicker cumpleanios;
    EditText telefono;
    EditText correo;
    EditText info;
    Button Aceptar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = findViewById(R.id.editnombre);
        cumpleanios = findViewById(R.id.editcumpleanios);
        telefono    = findViewById(R.id.edittelefono);
        correo      = findViewById(R.id.editcorreo);
        info        = findViewById(R.id.editinfo);
        Aceptar     = findViewById(R.id.btnaceptar);

        Aceptar.setOnClickListener(v -> {
            String name = nombre.getText().toString();
            float age   = cumpleanios.getY();
            String number = telefono.getText().toString();
            String mail = correo.getText().toString();
            String inf = info.getText().toString();


            Intent i = new Intent(MainActivity.this, MostrarDatos.class);

            i.putExtra("name", name);
            i.putExtra("age", age);
            i.putExtra("number", number);
            i.putExtra("mail", mail);
            i.putExtra("inf", inf);

            startActivity(i);
        });
    }}