package com.example.singleton.api

import com.example.singleton.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface apiService {
@GET("placeholder/user/{userId}")
suspend fun getuser(
    @Path("userid") userid : String

) : User

}