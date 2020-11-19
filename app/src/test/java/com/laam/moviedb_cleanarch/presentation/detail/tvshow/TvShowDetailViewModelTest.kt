package com.laam.moviedb_cleanarch.presentation.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.laam.core.ext.repository.State
import com.laam.core.model.TvShowEntity
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import com.laam.moviedb_cleanarch.framework.repository.TvShowRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
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
class TvShowDetailViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    private lateinit var viewModel: TvShowDetailViewModel
    private val dummyTvShow = TvShowDummy.generateDummyTvShow()[0]

    @Mock
    private lateinit var tvShowRepositoryImpl: TvShowRepositoryImpl

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getTvShow() = runBlockingTest {
        val resultState: State.Success<TvShowEntity?> = State.Success(dummyTvShow)
        Mockito.`when`(tvShowRepositoryImpl.get(dummyTvShow.id)).thenReturn(flowOf(resultState))

        val interactors = TvShowDetailInteractors(tvShowRepositoryImpl)
        viewModel = TvShowDetailViewModel(interactors, testScope).apply {
            getTvShow(dummyTvShow.id)
        }

        val selectedTvShow = viewModel.tvShowEntity.get()
        assertNotNull(selectedTvShow)

        assertEquals(dummyTvShow.id, selectedTvShow?.id)
        assertEquals(dummyTvShow.name, selectedTvShow?.name)
        assertEquals(dummyTvShow.overview, selectedTvShow?.overview)
        assertEquals(dummyTvShow.voteAverage, selectedTvShow?.voteAverage)
        assertEquals(dummyTvShow.poster, selectedTvShow?.poster)
        assertEquals(dummyTvShow.tags, selectedTvShow?.tags)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}