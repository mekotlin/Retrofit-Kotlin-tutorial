package mekotlinapps.dnyaneshwar.`in`.restdemo.model

/**
 * Created by Dnyaneshwar Dalvi on 22/11/17.
 */
data class Movies(var poster_path: String, var adult: Boolean, var overview: String, var release_date: String, var genre_ids: List<Int>, var id: Int,
                  var original_title: String, var original_language: String, var title: String, var backdrop_path: String, var popularity: Double,
                  var vote_count: Int, var video: Boolean, var vote_average: Double)
