package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TipoRegistroActivity extends AppCompatActivity {

    private Button btnAdmisiones, btnEducacionContinua, btnUEESOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_registro);

        btnAdmisiones = findViewById(R.id.btnAdmisiones);
        btnEducacionContinua = findViewById(R.id.btnEducacionContinua);
        btnUEESOnline = findViewById(R.id.btnUEESOnline);

        btnAdmisiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipoRegistroActivity.this, ColegioFormActivity.class);
                startActivity(intent);
            }
        });

        btnEducacionContinua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipoRegistroActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnUEESOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipoRegistroActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
