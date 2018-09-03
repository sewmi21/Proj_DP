package com.example.android.bmi_app;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sunfusheng.marqueeview.MarqueeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import data.DBHelper;
import data.DatabaseHandler;

public class CalorieslDataActivity extends AppCompatActivity {


    DatabaseHandler mydb;
    DBHelper mydb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caloriesl_data);
        mydb = new DatabaseHandler(this);
        mydb1 = new DBHelper(this);

        Burn_list_Calories();
        BurnCalories();
        Earn_Calories_Total();
        Earn_Calories();


        TextView yLabel = (TextView)findViewById(R.id.yLabel);
        TextView mLabel = (TextView)findViewById(R.id.mLabel);
        TextView dLabel = (TextView)findViewById(R.id.dLabel);
        TextView eLabel = (TextView)findViewById(R.id.eLabel);
        MarqueeView marqueeView =(MarqueeView)findViewById(R.id.marqueeView);
        List<String> lisText = new ArrayList<>();
        lisText.add("This the page you  see your");
        lisText.add("calorie Earn ....");
        lisText.add("calorie Burn .....");
        lisText.add("What are the total...");
        marqueeView.startWithList(lisText);




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMMM/d/E", Locale.UK);
        String strDate = sdf.format(calendar.getTime());

        String[] values = strDate.split("/",0);
        yLabel.setText(values[0]);
        mLabel.setText(values[1]);
        dLabel.setText(values[2]);
        eLabel.setText(values[3]);



    }

    /////////////////////////////////////// burn////////////////////////////////////////////////
    public void Burn_list_Calories(){
        Button burn_btn_list  =(Button)findViewById(R.id.Burn_list_btn);
        burn_btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Cursor res_list = mydb.getBurnCalorieList();
                if(res_list.getCount()==0){
                    showMessage("Error","Please Plan your Diet schedule!! ");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res_list.moveToNext()){


                  buffer.append(res_list.getString(5)+"Kacl"+"\n");




                }
                showMessage("Calories you Burn List ",buffer.toString());
            }
        });

    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



    public void BurnCalories(){

        Button burn_btn  =(Button)findViewById(R.id.burn_btn);
        burn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res1 = mydb.getBurnCalorie();
                if(res1.getCount()==0){
                    showMessageTotal("Error","Please Plan your Diet schedule!!");
                    return;
                }
                StringBuffer buffer3 = new StringBuffer();
                while(res1.moveToNext()){


                    buffer3.append(res1.getString(0)+"Kacl"+"\n");




                }
                showMessageTotal("Total Calories you Burn  ",buffer3.toString());
            }
        });

    }
    public void showMessageTotal(String title3, String Message3){
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setCancelable(true);
        builder3.setTitle(title3);
        builder3.setMessage(Message3);
        builder3.show();

    }


    //////////////////////////////////////////////////////////////////////////////burnEnd///////////////////////////////////////////



    ////////////////////////////////////////////////////////Earn Calories///////////////////////////////////////////////////////

    public void Earn_Calories_Total(){
        Button Earn_btn  =(Button)findViewById(R.id.Earn_btn);
        Earn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor Earn1 = mydb1.getEarnCalorie();
                if(Earn1.getCount()==0){
                    showMessageEarn("Error"," good you no Earn calories");
                    return;
                }
                StringBuffer buffer1 = new StringBuffer();
                while(Earn1.moveToNext()){

                    buffer1.append(Earn1.getString(0)+"Kacl"+"\n");





                }
                showMessageEarn("Total Calories you Earn ",buffer1.toString());
            }
        });

    }
    public void showMessageEarn(String title1, String Message1){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setCancelable(true);
        builder1.setTitle(title1);
        builder1.setMessage(Message1);
        builder1.show();
    }


    public void Earn_Calories(){
        Button Earn_List  =(Button)findViewById(R.id.Earn_list_calories);
        Earn_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor Earn_list = mydb1.getEarn_list();
                if(Earn_list.getCount()==0){
                    showMessageBurn("Error"," good you no Earn calories");
                    return;
                }
                StringBuffer buffer2 = new StringBuffer();
                while(Earn_list.moveToNext()){

                    buffer2.append(Earn_list.getString(3)+"Kacl"+"\n");





                }
                showMessageBurn("Calories you Earn list ",buffer2.toString());
            }
        });

    }
    public void showMessageBurn(String title2, String Message2){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setCancelable(true);
        builder2.setTitle(title2);
        builder2.setMessage(Message2);
        builder2.show();

    }
    ///////////////////////////////////////////////////////////////////End  Earn Calories//////////////////////////////////
}
