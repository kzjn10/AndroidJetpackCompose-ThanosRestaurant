package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.DetailScreen
import com.example.myapplication.ui.ThanosRestaurantScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        addHomeScreen(navController, this)
        addDetailScreen(navController, this)
    }
}


private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        ThanosRestaurantScreen(
            navigateToDetail = {
                navController.navigate(NavRoute.Detail.path)
            }
        )
    }
}


private fun addDetailScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = NavRoute.Detail.path) {
        DetailScreen(
            navigateUp = {
                navController.navigateUp()
            }
        )
    }
}