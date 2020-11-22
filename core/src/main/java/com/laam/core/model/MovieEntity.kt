package com.laam.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "overview") val overview: String?,
    @ColumnInfo(name = "vote_average") val voteAverage: Float,
    @ColumnInfo(name = "poster") val poster: String?,
    @ColumnInfo(name = "tags") val tags: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String?
)