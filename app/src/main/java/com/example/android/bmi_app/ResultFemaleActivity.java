package com.example.android.bmi_app;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultFemaleActivity extends AppCompatActivity {
    public  TextView age,feet,inches,pounds,result_txt,Check_result;

          private static Double Normal_up = 25.0;
          private static Double Normal_Down = 18.0;
         private static Double Obese = 40.0;
    private static Double underweight =14.0;
    private Button btn ,rest_btn,diet1_btn,exercises_btn,statics_btn,cross_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_result_female);



        ImageView under = (ImageView)findViewById(R.id.image_underWeight);
        ImageView Normal = (ImageView)findViewById(R.id.imageNormal);
        ImageView Over = (ImageView)findViewById(R.id.image_overWeight);
        ImageView obes =(ImageView)findViewById(R.id.imageObese);


        age =(TextView)findViewById(R.id.age_txt);
        age.setText(getIntent().getStringExtra("AGE"));

        feet =(TextView)findViewById(R.id.feet_txt);
        feet.setText(getIntent().getStringExtra("FEET"));

        inches =(TextView)findViewById(R.id.inches_txt);
        inches.setText(getIntent().getStringExtra("INCHES"));

        pounds =(TextView)findViewById(R.id.weight_txt);
        pounds.setText(getIntent().getStringExtra("POUND"));
//////////////////////////////////////////////////////////////////////////////////////
        Bundle extras = getIntent().getExtras();


        result_txt =(TextView)findViewById(R.id.Result_txt);
        result_txt.setText(extras.getString("RESULT"));
        String input = result_txt.getText().toString();

        TextView calorieTxt = (TextView)findViewById(R.id.calorie_text);
        calorieTxt.setText((extras.getString("RESULT1")));
        Check_result = (TextView)findViewById(R.id.textView2);

        int value = getIntent().getIntExtra("RESULT",0);
        if((value > Normal_up)&&(value<Normal_Down)){
            Check_result.setText("Normal");
            Normal.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.cursor_move);
            Normal.setAnimation(anim);
        }

        if((value>26 )&& (value<=30)){
            Check_result.setText("over weight");
            Over.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.cursor_move);
            Over.setAnimation(anim);
        }
        if(value<17){
            Check_result.setText("Under weight");
            under.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.cursor_move);
            under.setAnimation(anim);
        }
        if((value>= Obese) && (value<underweight)){
            Check_result.setText("Obese");
            obes.setVisibility(View.VISIBLE);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.cursor_move);
            obes.setAnimation(anim);

        }







////////////////////////////////////////////////////////////////////////////////////////////////


// menu button  Start here////
        btn = (Button)findViewById(R.id.menu_button);
        rest_btn  = (Button)findViewById(R.id.Rest_btn);
        rest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultFemaleActivity.this,MainActivity.class));

            }
        });
        diet1_btn = (Button)findViewById(R.id.Diet_btn);
        diet1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultFemaleActivity.this,DietPlanFemaleActivity.class));
            }
        });

        exercises_btn =(Button)findViewById(R.id.exercises_btn);
        exercises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultFemaleActivity.this,ExercisesActivity.class));
            }
        });
        statics_btn = (Button)findViewById(R.id.Static_btn);
        statics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultFemaleActivity.this,CaloriesActivity.class));
            }
        });

        cross_btn =(Button)findViewById(R.id.cross_btn);


    }






    public void btnClicked(View view) {
        btn.setVisibility(View.INVISIBLE);
        btn.startAnimation(buttonClick);


        rest_btn.setVisibility(View.VISIBLE);
        rest_btn.animate().alpha(1.0f).setDuration(400);

        diet1_btn.setVisibility(View.VISIBLE);
        diet1_btn.animate().alpha(1.0f).setDuration(400);

        exercises_btn.setVisibility(View.VISIBLE);
        exercises_btn.animate().alpha(1.0f).setDuration(400);

        statics_btn.setVisibility(View.VISIBLE);
        statics_btn.animate().alpha(1.0f).setDuration(400);

        cross_btn.setVisibility(View.VISIBLE);
        cross_btn.startAnimation(buttonClick);


    }
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    public void btn2Clicked(View view) {
        btn.setVisibility(View.VISIBLE);
        btn.startAnimation(buttonClick);

        rest_btn.setVisibility(View.INVISIBLE);
        rest_btn.animate().alpha(0.0f).setDuration(400);

        diet1_btn.setVisibility(View.INVISIBLE);
        diet1_btn.animate().alpha(0.0f).setDuration(400);

        exercises_btn.setVisibility(View.INVISIBLE);
        exercises_btn.animate().alpha(0.0f).setDuration(400);

        statics_btn.setVisibility(View.INVISIBLE);
        statics_btn.animate().alpha(0.0f).setDuration(400);

        cross_btn.setVisibility(View.INVISIBLE);
        cross_btn.startAnimation(buttonClick);

    }
    // menu button  End here////


}
