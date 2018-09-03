package com.example.android.bmi_app;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

import java.util.Date;

public class UserEnterStaticsActivity extends AppCompatActivity {

    Button buttonAdd;
    EditText yInput;
    GraphView graphView;
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);
    MyHelperAdd helperAdd;
    SQLiteDatabase sqLiteDatabase;
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a");
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_enter_statics);

        buttonAdd =(Button)findViewById(R.id.Insert);
        yInput =(EditText)findViewById(R.id.Y_value);
        graphView =(GraphView)findViewById(R.id.graph_view);

        helperAdd = new MyHelperAdd(this);
        sqLiteDatabase =helperAdd.getWritableDatabase();
        graphView.addSeries(series);


        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX)
                {
                    return sdf.format(new Date((long)value));
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
        series.resetData(new DataPoint[] {});



        exqButton();


    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    private void exqButton() {
      buttonAdd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              long xValue = new Date().getTime();
              int yValue = Integer.parseInt(String.valueOf(yInput.getText()));

              helperAdd.insertData(xValue,yValue);
              series.resetData(getData());

              graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                  @Override
                  public String formatLabel(double value, boolean isValueX) {
                      if(isValueX)
                      {
                          return sdf.format(new Date((long)value));
                      }else {
                          return super.formatLabel(value, isValueX);
                      }
                  }
              });
          }
      });

    }

    private DataPoint[] getData() {
        String[] columns ={"xValues","yValues"};
        Cursor cursor = sqLiteDatabase.query("userEnterState",columns,null,null,null,null,null);

        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++)
        {
            cursor.moveToNext();
            dp[i]= new DataPoint(cursor.getLong(0),cursor.getInt(1));
        }
        return dp;
    }
}
