package com.laam.moviedb_cleanarch.framework.data.network.result

import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.BuildConfig
import com.squareup.moshi.Json

data class TvShowResult(
    @Json(name = "id") val id: Long = 0,
    @Json(name = "adult") val adult: Boolean = false,
    @Json(name = "backdrop_path") val backdropPath: String? = null,
    @Json(name = "original_language") val originalLanguage: String? = null,
    @Json(name = "original_title") val originalTitle: String? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "vote_average") val voteAverage: Float = 0F,
    @Json(name = "vote_count") val voteCount: Int = 0
) {

    fun mapToTvShow() = TvShow(
        id, name, overview, voteAverage,
        "${BuildConfig.MOVIE_DB_IMAGE_URL}/$posterPath", null
    )
}