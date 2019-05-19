package br.com.iuji.popularmovies.data.repository.local.remote

import br.com.iuji.popularmovies.BuildConfig
import br.com.iuji.popularmovies.domain.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val apiKey = BuildConfig.api_key
interface MovieApi {


    @GET("{search_type}")
    fun listMovies(@Path("search_type") searchType: String, @Query("api_key") apiKey: String): Call<List<Movie>>

//    @GET("{id}/reviews")
//    fun listReviews(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<ReviewResponse>
//
//    @GET("{id}/videos")
//    fun listTrailers(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<TrailerResponse>
}