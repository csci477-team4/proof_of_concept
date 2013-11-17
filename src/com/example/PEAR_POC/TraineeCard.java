package com.example.PEAR_POC;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class TraineeCard {

    private String name;
    private String info;

    public TraineeCard(String name, String info){
        this.name = name;
        this.info = info;
    }

    public String getName(){
        return this.name;
    }

    public String getInfo(){
        return this.info;
    }

    // just so we can see something nice
    @Override
    public String toString(){
        return name;
    }
}
