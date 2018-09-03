package com.example.android.bmi_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MyHelper extends SQLiteOpenHelper {
    private Context con;
    public MyHelper(Context context) {
        super(context, "USER_DETAIL",null, 1);
        con = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String createMaleTable = "create table MaleTable (Age INTEGER,Feet INTEGER,Inches INTEGER,Pounds INTEGER );";
        db.execSQL(createMaleTable);
        Toast.makeText(con,"Table Created",Toast.LENGTH_LONG).show();


        String createFemaleTable = "create table FemaleTable (Age INTEGER,Feet INTEGER,Inches INTEGER,Pounds INTEGER );";
        db.execSQL(createFemaleTable);
        Toast.makeText(con,"Table Created",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertMaleData(int age, int feet,int inches,int pounds)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Age",age);
        contentValues.put("Feet",feet);
        contentValues.put("Inches",inches);
        contentValues.put("Pounds",pounds);
        db.insert("MaleTable",null,contentValues);
        Toast.makeText(con,"Data inserted",Toast.LENGTH_LONG).show();

    }

    public void insertFemaleData(int age, int feet,int inches,int pounds)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Age",age);
        contentValues.put("Feet",feet);
        contentValues.put("Inches",inches);
        contentValues.put("Pounds",pounds);
        db.insert("MaleTable",null,contentValues);
        Toast.makeText(con,"Data inserted",Toast.LENGTH_LONG).show();

    }
}
