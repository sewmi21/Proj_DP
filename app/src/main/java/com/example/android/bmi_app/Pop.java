package com.example.android.bmi_app;

import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import data.DatabaseHandler;
import model.MyExercise;


public class Pop extends Activity implements
        OnItemSelectedListener {
    private   Spinner s1,s2;
    private Button save_btn;
//    private DatabaseHandler dba;
    private TextView min,tim,met;

    Integer i = 0;
    Integer j = 0;
    Integer k = 0;


    public Pop() {
    }

    @Override
protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);

    s1 = (Spinner)findViewById(R.id.spinner1);

        s1.setOnItemSelectedListener(this);

    s2 = (Spinner)findViewById(R.id.spinner2);
        save_btn = (Button)findViewById(R.id.Add);
   save_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveToDB();
        }
    });

    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(dm);

    int width = dm.widthPixels;
    int height = dm.heightPixels;

    getWindow().setLayout((int) (width * .8), (int) (height * .56));

     Button btnCanceled  =(Button)findViewById(R.id.cancel_btn);
    btnCanceled.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });








//////////////////////////////////////////////////////////////////////////////////////////////////
    // minutes +/- button start //

    Button min_decrease = (Button)findViewById(R.id.minutes_decrease);
    Button min_increase = (Button)findViewById(R.id.minutes_increase);
     min = (TextView)findViewById(R.id.minutes_text);
    i = Integer.parseInt(min.getText().toString());

    min_decrease.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String min_stringVal;
            if (i > 0) {
                i = i - 1;


                min_stringVal = String.valueOf(i);
                min.setText(min_stringVal);
            }

        }
    });

    min_increase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String min_stringVal;
            i = i + 1;

            min_stringVal = String.valueOf(i);
            min.setText(min_stringVal);
        }
    });
    // minutes +/- button end //
///////////////////////////////////////////////////////////////////////////////////////////////////
    // times +/- button start //

    Button times_decrease = (Button)findViewById(R.id.times_decrease);
    Button times_increase = (Button)findViewById(R.id.times_increase);
    tim = (TextView)findViewById(R.id.times_txt);
    j = Integer.parseInt(tim.getText().toString());

    times_decrease.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String times_stringVal;
            if (j > 0) {
                j = j - 1;


                times_stringVal = String.valueOf(j);
                tim.setText(times_stringVal);
            }


        }
    });
    times_increase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String times_stringVal;
            j = j + 1;


            times_stringVal = String.valueOf(j);
            tim.setText(times_stringVal);
        }
    });

    // times +/- button start //

////////////////////////////////////////////////////////////////////////////////////////////////////

    // meters +/- start//

    Button meters_decrease = (Button)findViewById(R.id.meters_decrease);
    Button meters_increase = (Button)findViewById(R.id.meters_increase);
      met = (TextView)findViewById(R.id.meters_txt);
    k = Integer.parseInt(met.getText().toString());

    meters_decrease.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String meters_stringVal;
            if (k > 0) {
                k = k - 1;


                meters_stringVal = String.valueOf(k);
                met.setText(meters_stringVal);
            }


        }
    });

    meters_increase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String meters_stringVal;
            k = k + 1;


            meters_stringVal = String.valueOf(k);
            met.setText(meters_stringVal);
        }
    });
    ///////////////////////////////////////////////////////////////////////////////////////////////



        }

    private void saveToDB() {

              DatabaseHandler dba = new DatabaseHandler(this);
            MyExercise exercise = new MyExercise();
            exercise.setTitle(s1.getSelectedItem().toString().trim());
            exercise.setMinutes(min.getText().toString().trim());
            exercise.setTimes(tim.getText().toString().trim());
            exercise.setMeters(met.getText().toString().trim());
            exercise.setCalories(s2.getSelectedItem().toString().trim());
            dba.addExercise(exercise);
            dba.close();
        Intent i = new Intent(Pop.this,ExercisesActivity.class);
        startActivity(i);


        }




    @Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                           long arg3) {

        String sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Kottu")) {
        List<String> list = new ArrayList<String>();
        list.add("58");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        s2.setAdapter(dataAdapter);
        }
        ///////////////////
        if(sp1.contentEquals("Fried Rice")) {
        List<String> list = new ArrayList<String>();
        list.add("280");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_item, list);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.notifyDataSetChanged();
        s2.setAdapter(dataAdapter2);
        }
//////////////////////////////////////

    if(sp1.contentEquals("Hamburger")) {
        List<String> list = new ArrayList<String>();
        list.add("88");
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter3.notifyDataSetChanged();
        s2.setAdapter(dataAdapter3);
    }
/////////////////////////////////////////////
    if(sp1.contentEquals("Pizza")) {
        List<String> list = new ArrayList<String>();
        list.add("140");
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter4.notifyDataSetChanged();
        s2.setAdapter(dataAdapter4);
    }
  ////////////////////////////////////////////
    if(sp1.contentEquals("Submarine bun")) {
        List<String> list = new ArrayList<String>();
        list.add("140");
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter5.notifyDataSetChanged();
        s2.setAdapter(dataAdapter5);
    }
////////////////////////////////////////////////
    if(sp1.contentEquals("Pancake")) {
        List<String> list = new ArrayList<String>();
        list.add("175");
        ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter6.notifyDataSetChanged();
        s2.setAdapter(dataAdapter6);
    }
//////////////////////////////////////////////////
    if(sp1.contentEquals("String Hoppers")) {
        List<String> list = new ArrayList<String>();
        list.add("266");
        ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter7.notifyDataSetChanged();
        s2.setAdapter(dataAdapter7);
    }
/////////////////////////////////////////////////////
    if(sp1.contentEquals("Noodles")) {
        List<String> list = new ArrayList<String>();
        list.add("74");
        ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter8.notifyDataSetChanged();
        s2.setAdapter(dataAdapter8);
    }
///////////////////////////////////////////////////////
    if(sp1.contentEquals("Macaroni")) {
        List<String> list = new ArrayList<String>();
        list.add("59");
        ArrayAdapter<String> dataAdapter9 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter9.notifyDataSetChanged();
        s2.setAdapter(dataAdapter9);
    }
    /////////////////////////////////////////////////////
    if(sp1.contentEquals("Pasta")) {
        List<String> list = new ArrayList<String>();
        list.add("140");
        ArrayAdapter<String> dataAdapter10 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter10.notifyDataSetChanged();
        s2.setAdapter(dataAdapter10);
    }
    //////////////////////////////////////////////////////
    if(sp1.contentEquals("Biryani")) {
        List<String> list = new ArrayList<String>();
        list.add("74");
        ArrayAdapter<String> dataAdapter11 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter11.notifyDataSetChanged();
        s2.setAdapter(dataAdapter11);
    }
    /////////////////////////////////////////////////////////
    if(sp1.contentEquals("Pittu")) {
        List<String> list = new ArrayList<String>();
        list.add("80");
        ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter12.notifyDataSetChanged();
        s2.setAdapter(dataAdapter12);
    }
    ////////////////////////////////////////////////////////////
    if(sp1.contentEquals("Kiribath")) {
        List<String> list = new ArrayList<String>();
        list.add("90");
        ArrayAdapter<String> dataAdapter13 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter13.notifyDataSetChanged();
        s2.setAdapter(dataAdapter13);
    }
    ////////////////////////////////////////////////////////////////
    if(sp1.contentEquals("Roti")) {
        List<String> list = new ArrayList<String>();
        list.add("113");
        ArrayAdapter<String> dataAdapter14 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter14.notifyDataSetChanged();
        s2.setAdapter(dataAdapter14);
    }
    //////////////////////////////////////////////////////////////////
    if(sp1.contentEquals("Lamprais")) {
        List<String> list = new ArrayList<String>();
        list.add("67");
        ArrayAdapter<String> dataAdapter15 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter15.notifyDataSetChanged();
        s2.setAdapter(dataAdapter15);
    }
    ///////////////////////////////////////////////////////////////////
    if(sp1.contentEquals("fruits Salad")) {
        List<String> list = new ArrayList<String>();
        list.add("140");
        ArrayAdapter<String> dataAdapter16 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter16.notifyDataSetChanged();
        s2.setAdapter(dataAdapter16);
    }
    ////////////////////////////////////////////////////////////////////
    if(sp1.contentEquals("cake")) {
        List<String> list = new ArrayList<String>();
        list.add("105");
        ArrayAdapter<String> dataAdapter17 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter17.notifyDataSetChanged();
        s2.setAdapter(dataAdapter17);
    }
    ///////////////////////////////////////////////////////////////////////
    if(sp1.contentEquals("sandwich")) {
        List<String> list = new ArrayList<String>();
        list.add("51");
        ArrayAdapter<String> dataAdapter18 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter18.notifyDataSetChanged();
        s2.setAdapter(dataAdapter18);
    }
    /////////////////////////////////////////////////////////////////////////

    if(sp1.contentEquals("Vade")) {
        List<String> list = new ArrayList<String>();
        list.add("42");
        ArrayAdapter<String> dataAdapter19 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter19.notifyDataSetChanged();
        s2.setAdapter(dataAdapter19);
    }
    /////////////////////////////////////////////////////////////////////////////

        }
@Override
public void onNothingSelected(AdapterView<?> arg0) {


        }
}
