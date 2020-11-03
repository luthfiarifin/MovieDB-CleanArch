package com.laam.moviedb_cleanarch.framework.repository

import com.laam.core.model.TvShow
import com.laam.core.repository.TvShowRepository
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor() : TvShowRepository {

    override fun getAll(): List<TvShow> = TvShowDummy.generateDummyTvShow()

    override fun get(id: Long): TvShow? = TvShowDummy.generateDummyTvShow().find { it.id == id }
}