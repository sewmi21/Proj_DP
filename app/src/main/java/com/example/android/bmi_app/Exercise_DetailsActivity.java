package com.example.android.bmi_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.DatabaseHandler;

public class Exercise_DetailsActivity extends AppCompatActivity {

    private TextView title,minutes,times,meters,calories,Date;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise__details);

        title =(TextView)findViewById(R.id.detailsTitle);
        minutes =(TextView)findViewById(R.id.minutes);
        times =(TextView)findViewById(R.id.times);
        meters =(TextView)findViewById(R.id.meters);
        calories =(TextView)findViewById(R.id.calories);
        Date =(TextView)findViewById(R.id.detailsDateText);
        deleteButton =(Button)findViewById(R.id.deleteButton);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            title.setText(extras.getString("title"));
            minutes.setText(extras.getString("minutes"));
            times.setText(extras.getString("times"));
            meters.setText(extras.getString("meter"));
            calories.setText(extras.getString("calories"));
            Date.setText("Done :" + extras.getString("date"));

            final int id = extras.getInt("id");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteExercise(id);
                    Toast.makeText(getApplicationContext(), "  delted", Toast.LENGTH_LONG).show();
                  startActivity(new Intent(Exercise_DetailsActivity.this, ExercisesActivity.class));

                }
            });
        }
    }
}
