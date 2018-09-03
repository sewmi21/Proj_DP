package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import model.MyExercise;



public class DatabaseHandler extends SQLiteOpenHelper {

    private final ArrayList<MyExercise> exerciseList = new ArrayList<>();
    public DatabaseHandler(Context context) {
        super(context, Constants.DATABASE_NAME, null,Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EXERCISE_TABLE = "CREATE TABLE " + Constants.TABLE_NAME +
                "(" + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.TITLE_NAME +
                " TEXT, " + Constants.MINUTES_NAME + " TEXT," + Constants.TIMES_NAME + " TEXT,"
                + Constants.METER_NAME + " TEXT," + Constants.COLORIES_NAME + " TEXT," + Constants.DATE_NAME +
                " LONG);";
        db.execSQL(CREATE_EXERCISE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        onCreate(db);
    }


    // delete exercise

    public void deleteExercise(int id){


        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_NAME, Constants.KEY_ID + "=? ",
                new String[]{ String.valueOf(id)});
        db.close();

    }

// add content to table

    public void addExercise(MyExercise exercise){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.TITLE_NAME, exercise.getTitle());
        values.put(Constants.MINUTES_NAME, exercise.getMinutes());
        values.put(Constants.TIMES_NAME, exercise.getTimes());
        values.put(Constants.METER_NAME, exercise.getMeters());
        values.put(Constants.COLORIES_NAME, exercise.getCalories());
        values.put(Constants.DATE_NAME, java.lang.System.currentTimeMillis());

        db.insert(Constants.TABLE_NAME, null, values);
        db.close();
    }

    // get All exercise
    public ArrayList<MyExercise>getExerciseList(){

        String selectQuery = "SELECT * From " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID,
                Constants.TITLE_NAME, Constants.MINUTES_NAME, Constants.TIMES_NAME, Constants.METER_NAME, Constants.COLORIES_NAME,
                Constants.DATE_NAME}, null, null, null, null, Constants.DATE_NAME);


        if(cursor.moveToFirst()){
            do{
                MyExercise exercise = new MyExercise();
                exercise.setTitle(cursor.getString(cursor.getColumnIndex(Constants.TITLE_NAME)));
                exercise.setMinutes(cursor.getString(cursor.getColumnIndex(Constants.MINUTES_NAME)));
                exercise.setTimes(cursor.getString(cursor.getColumnIndex(Constants.TIMES_NAME)));
                exercise.setMeters(cursor.getString(cursor.getColumnIndex(Constants.METER_NAME)));
                exercise.setCalories(cursor.getString(cursor.getColumnIndex(Constants.COLORIES_NAME)));

                exercise.setItemId(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID)));

                java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
                String dataData = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))).getTime());

                exercise.setRecorddate(dataData);

                exerciseList.add(exercise);

            }while (cursor.moveToNext());
        }


        return exerciseList;
    }

    public Cursor getBurnCalorieList(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res_list = db1.rawQuery("select * from "+Constants.TABLE_NAME,null);
        return  res_list;

    }
    public Cursor getBurnCalorie() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res1 = db.rawQuery("SELECT SUM(" + Constants.COLORIES_NAME + ") as Total FROM " + Constants.TABLE_NAME, null);


        /////////////////////////////////////////////
        return res1;
    }


}
