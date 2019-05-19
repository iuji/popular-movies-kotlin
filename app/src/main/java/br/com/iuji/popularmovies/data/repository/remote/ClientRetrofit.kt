package br.com.iuji.popularmovies.data.repository.local.remote

import br.com.iuji.popularmovies.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        fun getClient() : Retrofit{
            return Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

}