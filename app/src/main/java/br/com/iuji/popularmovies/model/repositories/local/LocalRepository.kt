package br.com.iuji.popularmovies.model.repositories.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.content.Context
import br.com.iuji.popularmovies.model.domain.Movie
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.domain.ReviewResponse
import br.com.iuji.popularmovies.model.domain.TrailerResponse
import br.com.iuji.popularmovies.model.repositories.MovieRepository
import io.reactivex.Flowable
import io.reactivex.Single

class LocalRepository (val context: Context) {

    fun listMovies(): LiveData<List<Movie>> {
        val movieDAO = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "MOVIES_DB"
        ).build().movieDao()
        return movieDAO.getAllMovies()
    }

    fun listReviews(searchType: String): Single<ReviewResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun listTrailers(searchType: String): Single<TrailerResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}