package com.example.antoniolinguaglossa.mvpexample2.MVP;

import android.view.View;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public interface ListPresenter {
    //void onResume();

    void onItemClicked(int position);

    void onDestroy();

    void onSearch (String query);

    ArrayList<Result> getItemsFromModel();

}
