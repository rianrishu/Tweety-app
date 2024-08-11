package com.rishu.tweety

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rishu.tweety.screens.CategoryScreen
import com.rishu.tweety.screens.DetailScreen
import com.rishu.tweety.ui.theme.TweetyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TweetyTheme {
                DetailScreen()
            }
        }
    }
}
