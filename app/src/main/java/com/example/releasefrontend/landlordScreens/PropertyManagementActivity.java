package com.example.releasefrontend.landlordScreens;
/**
 * @author Luke Munn
 */

import android.os.Bundle;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;
import com.example.releasefrontend.databinding.ActivityPropertyManagementBinding;

import java.util.List;

import api.ApiClientFactory;
import api.SlimCallback;
import model.Building;
/**
 * Main splashscreen for a logged in landlord, allowing to see
 * their given properties and select them.
 */
public class PropertyManagementActivity extends nav_landlord_activity {

    ActivityPropertyManagementBinding activityPropertyManagementBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPropertyManagementBinding = ActivityPropertyManagementBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Front Page");
        setContentView(activityPropertyManagementBinding.getRoot());
        allocateActivityTitle("Dashboard");
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        Button addNewProp = findViewById(R.id.newProp);

        TextView propDisplay = findViewById(R.id.propDisplay);
        propDisplay.setMovementMethod(new ScrollingMovementMethod());
        propDisplay.setHeight(410);

        System.out.println("...Getting all Buildings");
        //Ready for backend, will list all buildings
        ApiClientFactory.GetBuildingApi().findByLandlord(LoginActivity.mainLandlord.getId()).enqueue(new SlimCallback<List<Building>>(buildings ->{
            System.out.println(LoginActivity.mainLandlord.getId());
            System.out.println("In get function");
//            System.out.println("===========");
//            System.out.println(buildings.get(1).getAddress());
//            System.out.println("===========");
            System.out.println("*****" + buildings.size());

            propDisplay.setText("");

            if(buildings.size() ==0){
                propDisplay.setText("No current Properties");
            }else {
                for(int i = buildings.size()-1; i >= 0; i-- ){
                    System.out.println("in append");
                    propDisplay.append(buildings.get(i).getAddress());
                    propDisplay.append("\n");
                   // propDisplay.setText(buildings.get(i).getAddress());

                }
            }




        },"GetAllBuildings"));






        addNewProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertyManagementActivity.this, InitializeBuildingActivity.class );
                startActivity(intent);
                 }
        });

    }



}