package br.com.iuji.popularmovies.model.domain

data class TrailerResponse(
        val results: List<Trailer>
)

class Trailer {
    val key: String? = null
    val name: String? = null
}