package com.itau.starwars_challenge.data.repository

import com.itau.starwars_challenge.data.service.MovieService
import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {

    override suspend fun getMovies(): ResultRequest<List<MovieEntity>> {
        TODO("Not yet implemented")
    }
}