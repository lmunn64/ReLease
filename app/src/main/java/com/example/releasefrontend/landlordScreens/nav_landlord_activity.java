package com.example.releasefrontend.landlordScreens;
/**
 * @author Luke Munn
 */

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.releasefrontend.LandlordRegister;
import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;
import com.example.releasefrontend.tenantScreens.MaintenanceActivity;
import com.example.releasefrontend.tenantScreens.TenantFrontPage;
import com.google.android.material.navigation.NavigationView;

/**
 * Navigation drawer to be placed over all landlord screens.
 */
public class nav_landlord_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ImageView header;
    @Override
    public void setContentView(View view){
        //inflate and set navigation drawers and content view
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_landlord_nav, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);
        NavigationView navView = findViewById(R.id.navLandlord);
        View headerView =  navView.inflateHeaderView(R.layout.main_drawer_header);
        header = headerView.findViewById(R.id.header);

        header.setOnClickListener(new View.OnClickListener() {
            //set click listener so if user clicks the top header it will return to the main screen
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nav_landlord_activity.this, LandlordHomePageActivity.class);
                startActivity(intent);
            }
        });
        //set actionbar toggle for user to open the navigation drawer on a click
        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navLandlord);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_manage) { //If user clicks on property management menu item send to property management activity
            Intent intent = new Intent(nav_landlord_activity.this, PropertyManagementActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_maintenance) {//If user clicks on maintenance menu item send to maintenance activity
            Intent intent = new Intent(nav_landlord_activity.this, MaintenanceLandlordActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_logout) { //If user clicks on maintenance menu item send to login activity
            Intent intent = new Intent(nav_landlord_activity.this, LoginActivity.class);
            startActivity(intent);
        }
        return true;
    }

    protected void allocateActivityTitle(String titleString){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }
}
