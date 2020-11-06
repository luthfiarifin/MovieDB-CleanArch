package com.laam.core.model

data class MoviePagination<T>(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<T>
)