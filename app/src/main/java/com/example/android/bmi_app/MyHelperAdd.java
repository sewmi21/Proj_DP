package com.example.android.bmi_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyHelperAdd extends SQLiteOpenHelper {


    public MyHelperAdd(Context context) {
        super(context,"Statics_WeightDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table Weight_Table(xValues INTEGER,yValues INTEGER);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(long valX ,int valY)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("xValues",valX);
        contentValues.put("yValues",valY);

        db.insert("Weight_Table",null,contentValues);
    }
}




