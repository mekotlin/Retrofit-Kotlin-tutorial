package mekotlinapps.dnyaneshwar.`in`.restdemo.rest

import mekotlinapps.dnyaneshwar.`in`.restdemo.model.MovieResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Dnyaneshwar Dalvi on 22/11/17.
 */
interface ApiInterface {

    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<MovieResponse>
}