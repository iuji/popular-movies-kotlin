package br.com.iuji.popularmovies.model.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

data class MovieResponse(
        val results: List<Movie>
)

@Parcelize
data class Movie(
        val id: Int = 0,
        val title: String? = null,
        val overview: String? = null,
        @SerializedName("original_language") val originalLanguage: String? = null,
        @SerializedName("original_title") val originalTitle: String? = null,
        @SerializedName("vote_average") val voteAverage: String? = null,
        @SerializedName("poster_path") val posterPath: String? = null,
        @SerializedName("backdrop_path") val backdropPath: String? = null,
        @SerializedName("release_date") val releaseDate: Date? = null
) : Parcelable