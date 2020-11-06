package com.laam.moviedb_cleanarch.framework.data.network.result

import com.squareup.moshi.Json

data class GenreResult(
    @Json(name = "id") val id: Long = 0L,
    @Json(name = "name") val name: String? = null
)