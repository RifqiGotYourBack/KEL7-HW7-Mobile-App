package com.example.myapplication;  // Replace with your package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);  // Assuming this is the name of your layout file

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString();

                // Check if email contains @gmail.com and password is non-empty
                if(email.contains("@gmail.com") && !password.isEmpty()) {
                    // Start HomeFragment - For demonstration, I'm assuming you have a MainActivity that hosts your HomeFragment
                    Intent intent = new Intent(Login.this, MainActivity.class);  // Replace MainActivity with the activity that hosts your HomeFragment
                    startActivity(intent);
                    finish();  // Close the Login activity after navigation
                } else {
                    Toast.makeText(Login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
