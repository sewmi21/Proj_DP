package com.example.android.bmi_app;

import android.content.Context;
import android.content.SharedPreferences;



public class Intromanger {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public Intromanger(Context context){
        this.context = context;
        pref = context.getSharedPreferences("first",0);
        editor = pref.edit();
    }

    public void setFirst(Boolean isFirst)
    {
        editor.putBoolean("check",isFirst);
        editor.commit();
    }
    public boolean Check(){
        return  pref.getBoolean("check",true);
    }
}
