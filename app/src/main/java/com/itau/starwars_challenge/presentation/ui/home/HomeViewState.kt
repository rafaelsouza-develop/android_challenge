package com.itau.starwars_challenge.presentation.ui.home

import com.itau.starwars_challenge.domain.model.MovieEntity

sealed class HomeViewState {

    object Loading: HomeViewState()
    object MoviesEmpty: HomeViewState()
    data class MoviesLoaded(val movies: List<MovieEntity>): HomeViewState()
    data class MoviesLoadFailure(val error: Throwable) : HomeViewState()
}