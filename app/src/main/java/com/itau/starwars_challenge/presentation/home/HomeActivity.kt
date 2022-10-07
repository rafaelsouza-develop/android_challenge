package com.itau.starwars_challenge.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.itau.starwars_challenge.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObservables(viewModel)
        viewModel.dispatcherViewAction(HomeViewAction.GetMovies)
    }

    private fun setupObservables(viewModel: HomeViewModel) {
        viewModel.viewState.observe(this, Observer { viewState ->
            when (viewState) {
                is HomeViewState.MoviesLoaded -> {
                    viewState.movies
                }
                HomeViewState.Loading -> {


                }
                is HomeViewState.MoviesLoadFailure -> {


                }
            }
        })
    }
}