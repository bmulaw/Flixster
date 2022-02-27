package com.example.flikxster
import org.json.JSONArray

class Movie(val movieId: Int, val title: String, private val poster: String, val overview: String) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$poster"
    companion object {
        fun fromJsonArray(movieDataArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieDataArray.length()) {
                val movieData = movieDataArray.getJSONObject(i)
                movies.add(
                    Movie(movieData.getInt("id"),
                          movieData.getString("title"),
                          movieData.getString("poster_path"),
                          movieData.getString("overview"))
                )
            }
            return movies
        }
    }
}