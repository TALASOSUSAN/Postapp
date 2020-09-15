package com.example.postapp6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapp6.models.Post
import com.example.postapp6.repository.PostsRepository
import kotlinx.coroutines.launch


class PostsViewModel(val postsRepository: PostsRepository) : ViewModel() {
    var postsLiveData = MutableLiveData<List<Post>>()
    var postsFailedLiveData = MutableLiveData<String>()

    fun getPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}