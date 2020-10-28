package com.laam.moviedb_cleanarch.presentation.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import com.laam.moviedb_cleanarch.presentation.detail.movie.MovieDetailViewModel
import com.laam.moviedb_cleanarch.presentation.detail.tvshow.TvShowDetailViewModel
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = MovieDummy.generateDummyMovie()
    private val dummyTvShows = TvShowDummy.generateDummyTvShow()

    private val movieDetailViewModel: MovieDetailViewModel = MovieDetailViewModel()
    private val tvShowDetailViewModel: TvShowDetailViewModel = TvShowDetailViewModel()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        if (dummyMovies.isNotEmpty()) {
            onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_movie)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    dummyMovies.size
                )
            )
        } else {
            onView(withId(R.id.movie_img_empty)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun loadDetailMovie() {
        val clickPosition = 0

        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                clickPosition,
                click()
            )
        )

        val movie = movieDetailViewModel.movie.get()

        if (movie != null && movieDetailViewModel.isNoData.get().not()) {
            onView(withId(R.id.movieDetail_tv_title)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_tv_title)).check(matches(withText(movie.name)))

            onView(withId(R.id.movieDetail_tv_tags)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_tv_tags)).check(matches(withText(movie.tags)))

            onView(withId(R.id.movieDetail_tv_releaseDate)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_tv_releaseDate)).check(matches(withText(movie.releaseDate)))

            onView(withId(R.id.movieDetail_tv_overview)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_tv_overview)).check(matches(withText(movie.overview)))

            onView(withId(R.id.movieDetail_tv_rating)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_tv_rating)).check(matches(withText(movie.voteAverage.toString())))

            onView(withId(R.id.movieDetail_rb_rating)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_img_poster)).check(matches(isDisplayed()))
            onView(withId(R.id.movieDetail_img_date)).check(matches(isDisplayed()))
        } else {
            onView(withId(R.id.movieDetail_img_noData)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun loadTvShow() {
        onView(withText(R.string.tv_show)).perform(click())

        if (dummyTvShows.isNotEmpty()) {
            onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
            onView(withId(R.id.rv_tv_show)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    dummyTvShows.size
                )
            )
        } else {
            onView(withId(R.id.tvShow_img_empty)).check(matches(isDisplayed()))
        }
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText(R.string.tv_show)).perform(click())

        val clickPosition = 11

        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                clickPosition,
                click()
            )
        )

        val tvShow = tvShowDetailViewModel.tvShow.get()

        if (tvShow != null) {
            onView(withId(R.id.tvShowDetail_tv_title)).check(matches(isDisplayed()))
            onView(withId(R.id.tvShowDetail_tv_title)).check(matches(withText(tvShow.name)))

            onView(withId(R.id.tvShowDetail_tv_tags)).check(matches(isDisplayed()))
            onView(withId(R.id.tvShowDetail_tv_tags)).check(matches(withText(tvShow.tags)))

            onView(withId(R.id.tvShowDetail_tv_overview)).check(matches(isDisplayed()))
            onView(withId(R.id.tvShowDetail_tv_overview)).check(matches(withText(tvShow.overview)))

            onView(withId(R.id.tvShowDetail_tv_rating)).check(matches(isDisplayed()))
            onView(withId(R.id.tvShowDetail_tv_rating)).check(matches(withText(tvShow.voteAverage.toString())))

            onView(withId(R.id.tvShowDetail_rb_rating)).check(matches(isDisplayed()))
            onView(withId(R.id.tvShowDetail_img_poster)).check(matches(isDisplayed()))
        } else {
            onView(withId(R.id.tvShowDetail_img_noData)).check(matches(isDisplayed()))
        }
    }
}