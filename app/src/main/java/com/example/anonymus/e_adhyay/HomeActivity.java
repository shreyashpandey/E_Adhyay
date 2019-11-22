package com.example.anonymus.e_adhyay;


        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.Typeface;
        import android.os.Build;
        import android.os.Bundle;
       // import androidx.appcompat.app.AppCompatActivity;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.Window;
        import android.view.WindowManager;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.webkit.WebView;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageSwitcher;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.Toast;
        import android.widget.ViewSwitcher;

public class HomeActivity extends AppCompatActivity {

    Button bt_click_me;
    Button bt_click_me1,bt_click_me2;
    //ImageSwitcher imageSwitcher;
    //ImageButton nextButton;
    RelativeLayout r1;
   // int imageSwitcherImages[] =
          //  {R.drawable.r1,R.drawable.r2,R.drawable.r3};

    //int switcherImageLength = imageSwitcherImages.length;
    int counter = 0;
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
        setContentView(R.layout.activity_home);
       /*ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);*/
        //Add all your codes here
       // WebView mywebview = (WebView) findViewById(R.id.webView);
        // mywebview.loadUrl("https://www.javatpoint.com/");

       /* String data = "<html><body><h1>Hello, Javatpoint!</h1><img src="s5.gif"</body></html>";
        mywebview.loadData(data, "text/html", "UTF-8");*/
     /*   imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        nextButton = (ImageButton) findViewById(R.id.button);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.r1);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });

        Animation aniOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation aniIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        imageSwitcher.setOutAnimation(aniOut);
        imageSwitcher.setInAnimation(aniIn);

        nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

            counter++;
            if (counter == switcherImageLength) {
                counter = 0;
              //  imageSwitcher.setVisibility(View.INVISIBLE);
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);
            } else {
                imageSwitcher.setImageResource(imageSwitcherImages[counter]);

            }

           }
       });*/
        r1=(RelativeLayout)findViewById(R.id.r1);
        bt_click_me = findViewById(R.id.bt_click_me);
        bt_click_me2 = findViewById(R.id.bt_click_me2);
       // Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/abc.ttf");

       // bt_click_me.setTypeface(custom_font);
        bt_click_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LearnActivity.class));
                finish();
            }
        });
        bt_click_me1 = findViewById(R.id.bt_click_me1);
        bt_click_me1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, QuizActivity.class));
                finish();
            }
        });
        bt_click_me2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Info.class));
                finish();
            }
        });
        //while(true) {
           // mywebview.loadUrl("file:///android_asset/s4.jpg");
            /*mywebview.loadUrl("file:///android_asset/s3");
            mywebview.loadUrl("file:///android_asset/s2");*/
        //}
    //int c=0;


        //Happy coding :)
       // if (c == 1
             //   ) {
            zoom(new View(this));

        //}
       /* else {
            zoomO(new View(this));
        }*/
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void zoom(View view)
    {
        android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.zoom_out);

        bt_click_me.startAnimation(a1);
        bt_click_me1.startAnimation(a1);
        bt_click_me2.startAnimation(a1);
      // a1.setRepeatMode(Animation.INFINITE);
       // c++;
    }

    @Override
    public void onBackPressed(){
       //moveTaskToBack(true);
        super.onBackPressed();
        //d();
        System.exit(0);


    }
   /* public void zoomO(View view)
    {
        android.view.animation.Animation a1= AnimationUtils.loadAnimation (getApplicationContext(),R.anim.zoom_out);
        bt_click_me1.startAnimation(a1);
        a1.setRepeatCount(Animation.INFINITE);
        c--;
    }*/
}