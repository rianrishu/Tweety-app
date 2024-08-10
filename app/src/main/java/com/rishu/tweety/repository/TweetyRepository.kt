package com.rishu.tweety.repository

import android.util.Log
import com.rishu.tweety.api.TweetyAPIs
import com.rishu.tweety.models.TweetList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetyRepository @Inject constructor(private val tweetyAPIs: TweetyAPIs) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow(TweetList(null))
    val tweets: StateFlow<TweetList>
        get() = _tweets

    suspend fun getCategories() {
        Log.d("Categories",  "calling the API")
        val response = tweetyAPIs.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
            Log.d("Categories",  "API got the data" + _categories.value.toString())
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetyAPIs.getTweets(category)
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}