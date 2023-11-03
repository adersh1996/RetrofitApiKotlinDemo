package com.project.adersh.retrofitapikotlindemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtility {

    private val BASE_URL = "https://api.github.com"
    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}