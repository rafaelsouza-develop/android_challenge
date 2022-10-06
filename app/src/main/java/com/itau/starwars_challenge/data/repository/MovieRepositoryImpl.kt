package com.itau.starwars_challenge.data.repository

import com.itau.starwars_challenge.data.service.MovieService
import com.itau.starwars_challenge.data.ResultRequest
import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.domain.repository.MovieRepository
import com.itau.starwars_challenge.mapper.datatodomain.toDomain

class MovieRepositoryImpl(private val movieService: MovieService): MovieRepository {

    override suspend fun getMovies(): ResultRequest<List<MovieEntity>> {
        val response = movieService.getMovies()
        if(response.isSuccessful){
            return ResultRequest.Success(response.body().let { movies ->
                movies!!.map {
                    it.toDomain()
                }
            })
        }
        return ResultRequest.Failure(Throwable("Error ${response.errorBody()} ${response.message()} "))
    }
}