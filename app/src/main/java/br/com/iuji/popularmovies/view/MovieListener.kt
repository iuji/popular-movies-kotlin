package br.com.iuji.popularmovies.view

import br.com.iuji.popularmovies.model.domain.Movie

interface MovieListener {
    fun onMovieSelected(movie: Movie)
}