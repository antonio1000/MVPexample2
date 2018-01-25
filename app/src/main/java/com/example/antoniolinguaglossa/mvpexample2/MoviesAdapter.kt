package com.example.antoniolinguaglossa.mvpexample2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.antoniolinguaglossa.mvpexample2.MVP.MyInterface
import com.example.antoniolinguaglossa.mvpexample2.model.Result
import com.squareup.picasso.Picasso

import java.util.ArrayList

class MoviesAdapter(private val moviesList: ArrayList<Result>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {


    lateinit var onTapedListener : MyInterface

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var tubnail: ImageView
        var genre: TextView

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            genre = view.findViewById<View>(R.id.genre) as TextView
            tubnail = view.findViewById<View>(R.id.myTubnailImageView) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_list_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.artistName
        holder.genre.text = movie.trackName
        //if (movie.artistId != null)
        //holder.tubnail. = movie.artistId!!.toString()
        Picasso.with(holder.tubnail.context).load(movie.artworkUrl60).into(holder.tubnail)

        holder.itemView.setOnClickListener {
            // TODO your code
            onTapedListener.tapped(position)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}