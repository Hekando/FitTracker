package com.example.fittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Registro_Actividad extends AppCompatActivity {

    List<String> tipo_ejercicio = new ArrayList<>();
    Spinner spinner_ejercicio;
    Button boton_cerrar_sesion;
    Button boton_historial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro_actividad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boton_cerrar_sesion = findViewById(R.id.boton_cerrar);

        boton_cerrar_sesion.setOnClickListener(v ->
                startActivity( new Intent(Registro_Actividad.this, MainActivity.class))
        );

        boton_historial = findViewById(R.id.boton_act_registrada);

        boton_historial.setOnClickListener(v ->
                startActivity( new Intent(Registro_Actividad.this, RecycleActividad.class))
        );

        //Codigo para spiner, problando la lista de datos
        tipo_ejercicio.add("Fuerza");
        tipo_ejercicio.add("Cardio");
        tipo_ejercicio.add("Yoga");
        tipo_ejercicio.add("Calistenia");

        spinner_ejercicio = findViewById(R.id.spinner_ejercicio);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipo_ejercicio);
        spinner_ejercicio.setAdapter(adapter);
    }
}