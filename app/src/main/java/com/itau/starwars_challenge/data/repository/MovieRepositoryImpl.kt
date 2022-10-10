package com.itau.starwars_challenge.data.repository

import com.itau.starwars_challenge.data.service.MovieService
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository
import com.itau.starwars_challenge.mapper.datatodomain.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {

    override suspend fun getMovies(): Flow<List<MovieEntity>> = flow {
        val response = movieService.getMovies()
        emit(response.map {
            it.toDomain()
        })
    }
}