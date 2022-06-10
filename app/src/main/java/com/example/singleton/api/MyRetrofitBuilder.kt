package com.example.singleton.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofitBuilder {
    const val Base_url = "https://open-api.xyz/"
    val retrofitBuider: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())

    }
    val apiService: apiService by lazy {
        retrofitBuider
            .build()
            .create(apiService::class.java)
    }


}