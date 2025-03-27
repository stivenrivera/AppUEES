package com.example.miapp;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class GymUees extends AppCompatActivity {

    private GridView gymServicesGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Habilitar botón de regreso
            getSupportActionBar().setTitle("Sports Center UEES");
        }

        // Acción del botón de regreso
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa a la anterior
            }
        });

        gymServicesGrid = findViewById(R.id.gymServicesGrid);

        // Lista de servicios disponibles
        ArrayList<HashMap<String, String>> servicesList = new ArrayList<>();

        int[] serviceImages = {
                R.drawable.weights, R.drawable.treadmill,
                R.drawable.pingpong, R.drawable.boxeo,
                R.drawable.tenis, R.drawable.pool
        };

        String[] serviceNames = {
                "Área de Pesas", "Caminadoras",
                "Clases de Yoga", "Zona de Boxeo",
                "Bicicletas Estáticas", "Piscina"
        };

        for (int i = 0; i < serviceNames.length; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("image", String.valueOf(serviceImages[i]));
            map.put("text", serviceNames[i]);
            servicesList.add(map);
        }

        // Adaptador para mostrar los servicios en el GridView
        ListAdapter adapter = new SimpleAdapter(
                this, servicesList, R.layout.list_item_gym,
                new String[] { "image", "text" },
                new int[] { R.id.itemImage, R.id.itemText });

        gymServicesGrid.setAdapter(adapter);
    }
}
