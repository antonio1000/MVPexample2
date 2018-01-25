package com.example.antoniolinguaglossa.mvpexample2

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.SearchView
import android.util.Log
import android.widget.Toast
import com.example.antoniolinguaglossa.mvpexample2.MVP.*
import com.example.antoniolinguaglossa.mvpexample2.model.Result


class MainActivity : AppCompatActivity(), ItemListView, MyInterface {

    override fun navigateToDetails(position: Int) {
        //val message = position.toString()
        var ItemsGetOut : ArrayList<Result>
        ItemsGetOut = presenter!!.getItemsFromModel()

        val intent = Intent(this, MyDetailActivity::class.java).apply {
            //putExtra(EXTRA_MESSAGE, ItemsGetOut[position].artistId.toString())
            putExtra(EXTRA_MESSAGE, position)
        }


        startActivity(intent)

    }


    override fun tapped(pos: Int) {
        presenter?.onItemClicked(pos)
    }

    private var presenter: ListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ListPresenterImpl(this, ListModelImplRetrofit())

        searchView.setSubmitButtonEnabled(true)
        searchView.setQueryHint("Search...")

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                //AsyncTaskExample().execute(query)
                presenter?.onSearch(query)
                Log.d("test","Query: " + query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        searchView.isSubmitButtonEnabled = true

    }

    override fun setItems(items : ArrayList<Result>) {
        Log.d("test","Start SetItems")
        //itemListView!!.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, items))
        my_recycler_view.setHasFixedSize(true)
        var mAdapter: MoviesAdapter? = MoviesAdapter(items)
        //mAdapter = MoviesAdapter(items)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        if (my_recycler_view != null) {
            my_recycler_view.setLayoutManager(mLayoutManager)
            my_recycler_view.setItemAnimator(DefaultItemAnimator())
            my_recycler_view.setAdapter(mAdapter)
            mAdapter?.onTapedListener = this
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        Log.d("test",message)
    }

    /*override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }*/

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

    /*override fun showProgress() {
        progressBar.setVisibility(View.VISIBLE)
        listView.setVisibility(View.INVISIBLE)
    }

    override fun hideProgress() {
        progressBar.setVisibility(View.INVISIBLE)
        listView.setVisibility(View.VISIBLE)
    }*/

}