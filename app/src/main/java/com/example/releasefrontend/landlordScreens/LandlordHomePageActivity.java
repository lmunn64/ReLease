package com.example.releasefrontend.landlordScreens;

/**
 * @author Luke Munn
 */

import android.os.Bundle;
import android.view.View;
/**
 * @author Luke Munn
 */

import com.example.releasefrontend.databinding.ActivityLandlordHomePageBinding;


/**
 * Main splashscreen for a logged in landlord, allowing to see
 * and post announcements and posts to the building community
 */
public class LandlordHomePageActivity extends nav_landlord_activity {

    ActivityLandlordHomePageBinding activityLandlordHomePageBinding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLandlordHomePageBinding = ActivityLandlordHomePageBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Front Page");
        setContentView(activityLandlordHomePageBinding.getRoot());
        allocateActivityTitle("Dashboard");
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}

