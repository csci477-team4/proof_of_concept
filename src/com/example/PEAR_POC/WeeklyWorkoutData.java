package com.example.PEAR_POC;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 */
public class WeeklyWorkoutData {
    String start;
    String end;
    HashMap<String, String> data;

    public WeeklyWorkoutData(String s, String e, HashMap<String, String> data){
       this.start = s;
       this.end = e;
       this.data = data;
    }

    public ArrayList<String> getWorkouts(){
        ArrayList<String> arr = new ArrayList<String>();

        for(String k : data.keySet()){
            arr.add(k + " " + data.get(k));
        }

        return arr;
    }

    public String getStartTime(){
        return this.start;
    }

    public String getEndTime(){
        return this.end;
    }
}
