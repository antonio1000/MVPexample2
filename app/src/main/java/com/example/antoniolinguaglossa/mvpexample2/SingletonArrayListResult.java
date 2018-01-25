package com.example.antoniolinguaglossa.mvpexample2;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public class SingletonArrayListResult  {

    private static SingletonArrayListResult mInstance;
    private ArrayList<Result> list = null;

    public static SingletonArrayListResult getInstance() {
        if(mInstance == null)
            mInstance = new SingletonArrayListResult();

        return mInstance;
    }

    private SingletonArrayListResult() {
        list = new ArrayList<Result>();
    }
    // retrieve array from anywhere
    public ArrayList<Result> getArray() {
        return this.list;
    }
    //Add element to array
    /*public void addToArray(Result value) {
        list.add(value);
    }*/

    //Add element to array
    public void setArrayFromArray(ArrayList<Result> sourceValue) {
        list = sourceValue;
    }
}