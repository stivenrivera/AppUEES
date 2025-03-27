package com.example.miapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapp.RevistaAdapter;
import com.example.miapp.Evento;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;

public class RevistaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RevistaAdapter adapter;
    private List<Evento> listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revista);

        ImageView btnRegresar = findViewById(R.id.btn_regresar);
        btnRegresar.setOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.recyclerViewEventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaEventos = new ArrayList<>();
        cargarEventos();

        adapter = new RevistaAdapter(listaEventos);
        recyclerView.setAdapter(adapter);
    }

    private void cargarEventos() {
        listaEventos.add(new Evento("Facultad de Ciencias de la Salud",
                "Prof: Ing. Andres Garcia \nHan aceptado el intercambio de estudiantes con esta universidad.... \n ",
                R.drawable.perfilfacultad, R.drawable.conferencia));

        listaEventos
                .add(new Evento("Facultad de Derecho", "Alumno: Daniel Perez \nNo te pierdas esta noticia importante",
                        R.drawable.perfilfacultad, R.drawable.evento));
    }
}
