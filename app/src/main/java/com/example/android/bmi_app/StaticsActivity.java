package com.example.android.bmi_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class StaticsActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    MyHelper  myHelper;
    Button button,next , btn ,rest_btn,diet_btn,exercises_btn,statics_btn,cross_btn;
    GraphView graph;



    BarGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics);
        next =(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaticsActivity.this,UserEnterStaticsActivity.class));
            }
        });
       button =(Button)findViewById(R.id.adding_btn);
        myHelper = new MyHelper(this);

         graph = (GraphView) findViewById(R.id.graph);

       sqLiteDatabase = myHelper.getWritableDatabase();
        exqButton();


        /////////////////menu Button///////////////////////////////
        btn = (Button)findViewById(R.id.menu_button);
        rest_btn  = (Button)findViewById(R.id.Rest_btn);
        rest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(StaticsActivity.this,MainActivity.class));
            }
        });

        diet_btn = (Button)findViewById(R.id.Diet_btn);

        diet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaticsActivity.this,DietPlanActivity.class));
            }
        });

        exercises_btn =(Button)findViewById(R.id.exercises_btn);

        exercises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaticsActivity.this,ExercisesActivity.class));

            }
        });
        statics_btn = (Button)findViewById(R.id.Static_btn);
        statics_btn.setEnabled(false);
        statics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaticsActivity.this,CaloriesActivity.class));
            }
        });
        cross_btn =(Button)findViewById(R.id.cross_btn);



        ////////////////////////////////////////////////////////////



    }

    private void exqButton() {
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                series = new BarGraphSeries<DataPoint>(getData());
                 graph.addSeries(series);
                 series.setSpacing(5);
                 series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                     @Override
                     public int get(DataPoint dataPoint) {
                          if (dataPoint.getX() <= 100){
                             return Color.BLUE;
                         } if(dataPoint.getX()>=250){
                              return Color.RED;
                          }

                        else return Color.GREEN;
                     }

                 });



             }
         });

    }

    private DataPoint[] getData() {
        String[] columns = {"Age","Feet","Inches","Pounds"};
        Cursor cursor = sqLiteDatabase.query("MaleTable",columns,null,null,null,null,null);

        DataPoint[] dp = new DataPoint[cursor.getCount()];




        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getInt(1),cursor.getInt(3));
        }
        return dp;
    }



    public void btnClicked(View view) {




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


}
