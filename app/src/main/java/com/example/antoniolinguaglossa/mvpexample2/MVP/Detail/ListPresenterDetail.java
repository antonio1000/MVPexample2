package com.example.antoniolinguaglossa.mvpexample2.MVP.Detail;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public interface ListPresenterDetail {
    //void onResume();

    //void onItemClicked(int position);

    void onDestroy();

    //void onSearch (String query);

    void getItem(int position);

    ArrayList<Result> getItemsFromModel();

}