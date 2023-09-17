package com.example.releasefrontend.tenantScreens;
/**
 * @author Luke Munn
 */


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import com.example.releasefrontend.LoginActivity;
import com.example.releasefrontend.R;
import com.example.releasefrontend.databinding.ActivityTenantFrontPageBinding;
import com.example.releasefrontend.tenantScreens.nav_base_activity;

/**
 * Main splashscreen for a logged in tenant, allowing to see
 * and post to the building community.
 */
public class TenantFrontPage extends nav_base_activity {

    Button b1, b2;
    EditText e1, e2;
    TextView t1;

    ActivityTenantFrontPageBinding activityTenantFrontPageBinding;
    private WebSocketClient cc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTenantFrontPageBinding = ActivityTenantFrontPageBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Front Page");
        setContentView(activityTenantFrontPageBinding.getRoot());
        allocateActivityTitle("Dashboard");
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        e2 = (EditText) findViewById(R.id.et2);
        t1 = (TextView) findViewById(R.id.tx1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Draft[] drafts = {
                        new Draft_6455()
                };

                /**
                 * If running this on an android device, make sure it is on the same network as your
                 * computer, and change the ip address to that of your computer.
                 * If running on the emulator, you can use localhost.
                 */
                String w = "ws://coms-309-018.class.las.iastate.edu:8080/websocket/" + LoginActivity.mainTenant.getEmail();

                try {
                    Log.d("Socket:", "Trying socket");
                    cc = new WebSocketClient(new URI(w), (Draft) drafts[0]) {
                        @Override
                        public void onMessage(String message) {
                            Log.d("", "run() returned: " + message);
                            String s = t1.getText().toString();
                            t1.setText(s + "\nServer:" + message);
                        }

                        @Override
                        public void onOpen(ServerHandshake handshake) {
                            Log.d("OPEN", "run() returned: " + "is connecting");
                        }

                        @Override
                        public void onClose(int code, String reason, boolean remote) {
                            Log.d("CLOSE", "onClose() returned: " + reason);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("Exception:", e.toString());
                        }
                    };
                } catch (URISyntaxException e) {
                    Log.d("Exception:", e.getMessage().toString());
                    e.printStackTrace();
                }
                cc.connect();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    cc.send(e2.getText().toString());
                } catch (Exception e) {
                    Log.d("ExceptionSendMessage:", e.getMessage().toString());
                }
            }
        });



    }
}
