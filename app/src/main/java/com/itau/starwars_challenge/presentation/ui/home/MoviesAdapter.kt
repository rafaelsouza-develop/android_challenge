package com.itau.starwars_challenge.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itau.starwars_challenge.databinding.ItemMovieBinding
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.presentation.model.MovieVO

class MoviesAdapter(private val movies: List<MovieEntity>):RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemMovieBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

     class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
         fun bind(item: MovieEntity){
             with(binding){
                 txtTitle.text = item.title
                 txtDirector.text = item.director
                 txtRelease.text = item.releaseDate

                 Glide
                     .with(binding.root)
                     .load(item.cover)
                     .centerCrop()
                     .into(imgCover);
             }
         }
     }
}