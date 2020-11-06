package com.laam.moviedb_cleanarch.presentation.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImageUrl(view: ImageView, imageUrl: String?) {
        imageUrl?.let { view.load(it) }
    }
}