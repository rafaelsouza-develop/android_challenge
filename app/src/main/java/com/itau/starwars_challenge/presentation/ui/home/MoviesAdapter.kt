package com.itau.starwars_challenge.presentation.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.R.string
import com.itau.starwars_challenge.databinding.ItemMovieBinding
import com.itau.starwars_challenge.domain.model.MovieEntity

class MoviesAdapter(private val movies: List<MovieEntity>):RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemMovieBinding.inflate(inflater, parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

     class ViewHolder(private val binding: ItemMovieBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root){
         fun bind(item: MovieEntity){
             with(binding){
                 txtTitle.text =
                     "${context.getString(string.lb_title)} ${item.episodeId}: ${item.title}"
                 txtDirector.text = item.director
                 txtRelease.text = item.releaseDate
                 Glide
                     .with(binding.root)
                     .load(item.cover)
                     .centerCrop()
                     .into(imgCover)
             }
         }
     }
}