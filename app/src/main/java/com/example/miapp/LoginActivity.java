package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast; // Importar para usar Toast
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private TextView textRegister, textForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Vincular los elementos del layout
        buttonLogin = findViewById(R.id.buttonLogin);
        textRegister = findViewById(R.id.textRegister);
        textForgotPassword = findViewById(R.id.textForgotPassword);

        // Al pulsar "Ingresar", se abre MainActivity sin validar los campos

        buttonLogin.setOnClickListener(view -> {
            // Guardar estado de sesión
            SharedPreferences prefs = getSharedPreferences("MiAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("isLoggedIn", true);
            editor.apply();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        // Al pulsar "Regístrate", se abre RegisterActivity
        textRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, TipoRegistroActivity.class);
            startActivity(intent);
        });

        // Al pulsar "¿Olvidaste tu contraseña?" se muestra un mensaje (puedes
        // implementar otra lógica)
        textForgotPassword.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Función de recuperación en desarrollo", Toast.LENGTH_SHORT).show();
        });
    }
}
