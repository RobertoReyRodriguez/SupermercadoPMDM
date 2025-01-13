package com.example.supermercadorober;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton, switchLanguageButton;
    private TextView loginTitle;
    private ImageView logoImageView;

    private boolean isEnglish = false; // Para manejar el idioma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a los elementos del layout
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        switchLanguageButton = findViewById(R.id.switchLanguageButton);
        loginTitle = findViewById(R.id.loginTitle);
        logoImageView = findViewById(R.id.logoImageView);

        // Configurar acciones de botones
        loginButton.setOnClickListener(v -> validateLogin());
        switchLanguageButton.setOnClickListener(v -> switchLanguage());
    }

    private void validateLogin() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, isEnglish ? "Please fill all fields" : "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, isEnglish ? "Login successful!" : "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();

            // Aquí puedes añadir lógica para navegar a otra actividad
            // Intent intent = new Intent(this, MainActivity.class);
            // startActivity(intent);
        }
    }

    private void switchLanguage() {
        if (isEnglish) {
            // Cambiar a español
            loginTitle.setText("Inicio de Sesión");
            usernameEditText.setHint("Usuario");
            passwordEditText.setHint("Contraseña");
            loginButton.setText("Iniciar Sesión");
            switchLanguageButton.setText("Cambiar a Inglés");
        } else {
            // Cambiar a inglés
            loginTitle.setText("Login");
            usernameEditText.setHint("Username");
            passwordEditText.setHint("Password");
            loginButton.setText("Log In");
            switchLanguageButton.setText("Switch to Spanish");
        }
        isEnglish = !isEnglish;
    }
}
