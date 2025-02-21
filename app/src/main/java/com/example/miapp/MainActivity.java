package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import android.content.SharedPreferences;
import com.example.miapp.models.MenuItemModel;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private List<MenuItemModel> menuItems; // Usar la variable de instancia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar DrawerLayout con menú de hamburguesa
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Configurar NavigationView
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_login) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                } else if (id == R.id.nav_publicaciones) {
                    SharedPreferences prefs = getSharedPreferences("MiAppPrefs", MODE_PRIVATE);
                    boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
                    if (!isLoggedIn) {
                        Toast.makeText(MainActivity.this, "Debes iniciar sesión", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        startActivity(new Intent(MainActivity.this, PublicacionesActivity.class));
                    }
                } else if (id == R.id.nav_eventos) {
                    startActivity(new Intent(MainActivity.this, EventoActivity.class));
                } else if (id == R.id.nav_revista) {
                    startActivity(new Intent(MainActivity.this, RevistaActivity.class));
                } else if (id == R.id.nav_almacen) {
                    startActivity(new Intent(MainActivity.this, ProductosActivity.class));
                } else if (id == R.id.nav_logout) {
                    // Cerrar sesión
                    SharedPreferences prefs = getSharedPreferences("MiAppPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("isLoggedIn", false); // Establecer isLoggedIn en false
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Sesión cerrada", Toast.LENGTH_SHORT).show();

                    // Redirigir a la pantalla de login
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    finish(); // Opcional: Finaliza la actividad actual para que no se pueda volver atrás
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

        // Imagen principal
        ImageView mainImage = findViewById(R.id.mainImage);
        mainImage.setImageResource(R.drawable.header_image);

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setNestedScrollingEnabled(false);

        // Opciones del menú
        menuItems = new ArrayList<>(); // Usar la variable de instancia
        menuItems.add(new MenuItemModel("Login", R.drawable.login_image));
        menuItems.add(new MenuItemModel("Publicaciones", R.drawable.membership_image));
        menuItems.add(new MenuItemModel("Eventos", R.drawable.events_image));
        menuItems.add(new MenuItemModel("Revista", R.drawable.merchandising_image));
        menuItems.add(new MenuItemModel("Almacen", R.drawable.travel_image));
        menuItems.add(new MenuItemModel("UEES clinic", R.drawable.magazine_image));

        adapter = new MenuAdapter(this, menuItems, new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SharedPreferences prefs = getSharedPreferences("MiAppPrefs", MODE_PRIVATE);
                boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

                if (position == 0) { // Opción Login
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                } else if (position == 1) { // Opción Publicaciones
                    if (!isLoggedIn) { // Si NO está logueado
                        Toast.makeText(MainActivity.this, "Debes iniciar sesión", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    } else { // Si está logueado, abre Publicaciones
                        startActivity(new Intent(MainActivity.this, PublicacionesActivity.class));
                    }
                } else if (position == 2) { // Opción Eventos
                    startActivity(new Intent(MainActivity.this, EventoActivity.class));
                } else if (position == 3) { // Opción Revista
                    startActivity(new Intent(MainActivity.this, RevistaActivity.class));
                } else if (position == 4) { // Opción Almacén
                    startActivity(new Intent(MainActivity.this, ProductosActivity.class));
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
