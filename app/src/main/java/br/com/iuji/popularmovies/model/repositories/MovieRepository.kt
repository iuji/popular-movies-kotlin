package br.com.iuji.popularmovies.model.repositories

import br.com.iuji.popularmovies.model.domain.MovieResponse
import io.reactivex.Single

interface MovieRepository {
    fun listMovies(searchType: String) : Single<MovieResponse>
}