package com.example.messpoll.sharedPref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private Context context;

    public SharedPref(Context context){

        this.context = context;
    }

    public SharedPreferences getUserPreferences(){

        return context.getSharedPreferences("com.example.messpoll.sharedPref" , Context.MODE_PRIVATE);


    }

    public void removeAllUserPreferences() {
        getUserPreferences().edit().clear().apply();
    }


    public void setBreakfastEnabled(boolean b){

        getUserPreferences().edit().putBoolean("BreakfastPoll" , b).apply();

    }

    public boolean getBreakfastEnabled(){

        return getUserPreferences().getBoolean("BreakfastPoll" , true);

    }

    public  void setLunchEnabled(boolean b){

        getUserPreferences().edit().putBoolean("LunchPoll" , b).apply();

    }

    public  boolean getLunchEnabled(){

        return getUserPreferences().getBoolean("LunchPoll" , true);


    }




}
