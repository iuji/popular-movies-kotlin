package br.com.iuji.popularmovies.model.repositories.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.iuji.popularmovies.model.domain.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDAO
}