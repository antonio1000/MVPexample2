package com.example.antoniolinguaglossa.mvpexample2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import com.example.antoniolinguaglossa.mvpexample2.MVP.Detail.ItemListDetailView
import com.example.antoniolinguaglossa.mvpexample2.MVP.Detail.ListDetailModelImpl
import com.example.antoniolinguaglossa.mvpexample2.MVP.Detail.ListPresenterDetail
import com.example.antoniolinguaglossa.mvpexample2.MVP.Detail.ListPresenterDetailImpl
import com.example.antoniolinguaglossa.mvpexample2.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_my_detail.*

class MyDetailActivity : AppCompatActivity(), ItemListDetailView {
    override fun setDetail(itemDetail: Result?) {
        Picasso.with(this.myArtworkImageView.context).load(itemDetail!!.artworkUrl100).into(this.myArtworkImageView)
        detailTrackName.text = itemDetail.trackName
        detailAlbumName.text = itemDetail.collectionName
        detailArtistName.text = itemDetail.artistName
        detailPrice.text = itemDetail.trackPrice.toString()
        detailData.text = itemDetail.releaseDate.toString()
    }

    override fun showMessage(message: String?) {
        Log.d("test","Detail")
    }

    private var presenterDetail: ListPresenterDetail? = null
    //private lateinit var myItem : ArrayList<Result>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_detail)

        //val message = intent.getStringExtra(EXTRA_MESSAGE)
        val message = intent.getIntExtra(EXTRA_MESSAGE,0)

        presenterDetail = ListPresenterDetailImpl(this, ListDetailModelImpl())
        (presenterDetail as ListPresenterDetailImpl).getItem(message)

//        myItem= presenterDetail?.itemsFromModel!!

        //Call MVP View
        //this.setDetail(myItem[message.toInt()])
    }
}
