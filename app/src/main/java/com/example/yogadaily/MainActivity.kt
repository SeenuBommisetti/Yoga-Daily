package com.example.yogadaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.yogadaily.ui.navigation.AppNavigation
import com.example.yogadaily.ui.screens.AsanaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: AsanaViewModel = viewModel()
            AppNavigation(navController = navController, viewModel = viewModel)
        }
    }
}