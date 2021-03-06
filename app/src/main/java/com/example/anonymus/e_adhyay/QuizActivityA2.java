package com.example.anonymus.e_adhyay;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivityA2 extends AppCompatActivity {
    Button button;
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    TextView t1;

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
        setContentView(R.layout.activitya2_quiz);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        t1 = (TextView) findViewById(R.id.error);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    public void onclickbuttonMethod(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        genderradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            Toast.makeText(QuizActivityA2.this, "Nothing selected", Toast.LENGTH_SHORT).show();
        } else if (genderradioButton.getId() == R.id.radioMale) {
            Toast.makeText(QuizActivityA2.this, genderradioButton.getText(), Toast.LENGTH_SHORT).show();
            // Button myButton = (Button) findViewById(R.id.MY_BUTTON);
            // myButton.setOnClickListener(new View.OnClickListener() {
            // @Override
            // public void onClick(View v) {
            // Here, we are generating a random number

            ArrayList<Class> activityList1 = new ArrayList<>();
            //Intent i1=getIntent();
            Bundle extras = getIntent().getExtras();
            activityList1 = (ArrayList<Class>) extras.get("ACTIVITY_LIST1");
            ArrayList<Class> activityList = new ArrayList<>();
            activityList.add(QuizActivityB2.class);
            activityList.add(QuizActivityC2.class);
            activityList.add(QuizActivityD2.class);
            activityList.add(QuizActivityE2.class);


            Random generator = new Random();
            int number = generator.nextInt(5) + 1;

            Class activity = null;

            // Here, we are checking to see what the output of the random was
            switch (number) {
                case 1:
                    activity = QuizActivityB2.class;
                    // We are adding the number of the activity to the list
                    activityList.remove(QuizActivityB2.class);
                    break;
                case 2:
                    activity = QuizActivityC2.class;
                    activityList.remove(QuizActivityC2.class);
                    break;
                case 3:
                    activity = QuizActivityD2.class;
                    activityList.remove(QuizActivityD2.class);
                    break;
                default:
                    activity = QuizActivityE2.class;
                    activityList.remove(QuizActivityE2.class);
                    break;
               /* default:
                    activity=QuizActivity1.class;
                    activityList.remove(QuizActivity1.class);
                    break;*/

            }
            int s = 1;
            // We use intents to start activities
            Intent intent = new Intent(getBaseContext(), activity);
            // `intent.putExtra(...)` is used to pass on extra information to the next activity
            intent.putExtra("ACTIVITY_LIST", activityList);
            intent.putExtra("ACTIVITY_LIST1", activityList1);
            intent.putExtra("S", s);
            startActivity(intent);

        } else {
            t1.setVisibility(View.VISIBLE);
            Zoom();

        }
    }
    //zoom(new View(this));
    //
    //
    public  void Zoom()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        a.reset();

        t1.clearAnimation();
        t1.startAnimation(a);
    }
    /*  public void zoom(View view)
      {
          android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.zoom_out);
          button.startAnimation(a1);
          a1.setRepeatMode(Animation.INFINITE);
          // c++;
      }*/
      /*  radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {


            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radio0:
                        // do operations specific to this selection
                        break;
                    case R.id.radio1:
                        // do operations specific to this selection
                        break;
                    case R.id.radio2:
                        // do operations specific to this selection
                        break;
                }
            }
        });*/
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
        AlertDialog.Builder builder1 = new AlertDialog.Builder(QuizActivityA2.this);
        builder1.setMessage("Are you sure you want to leave this page ?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
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






