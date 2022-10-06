package com.itau.starwars_challenge.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("cover")
    var cover: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("director")
    var director: String?,

    @SerializedName("episode_id")
    var episodeId: String?,

    @SerializedName("release_date")
    var releaseDate: String?
)