package br.com.iuji.popularmovies.data.repository

import br.com.iuji.popularmovies.domain.Movie

interface ApiRepository {
    fun listRemoteMovies(success : (List<Movie>) -> Unit, failure: () -> Unit, searchType: String)
    fun listLocalMovies(success : (List<Movie>) -> Unit, failure: () -> Unit)
}