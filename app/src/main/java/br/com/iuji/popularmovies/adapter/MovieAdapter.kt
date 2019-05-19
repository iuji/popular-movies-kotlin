package br.com.iuji.popularmovies.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.com.iuji.popularmovies.domain.Movie
import android.widget.TextView
import br.com.iuji.popularmovies.R
import br.com.iuji.popularmovies.utils.Constants
import com.squareup.picasso.Picasso


class MovieAdapter constructor(private val mContext : Context): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    val mMovieList : MutableList<Movie> by lazy{
        mutableListOf<Movie>()
    }

    fun setMovieList(movies: List<Movie>){
        mMovieList.clear()
        mMovieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val context = parent.context
        val layoutIdForListMovie = R.layout.card_item_movie
        val layoutInflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view : View = layoutInflater.inflate(layoutIdForListMovie, parent, shouldAttachToParentImmediately)

        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.listItemTitleView?.text = mMovieList[position].title
        val urlImage = Constants.BASE_URL_IMAGE + mMovieList[position].poster_path
        Picasso.get().load(urlImage).placeholder(R.drawable.placeholder).into(holder.listItemImageView)
    }


    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var listItemTitleView: TextView? = null
        var listItemImageView: ImageView? = null
        var cardView: CardView? = null

        init {
            listItemTitleView = itemView.findViewById(R.id.tv_movie_title)
            listItemImageView = itemView.findViewById(R.id.iv_movie_img)
            cardView = itemView.findViewById(R.id.cv_item_movie)
        }

    }
}
