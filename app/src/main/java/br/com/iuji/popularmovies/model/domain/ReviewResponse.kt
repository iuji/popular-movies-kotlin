package br.com.iuji.popularmovies.model.domain

data class ReviewResponse(
        val results: List<Review>
)

class Review {
    val id: String? = null
    val author: String? = null
    val content: String? = null
    val url: String? = null
}