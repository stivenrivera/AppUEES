package com.example.miapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapp.EventoAdapter;
import com.example.miapp.Evento;
import java.util.ArrayList;
import java.util.List;

public class EventoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventoAdapter adapter;
    private List<Evento> listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos);

        recyclerView = findViewById(R.id.recyclerViewEventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaEventos = new ArrayList<>();
        cargarEventos();

        adapter = new EventoAdapter(listaEventos);
        recyclerView.setAdapter(adapter);
    }

    private void cargarEventos() {
        listaEventos.add(new Evento("Facultad de Ciencias de la Salud",
                "Este sabado tendremos la gran conferencia en la Biblioteca con un invitado sorpresa, no te la pierdas",
                R.drawable.ic_profile, R.drawable.conferencia));

        listaEventos.add(new Evento("Facultad de Comunicacion", "Espero puedas asistir",
                R.drawable.ic_profile, R.drawable.evento));

        listaEventos.add(new Evento("Facultad de Ciencias de la Salud",
                "Gran salida de campo apta para cualquier miembro de UEES",
                R.drawable.ic_profile, R.drawable.salida_campo));
    }
}
