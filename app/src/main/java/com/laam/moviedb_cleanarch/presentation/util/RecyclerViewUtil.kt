package com.laam.moviedb_cleanarch.presentation.util

import androidx.recyclerview.widget.RecyclerView

object RecyclerViewUtil {

    fun RecyclerView.setLoadMore(onLoadMoreListener: () -> Unit) {
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    onLoadMoreListener.invoke()
                }
            }
        })
    }
}