package br.com.iuji.popularmovies.model.repositories.local

import android.arch.persistence.room.TypeConverter
import java.util.*

 class DateConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}