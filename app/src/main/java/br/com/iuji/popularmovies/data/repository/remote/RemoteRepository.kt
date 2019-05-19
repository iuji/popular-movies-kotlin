package br.com.iuji.popularmovies.data.repository.local.remote

import br.com.iuji.popularmovies.BuildConfig
import br.com.iuji.popularmovies.data.repository.ApiRepository
import br.com.iuji.popularmovies.domain.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository(private val movieApi: MovieApi) : ApiRepository {

    override fun listRemoteMovies(success: (List<Movie>) -> Unit, failure: () -> Unit, searchType: String) {
        val call = movieApi.listMovies(searchType, BuildConfig.api_key)

        call.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if(response.isSuccessful){
                    success(response.body()!!)
                } else{
                    failure()
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                failure()
            }
        })
    }

    override fun listLocalMovies(success: (List<Movie>) -> Unit, failure: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}