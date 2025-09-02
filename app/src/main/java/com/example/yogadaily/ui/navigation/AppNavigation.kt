package com.example.yogadaily.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yogadaily.ui.screens.AsanaDetailScreen
import com.example.yogadaily.ui.screens.AsanaListScreen
import com.example.yogadaily.ui.screens.AsanaViewModel

@Composable
fun AppNavigation(navController: NavHostController, viewModel: AsanaViewModel) {
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            AsanaListScreen(
                asanas = viewModel.getAsanas(),
                onAsanaClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val asana = id?.let { viewModel.getAsanaById(it) }
            asana?.let {
                AsanaDetailScreen(asana = it)
            }
        }
    }
}
