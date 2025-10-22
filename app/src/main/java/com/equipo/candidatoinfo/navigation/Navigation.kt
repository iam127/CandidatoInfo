
package com.equipo.candidatoinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.equipo.candidatoinfo.ui.compare.CompareScreen
import com.equipo.candidatoinfo.ui.detail.DetailScreen
import com.equipo.candidatoinfo.ui.home.HomeScreen
import com.equipo.candidatoinfo.ui.main.MainScreen

sealed class Screen(val route: String) {
    object Main : Screen("main")
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
        startDestination = Screen.Main.route  // ✅ Empieza en Main
    ) {
        // ===== MAIN SCREEN (Pantalla inicial) =====
        composable(Screen.Main.route) {
            MainScreen(
                onNavigateToCandidatos = {
                    navController.navigate(Screen.Home.route)
                },
                onNavigateToCompare = {
                    navController.navigate(Screen.Compare.route)
                }
            )
        }

        // ===== HOME SCREEN (Lista de candidatos) =====
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDetail = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                },
                onNavigateToCompare = {
                    navController.navigate(Screen.Compare.route)
                }
            )
        }

        // ===== DETAIL SCREEN (Perfil del candidato) =====
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("candidateId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val candidateId = backStackEntry.arguments?.getString("candidateId") ?: ""
            DetailScreen(
                candidateId = candidateId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // ===== COMPARE SCREEN (Comparador) =====
        composable(Screen.Compare.route) {
            CompareScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onNavigateToDetail = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                }
            )
        }
    }
}