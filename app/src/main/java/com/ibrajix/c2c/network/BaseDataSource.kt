package com.ibrajix.c2c.network

import retrofit2.Response

abstract class BaseDataSource {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Resource<T> {

        try {

            val response = apiCall()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    return Resource.success(body)
                }
            }

            else{
                return Resource.error(message = "Something went wrong, please try again later")
            }

            return Resource.failed("Something went wrong, try again")

        } catch (e: Exception) {
            return Resource.failed(e.toString())
        }
    }

}