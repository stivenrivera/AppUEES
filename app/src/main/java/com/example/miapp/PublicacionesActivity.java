package com.example.miapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.miapp.PublicacionAdapter;
import com.example.miapp.Publicacion;
import java.util.ArrayList;
import java.util.List;

public class PublicacionesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PublicacionAdapter adapter;
    private List<Publicacion> listaPublicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publicaciones);

        recyclerView = findViewById(R.id.recyclerViewPublicaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaPublicaciones = new ArrayList<>();
        cargarPublicaciones();

        adapter = new PublicacionAdapter(listaPublicaciones);
        recyclerView.setAdapter(adapter);
    }

    private void cargarPublicaciones() {
        listaPublicaciones.add(new Publicacion("Facultad de Arquitectura y Diseño", "Esta es mi primera publicación.",
                R.drawable.ic_profile, R.drawable.imagen1));

        listaPublicaciones.add(new Publicacion("Facultad de Ciencias de la Salud “Dr. Enrique Ortega Moreira",
                "Disfrutando de un gran día!",
                R.drawable.ic_profile, R.drawable.imagen_video));

        listaPublicaciones.add(new Publicacion("Facultad de Derecho, Política y Desarrollo", "Presento este curso",
                R.drawable.ic_profile, R.drawable.imagen1));
    }
}
