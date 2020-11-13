package com.laam.moviedb_cleanarch.framework.repository

import com.laam.core.ext.repository.NetworkBoundRepository
import com.laam.core.ext.repository.State
import com.laam.core.model.Movie
import com.laam.core.model.MoviePagination
import com.laam.core.repository.MovieRepository
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieResult
import com.laam.moviedb_cleanarch.framework.data.network.routes.MovieRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRoutes: MovieRoutes
) : MovieRepository {

    override suspend fun getAll(): Flow<State<MoviePagination<Movie>>> =
        object :
            NetworkBoundRepository<MoviePagination<MovieResult>, MoviePagination<Movie>>() {

            override suspend fun fetchFromRemote(): Response<MoviePagination<MovieResult>> =
                movieRoutes.getMoviesPopular()

            override suspend fun mapFromRemote(request: MoviePagination<MovieResult>): MoviePagination<Movie> {
                val items = request.results.map { it.mapToMovie() }
                return MoviePagination(request.page, request.total_pages, request.total_results, items)
            }

        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun get(id: Long): Flow<State<Movie?>> =
        object :
            NetworkBoundRepository<MovieDetailResult, Movie?>() {
            override suspend fun fetchFromRemote(): Response<MovieDetailResult> =
                movieRoutes.getMovie(id)

            override suspend fun mapFromRemote(request: MovieDetailResult): Movie? =
                request.mapToMovie()

        }.asFlow().flowOn(Dispatchers.IO)
}