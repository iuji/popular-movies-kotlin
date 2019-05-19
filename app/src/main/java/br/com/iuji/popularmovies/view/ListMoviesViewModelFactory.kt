package br.com.iuji.popularmovies.view

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ListMoviesViewModelFactory constructor(private val repository: MovieRepository,
                                             private val application: Application) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(ListMoviesViewModel::class.java) ->
                        ListMoviesViewModel(repository, application)
                    else ->
                        throw IllegalArgumentException("Classe desconhecida.")
                }
            } as T
}
