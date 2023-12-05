package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MostrarDatos extends AppCompatActivity {

    TextView tvnombre, tvedad, tvtelefono, tvcorreo, tvinfo;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre   = (TextView)findViewById(R.id.tvnombre);
        tvedad     = (TextView)findViewById(R.id.tvedad);
        tvtelefono = (TextView)findViewById(R.id.tvtelefono);
        tvcorreo   = (TextView)findViewById(R.id.tvcorreo);
        tvinfo     = (TextView)findViewById(R.id.tvinfo);
        btnOk     = (Button)findViewById(R.id.btnok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostrarDatos.this, MainActivity.class);
                startActivity(intent);
            }
                                 });

        mostrarDatos();
    }

    private void mostrarDatos() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String edad   = datos.getString("age");
        String number = datos.getString("number");
        String correo = datos.getString("mail");
        String info = datos.getString("inf");

        tvnombre.setText(nombre);
        tvedad.setText(edad);

    }
}