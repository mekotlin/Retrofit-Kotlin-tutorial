package mekotlinapps.dnyaneshwar.`in`.restdemo.acitivty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import mekotlinapps.dnyaneshwar.`in`.restdemo.util.ListItemDecorations
import mekotlinapps.dnyaneshwar.`in`.restdemo.adapter.MyAdapter
import mekotlinapps.dnyaneshwar.`in`.restdemo.R
import mekotlinapps.dnyaneshwar.`in`.restdemo.model.MovieResponse
import mekotlinapps.dnyaneshwar.`in`.restdemo.model.Movies
import mekotlinapps.dnyaneshwar.`in`.restdemo.rest.APIClient
import mekotlinapps.dnyaneshwar.`in`.restdemo.rest.ApiInterface
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val TAG: String = MainActivity::class.java.simpleName
    val API_KEY: String = "ec44357d71b936de6ee7f5aa7837b6a4"
    lateinit var myCustomAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(ListItemDecorations(20))
        recyclerView.setHasFixedSize(true)

        if (API_KEY.isEmpty()) {
            toast("Please obtain your API KEY first from www.themoviedb.org")
            return
        }

        progressBar.visibility = View.VISIBLE

        var apiServices = APIClient.client.create(ApiInterface::class.java)

        val call = apiServices.getTopRatedMovies(API_KEY)

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                var listOfMovies: List<Movies> = response.body()?.results!!
                myCustomAdapter = MyAdapter(applicationContext, listOfMovies)
                recyclerView.setAdapter(myCustomAdapter)
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                progressBar.visibility = View.GONE
                Log.e(TAG, t.toString())
            }
        })
    }
}
