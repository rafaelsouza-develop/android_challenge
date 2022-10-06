package com.itau.starwars_challenge.domain.usecase

import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.model.MovieEntity

interface MovieUsecase {

    suspend fun getMovies(): ResultRequest< List<MovieEntity>>
}