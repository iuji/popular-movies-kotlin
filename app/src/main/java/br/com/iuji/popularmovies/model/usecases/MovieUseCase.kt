package br.com.iuji.popularmovies.model.usecases

import android.arch.lifecycle.MutableLiveData
import br.com.iuji.popularmovies.model.repositories.remote.RemoteRepository
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.repositories.local.LocalRepository
import br.com.iuji.popularmovies.model.status.StatusResponse
import br.com.iuji.popularmovies.model.status.errorData
import br.com.iuji.popularmovies.model.status.successData
import io.reactivex.disposables.Disposable

class MovieUseCase(private val remoteRepository: RemoteRepository,
                   private val localRepository: LocalRepository) {

    fun getMovies(liveData: MutableLiveData<StatusResponse<MovieResponse>>, searchType: String) : Disposable {
        if(searchType == LOCAL_TYPE){
            return localRepository.listMovies(searchType)
                    .subscribe(
                            {liveData.successData(it)},
                            {liveData.errorData(it)}
                    )
        }else{
            return remoteRepository.listMovies(searchType)
                    .subscribe(
                            {liveData.successData(it)},
                            {liveData.errorData(it)}
                    )
        }
    }

    companion object {
        const val LOCAL_TYPE = "Favorites Movies"
    }
}