package com.itau.starwars_challenge.presentation.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.databinding.ActivityMainBinding
import com.itau.starwars_challenge.presentation.model.MovieVO
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupObservables(viewModel)
        viewModel.dispatcherViewAction(HomeViewAction.GetMovies)
    }

    private fun setupObservables(viewModel: HomeViewModel) {
        viewModel.viewState.observe(this) { viewState ->
            when (viewState) {
                is HomeViewState.MoviesLoaded -> {
                    setRecyclerViewList(viewState.movies)
                }
                HomeViewState.Loading -> {


                }
                is HomeViewState.MoviesLoadFailure -> {


                }
            }
        }
    }

    private fun setRecyclerViewList(movies: List<MovieVO>) {
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter(movies)
        }
    }
}