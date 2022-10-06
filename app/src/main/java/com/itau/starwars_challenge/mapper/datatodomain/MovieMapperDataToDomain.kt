package com.itau.starwars_challenge.mapper.datatodomain

import com.itau.starwars_challenge.data.model.MovieResponse
import com.itau.starwars_challenge.domain.model.MovieEntity

fun MovieResponse.toDomain() = MovieEntity(

    cover = this.cover,
    title = this.title,
    director = this.director,
    episodeId = this.episodeId,
    releaseDate = this.releaseDate
)