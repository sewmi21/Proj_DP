package com.example.android.bmi_app;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.DecoDrawEffect;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;





public class WeightDataActivity extends AppCompatActivity {
    ///////////////////////////////////////////
    private DecoView mDecoView;
    private int mBackIndex;
    private int mSeries1Index;
    private int mSeries2Index;
    private int mSeries3Index;
    private final float mSeriesMax = 40f;







    //////////////////////////////
    Button insertButton;
    EditText inputTextY;
    GraphView graphView;
    MyHelperAdd helperAdd;
    SQLiteDatabase sqLiteDatabase;
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[0]);

    SimpleDateFormat sdf = new SimpleDateFormat("  MM/dd/yyyy ");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_data);
        insertButton =(Button)findViewById(R.id.insertButton);
        inputTextY = (EditText)findViewById(R.id.inputTextY);
        graphView = (GraphView)findViewById(R.id.graph_view);
        helperAdd = new MyHelperAdd(this);
        sqLiteDatabase = helperAdd.getWritableDatabase();




        //////////////////////////////////////////////


        mDecoView = (DecoView) findViewById(R.id.dynamicArcView);

        // Create required data series on the DecoView
        createBackSeries();
        createDataSeries1();
        //createDataSeries2();
        //createDataSeries3();

        // Setup events to be fired on a schedule
        createEvents();

        ///////////////////////////////////////////////////



        graphView.addSeries(series);
        exqInsert();


        series.resetData(getDataPoint());
        series.setThickness(8);
        series.setDrawBackground(true);
        series.setDrawDataPoints(true);

        series.setDataPointsRadius(15);
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX)
                {
                    return sdf.format(new Date((long)value));
                }else{
                    return super.formatLabel(value,isValueX);

                }
            }
        });


       graphView.setTitleTextSize(20);
        graphView.getGridLabelRenderer().setTextSize(25f);
        graphView.getGridLabelRenderer().reloadStyles();

        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMinY(93);
        graphView.getViewport().setMaxY(400);

        graphView.getViewport().setScalable(true);
        graphView.getViewport().setScalableY(true);
        graphView.setBackgroundColor(Color.rgb(224, 234, 249));


    }

    private void exqInsert() {
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long xValue = new Date().getTime();
                int yValue  = Integer.parseInt(String.valueOf(inputTextY.getText()));
                helperAdd.insertData(xValue,yValue);

                series.resetData(getDataPoint());
                graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    @Override
                    public String formatLabel(double value, boolean isValueX) {
                        if(isValueX)
                        {
                            return sdf.format(new Date((long)value));
                        }else{
                            return "  " +super.formatLabel(value, isValueX);


                        }
                    }
                });




            }
        });
    }

    private DataPoint[] getDataPoint() {

        String[] columns = {"xValues", "yValues"};
        Cursor cursor = sqLiteDatabase.query("Weight_Table", columns, null, null, null, null, null);
        DataPoint[] dp = new DataPoint[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++) {

            cursor.moveToNext();
            dp[i] = new DataPoint(cursor.getLong(0), cursor.getInt(1));
        }
        return dp;
    }

    /////////////////////////////////////////////////////


    private void createBackSeries() {
        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFE2E2E2"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(true)
                .build();

        mBackIndex = mDecoView.addSeries(seriesItem);
    }

    private void createDataSeries1() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFFF8800"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .build();

        final TextView textPercentage = (TextView) findViewById(R.id.textPercentage);
        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                float percentFilled = ((currentPosition - seriesItem.getMinValue()) / (seriesItem.getMaxValue() - seriesItem.getMinValue()));
                textPercentage.setText(String.format("%.0f%%", percentFilled * 100f));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });



        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {

            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });


        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {

            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        mSeries1Index = mDecoView.addSeries(seriesItem);
    }

    private void createDataSeries2() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("0f53ff"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .build();



        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {

            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        mSeries2Index = mDecoView.addSeries(seriesItem);
    }

    private void createDataSeries3() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FF6699FF"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .build();



        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {

            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        mSeries3Index = mDecoView.addSeries(seriesItem);
    }

    private void createEvents() {
        //mDecoView.executeReset();

        mDecoView.addEvent(new DecoEvent.Builder(mSeriesMax)
                .setIndex(mBackIndex)
                .setDuration(3000)
                .setDelay(100)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(mSeries1Index)
                .setDuration(2000)
                .setDelay(1250)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(25.4f)
                .setIndex(mSeries1Index)
                .setDelay(3250)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(mSeries2Index)
                .setDuration(1000)
                .setEffectRotations(1)
                .setDelay(7000)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(11.3f)
                .setIndex(mSeries2Index)
                .setDelay(8500)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_OUT)
                .setIndex(mSeries3Index)
                .setDuration(1000)
                .setEffectRotations(1)
                .setDelay(12500)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(4.36f).setIndex(mSeries3Index).setDelay(14000).build());

        mDecoView.addEvent(new DecoEvent.Builder(0).setIndex(mSeries3Index).setDelay(18000).build());

        mDecoView.addEvent(new DecoEvent.Builder(0).setIndex(mSeries2Index).setDelay(18000).build());

        mDecoView.addEvent(new DecoEvent.Builder(0)
                .setIndex(mSeries1Index)
                .setDelay(20000)
                .setDuration(1000)
                .setInterpolator(new AnticipateInterpolator())
                .setListener(new DecoEvent.ExecuteEventListener() {
                    @Override
                    public void onEventStart(DecoEvent decoEvent) {

                    }

                    @Override
                    public void onEventEnd(DecoEvent decoEvent) {

                    }
                })
                .build());


    }



    //////////////////////////////////////////////////////
}
