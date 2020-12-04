package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
import com.laam.moviedb_cleanarch.utils.PagedListTestUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class TvShowFavoriteViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: TvShowFavoriteViewModel

    @Mock
    private lateinit var tvShowRepositoryImpl: TvShowRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getTvShows() = runBlockingTest {
        val resultState = MutableLiveData<PagedList<TvShowFavoriteEntity>>()
        resultState.value = PagedListTestUtil.mockPagedList(TvShowDummy.generateDummyTvShowFavorite())

        Mockito.`when`(tvShowRepositoryImpl.getAllFavorite()).thenReturn(resultState)

        val interactors = TvShowListFavoriteInteractors(tvShowRepositoryImpl)
        viewModel = TvShowFavoriteViewModel(interactors, testScope)

        val list = viewModel.moviesLiveData.value
        Mockito.verify(tvShowRepositoryImpl).getAllFavorite()
        assertNotNull(list)

        assertEquals(12, list?.size)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}