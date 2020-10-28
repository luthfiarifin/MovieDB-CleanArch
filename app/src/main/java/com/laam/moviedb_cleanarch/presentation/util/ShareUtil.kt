package com.laam.moviedb_cleanarch.presentation.util

import android.app.Activity
import androidx.core.app.ShareCompat

object ShareUtil {

    fun Activity.shareText(title: String, text: String) {
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(title)
            .setText(text)
            .startChooser()
    }
}