package com.example.anonymus.e_adhyay;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
// import androidx.appcompat.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Button bt_click_me,bt_click_me1,bt_click_me2;

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
        setContentView(R.layout.activity_quiz);
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
              /* startActivity(new Intent(QuizActivity.this, QuizActivity1.class));
              finish();*/
               ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(QuizActivity1.class);
                activityList.add(QuizActivityA1.class);
                activityList.add(QuizActivityA2.class);
                activityList.add(QuizActivityA3.class);
                activityList.add(QuizActivityA4.class);
              /*  activityList.add(QuizActivity3.class);
                activityList.add(QuizActivity4.class);
                activityList.add(QuizActivity5.class);*/
                Random generator = new Random();
                int number = generator.nextInt(2) + 1;

                Class activity = null;

                // Here, we are checking to see what the output of the random was
                switch (number) {
                    case 1:
                        activity = QuizActivity1.class;
                        // We are adding the number of the activity to the list
                        activityList.remove(QuizActivity1.class);
                        break;
                    case 2:
                        activity = QuizActivityA1.class;
                        activityList.remove(QuizActivityA1.class);
                        break;
                    case 3:
                        activity = QuizActivityA2.class;
                        activityList.remove(QuizActivityA2.class);
                        break;
                    case 4:
                        activity = QuizActivityA3.class;
                        activityList.remove(QuizActivityA3.class);
                        break;
                 /*   case 3:
                        activity = QuizActivity4.class;
                        activityList.remove(QuizActivity4.class);
                        break;
                    case 4:
                        activity = QuizActivity5.class;
                        activityList.remove(QuizActivity5.class);
                        break;*/
                    default:
                        activity = QuizActivityA4.class;
                        activityList.remove(QuizActivityA4.class);
                        break;

                }
              //  int s = 1;
                // We use intents to start activities
                Intent intent = new Intent(getBaseContext(), activity);
                // `intent.putExtra(...)` is used to pass on extra information to the next activity
                intent.putExtra("ACTIVITY_LIST1", activityList);
                //intent.putExtra("S", s);
                startActivity(intent);
            }
        });
        bt_click_me1 = findViewById(R.id.bt_click_me1);
        bt_click_me1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(QuizActivity.this, QuizActivity1.class));
                finish();*/
                ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(QuizActivityM1.class);
                activityList.add(QuizActivityMA1.class);
                activityList.add(QuizActivityMA2.class);
                activityList.add(QuizActivityMA3.class);
                activityList.add(QuizActivityMA4.class);
              /*  activityList.add(QuizActivity3.class);
                activityList.add(QuizActivity4.class);
                activityList.add(QuizActivity5.class);*/
                Random generator = new Random();
                int number = generator.nextInt(2) + 1;

                Class activity = null;

                // Here, we are checking to see what the output of the random was
                switch (number) {
                    case 1:
                        activity = QuizActivityM1.class;
                        // We are adding the number of the activity to the list
                        activityList.remove(QuizActivityM1.class);
                        break;
                    case 2:
                        activity = QuizActivityMA1.class;
                        activityList.remove(QuizActivityMA1.class);
                        break;
                    case 3:
                        activity = QuizActivityMA2.class;
                        activityList.remove(QuizActivityMA2.class);
                        break;
                    case 4:
                        activity = QuizActivityMA3.class;
                        activityList.remove(QuizActivityMA3.class);
                        break;
                 /*   case 3:
                        activity = QuizActivity4.class;
                        activityList.remove(QuizActivity4.class);
                        break;
                    case 4:
                        activity = QuizActivity5.class;
                        activityList.remove(QuizActivity5.class);
                        break;*/
                    default:
                        activity = QuizActivityMA4.class;
                        activityList.remove(QuizActivityMA4.class);
                        break;

                }
                //  int s = 1;
                // We use intents to start activities
                Intent intent = new Intent(getBaseContext(), activity);
                // `intent.putExtra(...)` is used to pass on extra information to the next activity
                intent.putExtra("ACTIVITY_LIST1", activityList);
                //intent.putExtra("S", s);
                startActivity(intent);
            }
        });
        bt_click_me2 = findViewById(R.id.bt_click_me2);
        bt_click_me2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(QuizActivity.this, QuizActivity1.class));
                finish();*/
                ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(QuizActivityH1.class);
                activityList.add(QuizActivityHA1.class);
                activityList.add(QuizActivityHA2.class);
                activityList.add(QuizActivityHA3.class);
                activityList.add(QuizActivityHA4.class);
              /*  activityList.add(QuizActivity3.class);
                activityList.add(QuizActivity4.class);
                activityList.add(QuizActivity5.class);*/
                Random generator = new Random();
                int number = generator.nextInt(2) + 1;

                Class activity = null;

                // Here, we are checking to see what the output of the random was
                switch (number) {
                    case 1:
                        activity = QuizActivityH1.class;
                        // We are adding the number of the activity to the list
                        activityList.remove(QuizActivityH1.class);
                        break;
                    case 2:
                        activity = QuizActivityHA1.class;
                        activityList.remove(QuizActivityHA1.class);
                        break;
                    case 3:
                        activity = QuizActivityHA2.class;
                        activityList.remove(QuizActivityHA2.class);
                        break;
                    case 4:
                        activity = QuizActivityHA3.class;
                        activityList.remove(QuizActivityHA3.class);
                        break;
                 /*   case 3:
                        activity = QuizActivity4.class;
                        activityList.remove(QuizActivity4.class);
                        break;
                    case 4:
                        activity = QuizActivity5.class;
                        activityList.remove(QuizActivity5.class);
                        break;*/
                    default:
                        activity = QuizActivityHA4.class;
                        activityList.remove(QuizActivityHA4.class);
                        break;

                }
                //  int s = 1;
                // We use intents to start activities
                Intent intent = new Intent(getBaseContext(), activity);
                // `intent.putExtra(...)` is used to pass on extra information to the next activity
                intent.putExtra("ACTIVITY_LIST1", activityList);
                //intent.putExtra("S", s);
                startActivity(intent);
            }
        });


        android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.zoom_out);
        bt_click_me.startAnimation(a1);
        bt_click_me1.startAnimation(a1);
        bt_click_me2.startAnimation(a1);


    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
         super.onBackPressed();

        startActivity(new Intent(QuizActivity.this, HomeActivity.class));
         finish();
    }
}