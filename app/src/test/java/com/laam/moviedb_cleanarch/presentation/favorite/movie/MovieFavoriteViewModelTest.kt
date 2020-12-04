package com.laam.moviedb_cleanarch.presentation.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.laam.core.model.MovieFavoriteEntity
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import com.laam.moviedb_cleanarch.framework.repository.MovieRepositoryImpl
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
class MovieFavoriteViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: MovieFavoriteViewModel

    @Mock
    private lateinit var movieRepositoryImpl: MovieRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getMovieList() = runBlockingTest {
        val resultState = MutableLiveData<PagedList<MovieFavoriteEntity>>()
        resultState.value = PagedListTestUtil.mockPagedList(MovieDummy.generateDummyMovieFavorite())

        Mockito.`when`(movieRepositoryImpl.getAllFavorite()).thenReturn(resultState)

        val interactors = MovieListFavoriteInteractors(movieRepositoryImpl)
        viewModel = MovieFavoriteViewModel(interactors, testScope)

        val list = viewModel.moviesLiveData.value
        Mockito.verify(movieRepositoryImpl).getAllFavorite()
        assertNotNull(list)

        assertEquals(12, list?.size)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}