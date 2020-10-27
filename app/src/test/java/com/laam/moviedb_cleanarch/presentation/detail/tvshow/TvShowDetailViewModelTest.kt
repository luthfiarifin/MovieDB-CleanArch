package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowDetailViewModelTest {

    private lateinit var viewModel: TvShowDetailViewModel
    private val dummyTvShow = TvShowDummy.generateDummyTvShow()[0]

    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel()
        viewModel.setTvShow(dummyTvShow.id)
    }

    @Test
    fun getTvShow() {
        val selectedTvShow = viewModel.tvShow.get()
        assertNotNull(selectedTvShow)

        assertEquals(dummyTvShow.id, selectedTvShow?.id)
        assertEquals(dummyTvShow.name, selectedTvShow?.name)
        assertEquals(dummyTvShow.overview, selectedTvShow?.overview)
        assertEquals(dummyTvShow.voteAverage, selectedTvShow?.voteAverage)
        assertEquals(dummyTvShow.poster, selectedTvShow?.poster)
        assertEquals(dummyTvShow.tags, selectedTvShow?.tags)
    }
}