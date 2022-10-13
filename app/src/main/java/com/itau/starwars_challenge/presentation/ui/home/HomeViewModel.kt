package com.itau.starwars_challenge.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {


    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState> = _viewState


    private var movies = listOf<MovieEntity>()


    fun dispatcherViewAction(action: HomeViewAction) {

        when (action) {
            is HomeViewAction.GetMovies -> getMovies()
        }
    }

    private fun getMovies() {
        if (movies.isNotEmpty()) {
            _viewState.value = HomeViewState.MoviesLoaded(movies)
        } else {
            fetchMovies()
        }
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _viewState.value = HomeViewState.Loading
            movieRepository.getMovies()
                .catch { _viewState.value = HomeViewState.MoviesLoadFailure(it) }
                .collect {
                    if (it.isNullOrEmpty()) {
                        _viewState.value = HomeViewState.MoviesEmpty
                    } else {
                        movies = it
                        _viewState.value = HomeViewState.MoviesLoaded(it)
                    }
                }
        }
    }
}