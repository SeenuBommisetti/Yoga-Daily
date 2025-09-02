package com.example.yogadaily.ui.navigation

sealed class NavRoutes(val route: String) {
    object AsanaList : NavRoutes("asana_list")
    object AsanaDetail : NavRoutes("asana_detail/{asanaId}") {
        fun createRoute(asanaId: Int) = "asana_detail/$asanaId"
    }
}
