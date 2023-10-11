package com.nm.yourweather.presentation

import com.nm.yourweather.data.remote.request.GetCurrentRequest
import com.nm.yourweather.data.remote.response.GetCurrentResponse
import com.nm.yourweather.data.remote.util.NetworkManager
import com.nm.yourweather.data.remote.util.Response
import com.nm.yourweather.util.Utils.apiCall

class MainRepo {

    suspend fun getCurrent(lat: String, lon: String): Response<GetCurrentResponse> =
        apiCall {
            NetworkManager.apiService.getCurrentWeather(lat,lon)
        }


}