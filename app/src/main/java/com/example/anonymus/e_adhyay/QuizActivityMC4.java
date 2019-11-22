
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

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivityMC4 extends AppCompatActivity {
    Button button;
    // RadioButton genderradioButton;
    // RadioGroup radioGroup;
    TextView t1;
    ProgressBar p;
    int i1;

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
        setContentView(R.layout.activitymc4_quiz);
        //radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        t1 = (TextView) findViewById(R.id.error);
        t1.setVisibility(View.INVISIBLE);
        p = (ProgressBar) findViewById(R.id.splashProgress);

        Intent i = getIntent();

        i1 = i.getIntExtra("S", 0);
        i1 += 1;

        p.setProgress(i1);

    }

    public void aa(View v) {
        ArrayList<Class> activityList = new ArrayList<>();
        //Intent i1=getIntent();
        Bundle extras = getIntent().getExtras();
        activityList = (ArrayList<Class>) extras.get("ACTIVITY_LIST");
        ArrayList<Class> activityList1 = new ArrayList<>();
        //Intent i1=getIntent();
        Bundle extras1 = getIntent().getExtras();
        activityList1 = (ArrayList<Class>) extras1.get("ACTIVITY_LIST1");

        //String fileName = this.getArguments().getString("image");
        // activityList=extras.get(String.valueOf(i1));
          /*  if (activityList.size() == 0) {

            }*/

        // Now, the random number is generated between 1 and however many
        // activities we have remaining
        if (activityList.size() == 0) {
            Intent f = new Intent(QuizActivityMC4.this, QuizFinished.class);
            f.putExtra("ACTIVITY_LIST1", activityList1);
            startActivity(f);
        } else {
            Random generator = new Random();
            int number = generator.nextInt(activityList.size()) + 1;

            Class activity = null;

            // Here, we are checking to see what the output of the random was
            switch (number) {
                case 1:
                    // We will open the first remaining activi  ty of the list
                    activity = activityList.get(0);
                    // We will now remove that activity from the list
                    activityList.remove(0);
                    break;
                case 2:
                    // We will open the second remaining activity of the list
                    activity = activityList.get(1);
                    activityList.remove(1);
                    break;
                case 3:
                    // We will open the third remaining activity of the list
                    activity = activityList.get(2);
                    activityList.remove(2);
                    break;
                default:
                    // We will open the fourth remaining activity of the list
                    activity = activityList.get(3);
                    activityList.remove(3);
                    break;// We will open the fifth remaining activity of the list

            }

            // Note: in the above, we might not have 3 remaining activities, for example,
            // but it doesn't matter because that case wouldn't be called anyway,
            // as we have already decided that the number would be between 1 and the number of
            // activities left.


            // Starting the activity, and passing on the remaining number of activities
            // to the next one that is opened

            Intent intent = new Intent(getBaseContext(), activity);
            intent.putExtra("ACTIVITY_LIST", activityList);
            intent.putExtra("ACTIVITY_LIST1", activityList1);
            intent.putExtra("S", i1);
            startActivity(intent);
        }
    }
    public void e1 (View v){
        t1.setVisibility(View.VISIBLE);
        Zoom();
    }
    public void Zoom ()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        a.reset();

        t1.clearAnimation();
        t1.startAnimation(a);
    }

   /* public void onclickbuttonMethod(View v) {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        genderradioButton = (RadioButton) findViewById(selectedId);
        if (selectedId == -1) {
            Toast.makeText(QuizActivity1.this, "Nothing selected", Toast.LENGTH_SHORT).show();
        } else if (genderradioButton.getId() == R.id.radioMale) {
            Toast.makeText(QuizActivity1.this, genderradioButton.getText(), Toast.LENGTH_SHORT).show();
            // Button myButton = (Button) findViewById(R.id.MY_BUTTON);
            // myButton.setOnClickListener(new View.OnClickListener() {
            // @Override
            // public void onClick(View v) {
            // Here, we are generating a random number
            ArrayList<Class> activityList = new ArrayList<>();
            activityList.add(QuizActivity2.class);
            activityList.add(QuizActivity3.class);
            activityList.add(QuizActivity4.class);
            activityList.add(QuizActivity5.class);


            Random generator = new Random();
            int number = generator.nextInt(5) + 1;

            Class activity = null;

            // Here, we are checking to see what the output of the random was
            switch (number) {
                case 1:
                    activity = QuizActivity2.class;
                    // We are adding the number of the activity to the list
                    activityList.remove(QuizActivity2.class);
                    break;
                case 2:
                    activity = QuizActivity3.class;
                    activityList.remove(QuizActivity3.class);
                    break;
                case 3:
                    activity = QuizActivity4.class;
                    activityList.remove(QuizActivity4.class);
                    break;
                case 4:
                    activity = QuizActivity5.class;
                    activityList.remove(QuizActivity5.class);
                    break;

            }
            int s = 1;
            // We use intents to start activities
            Intent intent = new Intent(getBaseContext(), activity);
            // `intent.putExtra(...)` is used to pass on extra information to the next activity
            intent.putExtra("ACTIVITY_LIST", activityList);
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
   public void onBackPressed(){
       // moveTaskToBack(true);
       // super.onBackPressed();
       d();
       //startActivity(new Intent(LearnActivity.this, HomeActivity.class));
       //  finish();
   }

    public void d()
    {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(QuizActivityMC4.this);
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

