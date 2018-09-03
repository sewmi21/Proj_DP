package com.example.android.bmi_app;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


import java.util.Calendar;

public class DietPlanFemaleActivity extends AppCompatActivity {

    private Button btn ,rest_btn,diet_btn,exercises_btn,statics_btn,cross_btn,viewpage,dieabticsBtn,CholestroleBtn,GastritisBtn,DiechoBtn,CholGasBtn,GasDieaBtn,DiGaChoBtn,PregnantBtn,checkBtn,extraMealBtn;
    private CheckBox diabetic,cholestrol,gastritis,pregnant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_female);
        MenuButtons();


        extraMealBtn = (Button)findViewById(R.id.extra_meal_btn);
        extraMealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,ExtraMealActivity.class));
            }
        });













        Meal_notify();
        dieabticsBtn = (Button)findViewById(R.id.diabetics);
        dieabticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DDietResultActivity.class));
            }
        });

        CholestroleBtn = (Button)findViewById(R.id.Cholesterol);
        CholestroleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DietResultActivity.class));
            }
        });

        GastritisBtn = (Button)findViewById(R.id.gastritis_btn);
        GastritisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,GDietResultActivity.class));
            }
        });

        DiechoBtn =(Button)findViewById(R.id.diea_cho_btn);
        DiechoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DCDietResultActivity.class));
            }
        });

        CholGasBtn = (Button)findViewById(R.id.Chol_Gas_Btn);
        CholGasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(DietPlanFemaleActivity.this,CGDietResultActivity.class));
            }
        });

        GasDieaBtn = (Button)findViewById(R.id.Gas_diea_btn);
        GasDieaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DGDietResultActivity.class));
            }
        });

        DiGaChoBtn = (Button)findViewById(R.id.Di_Ga_Cho_btn);
        DiGaChoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DCGDietResultActivity.class));
            }
        });
        PregnantBtn=(Button)findViewById(R.id.pregnant_btn);
        PregnantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(DietPlanFemaleActivity.this,PDietResultActivity.class));
            }
        });


        checkBtn = (Button)findViewById(R.id.checkBtn);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cholestrol =(CheckBox)findViewById(R.id.Cholesterol_checkBox);
                gastritis = (CheckBox)findViewById(R.id.gastritis_checkBox);
                diabetic = (CheckBox)findViewById(R.id.diabetics_checkBox);
                pregnant =(CheckBox)findViewById(R.id.pregnant_checkBox);

                pregnant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        diabetic.setChecked(false);
                        gastritis.setChecked(false);
                        cholestrol.setChecked(false);
                        pregnant.setChecked(b);
                    }
                });


                if((cholestrol.isChecked())&& (!gastritis.isChecked())&& (!diabetic.isChecked())&&(!pregnant.isChecked())){
                    CholestroleBtn.setVisibility(View.VISIBLE);
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);

                }
                else if((diabetic.isChecked())&&(!gastritis.isChecked())&&(!cholestrol.isChecked())&&(!pregnant.isChecked())){
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    dieabticsBtn.setVisibility(View.VISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);


                }
                else if((gastritis.isChecked())&&(!diabetic.isChecked())&&(!cholestrol.isChecked())&&(!pregnant.isChecked())){
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.VISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);
                }

                else if((cholestrol.isChecked())&& (gastritis.isChecked())&& (!diabetic.isChecked())&&(!pregnant.isChecked())){
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.VISIBLE);

                }
                else if ((gastritis.isChecked())&&(diabetic.isChecked())&&(!cholestrol.isChecked())&&(!pregnant.isChecked())){
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.VISIBLE);
                }
                else if((diabetic.isChecked())&&(cholestrol.isChecked())&& (!gastritis.isChecked())&&(!pregnant.isChecked())){
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.VISIBLE);

                }
                else if((diabetic.isChecked())&&(cholestrol.isChecked())&& (gastritis.isChecked())&&(!pregnant.isChecked())){
                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.VISIBLE);
                }
                else if((pregnant.isChecked())&&(!cholestrol.isChecked())&& (!gastritis.isChecked())&& (!diabetic.isChecked())){

                    dieabticsBtn.setVisibility(View.INVISIBLE);
                    CholestroleBtn.setVisibility(View.INVISIBLE);
                    GastritisBtn.setVisibility(View.INVISIBLE);
                    CholGasBtn.setVisibility(View.INVISIBLE);
                    GasDieaBtn.setVisibility(View.INVISIBLE);
                    DiechoBtn.setVisibility(View.INVISIBLE);
                    DiGaChoBtn.setVisibility(View.INVISIBLE);
                    PregnantBtn.setVisibility(View.VISIBLE);

                }
            }
        });



    }







    public void MenuButtons(){

        btn = (Button)findViewById(R.id.menu_button);
        rest_btn  = (Button)findViewById(R.id.Rest_btn);
        rest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DietPlanFemaleActivity.this,MainActivity.class));
            }
        });

        diet_btn = (Button)findViewById(R.id.Diet_btn);
        diet_btn.setEnabled(false);
        diet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,DietPlanFemaleActivity.class));
            }
        });

        exercises_btn =(Button)findViewById(R.id.exercises_btn);

        exercises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,ExercisesActivity.class));

            }
        });
        statics_btn = (Button)findViewById(R.id.Static_btn);
        statics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DietPlanFemaleActivity.this,CaloriesActivity.class));
            }
        });
        cross_btn =(Button)findViewById(R.id.cross_btn);


    }


    public void btnClicked(View view) {

        checkBtn.setVisibility(View.INVISIBLE);
         extraMealBtn.setVisibility(View.INVISIBLE);

        btn.setVisibility(View.INVISIBLE);
        btn.startAnimation(buttonClick);


        rest_btn.setVisibility(View.VISIBLE);
        rest_btn.animate().alpha(1.0f).setDuration(400);

        diet_btn.setVisibility(View.VISIBLE);
        diet_btn.animate().alpha(1.0f).setDuration(400);


        exercises_btn.setVisibility(View.VISIBLE);
        exercises_btn.animate().alpha(1.0f).setDuration(400);


        statics_btn.setVisibility(View.VISIBLE);
        statics_btn.animate().alpha(1.0f).setDuration(400);

        cross_btn.setVisibility(View.VISIBLE);
        cross_btn.startAnimation(buttonClick);




    }
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    public void btn2Clicked(View view) {


        checkBtn.setVisibility(View.VISIBLE);
        extraMealBtn.setVisibility(View.VISIBLE);

        btn.setVisibility(View.VISIBLE);
        btn.startAnimation(buttonClick);

        rest_btn.setVisibility(View.INVISIBLE);
        rest_btn.animate().alpha(0.0f).setDuration(400);

        diet_btn.setVisibility(View.INVISIBLE);
        diet_btn.animate().alpha(0.0f).setDuration(400);

        exercises_btn.setVisibility(View.INVISIBLE);
        exercises_btn.animate().alpha(0.0f).setDuration(400);

        statics_btn.setVisibility(View.INVISIBLE);
        statics_btn.animate().alpha(0.0f).setDuration(400);

        cross_btn.setVisibility(View.INVISIBLE);
        cross_btn.startAnimation(buttonClick);



    }

























    public void Meal_notify(){

        AlarmManager alarmManager  = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calender = Calendar.getInstance();
//       calender.add(Calendar.HOUR_OF_DAY,1);
//        calender.add(Calendar.MINUTE,37);
        calender.set(Calendar.HOUR_OF_DAY,1);
        calender.set(Calendar.MINUTE,01);
        calender.set(Calendar.SECOND,00);

        Intent intent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
        PendingIntent broadcast =PendingIntent.getBroadcast(this,200,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),broadcast);
    }



}

