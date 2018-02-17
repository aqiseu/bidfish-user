package com.semarmesem.bidfish.bidfishcustomer.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.semarmesem.bidfish.bidfishcustomer.MainActivity;
import com.semarmesem.bidfish.bidfishcustomer.R;

public class SplashscreenActivity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 3500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


         /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashscreenActivity.this, LoginActivity.class);
                SplashscreenActivity.this.startActivity(mainIntent);
                SplashscreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
