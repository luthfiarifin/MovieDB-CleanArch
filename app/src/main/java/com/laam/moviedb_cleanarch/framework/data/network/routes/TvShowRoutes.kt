package com.laam.moviedb_cleanarch.framework.data.network.routes

import com.laam.core.model.MoviePagination
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowRoutes {

    @GET("tv/popular")
    suspend fun getTvShowsPopular(
        @Query("page") page: Int
    ): Response<MoviePagination<TvShowResult>>

    @GET("tv/{tv_show_id}")
    suspend fun getTvShow(
        @Path("tv_show_id") tvShowId: Long
    ): Response<TvShowDetailResult>
}