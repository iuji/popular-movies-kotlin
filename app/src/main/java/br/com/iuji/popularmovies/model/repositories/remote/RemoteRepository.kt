package br.com.iuji.popularmovies.model.repositories.remote

import br.com.iuji.popularmovies.BuildConfig
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.repositories.MovieRepository
import br.com.iuji.popularmovies.model.status.singleCallable
import io.reactivex.Single

class RemoteRepository(private val movieApi: MovieApi) : MovieRepository {

    override fun listMovies(searchType: String): Single<MovieResponse> =
            singleCallable {
                movieApi.listMovies(searchType, BuildConfig.api_key)
            }!!
}
