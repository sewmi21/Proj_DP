package com.example.android.bmi_app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import data.DatabaseHandler;
import model.MyExercise;


public class ExercisesActivity extends AppCompatActivity {
       private DatabaseHandler dba;
       private ArrayList<MyExercise> dbExercise = new ArrayList<>();
       private ExerciseAdapter exerciseAdapter;
       private ListView listView;
       private Button btn;
    private Button btn1 ,rest_btn,diet_btn,exercises_btn,statics_btn,cross_btn;
/*
    HOME PLUS ICON AND SUB ICONS
 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        listView = (ListView)findViewById(R.id.list);
        btn =(Button)findViewById(R.id.plus_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this,Pop.class));
            }
        });


        btn1 = (Button)findViewById(R.id.menu_button);
        rest_btn  = (Button)findViewById(R.id.Rest_btn);
        rest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(ExercisesActivity.this,MainActivity.class));
            }
        });


        diet_btn = (Button)findViewById(R.id.Diet_btn);

        diet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this,DietPlanActivity.class));
            }
        });

        exercises_btn =(Button)findViewById(R.id.exercises_btn);
        exercises_btn.setEnabled(false);
        exercises_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this,ExercisesActivity.class));

            }
        });


        statics_btn = (Button)findViewById(R.id.Static_btn);
        statics_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExercisesActivity.this,CaloriesActivity.class));
            }
        });
        cross_btn =(Button)findViewById(R.id.cross_btn);

        refreshData();






    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public void btnClicked(View view) {




        btn1.setVisibility(View.INVISIBLE);
        btn1.startAnimation(buttonClick);

        btn.setVisibility(View.INVISIBLE);

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




        btn1.setVisibility(View.VISIBLE);
        btn1.startAnimation(buttonClick);
        btn.setVisibility(View.VISIBLE);

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

    /////////////////////////////////////////////////////////////////////////////////////////////////

    private void refreshData() {
        dbExercise.clear();
        dba = new DatabaseHandler(getApplicationContext());
      ArrayList<MyExercise> exerciseFromDB = dba.getExerciseList();
        for(int i = 0; i<exerciseFromDB.size(); i++){
            String title = exerciseFromDB.get(i).getTitle();
            String minText = exerciseFromDB.get(i).getMinutes();
            String timeText = exerciseFromDB.get(i).getTimes();
            String meterText = exerciseFromDB.get(i).getMeters();
            String caloriesText = exerciseFromDB.get(i).getCalories();
            String dateText = exerciseFromDB.get(i).getRecorddate();

            int mid = exerciseFromDB.get(i).getItemId();

            MyExercise myexercise = new MyExercise();
            myexercise.setTitle(title);
            myexercise.setMinutes(minText);
            myexercise.setTimes(timeText);
            myexercise.setMeters(meterText);
            myexercise.setCalories(caloriesText);
            myexercise.setRecorddate(dateText);
            myexercise.setItemId(mid);

            dbExercise.add(myexercise);
        }
        dba.close();
        exerciseAdapter = new ExerciseAdapter(ExercisesActivity.this,R.layout.exercise_row , dbExercise);
        listView.setAdapter(exerciseAdapter);
        exerciseAdapter.notifyDataSetChanged();

    }

    public class ExerciseAdapter extends ArrayAdapter<MyExercise>{

        Activity activity;
        int layoutResource;
        MyExercise exercise;
        ArrayList<MyExercise> mdata = new ArrayList<>();

        public ExerciseAdapter(Activity act , int resource,ArrayList<MyExercise> data) {
            super(act, resource, data);
            activity = act;
            layoutResource = resource;
            mdata = data;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mdata.size();
        }

        @Nullable
        @Override
        public MyExercise getItem(int position) {
            return mdata.get(position);
        }

        @Override
        public int getPosition(MyExercise item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
              View row = convertView;
              ViewHolder holder = null;
            if( row == null|| (row.getTag())== null){
                LayoutInflater inflater = LayoutInflater.from(activity);
                row = inflater.inflate(layoutResource, null);
                holder = new ViewHolder();

                holder.mTitle = (TextView)row.findViewById(R.id.name);
                holder.mDate = (TextView)row.findViewById(R.id.dateText);

                row.setTag(holder);
            }else{
                holder = (ViewHolder) row.getTag();
            }

            holder.myExercise = getItem(position);
            holder.mTitle.setText(holder.myExercise.getTitle());
            holder.mDate.setText(holder.myExercise.getRecorddate());
            final ViewHolder finalHolder = holder;
            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = finalHolder.myExercise.getTitle().toString();
                    String minutes = finalHolder.myExercise.getMinutes().toString();
                    String times  = finalHolder.myExercise.getTimes().toString();
                    String meter = finalHolder.myExercise.getMeters().toString();
                    String calories = finalHolder.myExercise.getCalories().toString();
                    String date  = finalHolder.myExercise.getRecorddate().toString();

                    int mid =finalHolder.myExercise.getItemId();


                    Intent i = new Intent(ExercisesActivity.this,Exercise_DetailsActivity.class);
                    i.putExtra("title",title);
                    i.putExtra("minutes",minutes);
                    i.putExtra("times",times);
                    i.putExtra("meter",meter);
                    i.putExtra("calories",calories);
                    i.putExtra("date",date);
                    i.putExtra("id",mid);
                    startActivity(i);
                }
            });

            return row;
        }
    }

    class ViewHolder{

        MyExercise myExercise;
        TextView mTitle;
        TextView mId;
        TextView mMinutes;
        TextView mTimes;
        TextView mMeter;
        TextView mCalories;
        TextView mDate;
    }


}
