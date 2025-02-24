package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InformacionGeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);

        // **1️⃣ Inicializar el Spinner**
        Spinner spinnerTipoIdentificacion = findViewById(R.id.spinnerTipoIdentificacion);

        // **2️⃣ Opciones para el Spinner**
        String[] tiposIdentificacion = { "Cédula", "Pasaporte" };

        // **3️⃣ Adaptador para el Spinner**
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                tiposIdentificacion);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoIdentificacion.setAdapter(adapter);

        // **4️⃣ Evento de selección en el Spinner**
        spinnerTipoIdentificacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tipoSeleccionado = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada si no se selecciona
            }
        });

        // **5️⃣ Configurar el botón "Continuar"**
        Button btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(v -> {
            Intent intent = new Intent(InformacionGeneralActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
