package br.com.iuji.popularmovies.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import br.com.iuji.popularmovies.R
import br.com.iuji.popularmovies.adapter.MovieAdapter
import br.com.iuji.popularmovies.data.repository.local.remote.ClientRetrofit
import br.com.iuji.popularmovies.data.repository.local.remote.MovieApi
import br.com.iuji.popularmovies.data.repository.local.remote.RemoteRepository
import kotlinx.android.synthetic.main.activity_list_movies.*

class ListMoviesActivity : AppCompatActivity() {

    private var mRecyclerView : RecyclerView? = null
    private lateinit var viewModel: ListMoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
        createViewModel()
    }

    override fun onResume() {
        super.onResume()
        setupRecyclerView()
        viewModel = createViewModel()
    }

    private fun setupRecyclerView(){
        mRecyclerView = rv_movies
        mRecyclerView?.adapter = MovieAdapter(applicationContext)
        mRecyclerView?.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun createViewModel(): ListMoviesViewModel{
        val retrofit = ClientRetrofit.getClient()
        val repository = RemoteRepository(retrofit.create(MovieApi::class.java))
        val factory = ListMoviesViewModelFactory(repository, application)
        return ViewModelProviders.of(this, factory).get(ListMoviesViewModel::class.java)
    }
}