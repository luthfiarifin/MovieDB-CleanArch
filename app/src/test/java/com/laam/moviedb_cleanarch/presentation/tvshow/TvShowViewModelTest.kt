package com.laam.moviedb_cleanarch.presentation.tvshow

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShowList() {
        val list = viewModel.tvShowList
        assertEquals(12, list.size)
    }
}