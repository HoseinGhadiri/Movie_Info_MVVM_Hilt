package com.example.movieinfo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.movieinfo.R
import com.example.movieinfo.framework.network.SearchResponse
import com.example.movieinfo.framework.network.Status
import com.example.movieinfo.framework.utils.Utils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupObserver()

        search.setOnClickListener { mainViewModel.search(searchText.text.toString()) }
    }


    private fun setupObserver() {
        mainViewModel.movies.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
//                    progressBar.visibility = View.GONE
                    it.data?.let { searchResponse -> log(searchResponse) }
//                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
//                    progressBar.visibility = View.VISIBLE
//                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
//                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
//            val gson: Gson = GsonBuilder().serializeNulls().create()
//            val response : SearchResponse = gson.fromJson(it.body().toString(),
//                            SearchResponse::class.java)
        })

        mainViewModel.loading.observe(this, Observer {
            when (it.status) {
//                Status.SUCCESS -> {
//                    progressBar.visibility = View.GONE
//                    it.data?.let { users -> renderList(users) }
//                    recyclerView.visibility = View.VISIBLE
//                }
                Status.LOADING -> {
//                    progressBar.visibility = View.VISIBLE
//                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
//                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    fun log(response : SearchResponse){
        Utils.log("movie name = " + response.results[0].title)
    }
}