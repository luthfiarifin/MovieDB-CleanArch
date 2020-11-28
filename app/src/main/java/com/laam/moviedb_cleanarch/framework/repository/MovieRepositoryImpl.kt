package com.laam.moviedb_cleanarch.framework.repository

import com.laam.core.ext.repository.NetworkBoundRepository
import com.laam.core.ext.repository.State
import com.laam.core.model.MovieEntity
import com.laam.core.model.MovieFavoriteEntity
import com.laam.core.model.MoviePagination
import com.laam.core.repository.MovieRepository
import com.laam.moviedb_cleanarch.framework.data.local.dao.MovieDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.MovieFavoriteDao
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.MovieResult
import com.laam.moviedb_cleanarch.framework.data.network.routes.MovieRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRoutes: MovieRoutes,
    private val movieDao: MovieDao,
    private val movieFavoriteDao: MovieFavoriteDao
) : MovieRepository {

    override suspend fun getAll(page: Int): Flow<State<Pair<Int, List<MovieEntity>>>> =
        object :
            NetworkBoundRepository<Pair<Int, List<MovieEntity>>, MoviePagination<MovieResult>>() {

            override suspend fun fetchFromRemote(): Response<MoviePagination<MovieResult>> =
                movieRoutes.getMoviesPopular(page)

            override fun fetchFromLocal(): Pair<Int, List<MovieEntity>> =
                Pair(-1, movieDao.getMovies())

            override fun saveRemoteData(data: MoviePagination<MovieResult>) {
                movieDao.resetNewData(data.results.map { it.mapToMovie() })
            }

            override fun shouldSaveToLocal(data: MoviePagination<MovieResult>?): Boolean =
                data?.page == 1

            override fun mapFromRemote(data: MoviePagination<MovieResult>): Pair<Int, List<MovieEntity>> =
                Pair(data.page + 1, data.results.map { it.mapToMovie() })
        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun get(id: Long): Flow<State<MovieEntity?>> =
        object :
            NetworkBoundRepository<MovieEntity?, MovieDetailResult>() {

            override suspend fun fetchFromRemote(): Response<MovieDetailResult> =
                movieRoutes.getMovie(id)

            override fun fetchFromLocal(): MovieEntity? = null

            override fun saveRemoteData(data: MovieDetailResult) {}

            override fun shouldSaveToLocal(data: MovieDetailResult?): Boolean = false

            override fun mapFromRemote(data: MovieDetailResult): MovieEntity = data.mapToMovie()
        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun isFavorite(id: Long): Boolean = movieFavoriteDao.getMovie(id) != null

    override suspend fun insertFavorite(data: MovieFavoriteEntity) =
        movieFavoriteDao.insertMovie(data)

    override suspend fun deleteFavorite(id: Long) {
        movieFavoriteDao.deleteMovie(id)
    }
}