package com.laam.moviedb_cleanarch.presentation.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.framework.dummy.MovieDummy
import com.laam.moviedb_cleanarch.framework.dummy.TvShowDummy
import com.laam.core.ext.idling.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = MovieDummy.generateDummyMovie()
    private val dummyTvShows = TvShowDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

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

        onView(withId(R.id.movieDetail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_tv_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_tv_releaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_rb_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.movieDetail_img_date)).check(matches(isDisplayed()))
    }

    @Test
    fun loadMovieFavorite() {
        onView(withId(R.id.item_favorite)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
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

        val clickPosition = 0

        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                clickPosition,
                click()
            )
        )

        onView(withId(R.id.tvShowDetail_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDetail_tv_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDetail_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDetail_tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDetail_rb_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvShowDetail_img_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShowFavorite() {
        onView(withId(R.id.item_favorite)).perform(click())
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }
}