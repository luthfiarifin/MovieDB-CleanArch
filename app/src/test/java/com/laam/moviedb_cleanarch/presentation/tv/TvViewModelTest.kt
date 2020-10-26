package com.laam.moviedb_cleanarch.presentation.tv

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @Before
    fun setUp() {
        viewModel = TvViewModel()
    }

    @Test
    fun getTvShowList() {
        val list = viewModel.tvShowList
        assertEquals(12, list.size)
    }
}