package com.example.movieinfo.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.Movie
import com.example.movieinfo.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by Hosein on 1/3/2021.
 */
class MainAdapter (
    private val movies: ArrayList<Movie>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private var onItemClicked: OnItemClicked? = null

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, onItemClicked: OnItemClicked?) {
            itemView.title.text = movie.original_title
            itemView.overview.text =  movie.overview
            Glide.with(itemView.image.context)
                .load("http://image.tmdb.org/t/p/w94_and_h141_bestv2" + movie.poster_path)
                .into(itemView.image)
            itemView.root.setOnClickListener {
                onItemClicked?.onClick(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view, parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        if(onItemClicked!=null){
            holder.bind(movies[position], onItemClicked!!)
        }
    else
        holder.bind(movies[position],null)

    fun addData(list: List<Movie>) {
        movies.clear()
        movies.addAll(list)
    }

    fun addListener(itemClicked: OnItemClicked){
      this.onItemClicked = itemClicked
    }
}