package com.project.adersh.retrofitapikotlindemo.api

import com.project.adersh.retrofitapikotlindemo.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers():Response<Users>
}