package com.example.android.bmi_app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView tv1 = (TextView) findViewById(R.id.text1);
        TextView tv2 = (TextView) findViewById(R.id.text2);
        ImageView imageView = (ImageView) findViewById(R.id.splash_img);
        ProgressBar progressBar =(ProgressBar)findViewById(R.id.progressBar);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        Animation animation_zoom = AnimationUtils.loadAnimation(this,R.anim.zoom_in);
        tv1.startAnimation(animation);
        tv2.startAnimation(animation);
        imageView.startAnimation(animation_zoom);





      final  Intent i  = new Intent(this,MainActivity.class);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             finally {
                    startActivity(i);
                    finish();
                }

            }
        });
        thread.start();

    }

}
