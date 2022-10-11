package com.itau.starwars_challenge.mapper

import com.itau.starwars_challenge.data.model.MovieResponse
import com.itau.starwars_challenge.domain.model.MovieEntity

fun MovieResponse.toDomain() = MovieEntity(

    cover = this.cover.orEmpty(),
    title = this.title.orEmpty(),
    director = this.director.orEmpty(),
    episodeId = this.episodeId.orEmpty(),
    releaseDate = this.releaseDate.orEmpty()
)