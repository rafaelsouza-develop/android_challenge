package com.itau.starwars_challenge.presentation.home

import com.itau.starwars_challenge.presentation.model.MovieVO

sealed class HomeViewState {

    object Loading: HomeViewState()
    data class MoviesLoaded(val movies: List<MovieVO>): HomeViewState()
    data class MoviesLoadFailure(val error: Throwable) : HomeViewState()
}