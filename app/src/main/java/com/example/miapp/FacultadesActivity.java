package com.example.miapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FacultadesActivity extends AppCompatActivity {

    private TextView txtColegio, txtCarrera, txtValorCarrera, txtValorPRE;
    private String colegio;
    private String[] carrerasArquitectura = { "Arquitectura", "Arquitectura de Interiores",
            "Arquitectura y Urbanismo" };
    private String[] carrerasComunicacion = { "Comunicación", "Diseño Gráfico Interactivo", "Periodismo" };
    private String[] carrerasDerecho = { "Derecho", "Ciencias Políticas" };
    private String[] carrerasNegocios = { "Economía", "Negocios Digitales", "Administración de Empresas" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultades);

        txtColegio = findViewById(R.id.txtColegio);
        txtCarrera = findViewById(R.id.txtCarrera);
        txtValorCarrera = findViewById(R.id.txtValorCarrera);
        txtValorPRE = findViewById(R.id.txtValorPRE);

        // Recibir datos del formulario de colegio
        String colegio = getIntent().getStringExtra("COLEGIO");
        txtColegio.setText("Nombre: " + (colegio != null ? colegio : "--"));

        // Botones de facultades
        Button btnArquitectura = findViewById(R.id.btnArquitectura);
        Button btnComunicacion = findViewById(R.id.btnComunicacion);
        Button btnDerecho = findViewById(R.id.btnDerecho);
        Button btnNegocios = findViewById(R.id.btnNegocios);

        btnArquitectura.setOnClickListener(view -> mostrarListaCarreras(carrerasArquitectura));
        btnComunicacion.setOnClickListener(view -> mostrarListaCarreras(carrerasComunicacion));
        btnDerecho.setOnClickListener(view -> mostrarListaCarreras(carrerasDerecho));
        btnNegocios.setOnClickListener(view -> mostrarListaCarreras(carrerasNegocios));
    }

    private void mostrarListaCarreras(String[] carreras) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una carrera")
                .setItems(carreras, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String carreraSeleccionada = carreras[which];
                        txtCarrera.setText("Carrera: " + carreraSeleccionada);
                        actualizarValoresCarrera(carreraSeleccionada);
                    }
                });
        builder.create().show();
    }

    private void actualizarValoresCarrera(String carrera) {
        int valorCarrera = 35000; // Valor base de ejemplo
        int valorPRE = 900; // Valor base de PRE

        if (carrera.contains("Arquitectura")) {
            valorCarrera = 36000;
        } else if (carrera.contains("Comunicación")) {
            valorCarrera = 30000;
        } else if (carrera.contains("Derecho")) {
            valorCarrera = 32000;
        } else if (carrera.contains("Negocios")) {
            valorCarrera = 34000;
        }

        txtValorCarrera.setText("Valor Carrera: $" + valorCarrera);
        txtValorPRE.setText("Valor PRE: $" + valorPRE);
    }
}
