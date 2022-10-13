package com.itau.starwars_challenge.domain.repository

import com.itau.starwars_challenge.domain.model.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovies(): Flow<List<MovieEntity>>
}