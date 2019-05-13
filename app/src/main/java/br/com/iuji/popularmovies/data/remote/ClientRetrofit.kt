package br.com.iuji.popularmovies.data.remote

import br.com.iuji.popularmovies.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    fun getClient() : Retrofit{
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}