package com.example.releasefrontend;
/**
 * @author Luke Munn
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
/**
 * Register splash screen allowing users to click which type of client to register as
 */
public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        TextView who = findViewById(R.id.who);
        TextView register =findViewById(R.id.register);

        Button tenantButton = findViewById(R.id.tenantButton);
        Button landlordButton = findViewById(R.id.landlordButton);
        Intent tenant = new Intent(RegisterScreen.this, TenantRegister.class);
        Intent landlord = new Intent(RegisterScreen.this, LandlordRegister.class);

        tenantButton.setOnClickListener(view -> {
            startActivity(tenant);
        });
        landlordButton.setOnClickListener(view -> {
            startActivity(landlord);
        });
    }
}