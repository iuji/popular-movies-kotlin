package br.com.iuji.popularmovies.utils

import android.view.View
import org.jetbrains.anko.runOnUiThread

fun View.changeVisibility(isVisible: Boolean) {
    this.context.runOnUiThread {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}