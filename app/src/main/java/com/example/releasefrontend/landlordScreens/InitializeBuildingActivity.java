package com.example.releasefrontend.landlordScreens;
/**
 * @author Luke Munn
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import com.example.releasefrontend.R;
/**
 * Base building initialization screen allowing landlord to initialize the address and the
 * number of units for a new building
 */
public class InitializeBuildingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize_building);

        EditText address = findViewById(R.id.Address);
        EditText numOfUnits = findViewById(R.id.NumOfUnits);

        Button next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addy = address.getText().toString();
                int unitNums = Integer.parseInt(numOfUnits.getText().toString());

                Intent intent = new Intent(InitializeBuildingActivity.this, FillUnitArrayActivity.class );
                intent.putExtra("Address",String.valueOf(addy));
                intent.putExtra("unitNums", unitNums);

                startActivity(intent);

            }
        });



    }
}