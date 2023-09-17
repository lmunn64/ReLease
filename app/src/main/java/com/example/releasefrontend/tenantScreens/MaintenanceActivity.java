package com.example.releasefrontend.tenantScreens;
/**
 * @author Luke Munn
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;
import com.example.releasefrontend.databinding.ActivityMantenanceBinding;

import api.ApiClientFactory;
import api.SlimCallback;
import model.MaintenanceRequest;

/**
 * Main maintenance screen for tenants. Allows tenants to request
 * maintenance for their specific room. This sends a request to the
 * maintenance worker and lists requests as pending, in progress, or complete
 */
public class MaintenanceActivity extends nav_base_activity {
    public MaintenanceRequest maintReq;
    ActivityMantenanceBinding activityMaintenanceBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMaintenanceBinding = ActivityMantenanceBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Maintenance");
        setContentView(activityMaintenanceBinding.getRoot());
        Button sendButton = findViewById(R.id.sendButton);
        EditText maintenanceReq = findViewById(R.id.maintenanceReq);
        allocateActivityTitle("Maintenance Request");

        sendButton.setOnClickListener(view -> {

            String fullReq = maintenanceReq.getText().toString();
            maintReq = new MaintenanceRequest();
            maintReq.setMessage(fullReq);

            maintReq.setTenant(LoginActivity.mainTenant);
            ApiClientFactory.GetMaintenanceApi().PostMaintenanceReq(LoginActivity.mainTenant.getId(), maintReq.getMessage()).enqueue(new SlimCallback<MaintenanceRequest>(mainReq ->{
                System.out.println(maintReq.getMessage());
                System.out.println(maintReq.getMessage());
                System.out.println(LoginActivity.mainTenant.getId());
            }));
            Toast.makeText(MaintenanceActivity.this, "Sent! Please allow us time to process and repair.", Toast.LENGTH_SHORT).show();
            maintenanceReq.setText(" ");
        });
    }
}

