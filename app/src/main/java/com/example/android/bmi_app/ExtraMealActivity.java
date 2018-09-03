package com.example.android.bmi_app;


import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.Calendar;

import FragmentActivity.InterGalactic;
import FragmentActivity.InterPlanetary;
import FragmentActivity.InterStellar;
import adapter.MyPagerAdapter;
import data.DBAdapter;
import model.Spacecraft;

public class ExtraMealActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tab;
    private ViewPager vp;
    int currentPos=0;

    EditText nameEditText;
    EditText valueEditText;
    EditText caloriesEditText;
    Button saveBtn;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_meal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //VIEWPAGER AND TABS
        vp = (ViewPager) findViewById(R.id.viewpager);
        addPages();

        //SETUP TAB
        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
        tab.addOnTabSelectedListener(this);
    }



    /*
    DISPLAY INPUT DIALOG
    SAVE
     */
    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Your choice");
        d.setContentView(R.layout.dialog_layout);

        //INITIALIZE VIEWS
        nameEditText= (EditText) d.findViewById(R.id.nameEditTxt);
        valueEditText =(EditText)d.findViewById(R.id.valueEditTxt);
        caloriesEditText =(EditText)d.findViewById(R.id.caloriesEditTxt);
        saveBtn= (Button) d.findViewById(R.id.saveBtn);
        sp = (Spinner) d.findViewById(R.id.category_SP);

        //SPINNER ADAPTER
        final String[] categories = {InterPlanetary.newInstance().toString(),
                InterStellar.newInstance().toString(),
                InterGalactic.newInstance().toString()};
        sp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories));

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Spacecraft s = new Spacecraft();
                s.setName(nameEditText.getText().toString());
                s.setValue(valueEditText.getText().toString());
                s.setCalories(caloriesEditText.getText().toString());
                s.setCategory(sp.getSelectedItem().toString());

                if (new DBAdapter(ExtraMealActivity.this).saveSpacecraft(s)) {
                    nameEditText.setText("");
                    valueEditText.setText("");
                    caloriesEditText.setText("");
                    sp.setSelection(0);
                } else {
                    Toast.makeText(ExtraMealActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //SHOW DIALOG
        d.show();


    }
  private void NotifyMe(){

      Calendar calendar = Calendar.getInstance();

      calendar.set(Calendar.HOUR_OF_DAY,02);
      calendar.set(Calendar.MINUTE,52);
      calendar.set(Calendar.SECOND,10);
      Intent intent = new Intent(getApplicationContext(),AlarmReceiver_Meal.class);
      PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),120,intent,PendingIntent.FLAG_UPDATE_CURRENT);
      AlarmManager alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
      alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmManager.INTERVAL_DAY,pendingIntent);

  }
//uniqe request code


    //FILL TAB PAGES
    private void addPages()
    {
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
          myPagerAdapter.addPage(InterPlanetary.newInstance());
         myPagerAdapter.addPage(InterGalactic.newInstance());
         myPagerAdapter.addPage(InterStellar.newInstance());


        vp.setAdapter(myPagerAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(currentPos=tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.addMenu) {
            displayDialog();
            return true;
        }if(id== R.id.notify){
            NotifyMe();
        }

        return super.onOptionsItemSelected(item);
    }

}
