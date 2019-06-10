package br.com.iuji.popularmovies.model.repositories.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import br.com.iuji.popularmovies.model.domain.Movie

@Dao
interface MovieDAO {
    @Query("SELECT * FROM movie")
    fun getAllMovies():LiveData<List<Movie>>

    @Insert
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

//    @Query("SELECT * FROM movie WHERE id = :id")
//    fun loadMovieById(id: Int): MutableLiveData<Movie>
}