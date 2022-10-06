package com.itau.starwars_challenge.domain.usecase

import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository

class MovieUsecaseImpl(private val movieRepository: MovieRepository): MovieUsecase {

    override suspend fun getMovies():ResultRequest< List<MovieEntity>> {
        return movieRepository.getMovies()
    }
}