package com.example.movieshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.movieshow.adapter.MovieAdapter
import com.example.movieshow.databinding.ActivityMainBinding
import com.example.movieshow.model.Movie
import com.example.movieshow.viewmodel.MovieViewModel
import com.google.gson.JsonArray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MovieViewModel
    lateinit var movieAdapter: MovieAdapter
    lateinit var listMovie : List<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        movieAdapter = MovieAdapter(listMovie)
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        listMovie = listOf()

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getNewMovies().observe(this@MainActivity, Observer {
                listMovie = it
            })
        }
        Log.d("live", "$listMovie")

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = movieAdapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (lastVisibleItem == totalItemCount - 1) {
                    lifecycleScope.launch {
                        viewModel.getNewMovies()
                    }
                }
            }
        })
    }
}


// changes somethings
// chage 


















/*
val str = "https://quotable.io/quotes?page=1"
val stringRequest = StringRequest(Request.Method.GET, str, object : Response.Listener<String?> {
    override fun onResponse(response: String?) {
        val responseGet = response?.let { JSONObject(it) }
        Log.d("Result", "$responseGet")


        val a = responseGet?.getJSONArray("results")?.getJSONObject(0)
        for (i in 0 .. 10){
            val a = responseGet?.getJSONArray("results")?.getJSONObject(i)
            Log.d("result", "${a?.getString("author")}")
        }


        val author = a?.getString("author")
        Log.d("result", "$author")

        */
/*val result = JSONArray(responseGet?.getString("results"))

        Log.d("Result", "$result")*//*


    }
}, Response.ErrorListener {
    Log.d("Res", "Error")
} )
Volley.newRequestQueue(this).add(stringRequest)*/
