package br.com.iuji.popularmovies.model.repositories.remote

import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.domain.ReviewResponse
import br.com.iuji.popularmovies.model.domain.TrailerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("{search_type}")
    fun listMovies(@Path("search_type") searchType: String, @Query("api_key") apiKey: String): Single<MovieResponse>

    @GET("{id}/reviews")
    fun listReviews(@Path("id") id: Int, @Query("api_key") apiKey: String): Single<ReviewResponse>

    @GET("{id}/videos")
    fun listTrailers(@Path("id") id: Int, @Query("api_key") apiKey: String): Single<TrailerResponse>
}