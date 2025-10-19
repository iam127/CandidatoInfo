package com.equipo.candidatoinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.equipo.candidatoinfo.ui.home.HomeScreen
import com.equipo.candidatoinfo.ui.detail.DetailScreen
import com.equipo.candidatoinfo.ui.compare.CompareScreen

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
            HomeScreen(
                onNavigateToDetail = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))},
                onNavigateToCompare = {
                    navController.navigate(Screen.Compare.route)
                }
            )
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val candidateId = backStackEntry.arguments?.getString("candidateId") ?: ""
            DetailScreen(
                candidateId = candidateId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Compare.route) {
            CompareScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
