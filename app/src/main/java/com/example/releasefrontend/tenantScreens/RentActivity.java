package com.example.releasefrontend.tenantScreens;
/**
 * @author Luke Munn
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.releasefrontend.R;
import com.example.releasefrontend.databinding.ActivityRentBinding;
/**
 * Main splashscreen for the given tenants rent. This screen
 * allows tenants to pay their rent as well as see previous
 * payments, and due dates.
 */
public class RentActivity extends nav_base_activity {

    ActivityRentBinding activityRentBinding;

    String rent;
    @SuppressLint("ClickableViewAccessibility")

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityRentBinding  = ActivityRentBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Maintenance");
        setContentView(activityRentBinding .getRoot());
        allocateActivityTitle("Rent");
//        ApiClientFactory.GetRentApi().GetRentByUnit(LoginActivity.mainTenant.getUnit().getId()).enqueue(new SlimCallback<Rent>(rent ->{
//            this.rent = String.valueOf(rent.getBill()) + ".00";
//        }));

        //static rent amount due to death of MySQL database under Iowa States network
        rent = "400.00";
        SpannableString ss1 = new SpannableString(rent);
        ss1.setSpan(new RelativeSizeSpan(2f), 0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView payRent = findViewById(R.id.payRent);
        TextView rent = findViewById(R.id.value2);
        TextView sign = findViewById(R.id.value);
        rent.setText(ss1);
        //awesome basic scrollview implementation
//        TextView text1 = new TextView(this);
//        text1.setText("Teehee");
//        LinearLayout layout = findViewById(R.id.scrollLayout);
//        text1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        layout.addView(text1);
        payRent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                RentActivity.super.onTouchEvent(event);
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        payRent.setBackgroundResource(R.drawable.clicked_border);

                        return true;
                    case MotionEvent.ACTION_UP:
                        payRent.setBackgroundResource(R.drawable.border);
                        Toast.makeText(RentActivity.this, "Paid Rent!", Toast.LENGTH_SHORT).show();
                        String s = "0.00";
                        SpannableString ss1 = new SpannableString(s);
                        ss1.setSpan(new RelativeSizeSpan(2f), 0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        sign.setGravity(Gravity.RIGHT);
                        rent.setText(ss1);
                        return true;

                }
                return false;
            }
        });

    }
}
