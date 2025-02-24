package com.example.miapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.widget.Button;


public class FacultadesActivity extends AppCompatActivity {

    private TextView txtCarrera, txtValorCarrera, txtValorPRE;
    private ExpandableListView expandableListView;
    private FacultadesAdapter adapter;
    private HashMap<String, Integer> valoresCarrera;
    private HashMap<String, Integer> valoresPRE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultades);

        txtCarrera = findViewById(R.id.txtCarrera);
        txtValorCarrera = findViewById(R.id.txtValorCarrera);
        txtValorPRE = findViewById(R.id.txtValorPRE);
        expandableListView = findViewById(R.id.expandableListView);

        List<String> facultades = new ArrayList<>();
        HashMap<String, List<String>> carreras = new HashMap<>();
        valoresCarrera = new HashMap<>();
        valoresPRE = new HashMap<>();

        // Definir facultades
        facultades.add("Arquitectura y Diseño");
        facultades.add("Ciencias de la Comunicación");
        facultades.add("Derecho, Política y Desarrollo");
        facultades.add("Negocios y Economía");

        // Definir carreras y valores
        carreras.put("Arquitectura y Diseño", List.of("Arquitectura", "Arquitectura de Interiores", "Arquitectura y Urbanismo"));
        valoresCarrera.put("Arquitectura", 36000);
        valoresCarrera.put("Arquitectura de Interiores", 34000);
        valoresCarrera.put("Arquitectura y Urbanismo", 35000);
        valoresPRE.put("Arquitectura", 2500);
        valoresPRE.put("Arquitectura de Interiores", 2200);
        valoresPRE.put("Arquitectura y Urbanismo", 2300);

        carreras.put("Ciencias de la Comunicación", List.of("Comunicación", "Diseño Gráfico Interactivo", "Periodismo"));
        valoresCarrera.put("Comunicación", 30000);
        valoresCarrera.put("Diseño Gráfico Interactivo", 29000);
        valoresCarrera.put("Periodismo", 28000);
        valoresPRE.put("Comunicación", 2000);
        valoresPRE.put("Diseño Gráfico Interactivo", 1800);
        valoresPRE.put("Periodismo", 1900);

        carreras.put("Derecho, Política y Desarrollo", List.of("Derecho", "Ciencias Políticas"));
        valoresCarrera.put("Derecho", 32000);
        valoresCarrera.put("Ciencias Políticas", 31000);
        valoresPRE.put("Derecho", 2100);
        valoresPRE.put("Ciencias Políticas", 2050);

        carreras.put("Negocios y Economía", List.of("Economía", "Negocios Digitales", "Administración de Empresas"));
        valoresCarrera.put("Economía", 31000);
        valoresCarrera.put("Negocios Digitales", 30000);
        valoresCarrera.put("Administración de Empresas", 32000);
        valoresPRE.put("Economía", 2000);
        valoresPRE.put("Negocios Digitales", 1900);
        valoresPRE.put("Administración de Empresas", 2100);

        adapter = new FacultadesAdapter(this, facultades, carreras, valoresCarrera);
        expandableListView.setAdapter(adapter);

        // Detectar cuando el usuario selecciona una carrera
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String facultad = facultades.get(groupPosition);
            String carreraSeleccionada = carreras.get(facultad).get(childPosition);
            int valorCarrera = valoresCarrera.getOrDefault(carreraSeleccionada, 0);
            int valorPre = valoresPRE.getOrDefault(carreraSeleccionada, 0);

            // Actualizar los textos en los recuadros
            txtCarrera.setText(carreraSeleccionada);
            txtValorCarrera.setText("Valor Carrera: $" + valorCarrera);
            txtValorPRE.setText("Valor PRE: $" + valorPre);

            Toast.makeText(this, "Seleccionaste: " + carreraSeleccionada, Toast.LENGTH_SHORT).show();

            return true;
        });
        Button btnContinuar = findViewById(R.id.btnContinuar);

        // Agregar el evento de clic
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a MainActivity
                Intent intent = new Intent(FacultadesActivity.this, InformacionGeneralActivity.class);
                startActivity(intent);
                finish(); // Opcional: Cierra esta actividad
            }
        });
    }
}
