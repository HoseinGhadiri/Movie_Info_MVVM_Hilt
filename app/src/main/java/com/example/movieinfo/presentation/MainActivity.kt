package com.example.movieinfo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.domain.Movie
import com.example.movieinfo.R
import com.example.movieinfo.framework.network.GetDetailsResponse
import com.example.movieinfo.framework.network.SearchResponse
import com.example.movieinfo.framework.network.Status
import com.example.movieinfo.framework.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),OnItemClicked {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()

        search.setOnClickListener { mainViewModel.search(searchText.text.toString()) }
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }


    private fun setupObserver() {
        mainViewModel.movies.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { searchResponse -> renderList(searchResponse) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        mainViewModel.movieDetails.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { searchResponse -> showDetails(searchResponse) }
//                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
//                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    fun renderList(response : SearchResponse){
        Utils.log("movie name = " + response.results[0].title)
        adapter.addListener(this)
        adapter.addData(response.results)
        adapter.notifyDataSetChanged()
    }

    fun showDetails(response : GetDetailsResponse){
        Utils.log("details name = " + response.keywords[0].name)
//        adapter.addListener(this)
//        adapter.addData(response.results)
//        adapter.notifyDataSetChanged()
    }

    override fun onClick(movie: Movie) {
        mainViewModel.getDetails(movie.id)
    }
}