package com.example.releasefrontend;
/**
 * @author Luke Munn
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import api.ApiClientFactory;
import api.SlimCallback;
import model.Building;
/**
= * Screen allowing new Tenants to choose the building they would like to be registered with
 */
public class newTenantBuildingActivity extends AppCompatActivity {
    public static Building building;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tenant_building);
        //Grab list of all buildings
        ApiClientFactory.GetBuildingApi().getAllBuildings().enqueue(new SlimCallback<List<Building>>(buildings ->{
            TextView[] textViews = new TextView[buildings.size()];
            System.out.println(buildings.size());

            //List all buildings in the database in a scrolling textView
            for(int i = 0; i < buildings.size(); i++) {
                int index = i;
                textViews[i] = new TextView(this);
                String addy = buildings.get(i).getAddress();
                System.out.println(addy);
                textViews[i].setText("\t" + addy);
                LinearLayout layout = findViewById(R.id.buildingScroll);
                textViews[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                textViews[i].setGravity(Gravity.CENTER_VERTICAL);
                textViews[i].setHeight(200);
                textViews[i].setTextSize(25);
                textViews[i].setBackgroundResource(R.drawable.border);
                layout.addView(textViews[i]);
                textViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       building = buildings.get(index);
                       System.out.println(building.getId());
                       Intent intent = new Intent(newTenantBuildingActivity.this, newTenantUnitActivity.class);
                       startActivity(intent);
                    }
                });
            }
              }));
    }
}