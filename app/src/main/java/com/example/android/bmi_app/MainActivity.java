package com.example.android.bmi_app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        Exercises_Notity();




        Button male_btn = (Button)findViewById(R.id.male_btn);
        male_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,MaleActivity.class));
           }
        });

        Button female_btn = (Button)findViewById(R.id.female_btn);
        female_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FemaleActivity.class));
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isFirstStart = getPrefs.getBoolean("firstStart",true);
                if(isFirstStart)
                {
                    startActivity(new Intent(MainActivity.this,Intro_MainActivity.class));
                    SharedPreferences.Editor e = getPrefs.edit();
                    e.putBoolean("firstStart",false);
                    e.apply();
                }
            }
        });
        thread.start();


    }


public void Exercises_Notity(){

    AlarmManager alarmManager1  = (AlarmManager) getSystemService(ALARM_SERVICE);
    Calendar calender1 = Calendar.getInstance();
//       calender.add(Calendar.HOUR_OF_DAY,1);
//        calender.add(Calendar.MINUTE,37);
    calender1.set(Calendar.HOUR_OF_DAY,1);
    calender1.set(Calendar.MINUTE,01);
    calender1.set(Calendar.SECOND,00);

    Intent intent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
    PendingIntent broadcast =PendingIntent.getBroadcast(this,100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    alarmManager1.setExact(AlarmManager.RTC_WAKEUP,calender1.getTimeInMillis(),broadcast);
}


}
