package com.example.movieshow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieshow.R
import com.example.movieshow.model.Movie

class MovieAdapter(private val movie : List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movie[position]
        Glide.with(holder.itemView)
            .load(movie.Poster)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.moviePoster)

        holder.movieTitle.text = movie.Title
        holder.movieYear.text = movie.Year
        holder.movieRuntime.text = movie.Runtime
        holder.movieCast.text = movie.Cast
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val moviePoster: ImageView = view.findViewById(R.id.moviePoster)
        val movieTitle: TextView = view.findViewById(R.id.movieTitle)
        val movieYear: TextView = view.findViewById(R.id.movieYear)
        val movieRuntime: TextView = view.findViewById(R.id.movieRuntime)
        val movieCast: TextView = view.findViewById(R.id.movieCast)
    }
}
