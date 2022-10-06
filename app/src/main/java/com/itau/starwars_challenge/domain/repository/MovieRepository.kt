package com.itau.starwars_challenge.domain.repository

import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.model.MovieEntity

interface MovieRepository {

    suspend fun getMovies(): ResultRequest<List<MovieEntity>>
}