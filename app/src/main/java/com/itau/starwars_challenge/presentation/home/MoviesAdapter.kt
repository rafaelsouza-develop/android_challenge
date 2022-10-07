package com.itau.starwars_challenge.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itau.starwars_challenge.databinding.ItemMovieBinding
import com.itau.starwars_challenge.presentation.model.MovieVO

class MoviesAdapter(private val movies: List<MovieVO>):RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemMovieBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

     class ViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
         fun bind(item: MovieVO){
             with(binding){
                 txtTitle.text = item.title
                 txtDirector.text = item.director
                 txtRelease.text = item.releaseDate
             }
         }
     }
}