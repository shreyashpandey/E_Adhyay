package com.example.anonymus.e_adhyay;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
// import androidx.appcompat.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class LearnActivity6 extends AppCompatActivity {

    Button bt_click_me,bt_click_me1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity6_learn);
       /* ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);*/
        //Add all your codes here
        // WebView mywebview = (WebView) findViewById(R.id.webView);
        // mywebview.loadUrl("https://www.javatpoint.com/");

       /* String data = "<html><body><h1>Hello, Javatpoint!</h1><img src="s5.gif"</body></html>";
        mywebview.loadData(data, "text/html", "UTF-8");*/
        bt_click_me = findViewById(R.id.bt_click_me);
        bt_click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity6.this, LearnActivity8.class));
                finish();
            }
        });
        bt_click_me1 = findViewById(R.id.bt_click_me1);
        bt_click_me1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnActivity6.this, LearnActivity9.class));
                finish();
            }
        });

        android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.z1);
        android.view.animation.Animation a2= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.z2);

        bt_click_me.startAnimation(a1);
        bt_click_me1.startAnimation(a2);

        //while(true) {
        // mywebview.loadUrl("file:///android_asset/s4.jpg");
            /*mywebview.loadUrl("file:///android_asset/s3");
            mywebview.loadUrl("file:///android_asset/s2");*/
        //}



        //Happy coding :)

    }

    @Override
    public void onBackPressed(){
        // moveTaskToBack(true);
        // super.onBackPressed();
        d();
        //startActivity(new Intent(LearnActivity.this, HomeActivity.class));
        //  finish();
    }

    public void d()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(LearnActivity6.this);
        builder1.setMessage("Are you sure you want to leave this page ?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(LearnActivity6.this, LearnActivity.class));
                        finish();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}