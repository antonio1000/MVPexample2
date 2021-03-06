package com.example.antoniolinguaglossa.mvpexample2.MVP;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public interface ListModel {

    interface OnFinishedListener {
        void onFinished(ArrayList<Result> items);
    }

    void findItems(String s, OnFinishedListener listener);

    ArrayList<Result> getItems();

}