package com.ibrajix.c2c.navigation

sealed class Routes(val route: String){
    object StartScreen: Routes(route = "start_screen")
    object HomeScreen: Routes(route = "home_screen")
}