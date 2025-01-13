package com.example.supermercadorober;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerUsernameEditText, registerEmailEditText, registerPasswordEditText;
    private Button registerButton, backToLoginButton, switchLanguageButton;
    private boolean isEnglish = false; // Para manejar el idioma

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Referencias a los elementos del layout
        registerUsernameEditText = findViewById(R.id.registerUsernameEditText);
        registerEmailEditText = findViewById(R.id.registerEmailEditText);
        registerPasswordEditText = findViewById(R.id.registerPasswordEditText);
        registerButton = findViewById(R.id.registerButton);
        backToLoginButton = findViewById(R.id.backToLoginButton);
        switchLanguageButton = findViewById(R.id.switchLanguageButton);

        // Configurar acciones de botones
        registerButton.setOnClickListener(v -> validateAndRegister());
        backToLoginButton.setOnClickListener(v -> {
            // Crear un Intent para abrir LoginActivity
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Finaliza RegisterActivity para no volver al pulsar "atrás"
        });
        switchLanguageButton.setOnClickListener(v -> switchLanguage());
    }

    private void validateAndRegister() {
        String username = registerUsernameEditText.getText().toString();
        String email = registerEmailEditText.getText().toString();
        String password = registerPasswordEditText.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, isEnglish ? "Please fill all fields" : "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, isEnglish ? "Invalid email format" : "Formato de correo electrónico inválido", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, isEnglish ? "Registration successful!" : "¡Registro exitoso!", Toast.LENGTH_SHORT).show();

            // Aquí puedes guardar los datos o navegar de regreso a LoginActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish(); // Finaliza RegisterActivity
        }
    }

    private void switchLanguage() {
        if (isEnglish) {
            // Cambiar a español
            registerUsernameEditText.setHint("Usuario");
            registerEmailEditText.setHint("Correo Electrónico");
            registerPasswordEditText.setHint("Contraseña");
            registerButton.setText("Registrar");
            backToLoginButton.setText("Volver a Login");
            switchLanguageButton.setText("Cambiar a Inglés");
        } else {
            // Cambiar a inglés
            registerUsernameEditText.setHint("Username");
            registerEmailEditText.setHint("Email");
            registerPasswordEditText.setHint("Password");
            registerButton.setText("Register");
            backToLoginButton.setText("Back to Login");
            switchLanguageButton.setText("Switch to Spanish");
        }
        isEnglish = !isEnglish;
    }
}
