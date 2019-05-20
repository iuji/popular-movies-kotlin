package br.com.iuji.popularmovies.view

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.iuji.popularmovies.model.usecases.MovieUseCase

@Suppress("UNCHECKED_CAST")
class ListMoviesViewModelFactory constructor(private val useCase: MovieUseCase,
                                             private val application: Application) : ViewModelProvider.Factory  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(ListMoviesViewModel::class.java) ->
                        ListMoviesViewModel(useCase, application)
                    else ->
                        throw IllegalArgumentException("Classe desconhecida.")
                }
            } as T
}
