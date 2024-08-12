package com.rishu.tweety.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishu.tweety.models.Tweet
import com.rishu.tweety.models.TweetList
import com.rishu.tweety.repository.TweetyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetyRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweetList: StateFlow<List<Tweet>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "motivation"
            repository.getTweets(category)
        }
    }
}
