package com.example.releasefrontend;
/**
 * @author Luke Munn
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import api.ApiClientFactory;
import api.SlimCallback;
import model.Landlord;
import model.Tenant;

import androidx.appcompat.app.AppCompatActivity;

import com.example.releasefrontend.landlordScreens.LandlordHomePageActivity;
import com.example.releasefrontend.tenantScreens.TenantFrontPage;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Main login screen for all users. Allows for registering and switching
 * between Landlord and Tenants on login
 */
public class LoginActivity extends AppCompatActivity {

    public static Tenant mainTenant;
    public static Landlord mainLandlord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextInputLayout email = findViewById(R.id.username);
        TextInputLayout password =findViewById(R.id.password);

        Button loginButton = findViewById(R.id.button2);
        Button registerButton = findViewById(R.id.button3);
        mainTenant = new Tenant();
        mainLandlord = new Landlord();
        Switch userSwitch = findViewById(R.id.switch1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailTmp = email.getEditText().getText().toString();
                String passTmp = password.getEditText().getText().toString();

                System.out.println(emailTmp);
                System.out.println(passTmp);
                if(!userSwitch.isChecked()){
                    ApiClientFactory.GetTenantApi().Login(emailTmp, passTmp).enqueue(new SlimCallback<Tenant>(ten ->{
                        mainTenant = new Tenant (ten.getNameF(),ten.getNameL(), ten.getEmail(), ten.getPassword(), ten.getId());
                        System.out.println(ten.getNameF());
                        //check credentials
                        if(ten.getNameF().equals("thisIsNull")){
                            Toast.makeText(LoginActivity.this, "TRY AGAIN!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "LOGGED IN!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, TenantFrontPage.class);
                            startActivity(intent);
                        }
                     }));
                }
                else{
                    ApiClientFactory.GetLandlordApi().Login(emailTmp, passTmp).enqueue(new SlimCallback<Landlord>(lan ->{
                        if(lan.getNameF().equals("thisIsNull")){
                            Toast.makeText(LoginActivity.this, "TRY AGAIN!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //good
                            mainLandlord = new Landlord (lan.getNameF(),lan.getNameL(), lan.getEmail(), lan.getPassword(), lan.getId());
                            Toast.makeText(LoginActivity.this, "LOGGED IN!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, LandlordHomePageActivity.class);
                            startActivity(intent);
                            }
                    }));
                }
            }
        });

        registerButton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterScreen.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed(){
        this.finishAffinity();
    }
}