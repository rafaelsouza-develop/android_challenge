package com.itau.starwars_challenge.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.usecase.MovieUsecase
import com.itau.starwars_challenge.mapper.domaintoview.toVO
import com.itau.starwars_challenge.presentation.model.MovieVO
import kotlinx.coroutines.launch

class HomeViewModel(private val movieUsecase: MovieUsecase) : ViewModel() {


    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState> = _viewState

    private val _viewAction = MutableLiveData<HomeViewState>()
    val viewAction: LiveData<HomeViewState> = _viewAction

    private  var movies = listOf<MovieVO>()


    fun dispatcherViewAction(action: HomeViewAction) {

        when (action) {
            is HomeViewAction.GetMovies -> getMovies()
        }
    }

    private fun getMovies() {
        if(movies.isNotEmpty()){
            _viewState.value = HomeViewState.MoviesLoaded(movies)
        }else{
            fetchMovies()
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _viewState.value = HomeViewState.Loading
            when (val response = movieUsecase.getMovies()) {
                is ResultRequest.Success -> {

                    response.data.let {

                        movies = response.data.map { movie -> movie.toVO() }
                        _viewState.value = HomeViewState.MoviesLoaded(movies)
                    }
                }
                is ResultRequest.Failure -> {
                    _viewState.value = HomeViewState.MoviesLoadFailure(response.throwable)
                }
            }
        }
    }
}