package com.laam.moviedb_cleanarch.framework.model

import android.os.Parcelable
import com.laam.core.model.Movie
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    val id: Long,
    val name: String,
    val overview: String,
    val voteAverage: Float,
    val poster: Int,
    val tags: String,
    val releaseDate: String
) : Parcelable {

    companion object {
        fun Movie.mapFromMovie() =
            MovieEntity(
                id,
                name,
                overview,
                voteAverage,
                poster,
                tags,
                releaseDate
            )
    }

    fun mapToMovie() = Movie(
        id,
        name,
        overview,
        voteAverage,
        poster,
        tags,
        releaseDate
    )
}