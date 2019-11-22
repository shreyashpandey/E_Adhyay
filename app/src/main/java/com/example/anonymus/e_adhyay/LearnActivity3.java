package com.example.anonymus.e_adhyay;


import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.Menu;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class LearnActivity3 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {
    /** Called when the activity is first created. */

    private TextToSpeech tts;
    private ImageButton buttonSpeak;
    ImageSwitcher imageSwitcher;
    TextSwitcher simpleTextSwitcher;
    ImageButton nextButton,prevButton;
    RelativeLayout r1;
    int imageSwitcherImages[] =
            {R.drawable.s18,R.drawable.s19,R.drawable.s20,R.drawable.i2,R.drawable.i3};
    String strings[] = {"Tomato", "Potato","Cabbage","Beat-Root","Onion"};
    int messageCount = strings.length;
    int switcherImageLength = imageSwitcherImages.length;
    int counter = 0;
    int counter1=0;
    //  private EditText editText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity3_learn);

        tts = new TextToSpeech(this, this);
        buttonSpeak = (ImageButton) findViewById(R.id.button1);


        r1=(RelativeLayout)findViewById(R.id.r1);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        nextButton = (ImageButton) findViewById(R.id.button);
        prevButton = (ImageButton) findViewById(R.id.button2);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(imageSwitcherImages[counter]);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });

        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        imageSwitcher.setOutAnimation(aniOut);
        imageSwitcher.setInAnimation(aniIn);
        simpleTextSwitcher = (TextSwitcher) findViewById(R.id.simpleTextSwitcher);
        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(LearnActivity3.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setTextSize(50);


                t.setTextColor(Color.rgb(255,255,255));
                return t;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to TextSwitcher
        simpleTextSwitcher.setInAnimation(in);
        simpleTextSwitcher.setOutAnimation(out);

        //text appear on start

        simpleTextSwitcher.setText(strings[counter]);
        nextButton.setOnClickListener(new View.OnClickListener() {
            /*   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
               @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)*/
            @Override
            public void onClick(View v) {

                counter++;
                if (counter == switcherImageLength) {
                    counter = 0;
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                    simpleTextSwitcher.setText(strings[counter]);
                } else {
                    imageSwitcher.setImageResource(imageSwitcherImages[counter]);
                    simpleTextSwitcher.setText(strings[counter]);
                    //  r1.setBackgroundColor(Color.rgb(200,100,230));
                    // r1.setBackgroundResource();
                    // buttonSpeak.setBackgroundResource();
                }
                buttonSpeak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        speakOut(strings[counter]);
                    }

                });

            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            /*   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
               @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)*/
            @Override
            public void onClick(View v) {

                counter1--;
                if (counter1 == -1) {
                    counter1 = switcherImageLength-1;
                    imageSwitcher.setImageResource(imageSwitcherImages[counter1]);
                    simpleTextSwitcher.setText(strings[counter1]);
                } else {
                    imageSwitcher.setImageResource(imageSwitcherImages[counter1]);
                    simpleTextSwitcher.setText(strings[counter1]);
                    //  r1.setBackgroundColor(Color.rgb(200,100,230));
                    // r1.setBackgroundResource();
                    // buttonSpeak.setBackgroundResource();
                }
                buttonSpeak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        speakOut(strings[counter1]);
                    }

                });

            }
        });

    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } /*else {
               // buttonSpeak.setEnabled(true);
                speakOut();
            }*/

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }
    private void speakOut(String text) {
        //String text = t.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity1_learn, menu);
        return true;
    }
    @Override
    public void onBackPressed(){
        // moveTaskToBack(true);
        super.onBackPressed();
        startActivity(new Intent(LearnActivity3.this, LearnActivity.class));
        finish();
    }

}