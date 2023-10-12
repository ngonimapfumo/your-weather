package com.nm.yourweather.data.remote.response


import com.google.gson.annotations.SerializedName

data class GetForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
) {
    data class City(
        val coord: Coord,
        val country: String,
        val id: Int,
        val name: String,
        val population: Int,
        val sunrise: Int,
        val sunset: Int,
        val timezone: Int
    ) {
        data class Coord(
            val lat: Double,
            val lon: Double
        )
    }

    data class List (
        val clouds: Clouds,
        val dt: Int,
        @SerializedName("dt_txt")
        val dtTxt: String,
        val main: Main,
        val pop: Double,
        val rain: Rain,
        val sys: Sys,
        val visibility: Int,
        val weather: kotlin.collections.List<Weather>,
        val wind: Wind
    ) {
        data class Clouds(
            val all: Int
        )

        data class Main(
            @SerializedName("feels_like")
            val feelsLike: Double,
            @SerializedName("grnd_level")
            val grndLevel: Int,
            val humidity: Int,
            val pressure: Int,
            @SerializedName("sea_level")
            val seaLevel: Int,
            val temp: Double,
            @SerializedName("temp_kf")
            val tempKf: Double,
            @SerializedName("temp_max")
            val tempMax: Double,
            @SerializedName("temp_min")
            val tempMin: Double
        )

        data class Rain(
            @SerializedName("3h")
            val h: Double
        )

        data class Sys(
            val pod: String
        )

        data class Weather(
            val description: String,
            val icon: String,
            val id: Int,
            val main: String
        )

        data class Wind(
            val deg: Int,
            val gust: Double,
            val speed: Double
        )
    }
}