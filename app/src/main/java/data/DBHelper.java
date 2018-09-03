package data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, Constants1.DB_NAME, null, Constants1.DB_VERSION);
    }
    /*
    CREATE TABLE
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            db.execSQL(Constants1.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /*
    UPGRADE TABLE
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.execSQL(Constants1.DROP_TB);
            db.execSQL(Constants1.CREATE_TB);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



    public Cursor getEarn_list(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Earn_list = db.rawQuery("select * from "+Constants1.TB_NAME,null);
        return  Earn_list;

    }


    public Cursor getEarnCalorie() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor Earn1 = db.rawQuery("SELECT SUM(" + Constants1.CALORIES + ") as Total FROM " + Constants1.TB_NAME, null);


        /////////////////////////////////////////////
        return Earn1;
    }




}
