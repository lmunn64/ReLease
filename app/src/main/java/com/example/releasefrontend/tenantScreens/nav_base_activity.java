package com.example.releasefrontend.tenantScreens;
/**
 * @author Luke Munn
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;
import com.google.android.material.navigation.NavigationView;
/**
 * Navigation drawer to be placed over all tenant screens.
 * uses menu.xml file to display the individual navigation drawers
 */
public class nav_base_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ImageView header;
    @Override
    public void setContentView(View view){
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_nav_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        NavigationView navView = findViewById(R.id.nav);
        View headerView =  navView.inflateHeaderView(R.layout.main_drawer_header);
        header = headerView.findViewById(R.id.header);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nav_base_activity.this, TenantFrontPage.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav);
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
        if (id == R.id.nav_rent) {
            Intent intent = new Intent(nav_base_activity.this, RentActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_maintenance) {
            Intent intent = new Intent(nav_base_activity.this, MaintenanceActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_logout) {
            Intent intent = new Intent(nav_base_activity.this, LoginActivity.class);
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
