package com.example.releasefrontend.landlordScreens;
/**
 * @author Luke Munn
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;

import api.ApiClientFactory;
import api.SlimCallback;
import model.Building;
import model.Unit;

/**
 * Screen allowing landlord to repeatedly fill
 * attributes of units for however many
 * units were specified to be initialized in the given
 * building
 */
public class FillUnitArrayActivity extends AppCompatActivity {
    private int unitsInitialized; //keeps track of how many units have been put into the buildiings unit array
    final private int[] buildingTmpId = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_unit_array);

        TextView addy = findViewById(R.id.Address);
        String address = getIntent().getStringExtra("Address");

        addy.setText(address);

        TextView unitNums = findViewById(R.id.unitIncrementer);
        int numUnits = getIntent().getIntExtra("unitNums",-1);

        unitNums.setText("now initilizing unit " + (unitsInitialized+1) + "/" + numUnits);

        Button nextUnit = findViewById(R.id.nextUnit);

        EditText unitNumber = findViewById(R.id.unitNumber);
        EditText beds = findViewById(R.id.beds);
        EditText baths = findViewById(R.id.baths);
        EditText rent = findViewById(R.id.rent);


        Building b = new Building(address, numUnits);
        Unit[] tmp = new Unit[numUnits];
        unitsInitialized = 0;

        ApiClientFactory.GetBuildingApi().PostBuildingByPath(LoginActivity.mainLandlord.getId(), b.getAddress(),b.getNumberOfUnits()).enqueue(new SlimCallback<Building>(building ->{
            System.out.println("posting by body");
            int id = building.getId();
            buildingTmpId[0] = id;
        }));

        nextUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int unitNumTmp = Integer.parseInt(unitNumber.getText().toString());
                    int bedTmp = Integer.parseInt(beds.getText().toString());
                    int bathTmp = Integer.parseInt(baths.getText().toString());
                    int rentTmp = Integer.parseInt(rent.getText().toString());

                    tmp[unitsInitialized] = new Unit(b, unitNumTmp,bedTmp,bathTmp,rentTmp);
                    b.setUnitArray(tmp);

                    //post last unit
                    if (unitsInitialized == numUnits - 1){
                        System.out.println(b.getAddress() + ":");
                        System.out.println("Number of units: " + b.getNumberOfUnits());
                        System.out.println("Units: " + b.printUnitArray());
                        System.out.println("Ready To Post");
                        System.out.println(LoginActivity.mainLandlord.getId());
                        System.out.println(b.getAddress());
                        System.out.println(b.getNumberOfUnits());
                        ApiClientFactory.GetUnitApi().CreateUnit2(buildingTmpId[0], unitNumTmp,  bedTmp,bathTmp, rentTmp).enqueue(new SlimCallback<Unit>(unit ->{
                            System.out.println("creating final unit");
                            Intent intent = new Intent(FillUnitArrayActivity.this, PropertyManagementActivity.class);
                            startActivity(intent);
                        }));

                    }
                    else{
                        ApiClientFactory.GetUnitApi().CreateUnit2(buildingTmpId[0], unitNumTmp,  bedTmp,bathTmp, rentTmp).enqueue(new SlimCallback<Unit>(unit ->{
                            System.out.println("creating unit");
                        }));
                        System.out.println(tmp[unitsInitialized].getUnitNumber());
                        unitsInitialized++;
                        unitNumber.setText("");
                        beds.setText("");
                        baths.setText("");
                        rent.setText("");
                        unitNums.setText("now initilizing unit " + (unitsInitialized+1) + "/" + numUnits);
                    }
                }
        });
    }
    public void check() {
        System.out.println("Check");
    }
    public String printUnitArray(Unit[] units){
        String out = "";
        for(int i = 0; i < units.length; i++){
            out = out + units[i].getUnitNumber() + ", ";
        }
        return out;
    }
}