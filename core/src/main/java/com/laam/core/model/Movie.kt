package com.laam.core.model

data class Movie(
    val id: Long,
    val name: String?,
    val overview: String?,
    val voteAverage: Float,
    val poster: String?,
    val tags: String?,
    val releaseDate: String?
)