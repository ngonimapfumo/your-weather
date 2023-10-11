package com.nm.yourweather.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nm.yourweather.data.remote.response.GetCurrentResponse
import com.nm.yourweather.data.remote.util.Response
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mainRepo = MainRepo()


    private val _getCurrent =
        MutableLiveData<Response<GetCurrentResponse>>()
    val getCurrent: LiveData<Response<GetCurrentResponse>> =
        _getCurrent

    fun getCurrent(lat: String, lon: String) {
        viewModelScope.launch {
            val response = mainRepo.getCurrent(lat, lon)
            _getCurrent.value = response
            Log.d("getCurrent: ", response.toString())
        }
    }
}