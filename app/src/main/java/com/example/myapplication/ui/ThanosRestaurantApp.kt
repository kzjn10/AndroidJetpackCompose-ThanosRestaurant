package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.NavGraph
import com.example.myapplication.ui.theme.ThanosRestaurantTheme

@Composable
fun ThanosRestaurantApp() {
    ThanosRestaurantTheme(darkTheme = false) {
        val navController = rememberNavController()
        NavGraph(navController = navController)
    }
}