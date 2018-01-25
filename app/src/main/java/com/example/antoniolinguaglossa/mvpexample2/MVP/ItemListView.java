package com.example.antoniolinguaglossa.mvpexample2.MVP;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public interface ItemListView {

    //void showProgress();

    //void hideProgress();

    void setItems(ArrayList<Result> items);

    void showMessage(String message);

    void navigateToDetails(int position);
}