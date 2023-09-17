package com.example.releasefrontend;
/**
 * @author Luke Munn
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import model.Tenant;

import api.ApiClientFactory;
import api.SlimCallback;
import model.Landlord;
import model.Tenant;
/**
 * Main screen for registering as a Tenant
 */
public class TenantRegister extends AppCompatActivity {
    public static Tenant t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);

        EditText firstName = findViewById(R.id.firstName);
        EditText lastName =findViewById(R.id.lastName);
        EditText email = findViewById(R.id.emailAddress);
        EditText pass =findViewById(R.id.password);
        EditText passConfirm = findViewById(R.id.confirmPass);

        TextView errorCred = findViewById(R.id.error1);
        TextView errorPass = findViewById(R.id.error2);


        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Checks for password requirements below:
                if(firstName.getText().toString().equals("") || lastName.getText().toString().equals("")|| email.getText().toString().equals("")) {
                    errorCred.setText("Invalid credentials. Fill all fields.");
                    errorCred.setVisibility(view.VISIBLE);
                }
                else{
                    errorCred.setText("");
                    errorCred.setVisibility(view.INVISIBLE);
                }
                if(pass.getText().toString().length() < 8){
                    errorPass.setText("Password not long enough!");
                    errorPass.setVisibility(view.VISIBLE);
                }
                else if (!pass.getText().toString().equals(passConfirm.getText().toString())){
                    errorPass.setText("Passwords do not match!");
                    errorPass.setVisibility(view.VISIBLE);
                }
                    //good
                    String firstNameTmp = firstName.getText().toString();
                    String lastNameTmp = lastName.getText().toString();
                    String emailTmp = email.getText().toString();
                    String passTmp = pass.getText().toString();

                    errorPass.setVisibility(view.INVISIBLE);

                    t = new Tenant(firstNameTmp,lastNameTmp,emailTmp,passTmp);
                    Intent intent = new Intent(TenantRegister.this, newTenantBuildingActivity.class);
                    startActivity(intent);
                }
//            }
       });
    }
}