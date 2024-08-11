package com.rishu.tweety.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rishu.tweety.viewmodels.DetailViewModel

@Preview
@Composable
fun DetailScreen() {
    val detailViewModel: DetailViewModel = viewModel()
    val tweetList = detailViewModel.tweetList.collectAsState()
    LazyColumn {
        items(tweetList.value) {
            TweetListItem(tweet = it.text)
        }
    }
}


@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        border = BorderStroke(1.dp, Color(0XFFCCCCCC))
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.body2
        )
    }
}