package com.example.antoniolinguaglossa.mvpexample2.MVP.Detail;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;

import java.util.ArrayList;

public class ListPresenterDetailImpl implements ListPresenterDetail {
    private ItemListDetailView mainDetailView;
    private ListDetailModel listDetailModel;

    public ListPresenterDetailImpl(ItemListDetailView mainView, ListDetailModel listDetailModel) {
        this.mainDetailView = mainView;
        this.listDetailModel = listDetailModel;
    }

    @Override
    public ArrayList<Result> getItemsFromModel() {
        return listDetailModel.getItems();
    }

    @Override public void onDestroy() {
        mainDetailView = null;
    }

    @Override
    public void getItem(int position) {
        mainDetailView.setDetail(listDetailModel.getItems().get(position));
    }
}
