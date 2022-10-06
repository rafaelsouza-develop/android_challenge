package com.itau.starwars_challenge.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.usecase.MovieUsecase
import com.itau.starwars_challenge.mapper.domaintoview.toVO
import com.itau.starwars_challenge.presentation.model.MovieVO
import com.itau.starwars_challenge.util.ResponseStatus
import com.itau.starwars_challenge.util.ViewState
import kotlinx.coroutines.launch

class HomeViewModel(private val movieUsecase: MovieUsecase) : ViewModel() {

    private val _movieLiveData = MutableLiveData<ViewState<List<MovieVO>, ResponseStatus>>()
    val movieLiveData: LiveData<ViewState<List<MovieVO>, ResponseStatus>> = _movieLiveData

    fun getMovies() {
        viewModelScope.launch {
            when (val response = movieUsecase.getMovies()) {
                is ResultRequest.Success -> {

                    response.data.let {

                        _movieLiveData.postValue(
                            ViewState(response.data.map { movie ->
                                movie.toVO()
                            }, ResponseStatus.SUCCESS)
                        )
                    }
                }
                is ResultRequest.Failure -> {
                    _movieLiveData.postValue(ViewState(null, ResponseStatus.ERROR, response.throwable))
                }
            }
        }
    }
}