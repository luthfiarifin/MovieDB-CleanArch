package com.laam.moviedb_cleanarch.presentation.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.laam.core.model.MovieFavoriteEntity
import com.laam.moviedb_cleanarch.framework.repository.MovieRepositoryImpl
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

    @Mock
    private lateinit var observer: Observer<PagedList<MovieFavoriteEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieFavoriteEntity>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getMovieList() = runBlockingTest {
        val dummyMovies = pagedList
        Mockito.`when`(dummyMovies.size).thenReturn(12)

        val movies = MutableLiveData<PagedList<MovieFavoriteEntity>>()
        movies.value = dummyMovies

        Mockito.`when`(movieRepositoryImpl.getAllFavorite()).thenReturn(movies)

        val interactors = MovieListFavoriteInteractors(movieRepositoryImpl)
        viewModel = MovieFavoriteViewModel(interactors, testScope)

        val movieEntities = viewModel.moviesLiveData.value

        Mockito.verify(movieRepositoryImpl).getAllFavorite()
        assertNotNull(movieEntities)
        assertEquals(12, movieEntities?.size)

        viewModel.moviesLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}