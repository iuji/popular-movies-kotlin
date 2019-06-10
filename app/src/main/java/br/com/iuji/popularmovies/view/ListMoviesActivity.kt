package br.com.iuji.popularmovies.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.DisplayMetrics
import br.com.iuji.popularmovies.R
import br.com.iuji.popularmovies.adapter.MovieAdapter
import br.com.iuji.popularmovies.model.repositories.remote.ClientRetrofit
import br.com.iuji.popularmovies.model.domain.Movie
import br.com.iuji.popularmovies.model.domain.MovieResponse
import br.com.iuji.popularmovies.model.repositories.local.LocalRepository
import br.com.iuji.popularmovies.model.repositories.remote.MovieApi
import br.com.iuji.popularmovies.model.repositories.remote.RemoteRepository
import br.com.iuji.popularmovies.model.status.StatusError
import br.com.iuji.popularmovies.model.status.StatusLoading
import br.com.iuji.popularmovies.model.status.StatusSuccess
import br.com.iuji.popularmovies.model.status.nonNullObserve
import br.com.iuji.popularmovies.model.usecases.MovieUseCase
import br.com.iuji.popularmovies.utils.changeVisibility
import kotlinx.android.synthetic.main.activity_list_movies.*
import org.jetbrains.anko.toast


class ListMoviesActivity : AppCompatActivity(), MovieListener {

    private val mAdapter = MovieAdapter(this)

    private lateinit var viewModel: ListMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
        setupRecyclerView()
        viewModel = createViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchMoviesList(TYPE_SEARCH_POPULAR)
//        viewModel.fetchFavoritesList()
        observerViewModelResponse()
    }

    private fun setupRecyclerView(){
        rv_movies?.setHasFixedSize(true)
        rv_movies?.adapter = mAdapter
        val layoutManager = GridLayoutManager(this, numberOfColumns())
        rv_movies?.layoutManager = layoutManager
    }

    private fun numberOfColumns(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthDivider = 300
        val width = displayMetrics.widthPixels
        val nColumns = width / widthDivider
        return if (nColumns < 2) 2 else nColumns
    }

    private fun createViewModel(): ListMoviesViewModel{
        val retrofit = ClientRetrofit.getClient()
        val remoteRepository = RemoteRepository(retrofit.create(MovieApi::class.java))
        val localRepository = LocalRepository(applicationContext)
        val useCase = MovieUseCase(remoteRepository, localRepository)
        val factory = ListMoviesViewModelFactory(useCase, application)
        return ViewModelProviders.of(this, factory).get(ListMoviesViewModel::class.java)
    }

    private fun observerViewModelResponse() {
        viewModel.getMovieData().nonNullObserve(this) { statusResponse ->
            when (statusResponse) {
                is StatusSuccess    -> onSuccess(statusResponse.data.results)
                is StatusError      -> onError()
                is StatusLoading    -> setLoading(true)
            }
        }

//        viewModel.getFavoriteData().nonNullObserve(this){ response ->
//            onSuccess(response)
//        }
    }

    private fun setLoading(loading: Boolean) {
        pb_loading_indicator.changeVisibility(loading)
    }

    private fun onSuccess(movies: List<Movie>) {
        setLoading(false)
        view_error.changeVisibility(false)
        view_movies.changeVisibility(true)
        mAdapter.setMovieList(movies)
    }

    private fun onError(){
        setLoading(false)
        view_movies.changeVisibility(false)
        view_error.changeVisibility(true)
    }

    override fun onMovieSelected(movie: Movie) {
        toast("clicou no: "+movie.originalTitle)
    }

    companion object {
        val TYPE_SEARCH_POPULAR = "popular"
        val TYPE_SEARCH_TOP_RATED = "top_rated"
    }
}