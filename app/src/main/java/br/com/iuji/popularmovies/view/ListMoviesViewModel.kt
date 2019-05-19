package br.com.iuji.popularmovies.view

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import br.com.iuji.popularmovies.domain.Movie

class ListMoviesViewModel(private val repository: MovieRepository, application : Application) : AndroidViewModel(application){

    var mMovies : List<Movie>? = null
    private val localType = "Favorites Movies"

    fun load(searchType : String){
        // Começa loading
        if(searchType == localType){
            loadLocal()
        } else{
            loadRemote(searchType)
        }
    }

    private fun loadRemote(searchType: String) {
        repository.listRemoteMovies(onSuccess(), onError(), searchType)
    }

    private fun loadLocal() {
        repository.listLocalMovies(onSuccess(), onError())
    }

    private fun onSuccess(): (List<Movie>) -> Unit {
        return { items ->

            if (items.isEmpty()) {
                // Mensagem de lista vazia
            } else {
                mMovies = items
            }

            // finaliza loading
        }
    }

    private fun onError(): () -> Unit{
        return {

        }
    }
}