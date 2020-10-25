package com.laam.moviedb_cleanarch.presentation.tv

import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import org.junit.Test

import org.junit.Assert.*

class TvViewModelTest {

    @Test
    fun getTvShowList() {
        val list = TvShowDummy.generateDummyTvShow()
        assertEquals(12, list.size)
    }
}