package com.rishu.tweety.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishu.tweety.repository.TweetyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: TweetyRepository
) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}