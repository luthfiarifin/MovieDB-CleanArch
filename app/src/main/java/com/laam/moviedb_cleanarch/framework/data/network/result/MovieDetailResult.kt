package com.laam.moviedb_cleanarch.framework.data.network.result

import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.BuildConfig
import com.squareup.moshi.Json

data class MovieDetailResult(
    @Json(name = "id") val id: Long = 0L,
    @Json(name = "adult") val adult: Boolean = false,
    @Json(name = "backdrop_path") val backdropPath: String? = null,
    @Json(name = "original_language") val originalLanguage: String? = null,
    @Json(name = "original_title") val originalTitle: String? = null,
    @Json(name = "overview") val overview: String? = null,
    @Json(name = "popularity") val popularity: Double = 0.0,
    @Json(name = "poster_path") val posterPath: String? = null,
    @Json(name = "release_date") val releaseDate: String? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "video") val video: Boolean = false,
    @Json(name = "vote_average") val voteAverage: Float = 0F,
    @Json(name = "vote_count") val voteCount: Int = 0,
    @Json(name = "genres") val genres: List<GenreResult> = listOf()
) {

    fun mapToMovie() = Movie(
        id,
        title,
        overview,
        voteAverage,
        "${BuildConfig.MOVIE_DB_IMAGE_URL}/$posterPath",
        genres.joinToString { it.name ?: "" },
        releaseDate
    )
}