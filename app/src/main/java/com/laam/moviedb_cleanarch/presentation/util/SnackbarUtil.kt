package com.laam.moviedb_cleanarch.presentation.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackbarUtil {

    fun View.showSnackbar(message: String) {
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
    }
}