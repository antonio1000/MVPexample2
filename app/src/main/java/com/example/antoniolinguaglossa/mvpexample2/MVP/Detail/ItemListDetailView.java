package com.example.antoniolinguaglossa.mvpexample2.MVP.Detail;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public interface ItemListDetailView {

    //void showProgress();

    //void hideProgress();

    //void setItems(ArrayList<Result> items);
    void setDetail(Result itemDetail);

    void showMessage(String message);

    //void navigateToDetails(int position);
}