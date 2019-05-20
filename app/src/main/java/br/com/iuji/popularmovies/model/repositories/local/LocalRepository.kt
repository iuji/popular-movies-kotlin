package br.com.iuji.popularmovies.model.repositories.local

import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.repositories.MovieRepository
import io.reactivex.Single

class LocalRepository : MovieRepository {
    override fun listMovies(searchType: String): Single<MovieResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}