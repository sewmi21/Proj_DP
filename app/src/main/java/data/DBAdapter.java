package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import model.Spacecraft;



public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    /*
    1. INITIALIZE DB HELPER AND PASS IT A CONTEXT

     */
    public DBAdapter(Context c) {
        this.c = c;
        helper = new DBHelper(c);
    }


    /*
    SAVE DATA TO DB
     */
    public boolean saveSpacecraft(Spacecraft spacecraft) {
        try {
            db = helper.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put(Constants1.NAME, spacecraft.getName());
            cv.put(Constants1.VALUE,spacecraft.getValue());
            cv.put(Constants1.CALORIES,spacecraft.getCalories());
            cv.put(Constants1.CATEGORY, spacecraft.getCategory());

            long result = db.insert(Constants1.TB_NAME, Constants1.ROW_ID, cv);
            if (result > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.close();
        }

        return false;
    }

    /*
     1. RETRIEVE SPACECRAFTS FROM DB AND POPULATE ARRAYLIST
     2. RETURN THE LIST
     */
    public ArrayList<Spacecraft> retrieveSpacecrafts(String category) {
        ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

        try {
            db = helper.getWritableDatabase();


            Cursor c=db.rawQuery("SELECT * FROM "+Constants1.TB_NAME+" WHERE "+Constants1.CATEGORY+" = '"+category+"'",null);

            Spacecraft s;
            spacecrafts.clear();

            while (c.moveToNext())
            {
                String s_name=c.getString(1);
                String s_value = c.getString(2);
                String s_calories = c.getString(3);
                String s_category=c.getString(4);

                s=new Spacecraft();
                s.setName(s_name);
                s.setValue(s_value);
                s.setCalories(s_calories);
                s.setCategory(s_category);

                spacecrafts.add(s);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.close();
        }

        return spacecrafts;
    }
}
