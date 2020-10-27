package com.laam.core.repository.tv

import com.laam.core.model.TvShow

interface TvShowDataSource {

    fun getAll(): List<TvShow>

    fun get(id: Long): TvShow?
}