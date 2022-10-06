package com.itau.starwars_challenge.mapper.domaintoview

import com.itau.starwars_challenge.domain.model.MovieEntity
import com.itau.starwars_challenge.presentation.model.MovieVO

fun MovieEntity.toVO() = MovieVO(

    cover = this.cover,
    title = "Star Wars - Episode " + this.episodeId + ":" + this.title,
    director = this.director,
    releaseDate = this.releaseDate
)