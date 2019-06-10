package br.com.iuji.popularmovies.model.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

data class MovieResponse(
        var results: List<Movie>
)

@Parcelize
@Entity(tableName = "movie")
data class Movie(
        @PrimaryKey var id: Int = 0,

        var title: String? = null,

        var overview: String? = null,

        @ColumnInfo(name = "original_language")
        @SerializedName("original_language") var originalLanguage: String? = null,

        @ColumnInfo(name = "original_title")
        @SerializedName("original_title") var originalTitle: String? = null,

        @ColumnInfo(name = "vote_average")
        @SerializedName("vote_average") var voteAverage: String? = null,

        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path") var posterPath: String? = null,

        @ColumnInfo(name = "backdrop_path")
        @SerializedName("backdrop_path") var backdropPath: String? = null,

        @ColumnInfo(name = "release_date")
        @SerializedName("release_date") var releaseDate: Date? = null
) : Parcelable