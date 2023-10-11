package com.nm.yourweather.util

import retrofit2.Response

object Utils {

    inline fun <T> apiCall(apiCall: () -> Response<T>): com.nm.yourweather.data.remote.util.Response<T> {
        return try {
            com.nm.yourweather.data.remote.util.Response.success(apiCall.invoke())
        } catch (e: Exception) {
            com.nm.yourweather.data.remote.util.Response.failure(e)
        }
    }
}