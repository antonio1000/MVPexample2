package com.example.antoniolinguaglossa.mvpexample2.MVP.Detail

import android.util.Log
import com.example.antoniolinguaglossa.mvpexample2.SingletonArrayListResult
import com.example.antoniolinguaglossa.mvpexample2.model.Result

class ListDetailModelImpl : ListDetailModel {
    internal var singletonArrayListResult = SingletonArrayListResult.getInstance()

    override fun getItems(): java.util.ArrayList<Result>? {
        Log.d("test","getItems");
        //return ITEMS
        return singletonArrayListResult.array
    }
}


