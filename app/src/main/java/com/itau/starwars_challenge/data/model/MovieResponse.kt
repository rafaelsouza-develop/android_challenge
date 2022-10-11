package com.itau.starwars_challenge.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("cover")
    val cover: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("director")
    val director: String?,

    @SerializedName("episode_id")
    val episodeId: String?,

    @SerializedName("release_date")
    val releaseDate: String?
)