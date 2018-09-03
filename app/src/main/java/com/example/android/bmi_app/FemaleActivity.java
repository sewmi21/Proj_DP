package com.example.android.bmi_app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FemaleActivity extends AppCompatActivity {
    private EditText edit_age,edit_feet, edit_inches ,edit_pounds;
    private TextView txt1;
    private Button button_Result;
    MyHelper myHelper1;
    SQLiteDatabase sqLiteDatabase1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_female);

        edit_feet =(EditText)findViewById(R.id.EditFeet);
        edit_inches =(EditText)findViewById(R.id.EditInches);
        edit_pounds = (EditText)findViewById(R.id.EditPounds);
        edit_age =(EditText)findViewById(R.id.EditAge);
        txt1 =(TextView)findViewById(R.id.Result_txt);

        myHelper1 = new MyHelper(this);
        sqLiteDatabase1= myHelper1.getWritableDatabase();






         button_Result = (Button)findViewById(R.id.button_calculate_bmi);
        button_Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Age_value = edit_age.getText().toString();
                String Feet_value = edit_feet.getText().toString();
                String Inches_value = edit_inches.getText().toString();
                String Pounds_value = edit_pounds.getText().toString();
                String results1 = Model.calculateCalorieFemale(edit_age,edit_feet,edit_inches,edit_pounds);


                String results = Model.calculateBMI(edit_feet,edit_inches,edit_pounds);




                Intent intent = new Intent(FemaleActivity.this,ResultFemaleActivity.class);
                intent.putExtra("AGE",Age_value);
                intent.putExtra("FEET",Feet_value);
                intent.putExtra("INCHES",Inches_value);
                intent.putExtra("POUND",Pounds_value);
                intent.putExtra("RESULT",results);
                intent.putExtra("RESULT1",results1);


                if(Model.isValidAge(edit_age)){

                }else {

                }

                if(Model.isValidFeet(edit_feet )){

                }
                else {

                }
                if(Model.isValidInches(edit_inches)){

                }else {

                }

                if(Model.isValidPounds(edit_pounds)){

                }else {
                    return;
                }








                startActivity(intent);
                exqButton1();



            }
        });

    }

    private void exqButton1() {


        int AgeVal = Integer.parseInt(String.valueOf(edit_age.getText()));
        int FeetVal = Integer.parseInt(String.valueOf(edit_feet.getText()));
        int InchesVal = Integer.parseInt(String.valueOf(edit_inches.getText()));
        int PoundsVal = Integer.parseInt(String.valueOf(edit_pounds.getText()));


        myHelper1.insertFemaleData(AgeVal,FeetVal,InchesVal,PoundsVal);


    }
}