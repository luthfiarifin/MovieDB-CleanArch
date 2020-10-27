package com.laam.moviedb_cleanarch.framework.datasource

import com.laam.core.model.TvShow
import com.laam.core.repository.tv.TvShowDataSource
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy

class TvShowDataSourceImpl : TvShowDataSource {

    override fun getAll(): List<TvShow> = TvShowDummy.generateDummyTvShow()
}