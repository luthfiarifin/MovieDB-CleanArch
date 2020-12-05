package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
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

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowFavoriteEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowFavoriteEntity>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getTvShows() = runBlockingTest {
        val dummyTvShows = pagedList
        Mockito.`when`(dummyTvShows.size).thenReturn(12)

        val movies = MutableLiveData<PagedList<TvShowFavoriteEntity>>()
        movies.value = dummyTvShows

        Mockito.`when`(tvShowRepositoryImpl.getAllFavorite()).thenReturn(movies)

        val interactors = TvShowListFavoriteInteractors(tvShowRepositoryImpl)
        viewModel = TvShowFavoriteViewModel(interactors, testScope)

        val tvShowEntities = viewModel.tvShowsLiveData.value

        Mockito.verify(tvShowRepositoryImpl).getAllFavorite()
        assertNotNull(tvShowEntities)
        assertEquals(12, tvShowEntities?.size)

        viewModel.tvShowsLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShows)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}