package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;

public class ProductosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private List<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        ImageView btnRegresar = findViewById(R.id.btn_regresar);
        btnRegresar.setOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.recyclerViewProductos);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Chompa UEES", 40.0, R.drawable.chompa));
        listaProductos.add(new Producto("Gorra UEES", 10.0, R.drawable.gorra));
        listaProductos.add(new Producto("Cuaderno UEES", 5.0, R.drawable.cuaderno));
        listaProductos.add(new Producto("Reloj UEES ", 30.0, R.drawable.reloj));

        adapter = new ProductoAdapter(this, listaProductos);
        recyclerView.setAdapter(adapter);

    }
}
