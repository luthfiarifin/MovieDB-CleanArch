package com.laam.core.model

data class TvShow(
    val id: Long,
    val name: String?,
    val overview: String?,
    val voteAverage: Float,
    val poster: String?,
    val tags: String?
)