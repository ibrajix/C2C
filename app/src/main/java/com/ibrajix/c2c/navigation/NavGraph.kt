package com.ibrajix.c2c.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ibrajix.c2c.ui.screens.home.HomeScreen
import com.ibrajix.c2c.ui.screens.home.StartScreen
import com.ibrajix.c2c.ui.viewmodel.MainViewModel

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Routes.StartScreen.route
    ){
        composable(
            route = Routes.StartScreen.route
        ){
            StartScreen(navigateToHomeScreen = {
                navController.navigate(Routes.HomeScreen.route)
            })
        }

        composable(
            route = Routes.HomeScreen.route
        ){
            val viewModel = hiltViewModel<MainViewModel>()
            HomeScreen(viewModel)
        }
    }

}