package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNombres, editTextApellidos, editTextCedula, editTextCiudad, editTextEmail, editTextCelular;
    private Spinner spinnerTitulo;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Vincular elementos del layout
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextCedula = findViewById(R.id.editTextCedula);
        editTextCiudad = findViewById(R.id.editTextCiudad);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextCelular = findViewById(R.id.editTextCelular);
        spinnerTitulo = findViewById(R.id.spinnerTitulo);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        // Opciones para el Spinner
        String[] titulos = { "Ingeniería en Sistemas", "Administración de Empresas", "Medicina", "Derecho",
                "Arquitectura", "Otra" };

        // Adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, titulos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTitulo.setAdapter(adapter);

        // Acción del botón de enviar
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = editTextNombres.getText().toString().trim();
                String apellidos = editTextApellidos.getText().toString().trim();
                String cedula = editTextCedula.getText().toString().trim();
                String ciudad = editTextCiudad.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String celular = editTextCelular.getText().toString().trim();
                String titulo = spinnerTitulo.getSelectedItem().toString();

                if (nombres.isEmpty() || apellidos.isEmpty() || cedula.isEmpty() || ciudad.isEmpty() ||
                        email.isEmpty() || celular.isEmpty() || titulo.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    // Iniciar la siguiente actividad
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
