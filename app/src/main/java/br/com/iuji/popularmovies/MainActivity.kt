package br.com.iuji.popularmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.view.View
import kotlinx.android.synthetic.main.activity_list_movies.*


class MainActivity :
        AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
    }

    private fun numberOfColumns(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthDivider = 300
        val width = displayMetrics.widthPixels
        val nColumns = width / widthDivider
        return if (nColumns < 2) 2 else nColumns
    }

    private fun startLoading() {
        pb_loading_indicator.visibility = View.VISIBLE
    }

    private fun endLoading() {
        pb_loading_indicator.visibility = View.GONE
    }

    private fun showErrorMessage() {
        view_movies.visibility = View.GONE
        view_error.visibility = View.VISIBLE
    }

    private fun showListMovieView() {
        view_movies.visibility = View.VISIBLE
        view_error.visibility = View.GONE
    }
}