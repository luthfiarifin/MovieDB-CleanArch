package com.laam.core.repository.tv

class TvShowRepository(private val dataSource: TvShowDataSource) {

    fun getAllTvShows() = dataSource.getAll()

    fun getTvShow(id: Long) = dataSource.get(id)
}