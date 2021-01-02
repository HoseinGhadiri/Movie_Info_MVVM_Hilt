package com.example.movieinfo.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.Movie
import com.example.movieinfo.framework.network.Resource
import com.example.movieinfo.framework.network.SearchResponse
import com.example.movieinfo.framework.repository.MainRepository
import com.example.movieinfo.framework.utils.NetworkHelper
import com.example.movieinfo.framework.utils.Utils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch

/**
 * Created by Hosein on 1/2/2021.
 */
class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    val gson: Gson = GsonBuilder().serializeNulls().create()
//    private val _movies = MutableLiveData<List<Movie>>()
    private val _movies = MutableLiveData<Resource<SearchResponse>>()
    private val _loading = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<SearchResponse>>
        get() = _movies

    val loading: LiveData<Resource<List<Movie>>>
        get() = _loading

    public fun search(name: String) {
        viewModelScope.launch {
            _loading.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.search(name).let {
                    if (it.isSuccessful) {
                        Utils.log("bodyyy = " + it.body().toString())

                        _movies.postValue(Resource.success(it.body()))
                    } else _loading.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _loading.postValue(Resource.error("No internet connection", null))
        }
    }
}