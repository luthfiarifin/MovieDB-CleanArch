package com.laam.core.repository.tv

class TvShowRepository(private val dataSource: TvShowDataSource) {

    fun getAllTv() = dataSource.getAll()
}