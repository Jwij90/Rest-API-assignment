package com.example.restapi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("comments")
    fun getComments(): Call<List<Post>>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com"
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}