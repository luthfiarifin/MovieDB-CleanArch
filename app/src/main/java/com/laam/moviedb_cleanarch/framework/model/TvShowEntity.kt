package com.laam.moviedb_cleanarch.framework.model

import android.os.Parcelable
import com.laam.core.model.TvShow
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowEntity(
    val id: Long,
    val name: String,
    val overview: String,
    val voteAverage: Float,
    val poster: Int,
    val tags: String
) : Parcelable {

    companion object {
        fun TvShow.mapFromTvShow(): TvShowEntity = TvShowEntity(
            id,
            name,
            overview,
            voteAverage,
            poster,
            tags
        )
    }

    fun mapToTvShow(): TvShow = TvShow(
        id,
        name,
        overview,
        voteAverage,
        poster,
        tags
    )
}