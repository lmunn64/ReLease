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
import model.Tenant;
import model.Unit;
/**
 * Screen allowing new Tenants to choose the unit (from the previously chosen building)
 * they would like to be registered with
 */
public class newTenantUnitActivity extends AppCompatActivity {
    public static int tenantUnit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tenant_unit);
        ApiClientFactory.GetUnitApi().findByBuilding(newTenantBuildingActivity.building.getId()).enqueue(new SlimCallback<List<Unit>>(units ->{
            TextView[] textViews = new TextView[units.size()];
            System.out.println(units.size());
            System.out.println(newTenantBuildingActivity.building.getId());
            //List all units for the given building in a scrolling textView
            for(int i = 0; i < units.size(); i++) {
                int index = i;
                textViews[i] = new TextView(this);
                int num = units.get(i).getUnitNumber();
                System.out.println(num);
                textViews[i].setText("\tUnit number: " + num);
                LinearLayout layout = findViewById(R.id.unitScroll);
                textViews[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                textViews[i].setGravity(Gravity.CENTER_VERTICAL);
                textViews[i].setHeight(200);
                textViews[i].setTextSize(25);
                textViews[i].setBackgroundResource(R.drawable.border);
                layout.addView(textViews[i]);
                textViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Post tenant to database and begin LoginActivity
                        tenantUnit = units.get(index).getId();
                        System.out.println(tenantUnit);
                        TenantRegister.t.setUnit(tenantUnit);
                        ApiClientFactory.GetTenantApi().PostTenantByPath(TenantRegister.t.getNameF(),TenantRegister.t.getNameL(),TenantRegister.t.getEmail(),TenantRegister.t.getPassword(), tenantUnit).enqueue(new SlimCallback<Tenant>(tenant ->{
                            System.out.println("sending");
                            System.out.println(TenantRegister.t.getEmail());
                            System.out.println(tenant.getEmail());
                        }));
                        Intent intent = new Intent(newTenantUnitActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }));
    }
}