package com.appweek14.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// API interface
interface JsonPlaceHolderApi {
    @GET("users")
    suspend fun getUsers(): List<User>
}

// Singleton
object RetrofitClient {
   private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: JsonPlaceHolderApi by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceHolderApi::class.java)
    }
}