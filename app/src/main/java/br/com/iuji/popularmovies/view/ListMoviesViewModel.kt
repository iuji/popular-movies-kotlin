package br.com.iuji.popularmovies.view

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.status.StatusLoading
import br.com.iuji.popularmovies.model.status.StatusResponse
import br.com.iuji.popularmovies.model.usecases.MovieUseCase
import io.reactivex.disposables.CompositeDisposable

class ListMoviesViewModel(private val useCase: MovieUseCase, application : Application) : AndroidViewModel(application){

    private val moviesData =  MutableLiveData<StatusResponse<MovieResponse>>()
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
    fun getMovieData() = moviesData

    fun fetchMoviesList(searchType : String){
        moviesData.value = StatusLoading()
        useCase.getMovies(moviesData, searchType)
                .also { disposables.add(it) }
    }

}