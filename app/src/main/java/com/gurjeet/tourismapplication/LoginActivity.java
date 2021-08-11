package com.gurjeet.tourismapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.extUsername);
        etPassword = findViewById(R.id.extPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter both username and password to login", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (userName.toLowerCase().equals("user1") && password.toLowerCase().equals("password1")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Incorrect Username or password!, try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}