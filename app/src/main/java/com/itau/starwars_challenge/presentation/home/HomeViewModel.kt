package com.itau.starwars_challenge.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.usecase.MovieUsecase
import com.itau.starwars_challenge.mapper.domaintoview.toVO
import kotlinx.coroutines.launch

class HomeViewModel(private val movieUsecase: MovieUsecase) : ViewModel() {

    val viewState = MutableLiveData<HomeViewState>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            viewState.value = HomeViewState.Loading
            when (val response = movieUsecase.getMovies()) {
                is ResultRequest.Success -> {

                    response.data.let {

                        val movies = response.data.map { movie -> movie.toVO() }
                        viewState.value = HomeViewState.MoviesLoaded(movies)
                    }
                }
                is ResultRequest.Failure -> {
                    viewState.value = HomeViewState.MoviesLoadFailure(response.throwable)
                }
            }
        }
    }
}