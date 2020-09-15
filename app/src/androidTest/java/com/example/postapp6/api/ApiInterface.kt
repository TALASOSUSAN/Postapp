package com.example.postapp6.api

import com.example.postapp6.models.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface
{
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}