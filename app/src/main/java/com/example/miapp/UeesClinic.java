package com.example.miapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;

public class UeesClinic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uees_clinic);

        // Referenciar los botones
        LinearLayout btnAgendarCita = findViewById(R.id.btnAgendarCita);
        LinearLayout btnSolicitarExamenes = findViewById(R.id.btnSolicitarExamenes);
        LinearLayout btnResultadosExamenes = findViewById(R.id.btnResultadosExamenes);
        LinearLayout btnResultadosImagenes = findViewById(R.id.btnResultadosImagenes);

        // Definir los clics de los botones
        btnAgendarCita.setOnClickListener(v -> {
            // Mostrar mensaje sobre WhatsApp
            Toast.makeText(UeesClinic.this, "Esta opción lo dirigirá a WhatsApp", Toast.LENGTH_SHORT).show();
        });

        btnSolicitarExamenes.setOnClickListener(v -> {
            // Mostrar ventana flotante para seleccionar los exámenes
            showExamenesDialog();
        });

        btnResultadosExamenes.setOnClickListener(v -> {
            // Mostrar ventana flotante para ingresar número de cédula
            showCedulaDialog();
        });

        btnResultadosImagenes.setOnClickListener(v -> {
            // Mostrar ventana flotante para ingresar número de cédula
            showCedulaDialog();
        });
    }

    // Método para mostrar la ventana flotante para ingresar el número de cédula
    private void showCedulaDialog() {
        // Crear el cuadro de diálogo para pedir la cédula
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Introduce tu número de cédula");

        // Crear un campo de texto para ingresar la cédula
        final EditText inputCedula = new EditText(this);
        builder.setView(inputCedula);

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Aceptar", (dialog, which) -> {
            String cedula = inputCedula.getText().toString();
            // Aquí puedes procesar la cédula ingresada
            Toast.makeText(UeesClinic.this, "Cédula ingresada: " + cedula, Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());

        // Mostrar el cuadro de diálogo
        builder.show();
    }

    // Método para mostrar la ventana flotante con Checkboxes para los exámenes
    private void showExamenesDialog() {
        // Crear el cuadro de diálogo para seleccionar los exámenes
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona los exámenes");

        // Crear Checkboxes para los tipos de exámenes
        final CheckBox checkboxOrina = new CheckBox(this);
        checkboxOrina.setText("Orina");
        final CheckBox checkboxHeces = new CheckBox(this);
        checkboxHeces.setText("Heces");
        final CheckBox checkboxSangre = new CheckBox(this);
        checkboxSangre.setText("Sangre");
        final CheckBox checkboxAzucar = new CheckBox(this);
        checkboxAzucar.setText("Azúcar");

        // Crear un contenedor y agregar los Checkboxes
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(checkboxOrina);
        layout.addView(checkboxHeces);
        layout.addView(checkboxSangre);
        layout.addView(checkboxAzucar);

        builder.setView(layout);

        // Configurar los botones del cuadro de diálogo
        builder.setPositiveButton("Aceptar", (dialog, which) -> {
            // Aquí puedes procesar las opciones seleccionadas
            StringBuilder selectedExams = new StringBuilder("Exámenes seleccionados: ");
            if (checkboxOrina.isChecked())
                selectedExams.append("Orina, ");
            if (checkboxHeces.isChecked())
                selectedExams.append("Heces, ");
            if (checkboxSangre.isChecked())
                selectedExams.append("Sangre, ");
            if (checkboxAzucar.isChecked())
                selectedExams.append("Azúcar");

            // Mostrar los exámenes seleccionados
            Toast.makeText(UeesClinic.this, selectedExams.toString(), Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());

        // Mostrar el cuadro de diálogo
        builder.show();
    }
}
