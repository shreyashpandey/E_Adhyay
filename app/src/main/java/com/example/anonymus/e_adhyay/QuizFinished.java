package com.example.anonymus.e_adhyay;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizFinished extends AppCompatActivity {

    int i1;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_quiz);
        bt=(Button)findViewById(R.id.bt3);
        android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.zoom_out);
        bt.startAnimation(a1);
        a1.setRepeatMode(Animation.INFINITE);

    }
    public void onclickbuttonMethod(View v){
       // int selectedId = radioGroup.getCheckedRadioButtonId();


        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        }
    public void onclickbuttonMethod1(View v) {
        // int selectedId = radioGroup.getCheckedRadioButtonId();


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
        if (activityList1.size() == 0) {
            Intent f = new Intent(QuizFinished.this, QuizActivity.class);
            //f.putExtra("ACTIVITY_LIST1", activityList1);
            startActivity(f);
        } else {
            Random generator = new Random();
            int number = generator.nextInt(activityList1.size()) + 1;

            Class activity = null;

            // Here, we are checking to see what the output of the random was
            switch (number) {
                case 1:
                    // We will open the first remaining activi  ty of the list
                    activity = activityList1.get(0);
                    // We will now remove that activity from the list
                    activityList1.remove(0);
                    break;
                case 2:
                    // We will open the second remaining activity of the list
                    activity = activityList1.get(1);
                    activityList1.remove(1);
                    break;
                default:
                    // We will open the third remaining activity of the list
                    activity = activityList1.get(2);
                    activityList1.remove(2);
                    break;


            }

            // Note: in the above, we might not have 3 remaining activities, for example,
            // but it doesn't matter because that case wouldn't be called anyway,
            // as we have already decided that the number would be between 1 and the number of
            // activities left.


            // Starting the activity, and passing on the remaining number of activities
            // to the next one that is opened

            Intent intent = new Intent(getBaseContext(), activity);

            intent.putExtra("ACTIVITY_LIST1", activityList1);

            startActivity(intent);
        }
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
        AlertDialog.Builder builder1 = new AlertDialog.Builder(QuizFinished.this);
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
