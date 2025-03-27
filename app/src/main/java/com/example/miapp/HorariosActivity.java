package com.example.miapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HorariosActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private HorariosAdapter adapter;
    private List<String> recorridos;
    private HashMap<String, List<String>> horarios;
    private FloatingActionButton fabDescargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);

        // Configurar Toolbar con botón de regresar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Habilitar botón de regreso
            getSupportActionBar().setTitle("Horarios de Recorridos");
        }

        // Acción del botón de regreso
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa a la anterior
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        fabDescargar = findViewById(R.id.fabDescargar);

        // Llenar datos de recorridos y horarios
        cargarDatos();

        adapter = new HorariosAdapter(this, recorridos, horarios);
        expandableListView.setAdapter(adapter);

        // Acción del botón flotante
        fabDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descargarHorarios();
            }
        });
    }

    private void cargarDatos() {
        recorridos = new ArrayList<>();
        horarios = new HashMap<>();

        recorridos.add("Samanes");
        recorridos.add("Centro Cívico");
        recorridos.add("Domingo Comín");
        recorridos.add("Alborada");
        recorridos.add("Urdesa Norte");
        recorridos.add("Puerto Azul - Ceibos");
        recorridos.add("Ciudadelas - La Joya");
        recorridos.add("Ciudadelas - Salitre");
        recorridos.add("Durán");

        List<String> horariosEjemplo = new ArrayList<>();
        horariosEjemplo.add("SALIDA BASE | LLEGADA UEES | SALIDA UEES | LLEGADA BASE");
        horariosEjemplo.add("6:15 - 7:00 - --- - ---");
        horariosEjemplo.add("8:00 - 9:00 - 9:10 - 10:00");
        horariosEjemplo.add("10:00 - 11:00 - 12:00 - 12:50");
        horariosEjemplo.add("13:00 - 14:00 - 16:10 - 17:00");
        horariosEjemplo.add("17:10 - 18:00 - 18:20 - 19:20");
        horariosEjemplo.add("19:20 - 20:10 - 20:45 - ---");

        for (String recorrido : recorridos) {
            horarios.put(recorrido, new ArrayList<>(horariosEjemplo));
        }
    }

    private void descargarHorarios() {
        Toast.makeText(this, "Descargando todas las paradas...", Toast.LENGTH_SHORT).show();

    }
}
