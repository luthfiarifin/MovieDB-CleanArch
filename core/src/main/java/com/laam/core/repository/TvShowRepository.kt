package com.laam.core.repository

import com.laam.core.model.TvShow

interface TvShowRepository {

    fun getAll(): List<TvShow>

    fun get(id: Long): TvShow?
}