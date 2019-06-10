package br.com.iuji.popularmovies.model.repositories.remote

import br.com.iuji.popularmovies.BuildConfig
import br.com.iuji.popularmovies.model.domain.Movie
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.domain.ReviewResponse
import br.com.iuji.popularmovies.model.domain.TrailerResponse
import br.com.iuji.popularmovies.model.repositories.MovieRepository
import br.com.iuji.popularmovies.model.status.defaultSchedulers
import br.com.iuji.popularmovies.model.status.singleCallable
import io.reactivex.Single

class RemoteRepository(private val movieApi: MovieApi) : MovieRepository {
    override fun listReviews(searchType: String): Single<ReviewResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listTrailers(searchType: String): Single<TrailerResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listMovies(searchType: String): Single<MovieResponse> =
        movieApi.listMovies(searchType, BuildConfig.api_key)
                .defaultSchedulers()


}
