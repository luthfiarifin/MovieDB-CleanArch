package com.laam.moviedb_cleanarch.framework.repository

import com.laam.core.ext.repository.NetworkBoundRepository
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.core.model.TvShowEntity
import com.laam.core.repository.TvShowRepository
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowResult
import com.laam.moviedb_cleanarch.framework.data.network.routes.TvShowRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRoutes: TvShowRoutes
) : TvShowRepository {

    override suspend fun getAll(): Flow<State<MoviePagination<TvShowEntity>>> =
        object :
            NetworkBoundRepository<MoviePagination<TvShowResult>, MoviePagination<TvShowEntity>>() {

            override suspend fun fetchFromRemote(): Response<MoviePagination<TvShowResult>> =
                tvShowRoutes.getTvShowsPopular()

            override suspend fun mapFromRemote(request: MoviePagination<TvShowResult>): MoviePagination<TvShowEntity> {
                val items = request.results.map { it.mapToTvShow() }
                return MoviePagination(
                    request.page,
                    request.total_pages,
                    request.total_results,
                    items
                )
            }

        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun get(id: Long): Flow<State<TvShowEntity?>> =
        object :
            NetworkBoundRepository<TvShowDetailResult, TvShowEntity?>() {
            override suspend fun fetchFromRemote(): Response<TvShowDetailResult> =
                tvShowRoutes.getTvShow(id)

            override suspend fun mapFromRemote(request: TvShowDetailResult): TvShowEntity? =
                request.mapToTvShow()

        }.asFlow().flowOn(Dispatchers.IO)
}