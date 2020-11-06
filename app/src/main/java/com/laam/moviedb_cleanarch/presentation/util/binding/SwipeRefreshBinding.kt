package com.laam.moviedb_cleanarch.presentation.util.binding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

object SwipeRefreshBinding {

    @JvmStatic
    @BindingAdapter("isRefreshing")
    fun bindSwipeIsRefreshing(layout: SwipeRefreshLayout, isRefreshing: Boolean?) {
        isRefreshing?.let { layout.isRefreshing = isRefreshing }
    }

    @BindingAdapter("onRefreshListener")
    @JvmStatic
    fun bindSwipeOnRefreshListener(
        layout: SwipeRefreshLayout,
        onRefreshListener: SwipeRefreshLayout.OnRefreshListener?
    ) {
        onRefreshListener?.let { layout.setOnRefreshListener(it) }
    }
}