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

public class LearnActivity11 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {
    /** Called when the activity is first created. */

    private TextToSpeech tts;
    private ImageButton buttonSpeak;
    TextSwitcher textSwitcher1;
    TextSwitcher simpleTextSwitcher;
    ImageButton nextButton,prevButton;
    RelativeLayout r1;
    String imageSwitcherImages[] =
            {"5+6","8*2","9/3","8-1","7*4","6/2","4*3","15%5","8*7","35/7","11+12","8+2","5-4","6+3","9*5","31*4","22*7","102+31","55/5*7","7+5%2"};
    String strings[] = {"11","16","3","7","28","3","12","0","56","5","23","10","1","9","45","124","154","133","77","10"};
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
        setContentView(R.layout.activity11_learn);

        tts = new TextToSpeech(this, this);
        buttonSpeak = (ImageButton) findViewById(R.id.button1);


        r1=(RelativeLayout)findViewById(R.id.r1);
        textSwitcher1 = (TextSwitcher) findViewById(R.id.textSwitcher1);
        nextButton = (ImageButton) findViewById(R.id.button);
        prevButton = (ImageButton) findViewById(R.id.button2);
        textSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(LearnActivity11.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setTextSize(80);


                t.setTextColor(Color.rgb(255,255,255));
                return t;
            }
        });

        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        textSwitcher1.setOutAnimation(aniOut);
        textSwitcher1.setInAnimation(aniIn);
        textSwitcher1.setText(imageSwitcherImages[counter]);
        simpleTextSwitcher = (TextSwitcher) findViewById(R.id.simpleTextSwitcher);
        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(LearnActivity11.this);
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
                    textSwitcher1.setText(imageSwitcherImages[counter]);
                    simpleTextSwitcher.setText(strings[counter]);
                } else {
                    textSwitcher1.setText(imageSwitcherImages[counter]);
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
                    textSwitcher1.setText(imageSwitcherImages[counter1]);
                    simpleTextSwitcher.setText(strings[counter1]);
                } else {
                    textSwitcher1.setText(imageSwitcherImages[counter1]);
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
        startActivity(new Intent(LearnActivity11.this, LearnActivity.class));
        finish();
    }

}