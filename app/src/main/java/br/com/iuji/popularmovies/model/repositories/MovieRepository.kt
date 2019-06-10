package br.com.iuji.popularmovies.model.repositories

import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.domain.ReviewResponse
import br.com.iuji.popularmovies.model.domain.TrailerResponse
import io.reactivex.Single

interface MovieRepository {
    fun listMovies(searchType: String) : Single<MovieResponse>
    fun listReviews(searchType: String) : Single<ReviewResponse>
    fun listTrailers(searchType: String) : Single<TrailerResponse>
}