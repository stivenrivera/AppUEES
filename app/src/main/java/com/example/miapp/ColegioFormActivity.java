package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class ColegioFormActivity extends AppCompatActivity {

    private Spinner spinnerProvincia, spinnerCiudad;
    private EditText editTextColegio;
    private Map<String, String[]> ciudadesPorProvincia;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colegio_form);

        spinnerProvincia = findViewById(R.id.spinnerProvincia);
        spinnerCiudad = findViewById(R.id.spinnerCiudad);
        editTextColegio = findViewById(R.id.editTextColegio);
        btnContinuar = findViewById(R.id.btnContinuar);

        // Inicializar las provincias y ciudades
        cargarDatos();

        // Configurar el spinner de provincias
        ArrayAdapter<String> adapterProvincia = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                ciudadesPorProvincia.keySet().toArray(new String[0]));
        adapterProvincia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adapterProvincia);

        // Manejar la selección de provincia para actualizar ciudades
        spinnerProvincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String provinciaSeleccionada = (String) parent.getItemAtPosition(position);
                actualizarCiudades(provinciaSeleccionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Seleccionar la primera provincia por defecto y llenar las ciudades
        actualizarCiudades(spinnerProvincia.getSelectedItem().toString());

        // Evento para continuar a la pantalla de facultades
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFacultadesActivity();
            }
        });
    }

    private void cargarDatos() {
        ciudadesPorProvincia = new HashMap<>();
        ciudadesPorProvincia.put("Azuay", new String[] { "Cuenca", "Gualaceo", "Paute" });
        ciudadesPorProvincia.put("Guayas", new String[] { "Guayaquil", "Daule", "Samborondón" });
        ciudadesPorProvincia.put("Pichincha", new String[] { "Quito", "Cayambe", "Machachi" });
    }

    private void actualizarCiudades(String provincia) {
        String[] ciudades = ciudadesPorProvincia.get(provincia);
        ArrayAdapter<String> adapterCiudad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ciudades);
        adapterCiudad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCiudad.setAdapter(adapterCiudad);
    }

    private void abrirFacultadesActivity() {
        // Obtener los valores seleccionados
        String provincia = spinnerProvincia.getSelectedItem().toString();
        String ciudad = spinnerCiudad.getSelectedItem().toString();
        String colegio = editTextColegio.getText().toString();

        // Crear intent y enviar datos a la siguiente pantalla
        Intent intent = new Intent(ColegioFormActivity.this, FacultadesActivity.class);
        intent.putExtra("COLEGIO", colegio);
        intent.putExtra("PROVINCIA", provincia);
        intent.putExtra("CIUDAD", ciudad);
        startActivity(intent);
    }
}
