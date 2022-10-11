package com.itau.starwars_challenge.presentation.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.itau.starwars_challenge.R
import com.itau.starwars_challenge.databinding.ActivityMainBinding
import com.itau.starwars_challenge.domain.model.MovieEntity
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
                    showSucessState()
                    setRecyclerViewList(viewState.movies)
                }
                HomeViewState.Loading -> {
                    showLoadingState()
                }
                is HomeViewState.MoviesLoadFailure -> {
                    showErrorState()
                }
                HomeViewState.MoviesEmpty -> {
                    showEmptyState()
                }
            }
        }
    }

    private fun setRecyclerViewList(movies: List<MovieEntity>) {
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesAdapter(movies)
        }
    }

    private fun showErrorState() {
        with(binding) {
            rvMovies.visibility = View.GONE
            containerErrorState.visibility = View.VISIBLE
            containerLoadingState.visibility = View.GONE
            containerEmptyState.visibility = View.GONE
        }
    }

    private fun showSucessState() {
        with(binding) {
            rvMovies.visibility = View.VISIBLE
            containerErrorState.visibility = View.GONE
            containerLoadingState.visibility = View.GONE
            containerEmptyState.visibility = View.GONE
        }
    }

    private fun showLoadingState() {
        with(binding) {
            rvMovies.visibility = View.GONE
            containerErrorState.visibility = View.GONE
            containerLoadingState.visibility = View.VISIBLE
            containerEmptyState.visibility = View.GONE
        }
    }

    private fun showEmptyState() {
        with(binding) {
            rvMovies.visibility = View.GONE
            containerErrorState.visibility = View.GONE
            containerLoadingState.visibility = View.GONE
            containerEmptyState.visibility = View.VISIBLE
        }
    }
}