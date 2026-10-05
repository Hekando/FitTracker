package com.example.fittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleActividad extends AppCompatActivity{

    public RecyclerView recycler;
    public ArrayList<ActividadModel> datos_adapter ;
    Button boton_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.historial_actividad);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        boton_volver = findViewById(R.id.boton_volver_registro);

        boton_volver.setOnClickListener(v ->
                startActivity( new Intent(RecycleActividad.this, Registro_Actividad.class))
        );

        //
        recycler = findViewById(R.id.recycle_actividad);

        //cargar los datos a mi lista
        datos_adapter = new ArrayList<ActividadModel>();
        datos_adapter.add( new ActividadModel("Fuerza", "Media", "2", "Hidratación adecuada"));
        datos_adapter.add( new ActividadModel("Yoga", "Baja", "1", "Calentamiento realizado"));
        datos_adapter.add( new ActividadModel("Calistenia", "Alta", "5", "Calentamiento realizado; Hidratación adecuada; " +
                "Estiramiento final"));
        datos_adapter.add( new ActividadModel("Cardio", "Media", "4", "Calentamiento realizado; Estiramiento final"));
        datos_adapter.add( new ActividadModel("Yoga", "Alta", "3", "Hidratación adecuada"));
        datos_adapter.add( new ActividadModel("Calistenia", "Baja", "1", "Hidratación adecuada; Estiramiento final"));
        datos_adapter.add( new ActividadModel("Cardio", "Alta", "5", "Calentamiento realizado; Hidratación adecuada; " +
                "Estiramiento final"));

        ActividadAdapter adapter = new ActividadAdapter(datos_adapter);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(adapter);
    }

}
