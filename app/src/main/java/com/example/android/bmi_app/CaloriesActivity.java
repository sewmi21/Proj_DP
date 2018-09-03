package com.example.android.bmi_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class
CaloriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        Button cal_btn =(Button)findViewById(R.id.calorie_image_btn);
        Button cal_stat_btn =(Button)findViewById(R.id.calorie_stat_btn);

        cal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaloriesActivity.this,CalorieslDataActivity.class));
            }
        });


        cal_stat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CaloriesActivity.this,WeightDataActivity.class));
            }
        });

    }
}
