package com.equipo.candidatoinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{candidateId}") {
        fun createRoute(candidateId: String) = "detail/$candidateId"
    }
    object Compare : Screen("compare")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            // TODO: HomeScreen()
        }

        composable(Screen.Detail.route) {
            // TODO: DetailScreen()
        }

        composable(Screen.Compare.route) {
            // TODO: CompareScreen()
        }
    }
}
