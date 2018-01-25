package com.example.antoniolinguaglossa.mvpexample2.MVP

import android.os.AsyncTask
import android.util.Log
import com.example.antoniolinguaglossa.mvpexample2.SingletonArrayListResult
import com.example.antoniolinguaglossa.mvpexample2.api.SingletonRetrofit
import com.example.antoniolinguaglossa.mvpexample2.model.Result


class ListModelImplRetrofit : ListModel {
    override fun getItems(): java.util.ArrayList<Result>? {
        Log.d("test","getItems");
        //return ITEMS
        return singletonArrayListResult.array
    }

    //var ITEMS = ArrayList<Result>()
    var singletonArrayListResult = SingletonArrayListResult.getInstance()

    override fun findItems(s : String, listener: ListModel.OnFinishedListener) {

        AsyncTaskExample(listener).execute(s)

    }

    inner class AsyncTaskExample: AsyncTask<String, String, ArrayList<Result>> {

        constructor() : super()

        private lateinit var listener: ListModel.OnFinishedListener

        constructor(listener: ListModel.OnFinishedListener) {
            this.listener = listener
        }

        override fun onPreExecute() {
            super.onPreExecute()
            //indeterminateBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: String?): ArrayList<Result> {

            var myITEMS: MutableList<Result> = ArrayList()
            Log.i("tag", "Synchronizing data [ START ]")
            val s = p0[0]
            //var headers = BackendServiceHeaderMap.obtain()
            val service = SingletonRetrofit.instance.mySingletonRetrofit
            //val credentials = UserLoginRequest("username", "password")
            //val tokenResponse = service
            //        .login(headers, credentials)
            //        .execute()
            val tokenResponse = service
                    .getResults(s!!)
                    .execute()

            myITEMS = ArrayList(tokenResponse.body()!!.results)

            return myITEMS
        }



        override fun onPostExecute(result: ArrayList<Result>?) {
            super.onPostExecute(result)

            //(item_list.adapter as SimpleItemRecyclerViewAdapter).setValues(result?.results!!)

            //indeterminateBar.visibility = View.INVISIBLE
            //my_recycler_view.adapter.notifyDataSetChanged()
            singletonArrayListResult.setArrayFromArray(result!!)
            listener.onFinished(singletonArrayListResult.array)
            //ITEMS = result!!
            //listener.onFinished(ITEMS)

            if (result.toString() == "") {
                Log.i("network", "Network Error")
            } else {
                Log.i("network", result.toString())
            }
        }
    }
}
