package br.com.iuji.popularmovies.data.repository.local.remote

import br.com.iuji.popularmovies.utils.Constants
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        fun getClient() : Retrofit{
            return Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()
        }
    }

}