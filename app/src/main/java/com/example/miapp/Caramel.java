package com.example.miapp;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class Caramel extends AppCompatActivity {

    private GridView menuGridView;
    private GridView productosGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caramel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Habilitar botón de regreso
            getSupportActionBar().setTitle("Caramel Coffee");
        }

        // Acción del botón de regreso
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra la actividad y regresa a la anterior
            }
        });

        menuGridView = findViewById(R.id.menuGridView);
        productosGridView = findViewById(R.id.productosGridView);

        // Menú de almuerzos
        String[] menuAlmuerzos = {
                "Almuerzo 1: Pollo con arroz y ensalada - $4",
                "Almuerzo 2: Pescado frito con papas y ensalada - $4"
        };
        int[] menuImages = { R.drawable.chicken, R.drawable.fish }; // Agrega tus imágenes en drawable
        MenuAdapter menuAdapter = new MenuAdapter(menuAlmuerzos, menuImages);
        menuGridView.setAdapter(menuAdapter);

        // Productos adicionales
        String[] productos = {
                "Café - $1",
                "Té - $1",
                "Helado - $2",
                "Torta de chocolate - $2",
                "Torta de choclo - $2",
                "Cake de vainilla - $2",
                "Torta de manzana - $2",
                "Pastelito de carne - $2"
        };
        int[] productosImages = { R.drawable.coffee, R.drawable.tea, R.drawable.ice_cream,
                R.drawable.ice_cream, R.drawable.coffee, R.drawable.tea,
                R.drawable.ice_cream, R.drawable.coffee }; // Agrega imágenes correspondientes
        ProductosAdapter productosAdapter = new ProductosAdapter(productos, productosImages);
        productosGridView.setAdapter(productosAdapter);
    }

    // Adapter personalizado para el menú de almuerzos
    private class MenuAdapter extends android.widget.BaseAdapter {
        private String[] items;
        private int[] images;

        public MenuAdapter(String[] items, int[] images) {
            this.items = items;
            this.images = images;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false); // Aquí cambiamos a
                                                                                              // list_item.xml
            }

            TextView itemText = convertView.findViewById(R.id.itemText);
            ImageView itemImage = convertView.findViewById(R.id.itemImage);

            itemText.setText(items[position]);
            itemImage.setImageResource(images[position]);

            return convertView;
        }
    }

    // Adapter personalizado para los productos adicionales
    private class ProductosAdapter extends android.widget.BaseAdapter {
        private String[] items;
        private int[] images;

        public ProductosAdapter(String[] items, int[] images) {
            this.items = items;
            this.images = images;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false); // Aquí cambiamos a
                                                                                              // list_item.xml
            }

            TextView itemText = convertView.findViewById(R.id.itemText);
            ImageView itemImage = convertView.findViewById(R.id.itemImage);

            itemText.setText(items[position]);
            itemImage.setImageResource(images[position]);

            return convertView;
        }
    }
}
