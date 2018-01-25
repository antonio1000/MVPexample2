package com.example.antoniolinguaglossa.mvpexample2.MVP;

import android.util.Log;

import com.example.antoniolinguaglossa.mvpexample2.model.Result;
import java.util.ArrayList;


public class ListPresenterImpl implements ListPresenter, ListModel.OnFinishedListener {

        private ItemListView mainView;
        private ListModel listModelInteractor;

        public ListPresenterImpl(ItemListView mainView, ListModel listModelInteractor) {
            this.mainView = mainView;
            this.listModelInteractor = listModelInteractor;
        }

        /*@Override public void onResume() {
            if (mainView != null) {
                //mainView.showProgress();
                Log.d("test","Progress");
            }

            //listModelInteractor.findItems("Zucchero", this);
        }*/

        @Override public void onItemClicked(int position) {
            //mainActivity.sendMessage(position);
            Log.d("test","onItemClicked");
            if (mainView != null) {
                mainView.showMessage(String.format("Position %d clicked", position + 1));
                Log.d("test","onItemClicked");
                mainView.navigateToDetails(position);
            }
        }

        @Override public void onDestroy() {
            mainView = null;
        }


        @Override
        public void onSearch(String query) {
         if (mainView != null) {
                //mainView.showProgress();
                Log.d("test","Progress");
            }

            listModelInteractor.findItems(query, this);

        }

    @Override
    public ArrayList<Result> getItemsFromModel() {
        Log.d("test","onPippo");
        ArrayList<Result> tmpVal = new ArrayList<Result>();
        tmpVal = listModelInteractor.getItems();
        return tmpVal;
    }


    @Override public void onFinished(ArrayList<Result> items) {
            Log.d("test","onFinisced");
            if (mainView != null) {
                mainView.setItems(items);
                //mainView.hideProgress();
                Log.d("test","Hide");

            }
        }

        public ItemListView getMainView() {
            return mainView;
        }

    }
