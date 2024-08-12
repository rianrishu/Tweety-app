package com.rishu.tweety

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                App()
            }
        }
    }
}


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categoryScreen") {
        composable(route = "categoryScreen") {
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }

        composable(
            route = "detail/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )) {
            val category = it.arguments?.getString("category")
            DetailScreen(category!!)
        }
    }
}
