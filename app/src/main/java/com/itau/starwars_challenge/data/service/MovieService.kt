package com.itau.starwars_challenge.data.service

import com.itau.starwars_challenge.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("dc12046175d1c54574fb")
    suspend fun getMovies(): Response<MovieResponse>
}