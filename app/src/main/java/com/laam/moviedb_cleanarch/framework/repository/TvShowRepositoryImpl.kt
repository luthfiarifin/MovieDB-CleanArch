package com.laam.moviedb_cleanarch.framework.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.laam.core.ext.repository.NetworkBoundRepository
import com.laam.core.ext.repository.State
import com.laam.core.model.MoviePagination
import com.laam.core.model.TvShowEntity
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.core.repository.TvShowRepository
import com.laam.moviedb_cleanarch.framework.data.local.dao.TvShowDao
import com.laam.moviedb_cleanarch.framework.data.local.dao.TvShowFavoriteDao
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowDetailResult
import com.laam.moviedb_cleanarch.framework.data.network.result.TvShowResult
import com.laam.moviedb_cleanarch.framework.data.network.routes.TvShowRoutes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRoutes: TvShowRoutes,
    private val tvShowDao: TvShowDao,
    private val tvShowFavoriteDao: TvShowFavoriteDao
) : TvShowRepository {

    override suspend fun getAll(page: Int): Flow<State<Pair<Int, List<TvShowEntity>>>> =
        object :
            NetworkBoundRepository<Pair<Int, List<TvShowEntity>>, MoviePagination<TvShowResult>>() {

            override suspend fun fetchFromRemote(): Response<MoviePagination<TvShowResult>> =
                tvShowRoutes.getTvShowsPopular(page)

            override fun fetchFromLocal(): Pair<Int, List<TvShowEntity>> =
                Pair(-1, tvShowDao.getTvShows())

            override fun saveRemoteData(data: MoviePagination<TvShowResult>) {
                tvShowDao.resetNewData(data.results.map { it.mapToTvShow() })
            }

            override fun shouldSaveToLocal(data: MoviePagination<TvShowResult>?): Boolean =
                data?.page == 1

            override fun mapFromRemote(data: MoviePagination<TvShowResult>): Pair<Int, List<TvShowEntity>> =
                Pair(data.page + 1, data.results.map { it.mapToTvShow() })
        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun get(id: Long): Flow<State<TvShowEntity?>> =
        object :
            NetworkBoundRepository<TvShowEntity?, TvShowDetailResult>() {

            override suspend fun fetchFromRemote(): Response<TvShowDetailResult> =
                tvShowRoutes.getTvShow(id)

            override fun fetchFromLocal(): TvShowEntity? = null

            override fun saveRemoteData(data: TvShowDetailResult) {}

            override fun shouldSaveToLocal(data: TvShowDetailResult?): Boolean = false

            override fun mapFromRemote(data: TvShowDetailResult): TvShowEntity = data.mapToTvShow()
        }.asFlow().flowOn(Dispatchers.IO)

    override suspend fun isFavorite(id: Long): Boolean = tvShowFavoriteDao.getTvShow(id) != null

    override suspend fun insertFavorite(data: TvShowFavoriteEntity) =
        tvShowFavoriteDao.insertTvShow(data)

    override suspend fun deleteFavorite(id: Long) {
        tvShowFavoriteDao.deleteTvShow(id)
    }

    override fun getAllFavorite(): LiveData<PagedList<TvShowFavoriteEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(tvShowFavoriteDao.getTvShows(), config).build()
    }
}