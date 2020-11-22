package com.laam.moviedb_cleanarch.framework.data.network.routes

import com.laam.core.model.MoviePagination
import com.laam.moviedb_cleanarch.BuildConfig
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRoutes {

    @GET("movie/popular?region=${BuildConfig.MOVIE_DB_REGION}")
    suspend fun getMoviesPopular(
        @Query("page") page: Int
    ): Response<MoviePagination<MovieResult>>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Long
    ): Response<MovieDetailResult>
}