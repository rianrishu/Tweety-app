package com.rishu.tweety.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishu.tweety.models.TweetList
import com.rishu.tweety.repository.TweetyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetyRepository
) : ViewModel() {

    val categories: StateFlow<TweetList>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweets("motivation")
        }
    }
}
