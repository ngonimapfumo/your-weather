package com.nm.yourweather.data.remote.service

import com.nm.yourweather.data.remote.request.GetCurrentRequest
import com.nm.yourweather.data.remote.response.GetCurrentResponse
import com.nm.yourweather.data.remote.response.GetForecastResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Response<GetCurrentResponse>

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Response<GetForecastResponse>

}