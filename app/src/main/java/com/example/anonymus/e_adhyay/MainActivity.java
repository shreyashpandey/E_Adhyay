package com.example.anonymus.e_adhyay;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrefManager prefManager = new PrefManager(getApplicationContext());
        if(prefManager.isFirstTimeLaunch()){
            prefManager.setFirstTimeLaunch(false);
            startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            finish();
        }
       /* else if(!prefManager.isFirstTimeLaunch())
        {
            new Handler().postDelayed(new Runnable()
            {
             @Override
             public void run()
             {
                 Intent homeIntent=new Intent(MainActivity.this,SplashActivity.class);
                 startActivity(homeIntent);
                 finish();
             }

            },SPLASH_TIME_OUT);
        }*/
    }
    protected void btn_Click(View view){
        Toast.makeText(MainActivity.this, "clicked on button", Toast.LENGTH_LONG).show();
    }
}